<%-- 
    Document   : addPostVaccinate
    Created on : Mar 22, 2022, 1:04:53 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file = "../../common/head.jsp" %>

    <body class="body-wrapper">

        <%@include file = "../../common/nav.jsp" %>
        <section class="login dashboard section">
            <!-- Container Start -->
            <div class="container">
                <!-- Row Start -->
                <div class="row">

                    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
                        <!-- Recently Favorited -->
                        <form action="addRequest" method="post">
                            <input type="hidden" name="post_id" value="${pv.id}">
                            <div class="widget dashboard-container my-adslist">         
                                <h3 style="font-weight: bold;" class="widget-header">Thông Tin Đợt Tiêm</h3>
                                <div class="dnx_content_form_item clearfix">
                                    <h4>Loại vaccine: ${pv.vaccName}</h4>
                                    <h4> Ngày bắt đầu tiêm:  ${pv.startDate}</h4>
                                    <h4>   Địa điểm: ${pv.place}</h4>
                                    <h4> Số mũi tiêm có sẵn: ${pv.amount}</h4>
                                    <h4>  Tình trạng: <c:choose>
                                            <c:when test="${pv.status}">
                                                Đang tiến hành                                                          
                                            </c:when>    
                                            <c:otherwise>
                                                Đã hết hạn                                                    
                                            </c:otherwise>
                                        </c:choose></h4>

                                    <h2> Đăng kí tiêm</h2>
                                    <p style="color: red;">
                                        ${message}
                                        <br>
                                        ${error}
                                    </p>
                                    <h6 class="font-weight-bold pt-4 pb-1"> Số điện thoại</h6>
                                    <input type="number" name="phone" class="border w-100 p-2 bg-white text-capitalize">
                                    <h6 class="font-weight-bold pt-4 pb-1"> Ghi chú</h6>
                                    <input type="text" name="note" class="border w-100 p-2 bg-white text-capitalize">  
                                    <h6 class="font-weight-bold pt-4 pb-1"></h6>                                     
                                </div>
                                <input style="margin-left:300px; ;" type="submit" class="btn btn-primary d-block mt-2" value="Đăng ký">                                              
                            </div>
                        </form>
                    </div>
                </div>
                <!-- Row End -->
            </div>
            <!-- Container End -->
        </section>

    </body>
    <%@include file = "../../common/footer.jsp" %>
</html>
