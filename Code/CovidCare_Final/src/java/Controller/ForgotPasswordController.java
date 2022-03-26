/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import DAO.QuestionDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class ForgotPasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("views/recover/sendEmailForgot.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO aD = new UserDAO();
        QuestionDAO qD = new QuestionDAO();  
        String username = request.getParameter("username").toString();
        String message="";
        int id=0;
        
        try {
            id = aD.getIdFromUsername(username);
            if (id != 0) {
                request.setAttribute("userId", id);               
                request.setAttribute("listQuestion", qD.getAllQuestion());
                request.getRequestDispatcher("views/recover/questionForgot.jsp").forward(request, response);
            }else{
                message = "Tài khoản không tồn tại";
                request.setAttribute("message", message);
                request.getRequestDispatcher("views/recover/sendEmailForgot.jsp").forward(request, response);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
