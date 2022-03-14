<%-- 
    Document   : newsDetails
    Created on : Feb 24, 2022, 9:57:02 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "../common/nav.jsp" %>
  
        <section class="news single-news section">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 offset-md-1 col-lg-12 offset-lg-0">
                        <article class="single-post">
                            <h3>${n.title}</h3>
                            <ul class="list-inline">
                                <li class="list-inline-item">by <a href="">Admin</a></li>
                                <li class="list-inline-item">${n.create_date}</li>
                            </ul>
                            <img src="${n.photo}">
                            <p> ${n.content}</p> 									
                            <p>Hết Bài !</p>
                        </article>
                    </div>
                </div>
            </div>
        </section>


        <section class="popular-deals section bg-gray">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-title">
                            <h2>Tin Tức Khác</h2>					
                        </div>
                    </div>
                </div>
                
                <div class="row">
                      
                    <!-- offer 01 -->
                    <div class="col-lg-12">                    
                        <div class="trending-ads-slide">
                           <c:forEach items="${newses}" var="n">
                            <div class="col-sm-12 col-lg-4">
                                
                                <div class="product-item bg-light">
                                    <div class="card">
                                        <div class="thumb-content">                                          
                                             <a href="NewsDetails?newsId=${n.newsId}">
                                                <img class="card-img-top img-fluid" src="${n.photo}">
                                            </a>
                                        </div>
                                        <div class="card-body">
                                            <h4 class="card-title"><a  <a href="NewsDetails?newsId=${n.newsId}">${n.title}</a></h4>
                                            <ul class="list-inline product-meta">
                                                <li class="list-inline-item">
                                                    <a><i class="fa fa-folder-open-o"></i>Admin</a>
                                                </li>
                                                <li class="list-inline-item">
                                                    <a href="NewsDetails?newsId=${n.newsId}"><i class="fa fa-calendar"></i>${n.create_date}</a>
                                                </li>
                                            </ul>
                                            <p class="card-text">${n.short_des}</p>                                          
                                        </div>
                                    </div>
                                </div>
                            </div>
                           </c:forEach>     
                        </div>
                        
                    </div>
                                        
                </div>
                                       
            </div>
        </section>

    </body>
    <%@include file = "../common/footer.jsp" %>
</html>
