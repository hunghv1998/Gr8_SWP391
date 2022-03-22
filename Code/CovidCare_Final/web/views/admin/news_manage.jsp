<%-- 
    Document   : manageNews
    Created on : Mar 10, 2022, 9:29:23 PM
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
                    <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0" >
                        <div class="sidebar" >				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu" style="width:auto;">
                                <ul>
                                    <li>
                                        <a href="news?action=add">
                                            <i class=""></i> Add News 
                                        </a>
                                    </li>    
                                    <li class="active">
                                        <a href="">
                                            <i class=""></i> News List 
                                        </a>
                                    </li>
                                    <li>
                                        <a href="ManageAccount">
                                            <i class=""></i> Manager profiles
                                        </a>
                                    </li>																			
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 offset-md-1 col-lg-9 offset-lg-0" >
                        <!-- Recently Favorited -->
                        <div class="widget dashboard-container my-adslist" style="width:auto;">
                            <h3 class="widget-header">Manage News</h3>
                            <table class="table table-responsive product-dashboard-table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th class="text-center" >Title</th>                                   
                                        <th class="text-center">Category</th>
                                        <th class="text-center">Status</th>
                                        <th class="text-center">Created date</th>
                                        <th class="text-center">Published date</th>
                                        <th class="text-center">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${newsList}" var="n">
                                        <tr>

                                            <td class="">
                                                <a>${n.getNewsId()}</a>
                                            <td  class="text-center" style="width:60%;">${n.getTitle()}</td>
                                            <td class="text-center">
                                                <c:forEach items="${newsCate}" var="cate">
                                                    <c:if test="${cate.getCateId() == n.getCateId()}">
                                                        ${cate.getCateName()}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td class="text-center">
                                                <c:choose>
                                                    <c:when test="${n.isStatus()}">
                                                        Đang hiển thị
                                                    </c:when>
                                                    <c:otherwise>
                                                        Đã ẩn
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td class="text-center">${n.getCreate_date()}</td>
                                            <td class="text-center">${n.getPublish_date()}</td>
                                            <td class="action" data-title="Action"> 
                                                <div class="">
                                                    <ul class="list-inline justify-content-center">
                                                        <li class="list-inline-item">
                                                            <a href="news?action=update&id=${n.newsId}" onclick="return confirm('Bạn muốn chỉnh sửa không?')" class="edit"><i class="fas fa-edit"  title="Edit"></i></a>
                                                        </li>      
                                                        <li class="list-inline-item">
                                                            <a href="news?id=${n.newsId}" class="edit"><i class="fa-solid fa-eye" title="View"></i></a>
                                                        </li>                                            
                                                        <li class="list-inline-item">
                                                            <a href="news?action=delete&id=${n.newsId}" onclick="return confirm('Bạn có muốn xóa tin tức này không?')" class="delete"><i class="fas fa-eraser" title="Delete"></i></a>
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
