/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.NewsDAO;
import Model.News;
import Model.NewsCategory;
import Model.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
        NewsDAO nD = new NewsDAO();
        ArrayList<NewsCategory> newsCate = nD.getCateList();

        if (newsCate != null) {
            request.setAttribute("newsCate", newsCate);
        }
        request.getRequestDispatcher("views/admin/news_create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String message = "";
        String photo = "";
        int publishStatus = -1;

        //get item
        String title = request.getParameter("title");
        int cateId = Integer.parseInt(request.getParameter("category"));
        String shortDes = request.getParameter("description");
        String content = request.getParameter("content");
        String rawPublishStatus = request.getParameter("publishStatus");

        //get file photo
        Part part = request.getPart("photo");
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
            photo = fileName;
        }

        Timestamp created_date = new Timestamp(System.currentTimeMillis());

        NewsDAO nD = new NewsDAO();

        if (rawPublishStatus != null) {
            publishStatus = Integer.parseInt(rawPublishStatus);
        }
        //get list category
        ArrayList<NewsCategory> newsCate = nD.getCateList();
        if (newsCate != null) {
            request.setAttribute("newsCate", newsCate);
        }

        //clear session Message
        //get Creator
        User user = (User) request.getSession().getAttribute("user");
        //check empty each item 
        if (title.equals("") || title.length() == 0) {
            message += "Tiêu đề bài viết trống ! <br>";
        }
        if (shortDes.equals("") || shortDes.length() == 0) {
            message += "Tóm tắt bài viết trống ! <br>";
        }
        if (content.equals("") || content.length() == 0) {
            message += "Nội dung bài viết trống ! <br>";
        }
        if (publishStatus == -1) {
            message += "Tùy chọn đăng chưa được lựa chọn <br>";
        }
        if (photo.equals("") || photo.length() == 0) {
            message += "Ảnh chưa được lựa chọn <br>";
        }

        //if message have content
        if (!message.equals("") || message.length() != 0) {
            News currNews = new News();
            if (request.getSession().getAttribute("currNews") != null) // check if condition the session not null
            {

                request.getSession().setAttribute("currNews", currNews);
            }
            currNews.setTitle(title);
            currNews.setShort_des(shortDes);
            currNews.setContent(content);
            currNews.setCateId(cateId);

            request.getSession().setAttribute("currNews", currNews);

            if (request.getSession().getAttribute("message") != null) // check if condition the session not null
            {
                request.getSession().setAttribute("message", "");
            }
            request.getSession().setAttribute("message", message);

            currNews.setTitle(title);

            response.sendRedirect("createNews");
        }

        //for test
//        int creator=3;
        //create news 
        News n = new News();
        n.setCreator(user.getUserId());
        n.setCateId(cateId);
        n.setTitle(title);
        n.setContent(content);
        n.setShort_des(shortDes);
        n.setPhoto(photo);
        n.setStatus((publishStatus == 1) ? true : false);
        n.setCreate_date(created_date);
        n.setPublish_date((publishStatus == 1) ? created_date : null);
        n.setReadCount(0);

        int insert_news = nD.addNews(n);

        if (insert_news != 0) {
            message += "Thêm bài viết thành công !<br>";
            request.setAttribute("message", message);
            request.getRequestDispatcher("views/admin/news_create.jsp").forward(request, response);
        }

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

}
