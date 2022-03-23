/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.AccountDAO;
import Dal.QuestionDAO;
import Model.Account;
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
        ;
        request.getRequestDispatcher("view/sendEmailForgot.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDAO aD = new AccountDAO();
        QuestionDAO qD = new QuestionDAO();  
        String username = request.getParameter("username").toString();
        String message="";
        boolean accExit;
        try {
            accExit = aD.checkAccountExist(username);

            if (accExit) {
                request.setAttribute("username", username);               
                request.setAttribute("listQuestion", qD.getAllQuestion());
                request.getRequestDispatcher("view/questionForgot.jsp").forward(request, response);
            }else{
                message = "Tài khoản không tồn tại";
                request.setAttribute("message", message);
                request.getRequestDispatcher("view/sendEmailForgot.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
