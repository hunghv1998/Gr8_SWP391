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
                            <h3>${news.getTitle()}</h3>
                            <ul class="list-inline">
                                <li class="list-inline-item">by <a href="">Admin</a></li>
                                <li class="list-inline-item">${news.create_date}</li>
                            </ul>
                            <img src="${news.getPhoto()}">
                            <p> ${news.getContent()}</p>
                        </article>
                    </div>
                </div>
            </div>
        </section>
    </body>
    <%@include file = "../common/footer.jsp" %>
</html>
