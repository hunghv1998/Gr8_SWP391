<%-- 
    Document   : index
    Created on : Mar 14, 2022, 11:46:56 AM
    Author     : chinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        request.setAttribute("title", "Trang chủ");
    %>
    <%@include file = "common/head.jsp" %>
    <body>
        <%@include file = "common/nav.jsp" %>

        <section class="hero-area bg-1 text-center overly">
            <!-- Container Start -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Header Contetnt -->
                        <div class="content-block">
                            <h1>Covid Care</h1>
                            <p>Tư vấn và hướng dẫn sức khỏe cộng đồng mùa covid <br> Cập nhật diễn biến covid hàng ngày</p>
                            <div class="short-popular-category-list text-center">
                                <h2>Danh mục phổ biến</h2>
                                <c:choose>
                                    <c:when test="${user.getUserType() == 1}">
                                        <ul class="list-inline">
                                            <li class="list-inline-item">
                                                <a href="managementAccount"><i class="fa fa-user"></i> Quản Lý Tài Khoản</a></li>
                                            <li class="list-inline-item">
                                                <a href="news"><i class="fa fa-newspaper-o"></i> Quản Lý Tin Tức</a>
                                            </li>
                                        </ul>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${user.getUserType() == 2}">
                                                <ul class="list-inline">
                                                    <li class="list-inline-item">
                                                        <a class="nav-link" href="news"><i class="fa fa-newspaper-o"></i>Tin Tức</a>
                                                    </li>
                                                    <li class="list-inline-item">
                                                        <a class="nav-link" href="chat"><i class="fa fa-wechat"></i>Hỗ Trợ Trực Tuyến</a>
                                                    </li>
                                                    <li class="list-inline-item">
                                                        <a class="nav-link" href="timetable"><i class="fa fa-calendar-times-o"></i>Thời Gian Biểu</a>
                                                    </li>
                                                </ul>

                                            </c:when>
                                            <c:otherwise>
                                                <ul class="list-inline">
                                                    <li class="list-inline-item">
                                                        <a class="nav-link" href="news"><i class="fa fa-newspaper-o"></i>Tin Tức</a>
                                                    </li>
                                                    <li class="list-inline-item">
                                                        <a class="nav-link" href="chat"><i class="fa fa-wechat"></i>Hỗ Trợ Trực Tuyến</a>
                                                    </li>
                                                    <li class="list-inline-item">
                                                        <a class="nav-link" href="timetable"><i class="fa fa-calendar-times-o"></i>Thời Gian Biểu</a>
                                                    </li>
                                                </ul>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Container End -->
        </section>

        <section class="hero-area bg-2 text-center overly">
            <!-- Container Start -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Header Contetnt -->
                        <div class="content-block" style="text-align: left;">
                            <h1><a href="news" style="color: whitesmoke;">Bản Tin Covid</a></h1>
                            <p>Cung cấp tin tức chính xác và liên tục về tình hình covid hiện nay <br> Cập nhật diễn biến covid hàng ngày</p>
                        </div>

                    </div>
                </div>
            </div>
            <!-- Container End -->
        </section>

        <section class="hero-area bg-3 text-center overly">
            <!-- Container Start -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Header Contetnt -->
                        <div class="content-block" style="text-align: right;">
                            <h1>Hỗ Trợ Trực Tuyến</h1>
                            <p>Với trang web Covid Care, bạn sẽ được trải nghiệm các tính năng:<br>
                                <i class="fa fa-gg"></i> Trao đổi trực tiếp với bác sĩ qua kênh chat online<br>
                                <i class="fa fa-gg"></i> Tự lập thời gian biểu hằng ngày trên trang web <br>
                                theo lời khuyên của bác sĩ<br>
                                Với đội ngũ bác sĩ uy tín, có kinh nghiệm và trình độ chuyên môn cao</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Container End -->
        </section>
    </body>
    <%@include file = "common/footer.jsp" %>
</body>
</html>