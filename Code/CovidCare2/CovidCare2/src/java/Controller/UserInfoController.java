/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.UserInfoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Account;
import Model.UserInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            response.sendRedirect("Login");
        } else {
            UserInfo userinfo = new UserInfo(null, false, "","", "", "", false);
            if (!uiD.checkFirstLogin(account.getUserName())) {
                request.setAttribute("update", "update");
            } else {
                userinfo = uiD.getUserInfo(account.getUserName());
            }
            session.setAttribute("name", userinfo.getName());
            session.setAttribute("gender", userinfo.isSex());
            session.setAttribute("bod", userinfo.getBday());
            session.setAttribute("email", userinfo.getEmail());
            session.setAttribute("image", userinfo.getImage());
            session.setAttribute("address", userinfo.getAddress());
            request.getSession().setAttribute("userinfo", userinfo);
            request.getRequestDispatcher("/view/profile.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("update") != null) {
            //Get UserInfo from session
            UserInfo userinfo = (UserInfo) request.getSession().getAttribute("userinfo");
            if (userinfo == null) {
                userinfo = new UserInfo();
            }

            //get info from jsp
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            Date bod = Date.valueOf(request.getParameter("bod"));
            //Image processing
            Part filePart = request.getPart("profilepic");

//            String image = request.getParameter("image");
            String image = "";

            System.out.println(request.getParameter("bod"));

            boolean gender = true;
            if (request.getParameter("gender").equals('1')) {
                gender = false;
            }

            // Validating input
            String message = "";
            ValidatingInput check = new ValidatingInput();
            if (!check.isName(name)) {
                message += "Tên đã nhập không đúng<br>";
            }
            if (!check.isPhoneNumber(phone)) {
                message += "Số điện thoại đã nhập không đúng<br>";
            }
            System.out.println(phone + " " + check.isPhoneNumber(phone));
            if (!check.isEmail(email)) {
                message += "Email đã nhập không đúng<br>";
            }
            if (filePart != null) {
                UploadFile ulF = new UploadFile();
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
                    response.sendRedirect("UserInfo");
                } else {
                    request.getSession().setAttribute("message", "Có lỗi đã xảy ra.<br>"
                            + "Vui lòng cập nhật lại.<br>");
                    response.sendRedirect("UserInfo?update");
                }
            }

        }
    }

    private String uploadFile(HttpServletRequest request, String part) throws IOException, ServletException {
        String fileName = "";
        try {
            Part filePart = request.getPart(part);
//            fileName = (String) getFileName(filePart);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            fileName = timestamp.getTime() + getFileExtension(getFileName(filePart));
            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (Exception e) {
            fileName = "";
        }
        return fileName;
    }

    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader: " + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        String extension = ".";

        int i = fileName.lastIndexOf(".");

        if (i > 0) {
            extension += fileName.substring(i + 1);
        }
        return extension;
    }
}
