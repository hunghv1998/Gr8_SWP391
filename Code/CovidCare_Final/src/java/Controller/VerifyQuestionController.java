/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import DAO.QuestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class VerifyQuestionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String answer = request.getParameter("answer");
        int questId = Integer.parseInt(request.getParameter("question_id"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String message="";
        
        QuestionDAO qD = new QuestionDAO();
        
        if(qD.checkingAccountAnswer(userId,questId,answer.trim())){
            request.setAttribute("userId", userId);
            request.getRequestDispatcher("views/recover/changeForgot.jsp").forward(request, response);
        }
        
        else{
            request.setAttribute("userId", userId);
            message ="Câu trả lời sai";
            request.setAttribute("message", message);
            request.setAttribute("listQuestion", qD.getAllQuestion());
            request.getRequestDispatcher("views/recover/questionForgot.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int userId = Integer.parseInt(request.getParameter("userId"));
        String password = request.getParameter("password");
        String cf_password = request.getParameter("confirm_password");
        String message="";
        UserDAO aD = new UserDAO();
        
        if(password.equals(cf_password)){
            aD.updatePassword(userId, password);
            response.sendRedirect("login");
        }else{
            message = "Mật khẩu không khớp !";
            request.setAttribute("userId", userId);
            request.setAttribute("message", message);
            request.getRequestDispatcher("views/recover/changeForgot.jsp").forward(request, response);           
        }
     }



}
