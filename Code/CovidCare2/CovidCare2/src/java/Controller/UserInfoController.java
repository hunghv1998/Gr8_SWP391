/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.UserInfoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Account;
import Model.UserInfo;
import java.sql.Date;

/**
 *
 * @author chinh
 */
public class UserInfoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Cập nhật thông tin");
        Account account = (Account) request.getSession().getAttribute("account");

        if (account == null) {
            response.sendRedirect("Login");
        } else {
            UserInfo user = new UserInfo();
            UserInfoDAO uiD = new UserInfoDAO();
            if (!uiD.checkFirstLogin(account.getUserName())) {
                request.setAttribute("update", "update");
            } else {
                user = uiD.getUserInfo(account.getUserName());
            }
            request.getSession().setAttribute("userinfo", user);
            request.getRequestDispatcher("/view/profile.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("update") != null) {
            //get info from jsp
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String image = request.getParameter("image");
            String address = request.getParameter("address");
            Date bday = Date.valueOf(request.getParameter("bday"));
            System.out.println(request.getParameter("address"));
            boolean sex = true;
            if (request.getParameter("sex").equals('1')) {
                sex = false;
            }

            // Validating input
            // Update input
            UserInfo userinfo = new UserInfo(bday, sex, email, image, address, name, true);
            Account account = (Account) request.getSession().getAttribute("account");
            UserInfoDAO uiD = new UserInfoDAO();
            int status = uiD.UpdateUserInfo(userinfo, account.getUserName());
            if (status > 0) {
                request.getSession().setAttribute("userinfo", userinfo);
                response.sendRedirect("UserInfo");
            } else {
                request.getSession().setAttribute("message", "Có lỗi đã xảy ra.<br>"
                        + "Vui lòng cập nhật lại.<br>");
                response.sendRedirect("UserInfo?update");
            }
        }

    }

}
