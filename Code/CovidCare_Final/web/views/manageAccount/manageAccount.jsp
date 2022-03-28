<%-- 
    Document   : manageAccount
    Created on : Feb 28, 2022, 7:20:24 PM
    Author     : Hoang Hung
--%>

<%@ page language="java" contentType="text/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <%@include file = "../../common/head.jsp" %>

    <body class="body-wrapper">

        <%@include file = "../../common/nav.jsp" %>

        <section class="dashboard section">
            <!-- Container Start -->
            <div class="container">
                <!-- Row Start -->
                <div class="row">
                    <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0">
                        <div class="sidebar">				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu" style="width: auto;">
                                <ul>
                                    <li class="active" >
                                        <a href="managementAccount"><i class=""></i>Quản lý tài khoản</a>
                                    </li>																			
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 offset-md-1 col-lg-9 offset-lg-0">
                        <!-- Recently Favorited -->
                        <div class="widget dashboard-container my-adslist" style="width: auto;">
                            <h3 class="widget-header">Quản lý tài khoản</h3>
                            <table  class="table table-responsive product-dashboard-table">
                                <thead>
                                    <tr>
                                        <th nowrap class="text-center" >Tài khoản</th>
                                        <th nowrap class="text-center">Mật khẩu</th>
                                        <th nowrap class="text-center">Vai trò</th>
                                        <th nowrap class="text-center">Trạng thái</th>
                                        <th nowrap class="text-center">Hoạt động</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listUser}" var="o">
                                        <tr>

                                            <td nowrap class="">
                                                <a>${o.username}</a>
                                            <td nowrap  class="text-center">${o.password}</td>
                                            <td nowrap class="text-center"><c:choose>
                                                    <c:when test="${o.userType == 1}">Admin</c:when> 
                                                    <c:when test="${o.userType == 2}">Bác sĩ</c:when>    
                                                    <c:otherwise>
                                                        Bệnh nhân
                                                    </c:otherwise>
                                                </c:choose></td>
                                            <td nowrap class="text-center">
                                                <c:choose>
                                                    <c:when test="${o.activeStatus}">Hoạt động</c:when>    
                                                    <c:otherwise>
                                                        Bị cấm
                                                    </c:otherwise>
                                                </c:choose></td>
                                            <td nowrap class="action" data-title="Tùy chọn"> 
                                                <div class="">
                                                    <ul class="list-inline justify-content-center">
                                                        <li class="list-inline-item">
                                                            <a href="editAccount?userId=${o.userId}" class="edit"><i class="fas fa-edit"  title="Chỉnh sửa"></i></a>
                                                        </li>                                                        
                                                    </ul>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>
                <!-- Row End -->
            </div>
            <!-- Container End -->
        </section>
    </body>
    <%@include file = "../../common/footer.jsp" %>
</html>
