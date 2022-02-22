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

public class UserInfoController extends HttpServlet {
    private static final long SerialVersionUID = 1L;
    private static final String  UPLOAD_DIR = "images/uploads";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("update") != null) {
            request.setAttribute("title", "Cập nhật thông tin cá nhân");
        } else {
            request.setAttribute("title", "Thông tin các nhân");
        }
        
        Account account = (Account) request.getSession().getAttribute("account");

        if (account == null) {
            response.sendRedirect("Login");
        } else {
            UserInfo user = new UserInfo();
            UserInfoDAO uiD = new UserInfoDAO();
            if (!uiD.checkFirstLogin(account.getUserName())) {
                request.setAttribute("update", "update");
            } else {
                user = uiD.getUserInfo(account.getUserName());
            }
            request.getSession().setAttribute("userinfo", user);
            request.getRequestDispatcher("/view/profile.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("update") != null) {
            //get info from jsp
            String name = request.getParameter("name");
            String email = request.getParameter("email");
//            String image = request.getParameter("image");
            String image = uploadFile(request, "profilepic");
            
            String address = request.getParameter("address");
            System.out.println(request.getParameter("bod"));
            Date bday = Date.valueOf(request.getParameter("bod"));
            boolean sex = true;
            if (request.getParameter("gender").equals('1')) {
                sex = false;
            }

            // Validating input
            // Update input
            UserInfo userinfo = new UserInfo(bday, sex, email, image, address, name, true);
            Account account = (Account) request.getSession().getAttribute("account");
            UserInfoDAO uiD = new UserInfoDAO();
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
        for(String content : part.getHeader("content-disposition").split(";")) {
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
