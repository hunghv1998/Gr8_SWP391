/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chinh
 */
public class ManagementController extends Authentication {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");

        // Authentication
        Account account = (Account) request.getSession().getAttribute("account");

        if (account == null) {
            response.sendRedirect("login");
        } else {
            if (account.getGroupId() == 1) {
                String target = request.getParameter("target");

                if (target == null || target.equals("")) {
                    target = "account";
                }
                if (target.equals("account")) {
                    request.getRequestDispatcher("ManageAccount").forward(request, response);
                }
            } else {
                response.sendRedirect("");
                
            }
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
