<%-- 
    Document   : viewProfile
    Created on : Feb 24, 2022, 11:16:45 AM
    Author     : chinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="dnx_content_inner">
    <h2 style="text-align: center;">Thông tin cá nhân</h2>
    <div class="dnx_content_box">
        <h3>Thông tin liên hệ</h3>
        <div class="dnx_content_form">
            <div class="dnx_content_form_2col clearfix">
                <div class="dnx_content_form_item clearfix">
                    <div class="dnx_content_form_item_lab">
                        <div class="dnx_content_form_item_lab">
                            Họ và tên
                        </div>
                    </div>
                    <div class="dnx_content_form_item_lab">
                        
                    </div>
                </div>
                <div class="dnx_content_form_item clearfix">
                    <div class="dnx_content_form_item_lab">
                        Giới tính
                    </div>
                    <div class="dnx_content_form_item_lab">
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="dnx_content_form_2col clearfix">
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab">
                    Ngày sinh
                </div>
                <div class="dnx_content_form_item_lab">
                    
                </div>
            </div>
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab">
                    Email
                </div>
                <div class="dnx_content_form_item_lab">
                    
                </div>
            </div>
        </div>
        <div class="dnx_content_form_2col clearfix">
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab">
                    Ảnh đại diện
                </div>
                <div class="dnx_content_form_item_lab">
                    <img src="images/uploads/${patient.getPhoto()}" style="width: 150px; height: 100px;">
                </div>
            </div>
            <div class="dnx_content_form_item clearfix">

            </div>
        </div>
        <p class="mt-3">Địa chỉ nơi đang ở:</p>
        <div class="dnx_content_form_2col clearfix">
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab">
                    Tỉnh /Thành
                </div>
                <div class="dnx_content_form_item_lab">
                    Hà Nội
                </div>
            </div>
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab">
                    Quận/Huyện
                </div>
                <div class="dnx_content_form_item_lab">
                    Cầu Giấy
                </div>
            </div>
        </div>
        <div class="dnx_content_form_2col clearfix">
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab">
                    Phường/Xã
                </div>
                <div class="dnx_content_form_item_lab">
                    Nghĩa Đô
                </div>
            </div>
            <div class="dnx_content_form_item clearfix">
            </div>
        </div>
        <div class="dnx_content_form_item clearfix">
            <div class="dnx_content_form_item_lab">
                Số nhà, tên đường
            </div>
            <div class="dnx_content_form_item_lab">
                
            </div>
        </div>
        <h3>TÌNH TRẠNG SỨC KHỎE</h3>
        <div class="dnx_content_form">
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab" style="line-height: 17px !important;">
                    Tình trạng tiêm vaccine
                </div>
                <div class="dnx_content_form_item_field">

                </div>
            </div>
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab" style="line-height: normal;">
                    Tên vắc xin
                </div>
                <div class="dnx_content_form_item_field">
                    <ul class="loaivx">
                        
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
                    

                </ul>
            </div>
        </div>
        <div class="col-md-12 col-lg-12" style="align-items: center; justify-content: center; margin-left: 400px;">
            <button class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3" onclick="location.href = 'userinfo?update'">Cập nhật</button>
        </div>
    </div>
</div>