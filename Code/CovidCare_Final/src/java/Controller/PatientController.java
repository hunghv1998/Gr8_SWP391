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
import Model.AgeType;
import Model.City;
import Model.Disease;
import Model.District;
import Model.Hospital;
import Model.Patient;
import Model.User;
import Model.Vaccine;
import Model.VaccineStatus;
import Model.Ward;
import Utils.ValidatingInput;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chinh
 */
public class PatientController extends HttpServlet {

    private final CommonDataDAO commonDAO = new CommonDataDAO();
    private final HospitalDAO hospitalDAO = new HospitalDAO();
    private final PatientDAO patientDAO = new PatientDAO();
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
            out.println("<title>Servlet PatientController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PatientController at " + request.getContextPath() + "</h1>");
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
        User user = (User) request.getSession().getAttribute("user");

        request.setAttribute("title", "Quản lý bệnh nhân");
        if (user == null || user.getUserType() != 2) {
            request.setAttribute("message", "Bạn không có quyền truy cập");
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        } else {
            Hospital hospital = hospitalDAO.getHospitalById(user.getUserId());

            String wardId = hospital.getWardId();
            String id = request.getParameter("id");

            if (id == null) {
                ArrayList<Patient> patients = patientDAO.getHospitalPatientsList(wardId);

                request.setAttribute("patients", patients);
                request.getRequestDispatcher("/views/doctor/patient_list.jsp").forward(request, response);
            } else {
                String action = request.getParameter("action");

                if (action == null) {
                    if (!check.isNumber(id) || patientDAO.getPatientInfo(Integer.parseInt(id)) == null) {
                        request.setAttribute("message", "Không tìm thấy bệnh nhân");
                        request.getRequestDispatcher("/views/error.jsp").forward(request, response);
                    } else {
                        Patient patient = patientDAO.getPatientInfo(Integer.parseInt(id));

                        ArrayList<VaccineStatus> vaccStatusList = commonDAO.getVaccineStatusList();
                        ArrayList<Vaccine> vaccines = commonDAO.getVaccineList();
                        ArrayList<AgeType> ages = commonDAO.getAgeTypeList();
                        ArrayList<Disease> diseases = commonDAO.getDiseaseList();

                        City patientCity = commonDAO.geCityByWardId(patient.getWardId());
                        District patientDistrict = commonDAO.getDistrictByWardId(patient.getWardId());
                        Ward patientWard = commonDAO.getWardByWardId(patient.getWardId());

                        request.setAttribute("vaccStatusList", vaccStatusList);
                        request.setAttribute("vaccines", vaccines);
                        request.setAttribute("ages", ages);
                        request.setAttribute("diseases", diseases);
                        request.setAttribute("city", patientCity);
                        request.setAttribute("district", patientDistrict);
                        request.setAttribute("ward", patientWard);

                        request.setAttribute("patient", patient);
                        request.getRequestDispatcher("/views/doctor/patient_detail.jsp").forward(request, response);
                    }
                } else if (action.equals("update")) {
                    request.getRequestDispatcher("/views/doctor/patient_covid.jsp").forward(request, response);
                }

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
