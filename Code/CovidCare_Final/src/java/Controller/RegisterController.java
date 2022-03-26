/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PatientDAO;
import DAO.QuestionDAO;
import DAO.UserDAO;
import Model.Question;
import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chinh
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        QuestionDAO qD = new QuestionDAO();
        ArrayList<Question> listQuestion = new ArrayList<>();

        if (user == null) {
            listQuestion = qD.getAllQuestion();

            if (listQuestion != null) {
                request.setAttribute("listQuestion", listQuestion);
            }

            request.getSession().invalidate();
            request.setAttribute("title", "Đăng ký");
            request.getRequestDispatcher("/views/register.jsp").forward(request, response);
        } else {
            response.sendRedirect(".");
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String raw_questionId = request.getParameter("ques_id");
        String answer = request.getParameter("answer");

        int questionId = Integer.parseInt(raw_questionId);

        String message = "";

        UserDAO userDAO = new UserDAO();
        QuestionDAO qD = new QuestionDAO();

        if (userDAO.getIdFromUsername(username) > 0) {
            message += "Tài khoản đã tồn tại<br>";
        }
        if (!password.equals(confirm)) {
            message += "Mật khẩu không trùng khớp<br>";
        }
        if (answer.equals("") && answer.length() == 0) {
            message += "Chưa trả lời câu hỏi bí mật<br>";
        }

        if (message.isEmpty()) {

            PatientDAO patientDAO = new PatientDAO();
            userDAO.addUser(new User(username, password, 3));
            patientDAO.addPatient(userDAO.getIdFromUsername(username));
            qD.addNewAnswer(userDAO.getIdFromUsername(username), questionId, answer);
            response.sendRedirect("login");
        } else {
            request.setAttribute("username", username);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/views/patient/register.jsp").forward(request, response);
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
