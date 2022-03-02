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
                            <h3 class="bg-gray p-4">Đăng Ký Tài Khoản</h3>
                            <form action="" method="post">
                                <fieldset class="p-4">
                                    <c:if test="${not empty message}">
                                        <b>${message}</b>
                                    </c:if>
                                    <input type="text" name="username" placeholder="Tài khoản" class="border p-3 w-100 my-2">
                                    <!--
                                    <input type="text" name="fullname" placeholder="Họ và tên" class="border p-3 w-100 my-2">
                                    <input type="number" name="phone" placeholder="Số điện thoại" class="border p-3 w-100 my-2">
                                    <input type="email" name="email" placeholder="Địa chỉ email" class="border p-3 w-100 my-2">
                                    -->
                                    <input type="password" name="password" placeholder="Mật khẩu" class="border p-3 w-100 my-2" value="">
                                    <input type="password" name="confirm" placeholder="Nhật lại mật khẩu" class="border p-3 w-100 my-2">                           
                                    <input style="margin-left: 115px;" type="submit" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3" value="Đăng Ký">                         
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>

    <%@include file = "../common/footer.jsp" %>
</html>