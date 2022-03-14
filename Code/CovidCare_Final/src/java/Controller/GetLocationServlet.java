/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CommonDataDAO;
import Model.City;
import Model.District;
import Model.Ward;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chinh
 */
@WebServlet(name = "GetLocationServlet", urlPatterns = {"/GetLocation"})
public class GetLocationServlet extends HttpServlet {

    private final CommonDataDAO cdD = new CommonDataDAO();

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String op = request.getParameter("operation");

            if (op.equals("city")) {
                ArrayList<City> cities = cdD.getAllCity();
                Gson json = new Gson();
                String cityList = json.toJson(cities);
                response.setContentType("text/html");
                out.write(cityList);
            }

            if (op.equals("district")) {
                String cityId = request.getParameter("cityId");
                ArrayList<District> districts = cdD.getDistrictByCityId(cityId);
                Gson json = new Gson();
                String districtList = json.toJson(districts);
                response.setContentType("text/html");
                out.write(districtList);
            }

            if (op.equals("ward")) {
                String wardId = request.getParameter("districtId");
                ArrayList<Ward> wards = cdD.getWardByDistrictId(wardId);
                Gson json = new Gson();
                String wardList = json.toJson(wards);
                response.setContentType("text/html");
                out.write(wardList);
            }
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
