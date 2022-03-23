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
import Model.Vaccine;
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
public class ViewDetailPostVaccinateController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        PostVaccineDAO pD = new PostVaccineDAO();
        VaccineDAO vD = new VaccineDAO();
        
        int id = 0;
        String raw_postId = request.getParameter("post_id");
        //check id
        if (raw_postId != null) {
            id = Integer.parseInt(raw_postId);
        }
        PostVaccinate pv = pD.getPostById(id);
        ArrayList<Vaccine> listVacc = vD.getListVaccine();
        
        for (Vaccine l : listVacc) {
            if (l.getVaccId() == pv.getVaccId()) {
                request.setAttribute("vaccName", l.getVaccName());
            }
        }
        
        request.setAttribute("pv", pv);
        request.getRequestDispatcher("view/viewDetailPostVaccinate.jsp").forward(request, response);        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
}
