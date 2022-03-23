/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.AccountDAO;
import Dal.PostVaccineDAO;
import Dal.VaccineDAO;
import Model.Account;
import Model.PostVaccinate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
        //load list Vaccin
        VaccineDAO vD = new VaccineDAO();
        request.setAttribute("listVaccine", vD.getListVaccine());
        request.getRequestDispatcher("view/addPostVaccinate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int vaccineId = 0;
        int amount = 0;

        AccountDAO aD = new AccountDAO();
        PostVaccineDAO pD = new PostVaccineDAO();

        String raw_vaccineId = request.getParameter("vacc_id");
        String raw_startDate = request.getParameter("start_date");
        String raw_expiredDate = request.getParameter("expired_date");
        String place = request.getParameter("place");
        String note = request.getParameter("note");
        String raw_amount = request.getParameter("amount");
        java.sql.Date created_date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        Account acc = (Account) request.getSession().getAttribute("account");
        String username = acc.getUserName();

        try {

            if (raw_vaccineId != null) {
                vaccineId = Integer.parseInt(raw_vaccineId);
            }
            if (raw_amount != null) {
                amount = Integer.parseInt(raw_amount);
            }
            Date startDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(raw_startDate);
            Date expiredDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(raw_expiredDate);

            PostVaccinate pv = new PostVaccinate();
            pv.setCreatedBy(username);
            pv.setCreatedDate(created_date);
            pv.setStartDate(startDate);
            pv.setExpiredDate(expiredDate);
            pv.setVaccId(vaccineId);
            pv.setPlace(place);
            pv.setNote(note);
            pv.setAmount(amount);
            pv.setStatus(true);

            //set wardId
            pv.setWardId(aD.getWardIdByUsername(username));

            //insert 
            pD.addPostVaccinate(pv);
            response.getWriter().print("Add success");

        } catch (Exception e) {
            response.getWriter().print("Add faild");
        }

    }

}
