package Controller;

import Dal.NewsDAO;
import Model.Account;
import Model.News;
import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

public class CreateNewsController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String UPLOAD_DIR = "images/news";
    public String dbFileName = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/createNews.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        NewsDAO nD = new NewsDAO(); 

        //get title, des,and path file
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        //get Short Des
        
        String shortDes = getShortDescriptiop(description);
        if(shortDes.length() == 0){
            request.setAttribute("errMess", "Description must be more than 100 character");
            request.getRequestDispatcher("CreateNews").forward(request, response);
        }
        //get created date 
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        //get Acc created 
        Account acc = (Account) request.getSession().getAttribute("account");

        //get image file 
        Part part = request.getPart("file");
        String fileName = "";
        if (part != null) {
             fileName = extractFileName(part);
            String applicationPath = getServletContext().getRealPath("");

            String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
            System.out.println("applicationPath:" + applicationPath);
            File fileUploadDirectory = new File(uploadPath);
            if (!fileUploadDirectory.exists()) {
                fileUploadDirectory.mkdirs();
            }
            //create new path to save image
            String savePath = uploadPath + File.separator + fileName;
            String sRootPath = new File(savePath).getAbsolutePath();

            //copy input file to new path
            part.write(savePath + File.separator);
            File fileSaveDir1 = new File(savePath);

            dbFileName = UPLOAD_DIR + File.separator + fileName;
            part.write(savePath + File.separator);
        }
   
       
        
        //Create New
        
        News n = new News();
        n.setContent(description);
        n.setCreate_date(date);
        n.setPublish_date(date);
        n.setPhoto("images/news/" + fileName);
        n.setUname(acc.getUserName());
        n.setShort_des(shortDes);
        n.setTitle(title);
        
        nD.createNews(n);
        
        response.sendRedirect("CreateNews");
     
        

        
        

    }

    private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    String getShortDescriptiop(String des) {
        String[] arrDes = des.split(" ");
        String shortDes = "";
        if(arrDes.length < 50){
            return "";
        }
        for (int i = 0; i < 50; i++) {
            shortDes += arrDes[i];
            shortDes += " ";
        }
        return shortDes;
    }

}
