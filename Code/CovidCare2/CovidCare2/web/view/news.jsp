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
                    <h1 style="color: #666; margin-top: 40px; font-weight: bold;" >Tin Tức</h1>
                  <div class="col-md-10 offset-md-1 col-lg-9 offset-lg-2">
                    <c:forEach items="${newses}" var="n">
                        <hr>
                        <div  class="section intro">
                            <div class="content">                              
                                <h2 class="content-title" style="color: #666666; margin-top: 40px;"><a href="NewsDetails?newsId=${n.newsId}">${n.title}</a></h2>
                                <div class="form-row">
                                    <div class="form-group col-md-6">                                 
                                        <a href="NewsDetails?newsId=${n.newsId}"><img src="${n.photo}" style="width: 400px; height: 300px"/></a>
                                    </div>
                                    <div class="form-group col-md-6 align-self-center" style="margin-top: 130px; ">
                                        <div style="margin-bottom: 30px; text-decoration :underline;"> <a style="font-family: cursive; font-weight: bolder; font-style: italic;"> Ngày tạo : </a><span style="color: #666; font-style: italic" href="NewsDetails?newsId=${n.newsId}"> ${n.create_date}</span></div>
                                        <div> <Span style ="font-style: italic;"> ${n.short_des} </span></div>
                                    </div>
                                </div>

                            </div>
                        </div>  
                        
                    </c:forEach>
                    </div>
                </div>
            </div>
        </div>


    </body>
    <%@include file = "../common/footer.jsp" %>
</html>
