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
        <div class="content-wrapper">
            <div class="container">
                <div class="content-left">
                    <div class="section cake">
                        <h1 class="product-name">${n.title}</h1>
                        <div class="content">
                            <div>
                                <img src="${n.photo}" style="width: 1100px; height: 600px">
                            </div>
                            ${n.content}  
                            <br>
                            <br>
                            <p><div>Date created:<br>${n.create_date}</div></p>
                            <p><div>Date published:<br>${n.publish_date}</div></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>
    <%@include file = "../common/footer.jsp" %>
</html>
