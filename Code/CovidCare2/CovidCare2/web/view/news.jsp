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
        <section class="page-title">
            <!-- Container Start -->
            <div class="container">
                <div class="row">
                    <div class="col-md-8 offset-md-2 text-center">
                        <!-- Title text -->
                        <h3>Tin Tức</h3>
                    </div>
                </div>
            </div>
            <!-- Container End -->
        </section>


        <section class="news section">
            <div class="container">

                <div class="row">
                    <div class="col-md-10 offset-md-1 col-lg-10 offset-lg-1">
                        <c:forEach items="${newses}" var="n">
                            <article>
                                <!-- Post Image -->
                                <div class="image">
                                    <a href="NewsDetails?newsId=${n.newsId}"><img src="${n.photo}"/></a>
                                </div>
                                <!-- Post Title -->
                                <h3><a href="NewsDetails?newsId=${n.newsId}">${n.title}</a></h3>
                                <ul class="list-inline">
                                    <li class="list-inline-item">by <a href="">Admin</a></li>
                                    <li class="list-inline-item" href="NewsDetails?newsId=${n.newsId}">${n.create_date}</li>
                                </ul>
                                <!-- Post Description -->
                                <p class="">${n.short_des}</p>
                                <!-- Read more button -->
                                <a href="NewsDetails?newsId=${n.newsId}" class="btn btn-primary">Read More</a>
                            </article>
                        </c:forEach>                  
                    </div>
                </div>

            </div>
        </section>

    </body>
    <%@include file = "../common/footer.jsp" %>
</html>
