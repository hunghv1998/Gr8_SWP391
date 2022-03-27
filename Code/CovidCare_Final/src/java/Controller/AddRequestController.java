/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PostVaccineDAO;
import DAO.RequestVaccineDAO;
import Model.RequestVaccinate;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class AddRequestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int post_id = Integer.parseInt(request.getParameter("post_id"));

        PostVaccineDAO pD = new PostVaccineDAO();

        request.setAttribute("pv", pD.getPostById(post_id));
        request.getRequestDispatcher("views/patient/addRequest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int post_id = Integer.parseInt(request.getParameter("post_id"));
        String phoneNumber = request.getParameter("phone");
        String note = request.getParameter("note");
        int result = -1;
        String message = "";
        User user = (User) request.getSession().getAttribute("user");

        java.sql.Date created_date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        //check items blank
        if (phoneNumber.equals("") || phoneNumber.length() == 0) {
            //clear session mess
            request.getSession().setAttribute("message", message);
            message += "Vui lòng nhập sđt";
            request.getSession().setAttribute("message", message);
            request.setAttribute("post_id", post_id);
            response.sendRedirect("addRequest");
        } else {
            //create new Request
            RequestVaccineDAO rD = new RequestVaccineDAO();
            RequestVaccinate rV = new RequestVaccinate();
            rV.setCreated_by(user.getUserId());
//            rV.setCreated_by(4);
            rV.setCreated_date(created_date.toString());
            rV.setPhone(phoneNumber);
            rV.setNote(note);
            rV.setStatus("2");
            rV.setImage("");
            result = rD.addRequestVaccinate(rV);
                                           
            //add success
            if (result != -1) {
                int request_id = rD.getMaxRequestId();
                rD.connectRequestToPost(post_id, request_id);
                response.sendRedirect("manageRequest");
            } else {
                response.getWriter().print("fail");
            }
        }
    }
}
