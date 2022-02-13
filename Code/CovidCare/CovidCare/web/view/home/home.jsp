<%-- 
    Document   : home
    Created on : Feb 9, 2022, 9:19:40 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "../nav/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "../nav/nav.jsp" %>
        
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
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <a href="news.jsp"><i class="fa fa-newspaper-o"></i> Tin Tức</a></li>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href=""><i class="fa fa-wechat"></i> Chat</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href=""><i class="fa fa-calendar-times-o"></i> Thời Gian Biểu</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Container End -->
        </section>

        <section class="hero-area bg-2 text-center overly" style="background: url('../images/home/banner-news.jpg');">
            <!-- Container Start -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Header Contetnt -->
                        <div class="content-block" style="text-align: left;">
                            <h1><a href="news.jsp" style="color: whitesmoke;">Bản Tin Covid</a></h1>
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
                            <div class="short-popular-category-list text-center">
                                <ul class="list-inline"  style="text-align: right;">
                                    <li class="list-inline-item">
                                        <a href=""><i class="fa fa-wechat"></i> Chat</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href=""><i class="fa fa-calendar-times-o"></i> Thời Gian Biểu</a>
                                    </li>
                                </ul>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
            <!-- Container End -->
        </section>

    </body>
<%@include file = "../nav/footer.jsp" %>
</html>




