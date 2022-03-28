/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PostVaccineDAO;
import DAO.VaccineDAO;
import Model.PostVaccinate;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class ManagePostVaccinateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<PostVaccinate> listPost = new ArrayList<>();
        User user = (User) request.getSession().getAttribute("user");
        PostVaccineDAO pD = new PostVaccineDAO();

        request.setAttribute("listPost", pD.getListPostVaccinate(3));
        request.getRequestDispatcher("views/doctor/managePostVaccinate.jsp").forward(request, response);
//        request.setAttribute("listPost", user.getUserId());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
