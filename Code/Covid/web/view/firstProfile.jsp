<%-- 
    Document   : firstProfile
    Created on : Feb 9, 2022, 9:19:11 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>UpdateFirstProfile</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="../css/style.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"/>
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
								<a class="nav-link" href="home.html">Trang chủ</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="">Hỗ Trợ Trực Tuyến</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="news.html">Tin tức</a>
							</li>
							<li class="nav-item active">
								<a class="nav-link" href="">Thời gian biểu</a>
							</li>
							
						</ul>
						<ul class="navbar-nav ml-auto mt-10">
							<li class="nav-item">
								<a class="nav-link login-button" href="login.html">Login</a>
							</li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
	</div>
</section>

<section class="hero-area bg-1 text-center overly">
	<!-- Container Start -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Header Contetnt -->
				<div class="content-block">
					<h1>Covid Care</h1>
					<p>Tư vấn và hướng dẫn sức khỏe cộng đồng mùa covid <br> Cập nhật diễn biến covid hàng ngày</p>
					<div class="short-popular-category-list text-center">
						<h2>Danh mục phổ biến</h2>
						<ul class="list-inline">
							<li class="list-inline-item">
								<a href="news.html">Bản Tin Covid</a></li>
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
				
			</div>
		</div>
	</div>
	<!-- Container End -->
</section>
  
 <!--==================================
=            User Profile            =
===================================-->

<section class="user-profile section">
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-md-1 col-lg-9 offset-lg-2">
				<!-- Edit Profile Welcome Text -->
				<div class="widget welcome-message">
					<h2 style="text-align: center;">Cập nhật thông tin khai báo</h2>
					<p style="text-align: center;">Đây là tài liệu quan trọng, thông tin của anh/chị sẽ giúp đưa ra những hướng dẫn, liên lạc cần thiết để phòng chống dịch bệnh</p>
                    <p style="text-align: center; color: red;" >(*) Đây là những thông tin quan trọng không được phép bỏ qua</p>
				</div>
				<!-- Edit Personal Info -->
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<div class="widget personal-info">	
							<h3 class="widget-header user">Thông tin cơ bản</h3>						
							<form action="#">
								<!-- Ho va ten -->
								<div class="form-group">
									<label for="name">Họ và tên <a style="color: red;">(*)</a></label>
									<input type="text" class="form-control" id="name">
								</div>
								<!-- CMND-->
								<div class="form-group">
									<label for="cmnd">Sổ hộ chiếu/CMND/CCCD</label>
									<input type="text" class="form-control" id="cmnd">
								</div>
								<!-- BHYT-->
								<div class="form-group">
									<label for="bhyt">Sổ hộ thẻ BHYT</label>
									<input type="text" class="form-control" id="bhyt">
								</div>
								<!-- Ngay Sinh -->
								<div class="form-group ">
									<label for="ngaysinh">Ngày sinh <a style="color: red;">(*)</a>
									<input type="date" class="form-control-file mt-2 pt-1" id="ngaysinh"></label>
								 </div>
								<!-- Gioi tinh -->
								<div class="form-group">
									<label for="gioitinh">Giới tính <a style="color: red;">(*)</a></label>
									<select><option>Chọn</option>
										<option> Nam </option>
										<option> Nữ </option>	
										<option> Khác </option>	</select>															
								</div>
								<!-- Checkbox
								<div class="form-check">
								  <label class="form-check-label" for="hide-profile">
									<input class="form-check-input mt-1" type="checkbox" value="" id="hide-profile">
									Hide Profile from Public/Comunity
								  </label>
								</div> -->
								<!-- Quoc tich -->
								<div class="form-group">
									<label for="quoctich">Quốc tịch <a style="color: red;">(*)</a></label>
									<select><option>Chọn</option>
										<option> Việt Nam </option>
										<option> Thái Lan </option>	
										<option> Hàn Quốc </option>	</select>															
								</div>						
							</form>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<!-- Change Password -->
					<div class="widget change-password">
						<h3 class="widget-header user">Địa chỉ liên lạc tại Việt Nam</h3>
						<form action="#">
							<!-- địa chỉ -->
							<div class="form-group">
								<label for="tinhthanh">Tỉnh thành  <a style="color: red;">(*)</a></label>
								<select><option>Chọn</option>
									<option> Việt Nam </option>
									<option> Thái Lan </option>	
									<option> Hàn Quốc </option>	</select>															
							</div>		
							<div class="form-group">
								<label for="quanhuyen">Quận huyện <a style="color: red;">(*)</a></label>
								<select><option>Chọn</option>
									<option> Việt Nam </option>
									<option> Thái Lan </option>	
									<option> Hàn Quốc </option>	</select>															
							</div>	
							<div class="form-group">
								<label for="phuongxa">Phường/Xã  <a style="color: red;">(*)</a></label>
								<select><option>Chọn</option>
									<option> Việt Nam </option>
									<option> Thái Lan </option>	
									<option> Hàn Quốc </option>	</select>															
							</div>
							<div class="form-group">
								<label for="diachinha">Địa chỉ nơi ở tại Việt Nam (Số nhà, tổ dân phố,...) <a style="color: red;">(*)</a></label>
								<input type="text" class="form-control" id="diachinha">
							</div>
							<div class="form-group">
								<label for="sdt">Số điện thoại <a style="color: red;">(*)</a></label>
								<input type="text" class="form-control" id="sdt">
							</div>
							<div class="form-group">
								<label for="diachinha">Trong vòng 14 ngày qua, Anh/Chị có đến quốc gia/vùng lãnh thổ nào(Có thể đi qua nhiều quốc gia)</label>
								<input type="text" class="form-control" id="diachinha">
							</div>
						</form>
					</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<!-- trieu chung -->
					<div class="widget trieuchung mb-0">
						<h3 class="widget-header user">Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện triệu chứng nào sau đây không ? <a style="color: red;">(*)</a></h3>
						<form action="#">
							<div class="form-group">
								<label for="vaccine">Danh sách vaccine hoặc sinh phẩm được sử dụng </label>
								<input type="text" class="form-control" id="vaccine">
							</div>
							<div class="form-group">
								<label for="lichsu">Lịch sử phơi nhiễm : Trong 14 ngày qua, Anh/Chị có <a style="color: red;">(*)</a></label>
								<textarea cols="40"></textarea>
							</div>				
						</form>
					</div>
					</div>

					<div class="col-lg-6 col-md-6">
						<!-- trieu chung -->
					<div class="widget trieuchung mb-0">
						<h3 class="widget-header user">Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện triệu chứng nào sau đây không ? <a style="color: red;">(*)</a></h3>
						<form action="#">
							<!-- Current Password -->
							<div class="form-group">
								<table border="1">
									<tr>
										<th>Triệu chứng</th>
										<th >Có</th>
										<th>Không</th>
									</tr>
									<tr><td>Sốt <a style="color: red;">(*)</td>
									<td></a><input type="radio"></td><td><input type="radio"></td></tr>
									<tr><td>Ho <a style="color: red;">(*)</td>
									<td></a><input type="radio"></td><td><input type="radio"></td></tr>			
									<tr><td>Khó thở <a style="color: red;">(*)</td>
									<td></a><input type="radio"></td><td><input type="radio"></td></tr>				
									<tr><td>Đau họng <a style="color: red;">(*)</td>
									<td></a><input type="radio"></td><td><input type="radio"></td></tr>	
									<tr><td>Mất vị giác <a style="color: red;">(*)</td>
									<td></a><input type="radio"></td><td><input type="radio"></td></tr>	
									<tr><td>Nôn/Buồn nôn <a style="color: red;">(*)</td>
									<td></a><input type="radio"></td><td><input type="radio"></td></tr>	
									<tr><td>Tiêu chảy <a style="color: red;">(*)</td>
									<td></a><input type="radio"></td><td><input type="radio"></td></tr>	
									<tr><td>Xuất huyết ngoài da <a style="color: red;">(*)</td>
									<td></a><input type="radio"></td><td><input type="radio"></td></tr>	
									<tr><td>Nổi ban ngoài da <a style="color: red;">(*)</td>
									<td></a><input type="radio"></td><td><input type="radio"></td></tr>	
								</table>
							</div>							
							
							
						</form>
					</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<button style="margin-left: 1000px;" type="submit" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3">Tiếp Theo</button>        
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
