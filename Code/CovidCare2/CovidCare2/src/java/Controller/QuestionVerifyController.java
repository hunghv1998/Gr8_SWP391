/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.AccountDAO;
import Dal.QuestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class QuestionVerifyController extends HttpServlet {
    
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String answer = request.getParameter("answer");
        int questId = Integer.parseInt(request.getParameter("question_id"));
        String username = request.getParameter("username");
        String message="";
        
        QuestionDAO qD = new QuestionDAO();
        
        if(qD.checkingAccountAnswer(username,questId,answer.trim())){
            request.setAttribute("username", username);
            request.getRequestDispatcher("view/changeForgot.jsp").forward(request, response);
        }
        else{
            request.setAttribute("username", username);
            message ="Câu trả lời sai";
            request.setAttribute("message", message);
            request.setAttribute("listQuestion", qD.getAllQuestion());
            request.getRequestDispatcher("view/questionForgot.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cf_password = request.getParameter("confirm_password");
        String message="";
        AccountDAO aD = new AccountDAO();
        
        if(password.equals(cf_password)){
            aD.updatePassword(username, password);
            response.sendRedirect("login");
        }else{
            message = "Mật khẩu không khớp !";
            request.setAttribute("username", username);
            request.setAttribute("message", message);
            request.getRequestDispatcher("view/changeForgot.jsp").forward(request, response);           
        }
     }



}
