/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CommonDataDAO;
import DAO.PatientDAO;
import Model.AgeType;
import Model.City;
import Model.Disease;
import Model.District;
import Model.Patient;
import Model.User;
import Model.Vaccine;
import Model.VaccineStatus;
import Model.Ward;
import Utils.UploadFile;
import Utils.ValidatingInput;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author chinh
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)

public class PatientInfoController extends HttpServlet {

    private static final String UPLOAD_DIR = "images/patient";

    private final ValidatingInput check = new ValidatingInput();
    private final PatientDAO patientDAO = new PatientDAO();
    private final CommonDataDAO commonDAO = new CommonDataDAO();

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
            out.println("<title>Servlet InfoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InfoController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();

        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("login");
        } else {
            String action = request.getParameter("action");

            if (action == null) {
                action = "view";
            }

            int id = 0;

            if (user.getUserType() == 3) {
                id = user.getUserId();
            } else if (request.getParameter("id") != null
                    && check.isNumber(request.getParameter("id"))) {
                id = Integer.parseInt(request.getParameter("id"));
            }

            Patient patient = (Patient) patientDAO.getPatientInfo(id);

            if (patient != null) {
                ArrayList<VaccineStatus> vaccStatusList = commonDAO.getVaccineStatusList();
                ArrayList<Vaccine> vaccines = commonDAO.getVaccineList();
                ArrayList<AgeType> ages = commonDAO.getAgeTypeList();
                ArrayList<Disease> diseases = commonDAO.getDiseaseList();
                
                City patientCity = commonDAO.geCityByWardId(patient.getWardId());
                District patientDistrict = commonDAO.getDistrictByWardId(patient.getWardId());
                Ward patientWard = commonDAO.getWardByWardId(patient.getWardId());
                
                session.setAttribute("vaccStatusList", vaccStatusList);
                session.setAttribute("vaccines", vaccines);
                session.setAttribute("ages", ages);
                session.setAttribute("diseases", diseases);
                session.setAttribute("patient", patient);
                session.setAttribute("city", patientCity);
                session.setAttribute("district", patientDistrict);
                session.setAttribute("ward", patientWard);

                if (patient.isFirstTimeLogin()) {
                    action = "update";
                }
            }

            request.setAttribute("action", action);

            // Set UserInfo title
            if (action.equals("update")) {
                request.setAttribute("title", "Cập nhật thông tin cá nhân");
            } else {
                request.setAttribute("title", "Thông tin cá nhân");
            }
            request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
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

        String action = request.getParameter("action");
        
        if (action == null) {
            action = "view";
        }
        
        request.setAttribute("action", action);
        
        int id = 0;

        if (request.getParameter("id") != null && check.isNumber(request.getParameter("id"))) {
            id = Integer.parseInt(request.getParameter("id"));
        } else {
            id = user.getUserId();
        }

        Patient patient = (Patient) request.getSession().getAttribute("patient");

        if (patient == null) {
            patient = new Patient();
        }

        // Patient name
        String name = request.getParameter("name");

        // Patient gender
        boolean gender = true;
        if (request.getParameter("gender").equals("0")) {
            gender = false;
        }

        // Patient DOB
        Date birthday = Date.valueOf(request.getParameter("birthday"));

        // Patient email
        String email = request.getParameter("email");

        // Profile Image processing
        Part filePart = request.getPart("profilepic");
        String image = patient.getPhoto();

        // Patient address
        String wardId = request.getParameter("wards");
        String address = request.getParameter("address");

        // Patient vaccine status
        int vaccineStatus = Integer.parseInt(request.getParameter("vaccineStatus"));
        String[] selectedVaccines = request.getParameterValues("vaccines");
        if (selectedVaccines == null) {
            selectedVaccines = new String[]{};
        }
        ArrayList<Integer> vaccines = new ArrayList<>();
        for (String selectedVaccine : selectedVaccines) {
            vaccines.add(Integer.parseInt(selectedVaccine));
        }
        // Patient pregnancy status
        boolean isPregnant = false;
        if (request.getParameter("isPregnant").equals("1")) {
            isPregnant = true;
        }

        // Patient health emergency
        boolean isEmergency = false;
        if (request.getParameter("isEmergency").equals("1")) {
            isEmergency = true;
        }

        // Patient age type
        int ageType = Integer.parseInt(request.getParameter("ages"));

        // Patient background diseases info
        String[] selectedDiseases = request.getParameterValues("diseases");
        ArrayList<Integer> diseases = new ArrayList<>();
        if (selectedDiseases == null) {
            selectedDiseases = new String[]{};
        }
        for (String selectedDisease : selectedDiseases) {
            diseases.add(Integer.parseInt(selectedDisease));
        }
        
        // Validating input
        String message = "";
        if (!check.isName(name)) {
            message += "Tên đã nhập không hợp lệ<br>";
        }

        if (!check.isEmail(email)) {
            message += "Email đã nhập không đúng<br>";
        }

        UploadFile ulF = new UploadFile();
        if (!ulF.getFileName(filePart).equals("")) {
            image = ulF.uploadFile(request, "profilepic", UPLOAD_DIR);
        }

        if (wardId == null || wardId.equals("0")) {
            message += "Vui lòng cập nhật chi tiết địa chỉ Phường/Xã đang sinh sống<br>";
        }

        if (vaccineStatus == 0 || vaccines.isEmpty()) {
            vaccineStatus = 1;
        } else if (vaccines.size() >= 3) {
            vaccineStatus = 4;
        } else if (vaccines.size() < 2) {
            vaccineStatus = 2;
        } else if (vaccineStatus < 3 && vaccines.size() == 2) {
            vaccineStatus = 3;
        }
        System.out.println(vaccines.size() + " " + vaccines.toString());
        if ((!gender) && isPregnant) {
            message += "Đàn ông không thể có bầu<br>";
        }

        if (ageType != check.CalculateBirthday(birthday)) {
            message += "Nhóm tuổi lựa chọn chưa chính xác<br>";
        }

        patient.setUserId(id);
        patient.setName(name);
        patient.setGender(gender);
        patient.setBirthday(birthday);
        patient.setEmail(email);
        patient.setPhoto(image);
        patient.setWardId(wardId);
        patient.setAddress(address);
        patient.setVaccineStatus(vaccineStatus);
        patient.setVaccList(vaccines);
        patient.setPregnancyStatus(isPregnant);
        patient.setEmergencyStatus(isEmergency);
        patient.setAgeType(ageType);
        patient.setDiseases(diseases);

        if (!message.equals("")) {
            request.getSession().setAttribute("message", message);
            request.getSession().setAttribute("patient", patient);
            request.getRequestDispatcher("views/profile.jsp").forward(request, response);
        } else {
            System.out.println(patient.getDiseases().toString());
            patientDAO.changePatientInfo(patient);
            patientDAO.updateFirstTimeFlag(id, false);

            response.sendRedirect("info");
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
