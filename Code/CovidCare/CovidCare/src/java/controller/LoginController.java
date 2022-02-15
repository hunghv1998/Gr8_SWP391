/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BaseDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Login");
        request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        
        BaseDAO bD = new BaseDAO();
        Account acc = bD.getAccountByUserNameAndPassWord(username, password);
        response.sendRedirect(".");
        if (acc != null) {
            request.getSession().setAttribute("Account", acc);
            response.sendRedirect("Home");
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
