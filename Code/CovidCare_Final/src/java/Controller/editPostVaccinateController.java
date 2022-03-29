/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PostVaccineDAO;
import Model.PostVaccinate;
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
public class editPostVaccinateController extends HttpServlet {
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        PostVaccineDAO pD = new PostVaccineDAO();
        PostVaccinate p = pD.getPostById(postId);
        
        //set update info
        p.setStartDate(request.getParameter("start_date"));
        p.setVaccId(Integer.parseInt(request.getParameter("vacc_id")));
        p.setExpiredDate(request.getParameter("expired_date"));
        p.setPlace(request.getParameter("place"));
        p.setNote(request.getParameter("note"));
        p.setAmount(Integer.parseInt(request.getParameter("amount")));
        
        //update
        int result = pD.updatePost(p);
        
        if(result != -1){
            response.sendRedirect("managePost");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
