<%-- 
    Document   : editProfile
    Created on : Feb 24, 2022, 11:16:58 AM
    Author     : chinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="dnx_content_inner">
    <h2 style="text-align: center;">Cập nhật thông tin cá nhân</h2>
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
                            <input type="text" name="name" class="form-control" value="${name}">
                        </div>
                    </div>
                    <div class="dnx_content_form_item clearfix">
                        <div class="dnx_content_form_item_lab">
                            Giới tính <span class="text-danger">*</span>
                        </div>
                        <div class="dnx_content_form_item_field">
                            <select name="gender" placeholder="Nhập nội dung">
                                <option value="0" <c:if test="${not gender}">selected</c:if>>Nam</option>
                                <option value="1" <c:if test="${gender}">selected</c:if>>Nữ</option>
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
                        <input class="datetimepicker-input form-control" type="date" name="bod" value="${bod}">
                    </div>
                </div>
                <div class="dnx_content_form_item clearfix">
                    <div class="dnx_content_form_item_lab">
                        Email <span class="text-danger">*</span>
                    </div>
                    <div class="dnx_content_form_item_field">
                        <input type="email" name="email" class="form-control" value="${email}">
                    </div>
                </div>
            </div>
            <div class="dnx_content_form_2col clearfix">
                <div class="dnx_content_form_item clearfix">
                    <div class="dnx_content_form_item_lab">
                        Ảnh đại diện
                    </div>
                    <div class="dnx_content_form_item_field">
                        <input type="file" name="profilepic" accept="image/*">
                    </div>
                </div>
                <div class="dnx_content_form_item clearfix">

                </div>
            </div>
            <p class="mt-3">Địa chỉ nơi đang ở:</p>
            <div class="dnx_content_form_2col clearfix">
                <div class="dnx_content_form_item clearfix">
                    <div class="dnx_content_form_item_lab">
                        Tỉnh/Thành
                    </div>
                    <div class="dnx_content_form_item_field">
                        <select id="city">
                            <option class="default-selected" value="" selected>Chọn Tỉnh/Thành phố</option>
                        </select>
                    </div>
                </div>
                <div class="dnx_content_form_item clearfix">
                    <div class="dnx_content_form_item_lab">
                        Quận/Huyện
                    </div>
                    <div class="dnx_content_form_item_field">
                        <select id="district">
                            <option class="default-selected" value="" selected>Chọn Quận/Huyện</option>
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
                        <select name="wardId" placeholder="Nhập nội dung" id="ward">
                            <option class="default-selected" value="" selected>Chọn Phường/Xã</option>
                        </select>
                    </div>
                </div>
                <div class="dnx_content_form_item clearfix">
                </div>
            </div>
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab" style="line-height: normal;">
                    Số nhà, tên đường
                </div>
                <div class="dnx_content_form_item_field">
                    <input type="text" name="address" class="form-control" value="${address}">
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
                            <c:forEach items="${vaccines}" var="vaccine">
                                <li>
                                    <input type="checkbox" value="${vaccine.getVaccId()}" id="vacc${vaccine.getVaccId()}" name="vaccines">
                                    <label for="vacc${vaccine.getVaccId()}">${vaccine.getVaccName()}</label>
                                </li>
                            </c:forEach>
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
                        <c:forEach items="${diseases}" var="disease">
                            <li>
                                <input type="checkbox" value="${disease.getDiseaseId()}" id="disease${disease.getDiseaseId()}" name="diseases">
                                <label for="disease${disease.getDiseaseId()}" style="display: flex;">${disease.getDiseaseDetail()}</label>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="col-md-12 col-lg-12" style="align-items: center; justify-content: center; margin-left: 400px;">
                <button  type="submit" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3">Cập nhật</button>
            </div>
        </div>
    </form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            url: "GetLocation",
            method: "GET",
            data: {operation: 'city'},
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                let obj = $.parseJSON(data);
                $.each(obj, function (key, value) {
                    $('#city').append('<option value="' + value.cityId + '">' + value.cityName + '</option>')
                });
                $('select').formSelect();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#city').append('<option>City Unavailable</option>');
            },
            cache: false
        });
        $('#city').change(function () {
            $('#district').find('option').remove();
            $('#district').append('<option>Chọn Quận/Huyện</option>');
            $('#ward').find('option').remove();
            $('#ward').append('<option>Chọn Phường/Xã</option>');

            let cityId = $('#city').val();
            let data = {
                operation: "district",
                cityId: cityId
            };
            $.ajax({
                url: "GetLocation",
                method: "GET",
                data: data,
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    let obj = $.parseJSON(data);
                    $.each(obj, function (key, value) {
                        $('#district').append('<option value="' + value.districtId + '">' + value.districtName + '</option>')
                    });
                    $('select').formSelect();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#district').append('<option>District Unavailable</option>');
                },
                cache: false
            });
        });

        $('#district').change(function () {
            $('#ward').find('option').remove();
            $('#ward').append('<option>Chọn Phường/Xã</option>');

            let districtId = $('#district').val();
            let data = {
                operation: "ward",
                districtId: districtId
            };

            $.ajax({
                url: "GetLocation",
                method: "GET",
                data: data,
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    let obj = $.parseJSON(data);
                    $.each(obj, function (key, value) {
                        $('#ward').append('<option value="' + value.wardId + '">' + value.wardName + '</option>')
                    });
                    $('select').formSelect();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#ward').append('<option>Ward Unavailable</option>');
                },
                cache: false
            });
        });
    });
</script>