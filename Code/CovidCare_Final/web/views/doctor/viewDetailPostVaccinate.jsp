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
        <%@include file = "../../common/head.jsp" %>
    </head>
    <body class="body-wrapper">
        <%@include file = "../../common/nav.jsp" %>
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
                                            <h6 class="font-weight-bold pt-4 pb-1">Loại vaccine:</h6>${currPost.vaccName} <br>                                                                            
                                            <h6 class="font-weight-bold pt-4 pb-1"> Ngày bắt đầu tiêm:</h6>${currPost.startDate}<br>  
                                            <h6 class="font-weight-bold pt-4 pb-1"> Ngày kết thúc tiêm:</h6>${currPost.expiredDate}<br>
                                            <h6 class="font-weight-bold pt-4 pb-1"> Địa điểm cụ thể :</h6>${currPost.place}<br>
                                            <h6 class="font-weight-bold pt-4 pb-1">Ghi chú :</h6>
                                            <textarea name="note" readonly class="border p-3 w-100" rows="7">${currPost.note}</textarea>
                                            <h6 class="font-weight-bold pt-4 pb-1">Số lượng mũi tiêm có sẵn :</h6>${currPost.amount}<br>
                                            <h6 class="font-weight-bold pt-4 pb-1">Trạng thái:</h6><c:choose>
                                                <c:when test="${currPost.status}">
                                                    Đang tiến hành                                                          
                                                </c:when>    
                                                <c:otherwise>
                                                    Đã hết hạn                                                    
                                                </c:otherwise>
                                            </c:choose>                                           
                                        </div>
                                        </tbody>
                                </table>
                                <h3>Yêu cầu tiêm:</h3>
                                <c:forEach items="${listRequestOfPost}" var='rv'>
                                    <div>
                                        Mã số yêu cầu: ${rv.id}<br>
                                        Tài khoản tạo: ${rv.created_name}<br>
                                        Số điện thoại: ${rv.phone}<br>
                                        Ngày yêu cầu:${rv.created_date}<br>
                                        Ghi chú:${rv.note}<br>
                                        Trạng thái: <c:choose>
                                            <c:when test="${rv.status == '2'}">
                                                Chờ xác nhận                                                           
                                            </c:when>
                                            <c:when test="${rv.status == '1'}">
                                                Chấp thuận                                                           
                                            </c:when>
                                            <c:otherwise>
                                                Bị từ chối                                                    
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="">
                                        <ul class="list-inline justify-content-center">
                                            <li class="list-inline-item">
                                                <a href="processRequest?post_id=${currPost.id}&&request_id=${rv.id}&&action=1" onclick="return confirm('Bạn muốn chấp thuận không ?')" class="edit"><i class="fa-solid fa-pen"  title="Chấp thuận "></i></a>
                                            </li>                                                                                             
                                            <li class="list-inline-item">
                                                <a href="processRequest?post_id=${currPost.id}&&request_id=${rv.id}&&action=2" onclick="return confirm('Bạn có muốn từ chối không ?')" class="delete"><i class="fas fa-eraser" title="Từ chối"></i></a>
                                            </li>
                                        </ul>
                                    </div>
                                </c:forEach>
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
