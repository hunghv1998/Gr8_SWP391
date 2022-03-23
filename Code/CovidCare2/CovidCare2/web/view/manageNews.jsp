<%-- 
    Document   : manageNews
    Created on : Mar 10, 2022, 9:29:23 PM
    Author     : Hoang Hung
--%>

<%@ page language="java" contentType="text/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <%@include file = "../common/head.jsp" %>
    <head>
          <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
          <title>ABC</title>
    </head>
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
                                    <li class="active"><a href="viewListNewsController"><i class=""></i> Manager News </a></li>
                                    <li>
                                        <a href="ManageAccount"><i class=""></i> Manager profiles <span>12</span></a>
                                    </li>																			
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0" >
                        <!-- Recently Favorited -->
                        <div class="widget dashboard-container my-adslist" >
                            <h3 class="widget-header">Manage Account</h3>
                            <table class="table table-responsive product-dashboard-table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th class="text-center" >Title</th>                                   
                                        <th class="text-center">Category</th>
                                        <th class="text-center">Created date</th>
                                        <th class="text-center">Action</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="${listN}" var="n">
                                        <tr>

                                            <td class="">
                                                <a>${n.newsId}</a>
                                            <td  class="text-center" >${n.title}</td>
                                            <td class="text-center"></td>
                                            <td class="text-center">${n.create_date}</td>

                                            <td class="action" data-title="Action"> 
                                                <div class="">
                                                    <ul class="list-inline justify-content-center">
                                                        <li class="list-inline-item">
                                                            <a href="EditNews?newsId=${n.newsId}" onclick="return confirm('Bạn muốn chỉnh sửa không?')" class="edit"><i class="fas fa-edit"  title="Edit"></i></a>
                                                        </li>      
                                                        <li class="list-inline-item">
                                                            <a href="NewsDetails?newsId=${n.newsId}" class="edit"><i class="fa-solid fa-eye" title="View"></i></a>
                                                        </li>                                            
                                                        <li class="list-inline-item">
                                                            <a href="DeleteNews?newsId=${n.newsId}" onclick="return confirm('Bạn có muốn xóa tin tức này không?')" class="delete"><i class="fas fa-eraser" title="Delete"></i></a>
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
        <script src="<%=request.getContextPath()%>/js/popUp.js"></script>
    </body>
    <%@include file = "../common/footer.jsp" %>
</html>
