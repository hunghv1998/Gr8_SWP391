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
        <%@include file = "../common/head.jsp" %>
    </head>
    <body class="body-wrapper">
        <%@include file = "../common/nav.jsp" %>
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
                                            <h6 class="font-weight-bold pt-4 pb-1"> Người tạo Post:</h6>
                                            <input type="text" readonly name="created_by" value="${pv.createdBy}" class="border w-100 p-2 bg-white text-capitalize">
                                            <h6 class="font-weight-bold pt-4 pb-1">Loại vaccine:</h6>                                    
                                            <input type="text" readonly name="vaccName" value="${vaccName}" class="border w-100 p-2 bg-white text-capitalize">                                                                               
                                            <h6 class="font-weight-bold pt-4 pb-1"> Ngày bắt đầu tiêm:</h6>
                                            <input type="date" readonly name="start_date" value="${pv.startDate}" class="border w-100 p-2 bg-white text-capitalize">
                                            <h6 class="font-weight-bold pt-4 pb-1"> Ngày kết thúc tiêm:</h6>
                                            <input type="date" readonly name="expired_date" value="${pv.expiredDate}" class="border w-100 p-2 bg-white text-capitalize">   
                                            <h6 class="font-weight-bold pt-4 pb-1"> Địa điểm cụ thể :</h6>
                                            <input type="text" readonly name="place" value="${pv.place}" class="border w-100 p-2 bg-white text-capitalize">                                                                                          
                                            <h6 class="font-weight-bold pt-4 pb-1">Ghi chú :</h6>
                                            <textarea name="note" readonly class="border p-3 w-100" rows="7">${pv.note}</textarea>
                                            <h6 class="font-weight-bold pt-4 pb-1">Số lượng mũi tiêm có sẵn :</h6>
                                            <input type="number" readonly name="amount" value="${pv.amount}" class="border w-100 p-2 bg-white text-capitalize">
                                            <h6 class="font-weight-bold pt-4 pb-1">Trạng thái:</h6>
                                            <input type="text" readonly name="status" value=<c:choose>
                                                       <c:when test="${pv.status}">
                                                           "Đang tiến hành"                                                           
                                                       </c:when>    
                                                       <c:otherwise>
                                                           "Đã hết hạn"                                                    
                                                       </c:otherwise>
                                                   </c:choose>
                                                   class="border w-100 p-2 bg-white text-capitalize">
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
    <%@include file = "../common/footer.jsp" %>
</html>
