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

        <section class="login py-5 border-top-1">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5 col-md-8 align-item-center">
                        <div class="border">
                            <h3 class="bg-gray p-4">Đăng Nhập</h3>
                            <form action="" method="POST">
                                <fieldset class="p-4">
                                    <c:if test="${not empty message}">
                                        <b>${message}</b>
                                    </c:if>
                                    <input type="text" placeholder="Tài khoản" name="Username" class="border p-3 w-100 my-2" value="${Username}">
                                    <input type="password" placeholder="Mật khẩu" name="Password" class="border p-3 w-100 my-2" value="${Password}">
                                    <div class="loggedin-forgot">
                                        <input type="checkbox" id="keep-me-logged-in">
                                        <label for="keep-me-logged-in" class="pt-3 pb-2">Ghi nhớ</label>
                                    </div>
                                    <button type="submit"
                                            class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3">Đăng
                                        Nhập</button>
                                    <a class="mt-3 d-block  text-primary" href="#">Quên mật khẩu ?</a>
                                    <a class="mt-3 d-inline-block text-primary" href="register">Đăng ký ngay</a>
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
