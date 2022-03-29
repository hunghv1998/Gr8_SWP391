/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PostVaccineDAO;
import DAO.RequestVaccineDAO;
import DAO.VaccineDAO;
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
public class ManagePostVaccinateController2 extends HttpServlet {

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
        int action = Integer.parseInt(request.getParameter("action"));
        int post_id = Integer.parseInt((String) request.getParameter("post_id"));

        PostVaccinate currPost = new PostVaccinate();
        PostVaccineDAO pD = new PostVaccineDAO();

        switch (action) {
            //edit
            case 1:
                VaccineDAO vD = new VaccineDAO();
                currPost = pD.getPostById(post_id);
                request.setAttribute("listVaccine", vD.getListVaccine());
                request.setAttribute("messsage", "");
                request.setAttribute("currPost", currPost);
                request.getRequestDispatcher("views/doctor/editPostVaccinate.jsp").forward(request, response);

                break;
            //view
            case 2:
                //get post
                currPost = new PostVaccinate();
                currPost = pD.getPostById(post_id);
                //get list request
                RequestVaccineDAO rD = new RequestVaccineDAO();
                request.setAttribute("listRequestOfPost", rD.getListRequestVaccinateProcess(post_id));
                request.setAttribute("messsage", "");
                request.setAttribute("currPost", currPost);
                request.getRequestDispatcher("views/doctor/viewDetailPostVaccinate.jsp").forward(request, response);
                break;
            //delete
            case 3:
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
