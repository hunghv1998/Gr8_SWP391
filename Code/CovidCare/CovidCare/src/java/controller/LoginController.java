/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import dal.UserInfoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private AccountDAO bD = new AccountDAO();
    private UserInfoDAO uiD = new UserInfoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Đăng nhập");
        request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        
        Account acc = bD.getAccountByUserNameAndPassWord(username, password);
        if (acc != null) {
            request.getSession().setAttribute("account", acc);
            if (!uiD.checkFirstLogin(username)) {
                request.getSession().setAttribute("message", 
                        "Đây là lần đầu bạn đăng nhập.<br>"
                                + "Vui lòng cập nhật thông tin cá nhân");
                response.sendRedirect("userinfo");
            } else {
            response.sendRedirect(".");
            }
        } else {
            request.setAttribute("Username", username);
            request.setAttribute("message", "Wrong username or password");
            request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
