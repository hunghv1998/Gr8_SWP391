/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Feature;
import model.Group;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Authentication", urlPatterns = {"/Authentication"})
public abstract class Authentication extends HttpServlet {

    boolean checkAuthentication(HttpServletRequest request) {
        Account acc = (Account) request.getSession().getAttribute("Account");

        if (acc == null) {
            return false;
        }

        String url = request.getServletPath();

        for (Group g : acc.getListGroup()) {
            for (Feature f : g.getListFeature()) {
                if (f.getUrl().equals(url)) {
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (checkAuthentication(request)) {
            processGet(request, response);
        } else {
            response.getWriter().print("Access Denie !");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (checkAuthentication(request)) {
            processPost(request, response);
        } else {
            response.getWriter().print("Access Denie !");
        }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

}
