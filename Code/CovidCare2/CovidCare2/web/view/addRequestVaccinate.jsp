<%-- 
    Document   : addPostVaccinate
    Created on : Mar 22, 2022, 1:04:53 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <section class="login dashboard section">
            <!-- Container Start -->
            <div class="container">
                <!-- Row Start -->
                <div class="row">       
                    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
                        <!-- Recently Favorited -->
                        <form action="addPostVaccinate" method="post">
                            <div class="widget dashboard-container my-adslist">         
                                <h3 style="font-weight: bold;" class="widget-header">Thông Tin Vaccine</h3>
                                <table class="table table-responsive product-dashboard-table">
                                    <tbody>
                                    <div class="col-lg-12">
                                        <div class="dnx_content_form_item clearfix">
                                            <div style="font-weight: bold;" class="dnx_content_form_item_lab">
                                                Chọn loại vaccine :
                                            </div>
                                            <div class="dnx_content_form_item_field">
                                                <select name="vacc_id">
                                                    <c:forEach items="${listVaccine}" var='v'>
                                                        <option value="${v.vaccId}">${v.vaccName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>     
                                        <h6 class="font-weight-bold pt-4 pb-1"> Ngày bắt đầu tiêm:</h6>
                                        <input type="date" name="start_date" class="border w-100 p-2 bg-white text-capitalize">
                                        <h6 class="font-weight-bold pt-4 pb-1"> Ngày kết thúc tiêm:</h6>
                                        <input type="date" name="expired_date" class="border w-100 p-2 bg-white text-capitalize">   
                                        <h6 class="font-weight-bold pt-4 pb-1"> Địa điểm cụ thể :</h6>
                                        <input type="text" name="place" class="border w-100 p-2 bg-white text-capitalize" placeholder="Nhập địa điểm vào đây">                                                                                          
                                        <h6 class="font-weight-bold pt-4 pb-1">Ghi chú :</h6>
                                        <textarea name="note" class="border p-3 w-100" rows="7" placeholder="Ghi chú vào đây"></textarea>
                                        <h6 class="font-weight-bold pt-4 pb-1">Số lượng mũi tiêm có sẵn :</h6>
                                        <input type="number" name="amount" class="border w-100 p-2 bg-white text-capitalize" placeholder="Nhập số lượng mũi vào đây">  
                                    </div>
                                    </tbody>
                                </table>                                                                                                         
                                <input style="margin-left:300px; ;" type="submit" class="btn btn-primary d-block mt-2" value="Đăng lên">                                              
                            </div>
                        </form>
                    </div>
                </div>
                <!-- Row End -->
            </div>
            <!-- Container End -->
        </section>

    </body>
</html>
