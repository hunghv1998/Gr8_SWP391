/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBContext;
import DAO.MessageDAO;
import Model.Message;
import Model.User;
import DAO.UserDAO;
import Model.ChatRoom;
import Utils.ValidatingInput;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chinh
 */
public class ChatController extends HttpServlet {

    HttpSession session;

    //was static
    DBContext connectionPool = new DBContext();

    Connection connection = connectionPool.getConnection();

    public ArrayList<String> listOfFetchedClientsIds = new ArrayList<>();

    private final MessageDAO messageDAO = new MessageDAO();
    private final UserDAO userDAO = new UserDAO();
    private final ValidatingInput check = new ValidatingInput();

    Integer currentUserId = 0;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        session = request.getSession();

        User user = (User) session.getAttribute("user");

        request.setAttribute("title", "Hỗ Trợ Trực Tuyến");
        if (user == null) {
            response.sendRedirect("login");
        } else if (user.getUserType() == 1) {
            request.setAttribute("message", "Bạn không có quyền truy cập.");
        } else {
            currentUserId = user.getUserId();

            ArrayList<ChatRoom> listOfChatRooms = new ArrayList<>();

            if (user.getUserType() == 2) {
                listOfChatRooms = messageDAO.getHospitalChatRooms(currentUserId);
            }
            if (user.getUserType() == 3) {
                listOfChatRooms = messageDAO.getPatientChatRooms(currentUserId);
            }
            request.setAttribute("listOfChatRooms", listOfChatRooms);

            String id = request.getParameter("id");

            ArrayList<Message> dialog = new ArrayList<>();

            if (id == null || !check.isNumber(id)) {
                request.setAttribute("errorMsg", "Không tìm thấy người dùng");
            } else {
                System.out.println(id);
                User chatTo = userDAO.getUserFromId(Integer.parseInt(id));

                if (!chatTo.isActiveStatus()) {
                    request.setAttribute("errorMsg", "Người dùng này hiện đang khóa tài khoản");
                } else {
                    messageDAO.markMsgsAsRead(currentUserId, chatTo.getUserId());
                    dialog = messageDAO.getMessagesBetween(currentUserId, Integer.parseInt(id));
                }
                request.setAttribute("chatTo", chatTo);
            }
            System.out.println(dialog.size());
            request.setAttribute("dialog", dialog);

            request.getRequestDispatcher("/views/chat.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        
        String newMsg = request.getParameter("newMsg");
        
        String toId = request.getParameter("id");
        
        Message message = new Message();
        
        message.setFromId(user.getUserId());
        message.setToId(Integer.parseInt(toId));
        message.setMessage(newMsg);
        message.setMessageDate(new Timestamp(System.currentTimeMillis()));
        message.setReadState(0);
        messageDAO.insertMessage(message);
        
        response.sendRedirect("chat?id=" + toId);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
