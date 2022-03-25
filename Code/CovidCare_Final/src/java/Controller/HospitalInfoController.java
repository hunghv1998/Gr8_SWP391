/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CommonDataDAO;
import DAO.HospitalDAO;
import DAO.PatientDAO;
import DAO.UserDAO;
import Model.City;
import Model.District;
import Model.Hospital;
import Model.User;
import Model.Ward;
import Utils.ValidatingInput;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chinh
 */
public class HospitalInfoController extends HttpServlet {

    private final HospitalDAO hospitalDAO = new HospitalDAO();
    private final CommonDataDAO commonDAO = new CommonDataDAO();
    private final ValidatingInput check = new ValidatingInput();

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HospitalInfoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HospitalInfoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login");
        } else {
            String id = request.getParameter("id");

            if (id == null) {
                id = String.valueOf(user.getUserId());
            }
            request.setAttribute("title", "Thông tin bệnh viện");
            if (!check.isNumber(id)
                    || hospitalDAO.getHospitalById(Integer.parseInt(id)) == null) {
                request.setAttribute("message", "Không tìm thấy thông tin bệnh viện");
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            } else {
                Hospital hospital = hospitalDAO.getHospitalById(Integer.parseInt(id));
                City patientCity = commonDAO.geCityByWardId(hospital.getWardId());
                District patientDistrict = commonDAO.getDistrictByWardId(hospital.getWardId());
                Ward patientWard = commonDAO.getWardByWardId(hospital.getWardId());

                request.setAttribute("city", patientCity);
                request.setAttribute("district", patientDistrict);
                request.setAttribute("ward", patientWard);

                request.setAttribute("hospital", hospital);
                
                request.getRequestDispatcher("/views/doctor/hospital_view.jsp").forward(request, response);

            }

        }
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
