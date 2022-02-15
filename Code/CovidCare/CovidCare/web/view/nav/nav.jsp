<%-- 
    Document   : nav
    Created on : Feb 14, 2022, 1:00:44 AM
    Author     : chinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Account account = (Account) session.getAttribute("Account");
%>
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar navbar-expand-lg navbar-light navigation">
                    <a class="navbar-brand" href="index.html">
                        <img src="images/icon.png" alt="" width="100" height="100">
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto main-nav ">
                            <li class="nav-item active">
                                <a class="nav-link" href="home.jsp">Trang chủ</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="">Hỗ Trợ Trực Tuyến</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="news.jsp">Tin tức</a>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="">Thời gian biểu</a>
                            </li>

                        </ul>
                        <ul class="navbar-nav ml-auto mt-10">
                            <c:choose>
                                <c:when test="${account == null}">
                                    <li class="nav-item">
                                        <a class="nav-link login-button" href="Login">Đăng Nhập</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="nav-item">
                                        <a class="nav-link login-button" href="">Đăng Xuất</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>

                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</section>

