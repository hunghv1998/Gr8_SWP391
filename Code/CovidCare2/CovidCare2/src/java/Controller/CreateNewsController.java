package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dal.NewsDAO;
import Model.Account;
import Model.News;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;

/**
 *
 * @author Administrator
 */
@MultipartConfig

public class CreateNewsController extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
        request.getRequestDispatcher("view/createNews.jsp").forward(request, response);

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
        try {
            NewsDAO nD = new NewsDAO();
            Account acc = (Account) request.getSession().getAttribute("account");
            Random r = new Random();
            //get data from jsp 
            String title = request.getParameter("title");
            String description = request.getParameter("description");

            //get date 
            java.sql.Date created_date = new java.sql.Date(System.currentTimeMillis());

            //get Photo 
            Part part = request.getPart("photo");
            String realPath = request.getServletContext().getRealPath("/images/news");
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            part.write(realPath + "/" + filename);

            //get Short Description 
            String[] arrOfStr = description.split(" ");
            String shortDes = "";
            for (int i = 0; i < 15; i++) {
                shortDes += arrOfStr[i];
                shortDes += " ";
            }

            //Create new news 
            News n = new News();
            n.setNewsId(r.nextInt());
            n.setTitle(title);
            n.setContent(description);
            n.setShort_des(shortDes);
            n.setUname(acc.getUserName());
            n.setCreate_date(created_date);

            //insert into DB
            nD.createNews(n);
            response.sendRedirect("view/home.jsp");
        } catch (Exception e) {

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
