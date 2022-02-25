<%-- 
    Document   : news.jsp
    Created on : Feb 17, 2022, 11:50:04 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "../common/nav.jsp" %>
        <section class="hero-area bg-3 text-center overly">
            <!-- Container Start -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Header Contetnt -->
                        <div class="content-block">
                            <h1>Covid Care</h1>
                            <p>
                                Tư vấn và hướng dẫn sức khỏe cộng đồng mùa covid <br />
                                Cập nhật diễn biến covid hàng ngày
                            </p>
                            <div class="short-popular-category-list text-center">
                                <h2>Danh mục phổ biến</h2>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <a href="news.html"> Bản Tin Covid</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="category.html">Hướng Dẫn</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="category.html">Chat</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="category.html">Thời Gian Biểu</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Container End -->
        </section>
        <div class="content-wrapper">
            <div class="container">
                <div class="content-left">
                    <c:forEach items="${newses}" var="n">
                        <div class="section intro">
                            <div class="content">
                                <h1 class="content-title"><a href="NewsDetails?newsId=${n.newsId}">${n.title}</a></h1>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                       <a href="NewsDetails?newsId=${n.newsId}"><img src="${n.photo}" style="width: 500px; height: 400px"/></a>
                                    </div>
                                    <div class="form-group col-md-6 align-self-center">
                                        <h2>${n.short_des}</h2>
                                    </div>
                                </div>

                            </div>
                        </div>  
                    </c:forEach>

                </div>
            </div>
        </div>


    </body>
    <%@include file = "../common/footer.jsp" %>
</html>
