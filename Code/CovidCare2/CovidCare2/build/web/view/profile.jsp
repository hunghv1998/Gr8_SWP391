<%-- 
    Document   : profile
    Created on : Feb 16, 2022, 3:40:31 AM
    Author     : chinh
--%>

<%@page import="Model.UserInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "../common/nav.jsp" %>

        <!--==================================
        =            User Profile            =
        ===================================-->

        <section class="user-profile section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-lg-12">
                        <% if (request.getAttribute("update") != null || request.getParameter("update") != null) {%>
                        <div class="dnx_content_inner">
                            <h2 style="text-align: center;">Cập nhật thông tin tài khoản</h2>
                            <c:if test="${not empty message}">
                                <p style="text-align: center;">
                                    <b>${message}</b>
                                </p>
                            </c:if>
                            <form action="" method="Post" enctype="multipart/form-data">
                                <div class="dnx_content_box">
                                    <h3>Thông tin liên hệ</h3>
                                    <div class="dnx_content_form">
                                        <div class="dnx_content_form_2col clearfix">
                                            <div class="dnx_content_form_item clearfix">
                                                <div class="dnx_content_form_item_lab">
                                                    <div class="dnx_content_form_item_lab">
                                                        Họ và tên <span class="text-danger">*</span>
                                                    </div>
                                                </div>
                                                <div class="dnx_content_form_item_field">
                                                    <input type="text" name="name" class="text-uppercase form-control">
                                                </div>
                                            </div>
                                            <div class="dnx_content_form_item clearfix">
                                                <div class="dnx_content_form_item_lab">
                                                    Giới tính <span class="text-danger">*</span>
                                                </div>
                                                <div class="dnx_content_form_item_field">
                                                    <select name="gender" placeholder="Nhập nội dung">
                                                        <option class="default-selected" value="0" selected="">Nam</option>
                                                        <option value="1">Nữ</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="dnx_content_form_2col clearfix">
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab">
                                                Ngày sinh <span class="text-danger">*</span>
                                            </div>
                                            <div class="dnx_content_form_item_field">
                                                <input class="datetimepicker-input form-control" type="date" name="bod">
                                            </div>
                                        </div>
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab">
                                                Số điện thoại <span class="text-danger">*</span>
                                            </div>
                                            <div class="dnx_content_form_item_field">
                                                <input type="text" name="phone" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="dnx_content_form_2col clearfix">
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab">
                                                Email
                                            </div>
                                            <div class="dnx_content_form_item_field">
                                                <input type="email" name="email" class="text-uppercase form-control">
                                            </div>
                                        </div>
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab">
                                                Ảnh đại diện
                                            </div>
                                            <div class="dnx_content_form_item_field">
                                                <input type="file" name="profilepic">
                                            </div>
                                        </div>
                                    </div>
                                    <p class="mt-3">Địa chỉ nơi đang ở:</p>
                                    <div class="dnx_content_form_2col clearfix">
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab">
                                                Tỉnh /Thành
                                            </div>
                                            <div class="dnx_content_form_item_field">
                                                <select name="city" placeholder="Nhập nội dung">
                                                    <option class="default-selected" value="1" selected="">Chọn tỉnh, thành phố</option>
                                                    <option value="2">Ba Vì</option>
                                                    <option value="3">Chương Mĩ</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab">
                                                Quận/Huyện
                                            </div>
                                            <div class="dnx_content_form_item_field">
                                                <select name="district" placeholder="Nhập nội dung">
                                                    <option class="default-selected" value="1" selected="">Chọn quận huyện</option>
                                                    <option value="2">Ba Vì</option>
                                                    <option value="3">Chương Mĩ</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="dnx_content_form_2col clearfix">
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab">
                                                Phường/Xã
                                            </div>
                                            <div class="dnx_content_form_item_field">
                                                <select name="ward" placeholder="Nhập nội dung">
                                                    <option class="default-selected" value="1" selected="">Chọn phường/xã</option>
                                                    <option value="2">Thị trấn Xuân Mai</option>
                                                    <option value="3">Xã Đông Sơn</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="dnx_content_form_item clearfix">
                                        <div class="dnx_content_form_item_lab" style="line-height: normal;">
                                            Số nhà, tên đường
                                        </div>
                                        <div class="dnx_content_form_item_field">
                                            <input type="text" name="address" class="form-control">
                                        </div>
                                    </div>
                                    <h3>TÌNH TRẠNG SỨC KHỎE</h3>
                                    <div class="dnx_content_form">
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab" style="line-height: 17px !important;">
                                                Tình trạng tiêm vaccine?
                                            </div>
                                            <div class="dnx_content_form_item_field">
                                                <!-- <input  data-bind="value:so_mui_da_tiem"/> -->
                                                <select id="so_mui_da_tiem" data-bind="value:so_mui_da_tiem">
                                                    <!-- <option value="1" selected="selected">Đã tiêm 2 mũi trở lên, thời gian tiêm mũi 2 đã trên 2 tuần</option>
                                        <option value="0" selected="selected">Lựa chọn khác</option> -->
                                                    <option value="0" selected="selected">Chưa tiêm</option>
                                                    <option value="2" selected="selected">Đã tiêm 1 mũi</option>
                                                    <option value="3" selected="selected">Đã tiêm 2 mũi, thời gian tiêm mũi 2 dưới 2 tuần
                                                    </option>
                                                    <option value="1" selected="selected">Đã tiêm 2 mũi, thời gian tiêm mũi 2 trên 2 tuần
                                                    </option>
                                                    <option value="4" selected="selected">Đã tiêm 3 mũi</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab" style="line-height: normal;">
                                                Tên vắc xin
                                            </div>
                                            <div class="dnx_content_form_item_field">
                                                <ul class="loaivx">
                                                    <li><input type="checkbox" value="1" id="vacxin-1" name="vacxin"><label
                                                            for="vacxin-1">AstraZeneca</label></li>
                                                    <li><input type="checkbox" value="2" id="vacxin-2" name="vacxin"><label
                                                            for="vacxin-2">Pfizer/BioTech</label></li>
                                                    <li><input type="checkbox" value="3" id="vacxin-3" name="vacxin"><label
                                                            for="vacxin-3">SPUTNIK V</label></li>
                                                    <li><input type="checkbox" value="4" id="vacxin-4" name="vacxin"><label
                                                            for="vacxin-4">Moderna</label></li>
                                                    <li><input type="checkbox" value="5" id="vacxin-5" name="vacxin"><label
                                                            for="vacxin-5">Vero Cell</label></li>
                                                    <li><input type="checkbox" value="6" id="vacxin-6" name="vacxin"><label
                                                            for="vacxin-6">Janssen</label></li>
                                                    <li><input type="checkbox" value="7" id="vacxin-7" name="vacxin"><label
                                                            for="vacxin-7">Abdala (Cuba)</label></li>
                                                    <li><input type="checkbox" value="8" id="vacxin-8" name="vacxin"><label
                                                            for="vacxin-8">Khác</label></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="dnx_content_form_item">
                                            <p>Phụ nữ có thai hoặc sinh con &lt;= 42 ngày tuổi không?</p>
                                            <ul>
                                                <li>
                                                    <input type="radio" id="co_thai" name="co_thai" value="1"><label
                                                        for="co_thai">Có</label>
                                                </li>
                                                <li>
                                                    <input type="radio" id="khong_co_thai" name="co_thai" value="0" checked=""><label
                                                        for="khong_co_thai">Không</label>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="dnx_content_form_item clearfix">
                                            <p>Có tình trạng cấp cứu chuyên khoa</p>
                                            <ul>
                                                <li>
                                                    <input type="radio" id="co_capcuu" name="co_capcuu" value="1"><label
                                                        for="co_capcuu">Có</label>
                                                </li>
                                                <li>
                                                    <input type="radio" id="khong_capcuu" name="co_capcuu" value="0" checked=""><label
                                                        for="khong_capcuu">Không</label>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab" style="line-height: 17px !important;">
                                                Người bệnh thuộc nhóm tuổi
                                            </div>
                                            <div class="dnx_content_form_item_field">                         
                                                <select id="loai_do_tuoi" data-bind="value:loai_do_tuoi">
                                                    <option value="1" selected="selected">Bệnh nhi dưới 3 tháng tuổi</option>
                                                    <option value="2" selected="selected">Dưới 50 tuổi</option>
                                                    <option value="3" selected="selected">Từ 50 đến 64 tuổi</option>
                                                    <option value="4" selected="selected">Trên 65 tuổi</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="dnx_content_form_item">
                                            <p>Người bệnh có đang điều trị một hay nhiều các bệnh nào trong số các bệnh sau đây?</p>
                                            <ul class="check_lst danhsach-benhnen">
                                                <!--             
                                      <li>
                                        <input type="checkbox" />
                                        <label>
                                          20. Có bệnh lý cấp tính kèm theo</label>
                                      </li> -->

                                                <li>
                                                    <input type="checkbox" id="benhnen_1" name="benh_nen_chi_tiet"
                                                           data-noidung="Đái tháo đường" data-id="1">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_1">1. Đái tháo
                                                        đường</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_2" name="benh_nen_chi_tiet"
                                                           data-noidung="Bệnh phổi tắc nghẽn mãn tính và các bệnh phổi khác" data-id="2">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_2">2. Bệnh phổi tắc
                                                        nghẽn mãn tính và các bệnh phổi khác</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_3" name="benh_nen_chi_tiet"
                                                           data-noidung="Ung thư đặc biệt là các khối u ác tính về huyết học, ung thư phổi và bệnh ung thư di căn khác"
                                                           data-id="3">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_3">3. Ung thư đặc biệt
                                                        là các khối u ác tính về huyết học, ung thư phổi và bệnh ung thư di căn khác</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_4" name="benh_nen_chi_tiet"
                                                           data-noidung="Bệnh thận mạn tính" data-id="4">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_4">4. Bệnh thận mạn
                                                        tính</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_5" name="benh_nen_chi_tiet"
                                                           data-noidung="Ghép tạng hoặc cấy ghép tế bào gốc tạo máu" data-id="5">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_5">5. Ghép tạng hoặc
                                                        cấy ghép tế bào gốc tạo máu</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_6" name="benh_nen_chi_tiet"
                                                           data-noidung="Béo phì, thừa cân" data-id="6">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_6">6. Béo phì, thừa
                                                        cân</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_7" name="benh_nen_chi_tiet"
                                                           data-noidung="Bệnh tim mạch (suy tim, bệnh động mạch vành hoặc bệnh cơ tim)"
                                                           data-id="7">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_7">7. Bệnh tim mạch
                                                        (suy tim, bệnh động mạch vành hoặc bệnh cơ tim)</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_8" name="benh_nen_chi_tiet"
                                                           data-noidung="Bệnh lý mạch máu não" data-id="8">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_8">8. Bệnh lý mạch máu
                                                        não</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_9" name="benh_nen_chi_tiet"
                                                           data-noidung="Hội chứng Down" data-id="9">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_9">9. Hội chứng
                                                        Down</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_10" name="benh_nen_chi_tiet" data-noidung="HIV/AIDS"
                                                           data-id="10">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_10">10.
                                                        HIV/AIDS</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_11" name="benh_nen_chi_tiet"
                                                           data-noidung="Bệnh lý thần kinh, bao gồm cả chứng sa sút trí tuệ" data-id="11">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_11">11. Bệnh lý thần
                                                        kinh, bao gồm cả chứng sa sút trí tuệ</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_12" name="benh_nen_chi_tiet"
                                                           data-noidung="Bệnh hồng cầu hình liềm" data-id="12">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_12">12. Bệnh hồng cầu
                                                        hình liềm</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_13" name="benh_nen_chi_tiet"
                                                           data-noidung="Bệnh hen suyễn" data-id="13">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_13">13. Bệnh hen
                                                        suyễn</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_14" name="benh_nen_chi_tiet"
                                                           data-noidung="Tăng huyết áp" data-id="14">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_14">14. Tăng huyết
                                                        áp</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_15" name="benh_nen_chi_tiet"
                                                           data-noidung="Thiếu hụt miễn dịch" data-id="15">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_15">15. Thiếu hụt miễn
                                                        dịch</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_16" name="benh_nen_chi_tiet" data-noidung="Bệnh gan"
                                                           data-id="16">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_16">16. Bệnh
                                                        gan</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_17" name="benh_nen_chi_tiet"
                                                           data-noidung="Rối loạn sử dụng chất gây nghiện" data-id="17">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_17">17. Rối loạn sử
                                                        dụng chất gây nghiện</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_18" name="benh_nen_chi_tiet"
                                                           data-noidung="Sử dụng corticosteroid hoặc các thuốc ức chế miễn dịch khác"
                                                           data-id="18">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_18">18. Sử dụng
                                                        corticosteroid hoặc các thuốc ức chế miễn dịch khác</label>
                                                </li>

                                                <li>
                                                    <input type="checkbox" id="benhnen_19" name="benh_nen_chi_tiet"
                                                           data-noidung="Các loại bệnh hệ thống" data-id="19">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_19">19. Các loại bệnh
                                                        hệ thống</label>
                                                </li>
                                                <li>
                                                    <input type="checkbox" id="benhnen_20" name="benh_nen_chi_tiet"
                                                           data-noidung="Các bệnh nền của trẻ em theo hướng dẫn BYT (trẻ đẻ non, cân nặng thấp; trẻ béo phì, thừa cân; đái tháo đường, bệnh tim bẩm sinh, các bệnh lý gene và rối loạn chuyển hóa, hen phế quản; bệnh thalassemia, ung thư, bệnh nhân đang điều trị bằng thuốc corticoid hoặc các thuốc ức chế miễn dịch khác,...)"
                                                           data-id="20">
                                                    <label style="width: calc(100% - 20px) !important;" for="benhnen_20">20. Các bệnh nền
                                                        của trẻ em theo hướng dẫn BYT (trẻ đẻ non, cân nặng thấp; trẻ béo phì, thừa cân; đái
                                                        tháo đường, bệnh tim bẩm sinh, các bệnh lý gene và rối loạn chuyển hóa, hen phế
                                                        quản; bệnh thalassemia, ung thư, bệnh nhân đang điều trị bằng thuốc corticoid hoặc
                                                        các thuốc ức chế miễn dịch khác,...)</label>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-lg-12" style="align-items: center; justify-content: center; margin-left: 400px;">
                                        <button  type="submit" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3">Cập nhật</button>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <%} else {
                            UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
                        %>
                        <table>
                            <tr>
                                <td>Họ và Tên</td>
                                <td><%=userinfo.getName()%></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><%=userinfo.getEmail()%></td>
                            </tr>
                            <tr>
                                <td>Ngày sinh</td>
                                <td><%=userinfo.getBday()%></td>
                            </tr>
                            <tr>
                                <td>Giới tính</td>
                                <td><%=(userinfo.isSex() == true ? "Nam" : "Nữ")%></td>
                            </tr>
                            <tr>
                                <td>Ảnh đại diện</td>
                                <!--<td><%=userinfo.getImage()%></td>-->
                                <td><img src="images/uploads/<%=userinfo.getImage()%>"></td>
                            </tr>
                            <tr>
                                <td>Địa chỉ</td>
                                <td><%=userinfo.getAddress()%></td>
                            </tr>
                        </table>
                        <%}%>
                    </div>
                </div>
            </div>
        </section>
    </body>

    <%@include file = "../common/footer.jsp" %>
</html>