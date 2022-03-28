<%-- 
    Document   : editNews
    Created on : Mar 15, 2022, 11:38:38 AM
    Author     : Hoang Hung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

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
                            <div class="widget user-dashboard-menu">
                                <ul>
                                    <li class="active">
                                        <a href="">
                                            <i class=""></i> Tạo Tin Tức Mới 
                                        </a>
                                    </li>   
                                    <li>
                                        <a href="news">
                                            <i class=""></i> Quản lý bản tin
                                        </a>
                                    </li>                                   													
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
                        <!-- Recently Favorited -->                     
                        <form action="news" method="post" enctype="multipart/form-data">
                            <div class="widget dashboard-container my-adslist">
                                <h3 class="widget-header">Tạo Tin Tức Mới</h3>
                                <p style="color: red;">
                                    ${message}
                                    <br>
                                    ${error}
                                </p>

                                <div class="col-lg-12">
                                    <div>
                                        <h6 class="font-weight-bold pt-4 pb-1">Tiêu đề :</h6>
                                        <input type="text" class="border w-100 p-2 bg-white text-capitalize" name="title" placeholder="Tối đa 250 ký tự" value=<c:if test="${not empty currNews.title}">"${currNews.title}"</c:if>>                             
                                        </div>
                                        <div class="choose-file text-center my-4 py-4 rounded">
                                            <label for="file-upload">
                                                <span class="d-block font-weight-bold text-dark">Thả Ảnh Vào Đây</span>
                                                <span class="d-block">hoặc</span>
                                                <span class="d-block btn bg-primary text-white my-3 select-files">Chọn Ảnh</span>
                                            <input type="file"  name="img" class="form-control-file d-none" id="file-upload">
                                        </label>
                                    </div>
                                    <div class="dnx_content_form_item clearfix">
                                        <div class="dnx_content_form_item_lab">
                                            Thể Loại
                                        </div>
                                        <div class="dnx_content_form_item_field">
                                            <select name="category">
                                                <option class="default-selected" value="0" selected="">Chọn Thể Loại</option>
                                                <c:forEach items="${newsCate}" var="cate">
                                                    <option value="${cate.cateId}"
                                                            >${cate.cateName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>       

                                    <div>
                                        <h6 class="font-weight-bold pt-4 pb-1">Tóm tắt:</h6>
                                        <textarea name="description" class="border p-3 w-100" rows="7" placeholder="Tối đa 250 ký tự"><c:if test="${not empty currNews.short_des}">"${currNews.short_des}"</c:if></textarea>
                                        </div>
                                        <h6 class="font-weight-bold pt-4 pb-1">Nội dung:</h6>
                                        <textarea name="content" class="border p-3 w-100" rows="7" placeholder="Tối đa 1000 ký tự"><c:if test="${not empty currNews.content}">"${currNews.content}"</c:if></textarea>

                                        <h6 class="font-weight-bold pt-4 pb-1">Đăng bài?</h6>
                                        <ul>
                                        <li>
                                        <input type="radio" id="notPublish" name="publishStatus" value="0" 
                                        <c:if test="${not currNews.status}">checked</c:if>>
                                        <label for="notPublish">Lưu nháp</label>
                                        </li>
                                        <li>
                                            <input type="radio" id="publish" name="publishStatus" value="1" 
                                            <c:if test="${currNews.status}">checked</c:if>>
                                            <label for="publish">Đăng bài</label>
                                        </li>
                                        </ul> 
                                    <c:choose>
                                        <c:when test="${currNews.newsId > 0}">
                                            <input type="submit" name="submit" class="btn btn-primary d-block mt-2" value="Cập Nhập">
                                        </c:when>    
                                        <c:otherwise>
                                            <input type="submit" name="submit" class="btn btn-primary d-block mt-2" value="Đăng bài">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- Row End -->
            </div>
            <!-- Container End -->
        </section>
    </body>

    <%@include file = "../../common/footer.jsp" %>
</html>