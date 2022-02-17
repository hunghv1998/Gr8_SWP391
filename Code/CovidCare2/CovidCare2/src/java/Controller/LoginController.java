/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dal.AccountDAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class LoginController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account acc = (Account) request.getSession().getAttribute("account");
        if(acc != null){
            request.setAttribute("username", acc.getUserName());
            request.setAttribute("password", acc.getPassWord());
        }
        request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountDAO aD = new AccountDAO();
        
        Account acc = aD.getAccountByUsernameAndPassword(username, password);
        
        if(acc != null){
           HttpSession session=request.getSession();  
           session.setAttribute("account",acc); 
            response.sendRedirect("Home");
            
        }else{
            request.setAttribute("messWrongPassword", "Username or password wrong !");
            request.getRequestDispatcher("/view/Login.jsp").forward(request,response);
        }
        
        
    }

 
}
