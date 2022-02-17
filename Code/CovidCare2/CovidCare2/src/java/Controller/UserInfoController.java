/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Account;

/**
 *
 * @author chinh
 */
public class UserInfoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Cập nhật thông tin");
        request.getRequestDispatcher("/view/profile.jsp").forward(request, response);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get info from jsp
        String name = request.getParameter("name");
        String nationalId = request.getParameter("nationalId");
        String BHYT = request.getParameter("BHYT");
        String dob = request.getParameter("dob");
        String sex = request.getParameter("sex");
        String country = request.getParameter("country");
        String cities = request.getParameter("cities");
        String districts = request.getParameter("districts");
        String wards = request.getParameter("wards");
        String address = request.getParameter("address");
        String sdt = request.getParameter("sdt");

        response.getWriter().print(name);
        response.getWriter().print(nationalId);
        response.getWriter().print(BHYT);
        response.getWriter().print(dob);
        response.getWriter().print(sex);
        response.getWriter().print(country);
        response.getWriter().print(cities);
        response.getWriter().print(districts);
        response.getWriter().print(wards);
        response.getWriter().print(address);
        response.getWriter().print(sdt);

    }

}
