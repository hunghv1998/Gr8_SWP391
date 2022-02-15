<%-- 
    Document   : login
    Created on : Feb 9, 2022, 9:16:02 PM
    Author     : asus
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
                                        <a href="news.jsp"><i class="fa fa-newspaper-o"></i> Bản Tin Covid</a>
                                    </li>
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
                            <h3 class="bg-gray p-4">Đăng Nhập</h3>
                            <form action="Login" method="post">
                                <fieldset class="p-4">
                                    <input type="text" placeholder="Tài khoản" name="Username" class="border p-3 w-100 my-2">
                                    <input type="password" placeholder="Mật khẩu" name ="Password" class="border p-3 w-100 my-2">
                                    <div class="loggedin-forgot">
                                        <input type="checkbox" id="keep-me-logged-in">
                                        <label for="keep-me-logged-in" class="pt-3 pb-2">Ghi nhớ</label>
                                    </div>
                                    <input type="submit"
                                            class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3" value="Đăng
                                    Nhập">
                                    <a class="mt-3 d-block  text-primary" href="#">Quên mật khẩu ?</a>
                                    <a class="mt-3 d-inline-block text-primary" href="view/register.jsp">Đăng ký ngay</a>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>

    <!--Footer-->

    <%@include file = "nav/footer.jsp" %>

</html>
