/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Model.User;
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
public class EditAccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String message = "";
        UserDAO userD = new UserDAO();
        User u = new User();

        u = userD.getUserFromId(userId);

        if (u != null) {
            request.setAttribute("user", u);
            request.getRequestDispatcher("views/manageAccount/editAccount.jsp").forward(request, response);
        } else {
            message += "User không tồn tại";
            request.getRequestDispatcher("views/manageAccount/manageAccount.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String updatePassword = request.getParameter("password");
        String message = "";
        UserDAO uD = new UserDAO();

        if (uD.updatePassword(userId, updatePassword) == 1) {
            response.sendRedirect("managementAccount");
        } else {
            message += "Cập nhật thất bại";
            User u = new User();
            u = uD.getUserFromId(userId);
            request.setAttribute("user", u);
            response.sendRedirect("managementAccount");
        }

    }

}
