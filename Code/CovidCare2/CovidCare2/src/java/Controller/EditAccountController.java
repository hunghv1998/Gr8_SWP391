/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.AccountDAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class EditAccountController extends Authentication {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountDAO aD = new AccountDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account acc = aD.getAccountByUsernameAndPassword(username, password);

        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("role", acc.getGroupId());
        request.getRequestDispatcher("/view/EditAccount.jsp").forward(request, response);

    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String old_name = request.getParameter("oldUsername");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        AccountDAO acc = new AccountDAO();
        acc.deleteAccountByUsername(old_name);
        acc.insertRole(username, password, role);
        response.sendRedirect("ManageAccount");
    }

}
