<%-- 
    Document   : hospital_view
    Created on : Mar 25, 2022, 3:04:13 PM
    Author     : chinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <%@include file = "../../common/head.jsp" %>

    <body class="body-wrapper">
        <%@include file = "../../common/nav.jsp" %>

        <div class="dnx_content_inner">
            <h2 style="text-align: center;">Thông tin Bệnh viện</h2>
            <div class="dnx_content_box">
                <h3>Thông tin liên hệ</h3>
                <div class="dnx_content_form">
                    <div class="dnx_content_form_2col clearfix">
                        <div class="dnx_content_form_item clearfix">
                            <div class="dnx_content_form_item_lab">
                                <div class="dnx_content_form_item_lab">
                                    Tên bệnh viện
                                </div>
                            </div>
                            <div class="dnx_content_form_item_lab">
                                ${hospital.hospitalName}
                            </div>
                        </div>
                        <div class="dnx_content_form_item clearfix">
                            <div class="dnx_content_form_item_lab">
                                Ảnh đại diện
                            </div>
                            <div class="dnx_content_form_item_lab">
                                <img src="images/uploads/${hospital.photo}" style="width: 150px; height: 100px;">
                            </div>
                        </div>
                    </div>
                </div>

                <p class="mt-3">Địa chỉ:</p>
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
                        Địa chỉ cụ thể
                    </div>
                    <div class="dnx_content_form_item_lab">
                        ${hospital.address}
                    </div>
                </div>
            </div>
        </div>

        <%@include file = "../../common/footer.jsp" %>
    </body>
</html>
