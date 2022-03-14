/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.NewsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoang Hung
 */
@WebServlet(name = "DeleteNewsController", urlPatterns = {"/DeleteNews"})
public class DeleteNewsController extends Authentication {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer newsId = Integer.parseInt(request.getParameter("newsId"));
        NewsDAO nD = new NewsDAO();
        nD.deleteNews(newsId);
        response.sendRedirect("viewListNewsController");
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
