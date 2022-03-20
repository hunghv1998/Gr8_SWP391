/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.AccountDAO;
import Dal.GroupDAO;
import Dal.QuestionDAO;
import Dal.UserInfoDAO;
import Model.Question;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class RegisterController extends HttpServlet {

    private final AccountDAO aD = new AccountDAO();
    private final GroupDAO gD = new GroupDAO();
    private final UserInfoDAO uiD = new UserInfoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        QuestionDAO qD = new QuestionDAO();
        ArrayList<Question> listQues = qD.getAllQuestion();

        request.setAttribute("listQuestion", listQues);
        request.setAttribute("title", "Đăng ký");

        request.getRequestDispatcher("view/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String raw_id = request.getParameter("ques_id");
        String answer = request.getParameter("answer");
        QuestionDAO qD = new QuestionDAO();
        
        
        String message = "";
        
        

        try {
            int id = Integer.parseInt(raw_id);

            try {
                //kiem tra ten dang nhap da ton tai
                if (aD.checkAccountExist(username)) {
                    message += "Tài khoản đã tồn tại<br>";
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!password.equals(confirm)) {
                message += "Mật khẩu không trùng khớp<br>";
            }

            if (message.isEmpty()) {
                aD.signup(username, password);
                gD.setGroupAccount(3, username);
                uiD.SignUpToUserList(username);
                qD.addNewAnswer(username,id,answer);                              
                response.sendRedirect("login");
            } else {
                request.setAttribute("username", username);
                request.setAttribute("message", message);
                request.getRequestDispatcher("/view/register.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
