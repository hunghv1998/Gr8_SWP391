<%-- 
    Document   : news
    Created on : Feb 9, 2022, 9:20:12 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Tin Tức</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="../css/style.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>

    <body class="body-wrapper">
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <nav class="navbar navbar-expand-lg navbar-light navigation">
                            <a class="navbar-brand" href="index.html">
                                <img src="../images/icon.png" alt="" width="100" height="100" />
                            </a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul class="navbar-nav ml-auto main-nav">
                                    <li class="nav-item active">
                                        <a class="nav-link" href="home.jsp">Trang chủ</a>
                                    </li>
                                    <li class="nav-item active">
                                        <a class="nav-link" href="">Hỗ Trợ Trực Tuyến</a>
                                    </li>
                                    <li class="nav-item active">
                                        <a class="nav-link" href="news.jsp">Tin tức</a>
                                    </li>
                                    <li class="nav-item active">
                                        <a class="nav-link" href="">Thời gian biểu</a>
                                    </li>
                                </ul>
                                <ul class="navbar-nav ml-auto mt-10">
                                    <li class="nav-item">
                                        <a class="nav-link login-button" href="login.jsp">Login</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </section>

        <!--===============================
      =            Hero Area            =
      ================================-->

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
                                        <a href="news.jsp"> Bản Tin Covid</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="">Chỉ Đạo Chống Dịch</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="">Hướng Dẫn</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="">Chat</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a href="">Thời Gian Biểu</a>
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

        <!--===================================
      =            Client Slider            =
      ====================================-->

        <!--===========================================
      =            Popular deals section            =
      ============================================-->

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
                                    <h4><a href="newsDetails.jsp">Tình Hình Covid Hàng Ngày</a></h4>
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

    <!--============================
  =            Footer            =
  =============================-->

    <footer class="footer section section-sm">
        <!-- Container Start -->
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-7 offset-md-1 offset-lg-0">
                    <!-- About -->
                    <div class="block about">
                        <!-- footer logo -->
                        <img src="../images/footer.png" alt="" width="250" />
                        <!-- description -->
                        <p class="alt-color">
                            Cuộc sống bận rộn có thể khiến bạn quên đi sức khỏe bản thân,
                            đặc biệt là mùa covid. Nhưng đến khi bị bệnh, nhiều người lại
                            không muốn đến bệnh viện vì quá đông và nguy cơ lây nhiễm cao.
                            Hiểu được điều đó, COVID CARE có thể giúp bạn dễ dàng kết nối
                            với bác sĩ và tư vấn cũng như hướng dẫn trực tuyến tại nhà.
                        </p>
                    </div>
                </div>
                <!-- Link list -->
                <div class="col-lg-6 offset-lg-1 col-md-3" style="text-align: right">
                    <div class="block">
                        <h4>Mọi đóng góp ý kiến xin liên hệ</h4>
                        <ul>
                            <li><a href="#">Đường dây nóng: 0123456789</a></li>
                            <li><a href="#">Email: Quân ngu@gmail.com</a></li>
                            <li><a href="#">Website: Covid Care</a></li>
                            <li><a href="#">Facebook: group8/facebook.com</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Container End -->
    </footer>
    <!-- Footer Bottom -->
    <footer class="footer-bottom">
        <!-- Container Start -->
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-12">
                    <!-- Copyright -->
                    <div class="copyright">
                        <p style="text-align: center">Copyright © 2022</p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</body>

</html>