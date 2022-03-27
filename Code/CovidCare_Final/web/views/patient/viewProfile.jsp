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
                        ${patient.getName()}
                    </div>
                </div>
                <div class="dnx_content_form_item clearfix">
                    <div class="dnx_content_form_item_lab">
                        Giới tính
                    </div>
                    <div class="dnx_content_form_item_lab">
                        <c:choose>
                            <c:when test="${not patient.isGender()}">
                                Nam
                            </c:when>
                            <c:otherwise>
                                Nữ
                            </c:otherwise>
                        </c:choose>
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
                    ${patient.getBirthday()}
                </div>
            </div>
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab">
                    Email
                </div>
                <div class="dnx_content_form_item_lab">
                    ${patient.getEmail()}
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
                    ${city.getCityName()}
                </div>
            </div>
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab">
                    Quận/Huyện
                </div>
                <div class="dnx_content_form_item_lab">
                    ${district.getDistrictName()}
                </div>
            </div>
        </div>
        <div class="dnx_content_form_2col clearfix">
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab">
                    Phường/Xã
                </div>
                <div class="dnx_content_form_item_lab">
                    ${ward.getWardName()}
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
                ${patient.getAddress()}
            </div>
        </div>
        <h3>TÌNH TRẠNG SỨC KHỎE</h3>
        <div class="dnx_content_form">
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab" style="line-height: 17px !important;">
                    Tình trạng tiêm vaccine
                </div>
                <div class="dnx_content_form_item_field">
                    <c:set var="vaccStatus" scope="session" value="${patient.getVaccineStatus()}"/>
                    <c:forEach items="${vaccStatusList}" var="c">
                        <c:if test="${c.getId() eq vaccStatus}">
                            ${c.getDetail()}
                        </c:if>
                    </c:forEach>
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
                                <input type="checkbox" disabled id="vacc${vaccine.getVaccId()}" name="vaccines" 
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
                <c:choose>
                    <c:when test="${patient.isPregnancyStatus()}">
                        Có
                    </c:when>
                    <c:otherwise>
                        Không
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="dnx_content_form_item clearfix">
                <p>Có tình trạng cấp cứu chuyên khoa</p>
                <c:choose>
                    <c:when test="${patient.isEmergencyStatus()}">
                        Có
                    </c:when>
                    <c:otherwise>
                        Không
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="dnx_content_form_item clearfix">
                <div class="dnx_content_form_item_lab" style="line-height: 17px !important;">
                    Người bệnh thuộc nhóm tuổi
                </div>
                <div class="dnx_content_form_item_field">
                    <c:set var="ageStatus" scope="session" value="${patient.getAgeType()}"/>
                    <c:forEach items="${ages}" var="age">
                        <c:if test="${age.getAgeId() == ageStatus}">${age.getAgeType()}</c:if>
                    </c:forEach>
                </div>
            </div>

            <div class="dnx_content_form_item">
                <p>Người bệnh có đang điều trị một hay nhiều các bệnh nào trong số các bệnh sau đây?</p>
                <ul class="check_lst danhsach-benhnen">
                    <c:forEach items="${diseases}" var="disease">
                        <li>
                            <input type="checkbox" id="disease${disease.getDiseaseId()}" disabled name="diseases" 
                                   <c:forEach items="${patient.getDiseases()}" var="dis">
                                       <c:if test="${dis == disease.getDiseaseId()}">checked</c:if>
                                   </c:forEach>>
                            <label for="disease${disease.getDiseaseId()}" style="display: flex;">${disease.getDetail()}</label>
                        </li>
                    </c:forEach>

                </ul>
            </div>
        </div>
        <c:if test="${user.userType == 3}">
            <div class="col-md-12 col-lg-12" style="align-items: center; justify-content: center; margin-left: 400px;">
                <button class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3" onclick="location.href = 'info?action=update'">Cập nhật</button>
            </div>
        </c:if>
        <c:if test="${user.userType == 2}">
            <div class="col-md-12 col-lg-12" style="align-items: center; justify-content: center; margin-left: 400px;">
                <button class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3" onclick="location.href = 'patient?action=update'">Xác nhận tình trạng covid</button>
            </div>
        </c:if>
    </div>
</div>