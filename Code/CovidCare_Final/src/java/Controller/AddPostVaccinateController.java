/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PostVaccineDAO;
import DAO.UserDAO;
import DAO.VaccineDAO;
import Model.PostVaccinate;
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
public class AddPostVaccinateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VaccineDAO vD = new VaccineDAO();
        request.setAttribute("listVaccine", vD.getListVaccine());
        request.getRequestDispatcher("/views/doctor/addPostVaccinate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int vaccineId = 0;
        int amount = 0;

        PostVaccineDAO pD = new PostVaccineDAO();
        UserDAO uD = new UserDAO();
        String mess = "";

        String raw_vaccineId = request.getParameter("vacc_id");
        String raw_startDate = request.getParameter("start_date");
        String raw_expiredDate = request.getParameter("expired_date");
        String place = request.getParameter("place");
        String note = request.getParameter("note");
        String raw_amount = request.getParameter("amount");
        java.sql.Date created_date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        request.setAttribute("messsage", mess);

        try {
            //check null items 
            if (raw_vaccineId.equals("") || raw_vaccineId.length() == 0) {
                mess += "Chưa chọn loại Vaccine <br>";
            }
            if (raw_startDate.equals("") || raw_startDate.length() == 0) {
                mess += "Chưa chọn ngày bắt đầu <br>";
            }
            if (raw_expiredDate.equals("") || raw_expiredDate.length() == 0) {
                mess += "Chưa chọn ngày kết thúc <br>";
            }
            if (place.equals("") || place.length() == 0) {
                mess += "Chưa cung cấp địa điểm tiêm <br>";
            }
            if (raw_amount.equals("") || raw_amount.length() == 0) {
                mess += "Chưa cung cấp số lượng Vaccin <br>";
            }
            if (!raw_vaccineId.equals("") || raw_vaccineId.length() != 0) {
                vaccineId = Integer.parseInt(raw_vaccineId);
            }
            if (!raw_amount.equals("") || raw_amount.length() != 0) {
                amount = Integer.parseInt(raw_amount);
            }

            //not input some item
            if (!mess.equals("") || mess.length() != 0) {
                //set curr Post
                PostVaccinate currPost = new PostVaccinate();
                request.getSession().setAttribute("currPost", currPost);
                currPost.setCreatedDate(created_date.toString());
                currPost.setStartDate(raw_startDate);
                currPost.setExpiredDate(raw_expiredDate);
                currPost.setVaccId(vaccineId);
                currPost.setPlace(place);
                currPost.setNote(note);
                currPost.setAmount(amount);
                request.getSession().setAttribute("currPost", currPost);

                VaccineDAO vD = new VaccineDAO();
                request.setAttribute("listVaccine", vD.getListVaccine());
                request.setAttribute("message", mess);
                request.getRequestDispatcher("/views/doctor/addPostVaccinate.jsp").forward(request, response);
                
            } else {
                PostVaccinate pv = new PostVaccinate();
                User user = (User) request.getSession().getAttribute("user");
//                pv.setCreatedBy(3);
                pv.setCreatedBy(user.getUserId());
                pv.setCreatedDate(created_date.toString());
                pv.setStartDate(raw_startDate);
                pv.setExpiredDate(raw_expiredDate);
                pv.setVaccId(vaccineId);
                pv.setPlace(place);
                pv.setNote(note);
                pv.setAmount(amount);
                pv.setStatus(true);
                //set wardId
                pv.setWardId(uD.getWardIdByUserId(user.getUserId(),user.getUserType()));

                //insert 
                int result = pD.addPostVaccinate(pv);

                if (result == -1) {
                    request.setAttribute("message", "Cần hoàn thành cung cấp địa chỉ của tài khoản này \n trước khi tạo lịch tiêm <br>");
                    request.getRequestDispatcher("/views/doctor/addPostVaccinate.jsp").forward(request, response);
                } else {
                    response.sendRedirect("managePost");
                }
            }
        } catch (Exception e) {
            response.getWriter().print("Add faild");
        }

    }

}
