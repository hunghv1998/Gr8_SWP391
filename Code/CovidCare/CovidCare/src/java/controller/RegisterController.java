/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
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
public class RegisterController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Register");
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
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
        
//        String fullname = request.getParameter("fullname");
//        String phone = request.getParameter("phone");
//        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        AccountDAO aD = new AccountDAO();
        
        String message = "";
        
        try {
            //kiem tra ten dang nhap da ton tai
            if(aD.checkAccountExist(username)){
                message += "Tài khoản đã tồn tại<br>";
//                response.getWriter().print("Username Existed!");
            }
//            else{
//                //neu chua ton tai username nao
//                //update thong tin vao db
////                int updateSuccess = aD.insertAccount(username,password,fullname,phone,email);
//                
//                response.sendRedirect("login");
//            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!password.equals(confirm)) {
            message += "Mật khẩu không trùng khớp<br>";
        }
        
        if (message.isEmpty()) {
            aD.signup(username, password);
            response.sendRedirect("login");
        } else {
            request.setAttribute("username", username);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/view/register.jsp").forward(request, response);
        }
     
    }


 
}