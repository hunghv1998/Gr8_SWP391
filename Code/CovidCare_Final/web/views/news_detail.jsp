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
                            <h3>${news.title}</h3>
                            <ul class="list-inline">
                                <li class="list-inline-item">by ${author}</li>
                                <li class="list-inline-item">at ${news.publish_date}</li>
                                <li class="list-inline-item">- Lượt xem ${news.readCount}</li>
                            </ul>
                            <img src="images/news/${news.photo}">
                            <h6>${news.short_des}</h6>
                            <p> ${news.content}</p>
                        </article>
                    </div>
                </div>
            </div>
        </section>
    </body>
    <%@include file = "../common/footer.jsp" %>
</html>
