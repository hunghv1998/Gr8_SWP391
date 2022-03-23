/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.HospitalDAO;
import DAO.PatientDAO;
import DAO.TimetableDAO;
import Model.Hospital;
import Model.Patient;
import Model.TimetableEvent;
import Model.User;
import Utils.ValidatingInput;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class TimetableController extends HttpServlet {

    private final PatientDAO patientDAO = new PatientDAO();
    private final HospitalDAO hospitalDAO = new HospitalDAO();
    private final TimetableDAO timetableDAO = new TimetableDAO();

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
            out.println("<title>Servlet TimetableController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimetableController at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("login");
        } else {
            String action = request.getParameter("action");
            if (action == null) {
                request.setAttribute("title", "Thời gian biểu");
                request.getRequestDispatcher("views/timetable.jsp").forward(request, response);
            } else {
                String id = request.getParameter("id");
                if (action.equals("add") || action.equals("update")) {
                    TimetableEvent event = new TimetableEvent(0, "", 
                            new Timestamp(System.currentTimeMillis()), 
                            new Timestamp(System.currentTimeMillis()), 
                            "", true, true, 0, 0);
                    if (id != null) {
                        event = timetableDAO.getEventDetail(Integer.parseInt(id));
                    }
                    request.setAttribute("event", event);
                    if (user.getUserType() == 2) {
                        Hospital hospital = hospitalDAO.getHospitalById(user.getUserId());
                        ArrayList<Patient> patientsList = patientDAO.getHospitalPatientsList(hospital.getWardId());
                        request.getSession().setAttribute("patients", patientsList);
                    }
                    if (action.equals("add")) {
                        request.setAttribute("title", "Thêm sự kiện mới");
                    }
                    if (action.equals("update")) {
                        request.setAttribute("title", "Thay đổi sự kiện");
                    }
                    request.getRequestDispatcher("views/timetable_add.jsp").forward(request, response);
                } else if (action.equals("delete")) {
                    timetableDAO.deleteEvent(Integer.parseInt(id));
                    response.sendRedirect("timetable");
                } else {
                    request.getRequestDispatcher("views/error.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        User user = (User) request.getSession().getAttribute("user");
        if (request.getParameter("action").equals("add") || request.getParameter("action").equals("update")) {
            String title = request.getParameter("title");
            Timestamp start = getTimestamp(request.getParameter("start"));
            Timestamp end = getTimestamp(request.getParameter("end"));
            String detail = request.getParameter("detail");
            boolean allDay = (request.getParameter("allday") != null);
            boolean progress = (request.getParameter("progress") != null);
            int creator = user.getUserId();
            int assignee = 0;
            if (user.getUserType() == 2) {
                if (check.isNumber(request.getParameter("patient"))) {
                    assignee = Integer.parseInt(request.getParameter("patient"));
                }
            } else {
                assignee = user.getUserId();
            }

            TimetableEvent event = new TimetableEvent(title, start, end, detail, allDay, progress, creator, assignee);
            
            if (request.getParameter("action").equals("add")) {
                timetableDAO.createEvent(event);
            } else if (request.getParameter("action").equals("update")) {
                timetableDAO.updateEvent(event);
            }
            response.sendRedirect("timetable");
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

    private Timestamp getTimestamp(String s) {
        System.out.println(s);
        return (Timestamp.valueOf(s.replace("T", " ").concat(":00.00")));
    }

}
