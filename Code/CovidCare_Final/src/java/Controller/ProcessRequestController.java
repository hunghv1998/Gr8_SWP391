/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PostVaccineDAO;
import DAO.ProcessRequestDAO;
import DAO.RequestVaccineDAO;
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
public class ProcessRequestController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int post_id = Integer.parseInt(request.getParameter("post_id"));
        int request_id = Integer.parseInt(request.getParameter("request_id"));
        int action = Integer.parseInt(request.getParameter("action"));
        PostVaccineDAO pD = new PostVaccineDAO();
        RequestVaccineDAO rD = new RequestVaccineDAO();
        ProcessRequestDAO prD = new ProcessRequestDAO();

        switch (action) {
            //accept request
            case 1:
                //curr amount vacc
                PostVaccinate pv = pD.getPostById(post_id);
                //update amount
                int amount1 = pv.getAmount() - 1;
                pD.updateAmount(post_id, amount1);
                //update status Request
                prD.acceptRequestPost(request_id);
                response.sendRedirect("managePost2?action=2&&post_id=" + post_id);
                break;
            //denie request
            case 2:
                //update status Request
                prD.denieRequestVaccinate(request_id);
                response.sendRedirect("managePost2?action=2&&post_id=" + post_id);
                break;
        }

    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
