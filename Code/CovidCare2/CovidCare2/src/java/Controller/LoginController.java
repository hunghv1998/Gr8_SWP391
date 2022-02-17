/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.AccountDAO;
import Dal.UserInfoDAO;
import Model.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account acc = (Account) request.getSession().getAttribute("account");
        if (acc != null) {
//            request.setAttribute("username", acc.getUserName());
//            request.setAttribute("password", acc.getPassWord());
            response.sendRedirect(".");
        } else {
            request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountDAO aD = new AccountDAO();
        UserInfoDAO uiD = new UserInfoDAO();

        Account acc = aD.getAccountByUsernameAndPassword(username, password);

        if (acc == null) {
            request.setAttribute("message", "Sai thông tin đăng nhập");
            request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("account", acc);
            if (acc.getGroupId() == 3 && !uiD.checkFirstLogin(username)) {
                response.sendRedirect("UserInfo");
            } else {
                response.sendRedirect(".");
            }
        }
    }
}
