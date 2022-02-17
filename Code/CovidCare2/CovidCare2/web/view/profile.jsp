<%-- 
    Document   : profile
    Created on : Feb 16, 2022, 3:40:31 AM
    Author     : chinh
--%>

<%@page import="Model.UserInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "../common/nav.jsp" %>

        <!--==================================
        =            User Profile            =
        ===================================-->

        <section class="user-profile section">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 offset-md-1 col-lg-9 offset-lg-2">
                        <% if (request.getAttribute("update") != null || request.getParameter("update") != null) {%>
                        <!-- Edit Profile Welcome Text -->
                        <div class="widget welcome-message"  >
                            <h2 style="text-align: center;">Cập nhật thông tin tài khoản</h2>
                            <c:if test="${not empty message}">
                                <p style="text-align: center;">
                                    <b>${message}</b>
                                </p>
                            </c:if>
                        </div>
                        <!-- Edit Personal Info -->
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <div class="widget personal-info">	
                                    <h3 class="widget-header user">Thông tin cơ bản</h3>						
                                    <form action="" method="Post">
                                        <!-- Ho va ten -->
                                        <div class="form-group">
                                            <label for="name">Họ và tên <a style="color: red;">(*)</a></label>
                                            <input style="width: 400px; margin: auto;" type="text" class="form-control" name="name">
                                        </div>
                                        <!-- Ho va ten -->
                                        <div class="form-group">
                                            <label for="email">Email <a style="color: red;">(*)</a></label>
                                            <input style="width: 400px; margin: auto;" type="email" class="form-control" name="email">
                                        </div>
                                        <!-- Ngay Sinh -->
                                        <div class="form-group">
                                            <label for="bday">Ngày sinh <a style="color: red;">(*)</a>
                                                <input type="date" class="form-control-file mt-2 pt-1" name="bday"></label>
                                        </div>
                                        <!-- Gioi tinh -->
                                        <div class="form-group">
                                            <label for="sex">Giới tính <a style="color: red;">(*)</a></label>
                                            <select name="sex"><option>Chọn</option>
                                                <option value="0"> Nam </option>
                                                <option value="1"> Nữ </option>	
                                            </select>														
                                        </div>
                                        <div class="form-group">
                                            <label for="image">Ảnh đại diện <a style="color: red;">(*)</a></label>
                                            <input style="width: 400px; margin: auto;" type="text" class="form-control" name="image">
                                        </div>
                                        <div class="form-group">
                                            <label for="address">Địa chỉ nơi ở tại Việt Nam (Số nhà, tổ dân phố,...) <a style="color: red;">(*)</a></label>
                                            <input style="width: 400px; margin: auto;" type="text" class="form-control" name="address">
                                        </div>
                                        <div class="row">
                                            <div class="col-md-10 offset-md-1 col-lg-9 offset-lg-2" style="align-items: center; justify-content: center; margin-left: 310px;">
                                                <button  type="submit" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3">Cập nhật</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <%} else {
                            UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
                        %>
                        <table>
                            <tr>
                                <td>Họ và Tên</td>
                                <td><%=userinfo.getName()%></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><%=userinfo.getEmail()%></td>
                            </tr>
                            <tr>
                                <td>Ngày sinh</td>
                                <td><%=userinfo.getBday()%></td>
                            </tr>
                            <tr>
                                <td>Giới tính</td>
                                <td><%=(userinfo.isSex() == true ? "Nam" : "Nữ")%></td>
                            </tr>
                            <tr>
                                <td>Ảnh đại diện</td>
                                <td><%=userinfo.getImage()%></td>
                            </tr>
                            <tr>
                                <td>Địa chỉ</td>
                                <td><%=userinfo.getAddress()%></td>
                            </tr>
                        </table>
                        <%}%>
                    </div>
                </div>

            </div>

        </section>

    </body>

    <%@include file = "../common/footer.jsp" %>
</html>