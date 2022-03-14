<%-- 
    Document   : profile
    Created on : Feb 16, 2022, 3:40:31 AM
    Author     : chinh
--%>

<%@page import="Model.UserInfo"%>
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
                        <% if (request.getAttribute("update") != null || request.getParameter("update") != null) {%>
                        <%@include file = "patient/editProfile.jsp" %>
                        <%} else {%>
                        <%@include file = "patient/viewProfile.jsp" %>
                        <%}%>
                    </div>
                </div>
            </div>
        </section>
    </body>

    <%@include file = "../common/footer.jsp" %>
</html>