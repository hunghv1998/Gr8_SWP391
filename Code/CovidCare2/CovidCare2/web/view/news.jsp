<%-- 
    Document   : news.jsp
    Created on : Feb 17, 2022, 11:50:04 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
                            <h1>Covid Care</h1>
                            <p>
                                Tư vấn và hướng dẫn sức khỏe cộng đồng mùa covid <br />
                                Cập nhật diễn biến covid hàng ngày
                            </p>
                            <div class="short-popular-category-list text-center">
                                <h2>Danh mục phổ biến</h2>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <a href="news.html"> Bản Tin Covid</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="category.html">Chỉ Đạo Chống Dịch</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="category.html">Hướng Dẫn</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="category.html">Chat</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="category.html">Thời Gian Biểu</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- Advance Search -->
                        <div class="advance-search">
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-lg-12 col-md-12 align-content-center">
                                        <form>
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <input type="text" class="form-control my-2 my-lg-1" id="inputtext4"
                                                           placeholder="Bạn Đang Tìm Kiếm Gì" />
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <select class="w-100 form-control mt-lg-1 mt-md-2">
                                                        <option>Danh Mục Tin Tức</option>
                                                        <option value="1">Bản Tin Covid</option>
                                                        <option value="2">Chỉ Đạo Chống Dịch</option>
                                                        <option value="4">Hướng Dẫn</option>
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
            <!-- Container End -->
        </section>

    </section>

    <section class=" section">
        <!-- Container Start -->
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- Section title -->
                    <div class="section-title">
                        <h2>Bản Tin Covid</h2>
                    </div>
                    <div class="row">
                        <!-- Category list -->
                        <div class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
                            <div class="category-block">
                                <div class="header">
                                    <h4><a href="newDetails.html">Tình Hình Covid Hàng Ngày</a></h4>
                                </div>
                                <ul class="category-list">
                                    <li><a>Hà Nội <span>1193</span></a></li>
                                    <li><a>HCM <span>233</span></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
                            <div class="category-block">
                                <div class="header">
                                    <h4>Tình Hình Covid Hàng Ngày</h4>
                                </div>
                                <ul class="category-list">
                                    <li><a>Hà Nội <span>1193</span></a></li>
                                    <li><a>HCM <span>233</span></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
                            <div class="category-block">
                                <div class="header">
                                    <h4>Tình Hình Covid Hàng Ngày</h4>
                                </div>
                                <ul class="category-list">
                                    <li><a>Hà Nội <span>1193</span></a></li>
                                    <li><a>HCM <span>233</span></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
                            <div class="category-block">
                                <div class="header">
                                    <h4>Tình Hình Covid Hàng Ngày</h4>
                                </div>
                                <ul class="category-list">
                                    <li><a>Hà Nội <span>1193</span></a></li>
                                    <li><a>HCM <span>233</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="col-12">
                    <!-- Section title -->
                    <div class="section-title">
                        <h2>Chỉ Đạo Chống Dịch</h2>
                    </div>
                    <div class="row">
                        <!-- Category list -->
                        <div class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
                            <div class="category-block">
                                <div class="header">
                                    <h4>Tình Hình Covid Hàng Ngày</h4>
                                </div>
                                <ul class="category-list">
                                    <li><a>Hà Nội <span>1193</span></a></li>
                                    <li><a>HCM <span>233</span></a></li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="col-12">
                    <!-- Section title -->
                    <div class="section-title">
                        <h2>Hướng Dẫn</h2>
                    </div>
                    <div class="row">
                        <!-- Category list -->
                        <div class="col-lg-3 offset-lg-0 col-md-5 offset-md-1 col-sm-6 col-6">
                            <div class="category-block">
                                <div class="header">
                                    <h4>Tình Hình Covid Hàng Ngày</h4>
                                </div>
                                <ul class="category-list">
                                    <li><a>Hà Nội <span>1193</span></a></li>
                                    <li><a>HCM <span>233</span></a></li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- Container End -->
    </section>
    </body>
    <%@include file = "../common/footer.jsp" %>
</html>
