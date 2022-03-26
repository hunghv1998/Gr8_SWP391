<%-- 
    Document   : login
    Created on : Mar 14, 2022, 3:03:48 PM
    Author     : chinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">

        <%@include file = "../common/nav.jsp" %>

        <section class="login py-5 border-top-1">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5 col-md-8 align-item-center">
                        <div class="border">
                            <h3 class="bg-gray p-4">Đăng Nhập</h3>

                            <fieldset class="p-4">
                                <c:if test="${not empty message}">
                                    <b>${message}</b>
                                </c:if> 
                                <form action="" method="POST">
                                    <input type="text" placeholder="Tài khoản" name="username" class="border p-3 w-100 my-2" value="${username}">
                                    <input type="password" placeholder="Mật khẩu" name="password" class="border p-3 w-100 my-2" >
                                    <div class="loggedin-forgot">
                                        <input type="checkbox" id="keep-me-logged-in">
                                        <label for="keep-me-logged-in" class="pt-3 pb-2">Ghi nhớ</label>
                                    </div>
                                    <button type="submit"
                                            class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3">Đăng
                                        Nhập</button>
                                    <a class="mt-3 d-block  text-primary" href="forgotPassword">Quên mật khẩu ?</a>
                                    <a class="mt-3 d-inline-block text-primary" href="register">Đăng ký ngay</a>
                                </form>
                            </fieldset>

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>

    <!--Footer-->

    <%@include file = "../common/footer.jsp" %>

</html>
