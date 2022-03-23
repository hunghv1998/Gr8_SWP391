<%-- 
    Document   : error.jsp
    Created on : Feb 14, 2022, 10:55:30 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">

        <%@include file = "../common/nav.jsp" %>
        <section class="section bg-gray">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 text-center mx-auto">
                        <div class="404-img">
                            <img src="images/error.png" class="img-fluid" alt="">
                        </div>
                        <div class="404-content">
                            <h1 class="display-1 pt-1 pb-2">Oops</h1>
                            <p class="px-3 pb-2 text-dark">${message}</p>
                            <a href="." class="btn btn-info">GO HOME</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--Footer-->

        <%@include file = "../common/footer.jsp" %>

</html>
