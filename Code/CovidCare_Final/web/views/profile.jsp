<%-- 
    Document   : profile
    Created on : Mar 14, 2022, 6:19:51 PM
    Author     : chinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "../common/nav.jsp" %>

        <!--==================================
        =            User Profile            =
        ===================================-->

        <section class="user-profile section" style="padding-top: 0px;">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-lg-12">
                        <% if (request.getParameter("action") == null
                                    || request.getAttribute("action").equals("view")
                                    || request.getParameter("action").equals("view")) {%>
                        <%@include file = "patient/viewProfile.jsp" %>
                        <%} else if (request.getAttribute("action").equals("update")
                                || request.getParameter("action").equals("update")) {%>
                        <%@include file = "patient/editProfile.jsp" %>
                        <%}%>
                    </div>
                </div>
            </div>
        </section>
    </body>

    <%@include file = "../common/footer.jsp" %>
</html>