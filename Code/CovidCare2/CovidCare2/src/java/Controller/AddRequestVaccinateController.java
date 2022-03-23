/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class AddRequestVaccinateController extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_postId = request.getParameter("post_id");
        int postId=0;
        if(raw_postId != null){
            postId = Integer.parseInt(raw_postId);            
        }
        
        request.setAttribute("post_id", postId);
        request.getRequestDispatcher("view/addRequestVaccinate.jsp").forward(request, response);
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
