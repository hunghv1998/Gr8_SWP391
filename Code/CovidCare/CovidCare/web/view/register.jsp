<%-- 
    Document   : register
    Created on : Feb 14, 2022, 1:22:06 AM
    Author     : chinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "nav/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "nav/nav.jsp" %>

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
                                        <a href="news.html"> Bản Tin Covid</a></li>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="">Chat</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="">Thời Gian Biểu</a>
                                    </li>
                                </ul>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
            <!-- Container End -->
        </section>

        <section class="login py-5 border-top-1">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5 col-md-8 align-item-center">
                        <div class="border">
                            <h3 class="bg-gray p-4">Đăng Ký Tài Khoản</h3>
                            <form action="register" method="post">
                                <fieldset class="p-4">
                                    <input type="text" name="username" placeholder="Tài khoản" class="border p-3 w-100 my-2">
                                    <input type="text" name="fullname" placeholder="Họ và tên" class="border p-3 w-100 my-2">
                                    <input type="number" name="phone" placeholder="Số điện thoại" class="border p-3 w-100 my-2">
                                    <input type="email" name="email" placeholder="Địa chỉ email" class="border p-3 w-100 my-2">
                                    <input type="password" name="password" placeholder="Mật khẩu" class="border p-3 w-100 my-2">
                                    <input type="password" name="password2" placeholder="Nhật lại mật khẩu" class="border p-3 w-100 my-2">                           
                                    <input style="margin-left: 115px;" type="submit" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3" value="Đăng Ký">                         
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>

    <%@include file = "nav/footer.jsp" %>
</html>
