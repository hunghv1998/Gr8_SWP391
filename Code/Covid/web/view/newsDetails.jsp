<%-- 
    Document   : newsDetails
    Created on : Feb 9, 2022, 9:20:36 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Login</title>
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
              <img src="../images/icon.png" alt="" width="100" height="100">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav ml-auto main-nav ">
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

  <section class="hero-area bg-2 text-center overly">
    <!-- Container Start -->
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <!-- Header Contetnt -->
          <div class="content-block">
            <h1>Covid Care</h1>
            <p>Tư vấn và hướng dẫn sức khỏe cộng đồng mùa covid <br> Cập nhật diễn biến covid hàng ngày</p>
          </div>
        </div>
      </div>
    </div>
    <!-- Container End -->
  </section>

  <section class="blog single-blog section">
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-md-1 col-lg-9 offset-lg-0">
				<article class="single-post">
					<h3>Ban tin covid hnay</h3>
					<ul class="list-inline">
						<li class="list-inline-item">by <a href="">Admin</a></li>
						<li class="list-inline-item">Nov 22, 2016</li>
					</ul>
					<img src="../images/login.png" alt="article-01">
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed eiusmod tempor incididunt  labore et dolore magna aliqua. Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip.ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. 
					sunt in culpa qui officia deserunt mollit anim id est laborum.</p> 
					
					<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit.</p>

					<p>sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.</p>
				</article>
				<div class="block comment">
					<h4>Leave A Comment</h4>
					<form action="#">
						<!-- Message -->
						<div class="form-group mb-30">
						    <label for="message">Message</label>
						    <textarea class="form-control" id="message" rows="8"></textarea>
						</div>
						<div class="row">
							<div class="col-sm-12 col-md-6">
								<!-- Name -->
								<div class="form-group mb-30">
								    <label for="name">Name</label>
								    <input type="text" class="form-control" id="name">
								</div>
							</div>
							<div class="col-sm-12 col-md-6">
								<!-- Email -->
								<div class="form-group mb-30">
								    <label for="email">Email</label>
								    <input type="email" class="form-control" id="email">
								</div>
							</div>
						</div>
						<button class="btn btn-transparent">Leave Comment</button>
					</form>
				</div>
			</div>
			<div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0">
				<div class="sidebar">
					<!-- Category Widget -->
					<div class="widget category">
						<!-- Widget Header -->
						<h5 class="widget-header">Danh mục</h5>
						<ul class="category-list">
							<li><a href="home.jsp">Trang chủ</a></li>
							<li><a href="news.jsp">Tin Tức</a></li>
							<li><a href="">Chat</a></li>
							<li><a href="">Thời Gian Biểu</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

  <!--Footer-->

  <footer class="footer section section-sm">
    <!-- Container Start -->
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-md-7 offset-md-1 offset-lg-0">
          <!-- About -->
          <div class="block about">
            <!-- footer logo -->
            <img src="../images/footer.png" alt="" width="250">
            <!-- description -->
            <p class="alt-color">Cuộc sống bận rộn có thể khiến bạn quên đi sức khỏe bản thân,
              đặc biệt là mùa covid. Nhưng đến khi bị bệnh, nhiều người lại không muốn đến bệnh viện
              vì quá đông và nguy cơ lây nhiễm cao.
              Hiểu được điều đó, COVID CARE có thể giúp bạn dễ dàng kết nối với
              bác sĩ và tư vấn cũng như hướng dẫn trực tuyến tại nhà.</p>
          </div>
        </div>
        <!-- Link list -->
        <div class="col-lg-6 offset-lg-1 col-md-3" style="text-align: right;">
          <div class="block">
            <h4>Mọi đóng góp ý kiến xin liên hệ</h4>
            <ul>
              <li><a href="#">Đường dây nóng: 0123456789</a></li>
              <li><a href="#">Email: group8@gmail.com</a></li>
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
        <div>
          <!-- Copyright -->
          <div class="copyright">
            <p style="text-align: center;">Copyright © 2022</p>
          </div>
        </div>
      </div>
    </div>
  </footer>

</html>