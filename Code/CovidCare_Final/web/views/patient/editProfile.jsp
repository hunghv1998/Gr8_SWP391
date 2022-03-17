<%-- 
    Document   : editProfile
    Created on : Feb 24, 2022, 11:16:58 AM
    Author     : chinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <input type="text" name="name" class="form-control" value="${patient.getName()}">
                        </div>
                    </div>
                    <div class="dnx_content_form_item clearfix">
                        <div class="dnx_content_form_item_lab">
                            Giới tính <span class="text-danger">*</span>
                        </div>
                        <div class="dnx_content_form_item_field">
                            <select name="gender" placeholder="Nhập nội dung">
                                <option value="0" <c:if test="${not patient.isGender()}">selected</c:if>>Nam</option>
                                <option value="1" <c:if test="${patient.isGender()}">selected</c:if>>Nữ</option>
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
                            <input class="datetimepicker-input form-control" type="date" name="birthday" value="${patient.getBirthday()}">
                    </div>
                </div>
                <div class="dnx_content_form_item clearfix">
                    <div class="dnx_content_form_item_lab">
                        Email <span class="text-danger">*</span>
                    </div>
                    <div class="dnx_content_form_item_field">
                        <input type="email" name="email" class="form-control" value="${patient.getEmail()}">
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
                        <select id="city" name="cities">
                            <option class="default-selected" value="0" selected>Chọn Tỉnh/Thành phố</option>
                        </select>
                    </div>
                </div>
                <div class="dnx_content_form_item clearfix">
                    <div class="dnx_content_form_item_lab">
                        Quận/Huyện
                    </div>
                    <div class="dnx_content_form_item_field">
                        <select id="district" name="districts">
                            <option class="default-selected" value="0" selected>Chọn Quận/Huyện</option>
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
                        <select name="wards" placeholder="Nhập nội dung" id="ward">
                            <option class="default-selected" value="0" selected>Chọn Phường/Xã</option>
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
                    <input type="text" name="address" class="form-control" value="${patient.getAddress()}">
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
                        <select name="vaccineStatus">
                            <option class="default-selected" value="0" selected>Chọn tình trạng tiêm vaccine</option>
                            <c:set var="vaccStatus" scope="session" value="${patient.getVaccineStatus()}"/>
                            <c:forEach items="${vaccStatusList}" var="c">
                                <option value="${c.getId()}" 
                                        <c:if test="${c.getId() eq vaccStatus}">
                                            selected
                                        </c:if>>${c.getDetail()}</option>
                            </c:forEach>
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
                                    <input type="checkbox" value="${vaccine.getVaccId()}" id="vacc${vaccine.getVaccId()}" name="vaccines" 
                                           <c:forEach items="${patient.getVaccList()}" var="vacc">
                                               <c:if test="${vacc == vaccine.getVaccId()}">
                                                   checked
                                               </c:if>
                                           </c:forEach>>
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
                            <input type="radio" name="isPregnant" value="0" id="notPregnant" 
                                   <c:if test="${not isPregnant}">checked</c:if>>
                                   <label for="notPregnant">Không</label>
                            </li>
                            <li>
                                <input type="radio" name="isPregnant" value="1" id="pregnant" 
                                <c:if test="${isPregnant}">checked</c:if>>
                                <label for="pregnant">Có</label>
                            </li>
                        </ul>
                    </div>
                    <div class="dnx_content_form_item clearfix">
                        <p>Có tình trạng cấp cứu chuyên khoa?</p>
                        <ul>
                            <li>
                                <input type="radio" id="notEmergency" name="isEmergency" value="0" 
                                <c:if test="${not isEmergency}">checked</c:if>>
                                <label for="notEmergency">Không</label>
                            </li>
                            <li>
                                <input type="radio" id="emergency" name="isEmergency" value="1" 
                                <c:if test="${isEmergency}">checked</c:if>>
                                <label for="emergency">Có</label>
                            </li>
                        </ul>
                    </div>
                    <div class="dnx_content_form_item clearfix">
                        <div class="dnx_content_form_item_lab" style="line-height: 17px !important;">
                            Người bệnh thuộc nhóm tuổi
                        </div>
                        <div class="dnx_content_form_item_field">                         
                            <select name="ages">
                                <option value="0">Chọn nhóm tuổi phù hợp</option>
                            <c:set var="ageStatus" scope="session" value="${patient.getAgeType()}"/>
                            <c:forEach items="${ages}" var="age">
                                <option value="${age.getAgeId()}" 
                                        <c:if test="${age.getAgeId() == ageStatus}">selected</c:if>>${age.getAgeType()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="dnx_content_form_item">
                    <p>Người bệnh có đang điều trị một hay nhiều các bệnh nào trong số các bệnh sau đây?</p>
                    <ul class="check_lst danhsach-benhnen">
                        <c:forEach items="${diseases}" var="disease">
                            <li>
                                <input type="checkbox" value="${disease.getDiseaseId()}" id="disease${disease.getDiseaseId()}" name="diseases" 
                                       <c:forEach items="${patient.getDiseases()}" var="dis">
                                           <c:if test="${dis == disease.getDiseaseId()}">checked</c:if>
                                       </c:forEach>>
                                <label for="disease${disease.getDiseaseId()}" style="display: flex;">${disease.getDetail()}</label>
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
                    if (value.cityId === "${city.getCityId()}") {
                        $('#city').append('<option value="' + value.cityId + '" selected>' + value.cityName + '</option>');
                    } else {
                        $('#city').append('<option value="' + value.cityId + '">' + value.cityName + '</option>');
                    }
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
                        if (value.districtId === "${district.getDistrictId()}") {
                            $('#district').append('<option value="' + value.districtId + '" selected>' + value.districtName + '</option>');
                        } else {
                            $('#district').append('<option value="' + value.districtId + '">' + value.districtName + '</option>');
                        }
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
                        if (value.wardId === "${ward.getWardId()}") {
                            $('#ward').append('<option value="' + value.wardId + '" selected>' + value.wardName + '</option>');
                        } else {
                            $('#ward').append('<option value="' + value.wardId + '">' + value.wardName + '</option>');
                        }
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