<%-- 
    Document   : profile
    Created on : Feb 16, 2022, 3:40:31 AM
    Author     : chinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "nav/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "nav/nav.jsp" %>

        <!--==================================
        =            User Profile            =
        ===================================-->

        <section class="user-profile section">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 offset-md-1 col-lg-9 offset-lg-2">
                        <!-- Edit Profile Welcome Text -->
                        <div class="widget welcome-message">
                            <h2 style="text-align: center;">Cập nhật thông tin tài khoản</h2>
                            <c:if test="${not empty message}">
                                <p style="text-align: center;">
                                    <b>${message}</b>
                                </p>
                            </c:if>
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
                                            <label for="bhyt">Sổ thẻ BHYT</label>
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
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-10 offset-md-1 col-lg-9 offset-lg-2" style="align-items: center; justify-content: center;">
                        <button  type="submit" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3">Cập nhật</button>
                    </div>
                </div>
            </div>

        </section>
    </body>

    <%@include file = "nav/footer.jsp" %>
</html>