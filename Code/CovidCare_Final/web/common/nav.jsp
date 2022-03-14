<%-- 
    Document   : nav
    Created on : Feb 14, 2022, 1:00:44 AM
    Author     : chinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar navbar-expand-lg navbar-light navigation">
                    <a class="navbar-brand" href=".">
                        <img src="images/icon.png" alt="" width="100" height="100">
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto main-nav ">
                            <li class="nav-item active">
                                <a class="nav-link" href=".">Trang chủ</a>
                            </li>
                            <c:choose>
                                <c:when test="${account.getGroupId() == 1}">
                                    <li class="nav-item active">
                                        <a class="nav-link" href="management">Quản lý</a>
                                    </li>
                                    <li class="nav-item active">
                                        <a class="nav-link" href="statistic">Thống kê</a>
                                    </li>
                                    <li class="nav-item active">
                                        <a class="nav-link" href="CreateNews">Tạo bản tin mới</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${account.getGroupId() == 2}">
                                            <li class="nav-item active">
                                                <a class="nav-link" href="">Lịch trình</a>
                                            </li>
                                            <li class="nav-item active">
                                                <a class="nav-link" href="">Quản lý bệnh nhân</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="nav-item active">
                                                <a class="nav-link" href="chat">Hỗ Trợ Trực Tuyến</a>
                                            </li>
                                            <li class="nav-item active">
                                                <a class="nav-link" href="news">Tin tức</a>
                                            </li>
                                            <li class="nav-item active">
                                                <a class="nav-link" href="tutorial">Hướng dẫn</a>
                                            </li>
                                            <li class="nav-item active">
                                                <a class="nav-link" href="timetable">Thời gian biểu</a>
                                            </li>
                                            <c:if test="${account.getGroupId() == 3}">
                                                <li class="nav-item active">
                                                    <a class="nav-link" href="userinfo">Thông tin cá nhân</a>
                                                </li>
                                            </c:if>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                        <ul class="navbar-nav ml-auto mt-10">
                            <c:choose>
                                <c:when test="${account == null}">
                                    <li class="nav-item">                                   
                                        <a class="nav-link login-button" href="login">Đăng Nhập</a> 
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="nav-item">
                                        <a class="nav-link login-button" href="logout">Đăng Xuất</a> 
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
