/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import dal.GroupDAO;
import dal.UserInfoDAO;
import java.io.IOException;
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

    private final AccountDAO aD = new AccountDAO();
    private final GroupDAO gD = new GroupDAO();
    private final UserInfoDAO uiD = new UserInfoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Đăng ký");
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
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        
        
        String message = "";
        
        try {
            //kiem tra ten dang nhap da ton tai
            if(aD.checkAccountExist(username)){
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
            response.sendRedirect("login");
        } else {
            request.setAttribute("username", username);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/view/register.jsp").forward(request, response);
        }
     
    }


 
}
