<%-- 
    Document   : addPostVaccinate
    Created on : Mar 22, 2022, 1:04:53 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file = "../../common/head.jsp" %>

    <body class="body-wrapper">

        <%@include file = "../../common/nav.jsp" %>
        <section class="login dashboard section">
            <!-- Container Start -->
            <div class="container">
                <!-- Row Start -->
                <div class="row">       
                    <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0">
                        <div class="sidebar">				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu" style="width:auto;">
                                <ul>
                                    <li class="active">
                                        <a href="addPost">
                                            <i class=""></i> Tạo lịch tiêm
                                        </a>
                                    </li>   
                                    <li>
                                        <a href="managePost">
                                            <i class=""></i> Quản lý lịch tiêm
                                        </a>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>
                     <div class="col-md-10 offset-md-1 col-lg-9 offset-lg-0">
                        <!-- Recently Favorited -->
                        <form action="editPost" method="post">
                            <div class="widget dashboard-container my-adslist" style="width:auto;">
                                <p style="color: red;">
                                    ${message}
                                    <br>
                                    ${error}
                                </p>

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
                                                        <option value="${v.vaccId}" <c:if test="${currPost.vaccId == v.vaccId}"> selected</c:if>
                                                                >${v.vaccName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <input type="hidden" name="postId" value="${currPost.id}"
                                        <h6 class="font-weight-bold pt-4 pb-1"> Ngày bắt đầu tiêm:</h6>
                                        <input type="date" name="start_date" class="border w-100 p-2 bg-white text-capitalize" value="${currPost.startDate}">
                                        <h6 class="font-weight-bold pt-4 pb-1"> Ngày kết thúc tiêm:</h6>
                                        <input type="date" name="expired_date" class="border w-100 p-2 bg-white text-capitalize" value="${currPost.expiredDate}">   
                                        <h6 class="font-weight-bold pt-4 pb-1"> Địa điểm cụ thể :</h6>
                                        <input type="text" name="place" class="border w-100 p-2 bg-white text-capitalize" placeholder="Nhập địa điểm vào đây" value="${currPost.place}">                                                                                          
                                        <h6 class="font-weight-bold pt-4 pb-1">Ghi chú :</h6>
                                        <textarea name="note" class="border p-3 w-100" rows="7" placeholder="Ghi chú vào đây">${currPost.note}</textarea>
                                        <h6 class="font-weight-bold pt-4 pb-1">Số lượng mũi tiêm có sẵn :</h6>
                                        <input type="number" name="amount" class="border w-100 p-2 bg-white text-capitalize" placeholder="Nhập số lượng mũi vào đây" value="${currPost.amount}">  
                                    </div>
                                    </tbody>
                                </table>
                                <c:choose>
                                    <c:when test="${currPost.id >0}">
                                        <input style="margin-left:300px; ;" type="submit" class="btn btn-primary d-block mt-2" value="Cập nhật">   

                                    </c:when>    
                                    <c:otherwise>
                                        <input style="margin-left:300px; ;" type="submit" class="btn btn-primary d-block mt-2" value="Đăng lên">   

                                    </c:otherwise>
                                </c:choose>

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
