/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.CommonDataDAO;
import Dal.UserInfoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Account;
import Model.Disease;
import Model.UserInfo;
import Model.Vaccine;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import utils.ValidatingInput;
import utils.UploadFile;

/**
 *
 * @author chinh
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)

public class UserInfoController extends HttpServlet {

    private static final long SerialVersionUID = 1L;
    private static final String UPLOAD_DIR = "images/uploads";

    private final UserInfoDAO uiD = new UserInfoDAO();
    private final CommonDataDAO cdD = new CommonDataDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Get session
            HttpSession session = request.getSession();

            // Set UserInfo title
            if (request.getParameter("update") != null) {
                request.setAttribute("title", "Cập nhật thông tin cá nhân");
            } else {
                request.setAttribute("title", "Thông tin các nhân");
            }
            // Authentication
            Account account = (Account) request.getSession().getAttribute("account");

            if (account == null) {
                response.sendRedirect("login");
            } else {
                UserInfo userinfo = new UserInfo(null, false, "", "", "", "", false);
                if (!uiD.checkFirstLogin(account.getUserName())) {
                    request.setAttribute("update", "update");
                } else {
                    userinfo = uiD.getUserInfo(account.getUserName());
                }

                ArrayList<Vaccine> vaccines = cdD.getVaccineList();
                ArrayList<Disease> diseases = cdD.getDiseaseList();

                session.setAttribute("name", userinfo.getName());
                session.setAttribute("gender", userinfo.isSex());
                session.setAttribute("bod", userinfo.getBday());
                session.setAttribute("email", userinfo.getEmail());
                session.setAttribute("image", userinfo.getImage());
                session.setAttribute("address", userinfo.getAddress());
                session.setAttribute("vaccines", vaccines);
                session.setAttribute("diseases", diseases);

                request.getSession().setAttribute("userinfo", userinfo);
                request.getRequestDispatcher("/view/profile.jsp").forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        if (request.getParameter("update") != null) {
            //Get UserInfo from session
            UserInfo userinfo = (UserInfo) request.getSession().getAttribute("userinfo");
            if (userinfo == null) {
                userinfo = new UserInfo();
            }

            //get info from jsp
            String name = request.getParameter("name");
            System.out.println(name);
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            Date bod = Date.valueOf(request.getParameter("bod"));
            //Image processing
            Part filePart = request.getPart("profilepic");
            String image = userinfo.getImage();

            System.out.println(request.getParameter("bod"));

            boolean gender = true;
            if (request.getParameter("gender").equals("0")) {
                gender = false;
            }

            // Validating input
            String message = "";
            ValidatingInput check = new ValidatingInput();
            System.out.println(check.CalculateBirthday(bod));
            if (!check.isName(name)) {
                message += "Tên đã nhập không đúng<br>";
            }
            if (!check.isEmail(email)) {
                message += "Email đã nhập không đúng<br>";
            }
            UploadFile ulF = new UploadFile();
            if (!ulF.getFileName(filePart).equals("")) {
                image = ulF.uploadFile(request, "profilepic", UPLOAD_DIR);
            }
            if (!message.equals("")) {
                request.getSession().setAttribute("message", message);
                request.setAttribute("name", name);
                request.setAttribute("email", email);
                request.getRequestDispatcher("view/profile.jsp").forward(request, response);
            } else {
                // Update input
                userinfo.setName(name);
                userinfo.setSex(gender);
                userinfo.setEmail(email);
                userinfo.setAddress(address);
                userinfo.setImage(image);
                userinfo.setBday(bod);
                userinfo.setFirstTimeLogin(true);
//                UserInfo userinfo = new UserInfo(bday, gender, email, image, address, name, true);
                Account account = (Account) request.getSession().getAttribute("account");
                int status = uiD.UpdateUserInfo(userinfo, account.getUserName());
                if (status > 0) {
                    request.getSession().setAttribute("userinfo", userinfo);
                    response.sendRedirect("userinfo");
                } else {
                    request.getSession().setAttribute("message", "Có lỗi đã xảy ra.<br>"
                            + "Vui lòng cập nhật lại.<br>");
                    response.sendRedirect("userinfo?update");
                }
            }
        }
    }
}
