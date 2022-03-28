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

        <section>
            <!-- Container Start -->
            <div class="">
                <!-- Row Start -->
                <div class="row">
                    <div class="col-md-10 col-lg-2 offset-lg-0" >
                        <div class="sidebar" >				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu" style="width:250px;">
                                <ul>
                                    <li>
                                        <a href="news?action=add">
                                            <i class=""></i> Tạo Tin Tức Mới 
                                        </a>
                                    </li>    
                                    <li class="active">
                                        <a href="">
                                            <i class=""></i> Quản lý bản tin
                                        </a>                                        
                                    </li>																			
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 col-lg-10 offset-lg-0" >
                        <!-- Recently Favorited -->
                        <div class="widget dashboard-container my-adslist" style="width:auto;">
                            <h3 class="widget-header">Quản lý bản tin
                                        </h3>
                            <table class="table table-responsive product-dashboard-table">
                                <thead>
                                    <tr>
                                        <th nowrap class="text-center">STT</th>
                                        <th nowrap class="text-center">Tiêu Đề</th>                                   
                                        <th nowrap class="text-center">Thể Loại</th>
                                        <th nowrap class="text-center">Trạng Thái</th>
                                        <th nowrap class="text-center">Ngày Tạo</th>
                                        <th nowrap class="text-center">Ngày Đăng</th>
                                        <th nowrap class="text-center">Chức Năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${newsList}" var="n">
                                        <tr>

                                            <td nowrap class="">
                                                <a>${n.getNewsId()}</a>
                                            <td nowrap  class="text-center">${n.getTitle()}</td>
                                            <td nowrap class="text-center">
                                                <c:forEach items="${newsCate}" var="cate">
                                                    <c:if test="${cate.getCateId() == n.getCateId()}">
                                                        ${cate.getCateName()}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td nowrap class="text-center">
                                                <c:choose>
                                                    <c:when test="${n.isStatus()}">
                                                        Đang hiển thị
                                                    </c:when>
                                                    <c:otherwise>
                                                        Đã ẩn
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td nowrap class="text-center">${n.getCreate_date()}</td>
                                            <td nowrap class="text-center">${n.getPublish_date()}</td>
                                            <td nowrap class="action" data-title="Action"> 
                                                <div class="">
                                                    <ul class="list-inline justify-content-center">
                                                        <li class="list-inline-item">
                                                            <a href="news?action=update&id=${n.newsId}" onclick="return confirm('Bạn muốn chỉnh sửa không?')" class="edit"><i class="fas fa-edit"  title="Edit"></i></a>
                                                        </li>      
                                                        <li class="list-inline-item">
                                                            <a href="news?id=${n.newsId}" class="edit"><i class="fa-solid fa-book" title="View"></i></a>
                                                        </li>                                            
                                                        <c:choose>
                                                            <c:when test="${n.status == true}">
                                                                <li class="list-inline-item">
                                                                    <a href="news?action=delete&id=${n.newsId}" onclick="return confirm('Bạn có muốn ẩn tin tức này không?')" class="delete"><i class="fas fa-eye-slash" title="Hide"></i></a>
                                                                </li>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <li class="list-inline-item">
                                                                    <a href="news?action=show&id=${n.newsId}" onclick="return confirm('Bạn có muốn hiện tin tức này không?')" class="delete"><i class="fas fa-eye" title="Show"></i></a>
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
    <%@include file = "../../common/footer.jsp" %>
</html>
