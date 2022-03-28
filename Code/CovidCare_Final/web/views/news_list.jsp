<%-- 
    Document   : news_list2
    Created on : Mar 22, 2022, 11:28:47 AM
    Author     : chinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file = "../common/head.jsp" %>
    <body class="body-wrapper">
        <%@include file = "../common/nav.jsp" %>

        <section class="hero-area bg-3 text-center overly">
            <!-- Container Start -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Header Contetnt -->
                        <div class="content-block">
                            <h1>Bản tin Covid</h1>
                            <p>
                                Tư vấn và hướng dẫn sức khỏe cộng đồng mùa covid <br />
                                Cập nhật diễn biến covid hàng ngày
                            </p>
                            <div class="short-popular-category-list text-center">
                                <h2>Danh mục phổ biến</h2>
                                <ul class="list-inline">
                                    <c:forEach items="${newsCate}" var="cate">
                                        <li class="list-inline-item">
                                            <a href="news?cateId=${cate.cateId}">${cate.cateName}</a>
                                        </li>
                                    </c:forEach>
                                    <li class="list-inline-item">
                                        <a href="tutorial">Hướng Dẫn</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- Advance Search -->
                        <div class="advance-search">
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-lg-12 col-md-12 align-content-center">
                                        <form action="news?action=search" method="POST">
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <input name="searchText" type="text" class="form-control my-2 my-lg-1" id="inputtext4"
                                                           placeholder="Bạn Đang Tìm Kiếm Gì" />
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <select name="searchCate" class="w-100 form-control mt-lg-1 mt-md-2">
                                                        <option value="0">Danh Mục Tin Tức</option>
                                                        <c:forEach items="${newsCate}" var="cate">
                                                            <option value="${cate.cateId}">${cate.cateName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-2 align-self-center">
                                                    <button type="submit" class="btn btn-primary">
                                                        Tìm Kiếm
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <% if (request.getParameter("action") == null && request.getParameter("cateId") == null) { %>
        <section class=" section">
            <!-- Container Start -->
            <div class="container">
                <c:forEach items="${newsCate}" var="cate">
                    <div class="row">
                        <div class="col-12">
                            <div class="section-title">
                                <h2>${cate.cateName}</h2>
                            </div>
                            <div class="row">
                                <c:forEach items="${topNews}" var="news">
                                    <c:if test="${news.cateId == cate.cateId}">
                                        <div class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
                                            <div class="category-block">
                                                <div class="header" >
                                                    <h4>
                                                        <a href="news?id=${news.newsId}" style="overflow:hidden;text-overflow: ellipsis;max-width: 100px;">${news.title}</a>
                                                    </h4>
                                                </div>
                                                <div>
                                                    <img src="images/news/${news.photo}" style="height: 200px; width: 200px; object-fit: contain;">
                                                    <span>${news.short_des}</span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>

                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
        <%} else if (request.getParameter("cateId") != null) {%>
        <section class=" section">
            <!-- Container Start -->
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="section-title">
                            <h2>${showCate.cateName}</h2>
                        </div>
                        <div class="row">
                            <c:forEach items="${newsList}" var="news">
                                <c:if test="${news.cateId == showCate.cateId}">
                                    <div class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
                                        <div class="category-block">
                                            <div class="header">
                                                <h4>
                                                    <a href="news?id=${news.newsId}">${news.title}</a>
                                                </h4>
                                            </div>
                                            <div>
                                                <img src="images/news/${news.photo}" style="height: 100%; width: 100%; object-fit: contain;">
                                                <span>${news.short_des}</span>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%} else if (request.getParameter("action").equals("search")) {%>
        <section class=" section">
            <!-- Container Start -->
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="row">
                            <c:forEach items="${result}" var="news">
                                <div class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
                                    <div class="category-block">
                                        <div class="header">
                                            <h4>
                                                <a href="news?id=${news.newsId}">${news.title}</a>
                                            </h4>
                                        </div>
                                        <div>
                                            <img src="images/news/${news.photo}" style="height: 100%; width: 100%; object-fit: contain;">
                                            <span>${news.short_des}</span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%}%>
    </body>
</html>
