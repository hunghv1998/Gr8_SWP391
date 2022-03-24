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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
            request.getRequestDispatcher("/views/chat.jsp").forward(request, response);
        }
    }

    public void insertMsgIntoDb(Message messageObj) {
        if (connection != null) {
            messageDAO.insertMessage(messageObj);
        }
    }

    public String getUserNameFromDB(Integer userId) {
        String userName = null;
        if (connection != null) {
            userName = userDAO.getUserNameWithId(userId);
        }
        return userName;
    }

    protected Boolean processAjaxRequests(HttpServletRequest request, HttpServletResponse response, Enumeration<String> paramNames, PrintWriter out, Boolean ajaxProcessed) {
        //Boolean ajaxProcessed = false;
        String param = paramNames.nextElement();
        if (param.equals("getLoggedInUserId")) {
            System.out.print(param);

            User currentUser = (User) session.getAttribute("currentSessionUser");
            if (currentUser != null) {
                out.print(currentUser.getUserId());
                System.out.println("just sent to client: fromId:" + currentUser.getUserId());
            }

            ajaxProcessed = true;
        } else if (param.equals("getMessages")) {
            System.out.print(param);

            String messageToUserId = request.getParameter("getMessages");
            System.out.println("should get all messages from user with ID: " + messageToUserId);
            if (messageToUserId != null) {
                User currentUser = (User) session.getAttribute("currentSessionUser");
                Connection currentConnection = (Connection) session.getAttribute("currentConnection");

                if (currentUser != null && currentConnection != null) {
                    Integer toId = Integer.parseInt(messageToUserId);
                    System.out.println("next will try to fetch msgs from: " + currentUser.getUserId() + ", to:" + toId);
                    ArrayList<Message> listOfMessages = messageDAO.getMessagesBetween(toId, currentUser.getUserId());
                    for (Message messageObj : listOfMessages) {
                        out.println(messageObj.getMessage());
                        /*out.println("fromId: "+messageObj.getFromId()
                         +", toId: "+messageObj.getToId()
                         +", message text: "+messageObj.getMessageText());*/
                    }
                }
            }
            ajaxProcessed = true;
        } else if (param.equals("getSenders")) {
            System.out.print(param);

            String unreadMsgsToUserId = request.getParameter("getSenders");
            System.out.println("should get messages unread by userID: " + unreadMsgsToUserId);
            if (unreadMsgsToUserId != null) {
                User currentUser = (User) session.getAttribute("currentSessionUser");
                Connection currentConnection = (Connection) session.getAttribute("currentConnection");

                if (currentUser != null && currentConnection != null) {
                    Integer toId = Integer.parseInt(unreadMsgsToUserId);
                    //System.out.println("next will try to fetch msgs from: "+currentUser.getId()+", to:"+toId);
                    ArrayList<User> listOfSenders = messageDAO.getListOfSenders(toId);

                    JsonProvider provider = JsonProvider.provider();
                    JsonArrayBuilder jArrayBulider = provider.createArrayBuilder();
                    JsonArray jsonSendersArray;

                    for (User senderUserDTO : listOfSenders) {

                        JsonObject senderJsonObject = provider.createObjectBuilder()
                                .add("fromUserId", senderUserDTO.getUserId())
                                .add("senderName", senderUserDTO.getUsername())
                                .build();

                        jArrayBulider = jArrayBulider.add(senderJsonObject);
                    }
                    jsonSendersArray = jArrayBulider.build();
                    if (jsonSendersArray.size() > 0) {
                        System.out.println("jsonSendersArray size: " + jsonSendersArray.size() + ", with contents: ");
                        for (int index = 0; index < jsonSendersArray.size(); index++) {
                            System.out.println(jsonSendersArray.getJsonObject(index).getJsonNumber("fromUserId")
                                    + " : "
                                    + jsonSendersArray.getJsonObject(index).getJsonString("senderName"));
                        }
                    }
                    out.print(jsonSendersArray);
                }
            }
            ajaxProcessed = true;
        }
        
        return ajaxProcessed;
    }

    protected void processHttpPostRequest(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws ServletException, IOException {
        System.out.println("nothing");
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
        //HttpSession session = null;
        /*
        if(session == null)
        {
            session = request.getSession(false);
            System.out.println("doPost-getting a new session with ID: "+session.getId());
        }
         */
        session = request.getSession();
        System.out.println("doPost-getting a new session with ID: " + session.getId());

        PrintWriter out = response.getWriter();

        Boolean ajaxProcessed = false;
        Enumeration<String> paramNames = request.getParameterNames();
        if (paramNames.hasMoreElements()) {
            while (paramNames.hasMoreElements()) {
                ajaxProcessed = processAjaxRequests(request, response, paramNames, out, ajaxProcessed);
            }
        }

        if (!ajaxProcessed) {
            processHttpPostRequest(request, response, out);
        }
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
