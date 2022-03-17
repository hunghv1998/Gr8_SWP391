<%-- 
    Document   : manageAccount
    Created on : Feb 28, 2022, 7:20:24 PM
    Author     : Hoang Hung
--%>

<%@ page language="java" contentType="text/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">

        <%@include file = "../common/nav.jsp" %>

        <section class="dashboard section">
            <!-- Container Start -->
            <div class="container">
                <!-- Row Start -->
                <div class="row">
                    <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0">
                        <div class="sidebar">				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu">
                                <ul>
                                    <li><a href="CreateNews"><i class=""></i> Create News </a></li>    
                                    <li><a href="viewListNewsController"><i class=""></i> Manager News </a></li>
                                    <li class="active" >
                                        <a href="ManageAccount"><i class=""></i> Manager profiles <span>12</span></a>
                                    </li>																			
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
                        <!-- Recently Favorited -->
                        <div class="widget dashboard-container my-adslist">
                            <h3 class="widget-header">Manage Account</h3>
                            <table  class="table table-responsive product-dashboard-table">
                                <thead>
                                    <tr>
                                        <th>Account</th>
                                        <th class="text-center">Password</th>
                                        <th class="text-center">Role</th>
                                        <th class="text-center">Status</th>
                                        <th class="text-center">Action</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="${listA}" var="o">
                                        <tr>

                                            <td class="">
                                                <a>${o.userName}</a>
                                            <td  class="text-center">${o.passWord}</td>
                                            <td class="text-center">${o.group.name}</td>
                                            <td class="text-center">
                                                <c:choose>
                                                    <c:when test="${o.status}">Active</c:when>    
                                                    <c:otherwise>
                                                        Ban
                                                    </c:otherwise>
                                                </c:choose></td>


                                            <td class="action" data-title="Action"> 
                                                <div class="">
                                                    <ul class="list-inline justify-content-center">
                                                        <li class="list-inline-item">
                                                            <a href="EditAccount?username=${o.userName}&&password=${o.passWord}" class="edit"><i class="fas fa-edit"  title="Edit"></i></a>
                                                        </li>
                                                        <c:choose>
                                                            <c:when test="${o.status}">
                                                                <li class="list-inline-item">
                                                                    <a href="DeleteAccount?username=${o.userName}&&status=${o.status}" onclick="return confirm('Bạn có muốn cấm tài khoản này không?')" class="delete"><i class="fas fa-eraser" title="Active"></i></a>
                                                                </li> 
                                                            </c:when>    
                                                            <c:otherwise>
                                                                <li class="list-inline-item">
                                                                    <a href="DeleteAccount?username=${o.userName}&&status=${o.status}" onclick="return confirm('Bạn có muốn kích hoạt lại tài khoản này không?')" class="delete"><i class="fas fa-eraser" title="Ban"></i></a>
                                                                </li> 
                                                            </c:otherwise>
                                                        </c:choose>


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
    <%@include file = "../common/footer.jsp" %>
</html>
