<%-- 
    Document   : manageListPostVaccine
    Created on : Mar 24, 2022, 9:34:42 AM
    Author     : Hoang Hung
--%>

<%@ page language="java" contentType="text/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <%@include file = "../../common/head.jsp" %>

    <body class="body-wrapper">

        <%@include file = "../../common/nav.jsp" %>

        <section class="dashboard section">
            <!-- Container Start -->
            <div class="container">
                <!-- Row Start -->
                <div class="row">                   
                     <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0">
                        <div class="sidebar" >				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu" style="width:auto;">
                                <ul>
                                    <li>
                                        <a href="listPostPatient">
                                            <i class=""></i> Thông báo tiêm 
                                        </a>
                                    </li>    
                                    <li class="active">
                                        <a href="viewListRequest">
                                            <i class=""></i> Đăng ký tiêm
                                        </a>                                        
                                    </li>																			
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 offset-md-1 col-lg-9 offset-lg-0">
                    
                        <!-- Recently Favorited -->
                        <div  class="widget dashboard-container my-adslist" style="width:auto;">
                            <c:if test="${message != null}">${message}</c:if>
                                <h3 class="widget-header">Danh sách yêu cầu tiêm.</h3>
                                <table  class="table table-responsive product-dashboard-table">
                                    <thead>
                                        <tr>
                                            <th nowrap class="text-center">Ngày tạo</th>
                                            <th nowrap class="text-center">Số điện thoại</th>
                                            <th nowrap class="text-center">Ghi chú</th> 
                                            <th nowrap class="text-center">Tình trạng</th>                                                                         
                                        </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach items="${listRequest}" var='rv'>
                                        <tr>                               
                                            <td nowrap  class="text-center">${rv.created_date}</td>
                                            <td nowrap class="text-center">${rv.phone}</td>                                          
                                            <td nowrap class="text-center">${rv.note}</td>                                          
                                            <td nowrap class="text-center"> <c:choose>
                                                    <c:when test="${rv.status == '2'}">
                                                        Chờ xác nhận                                                           
                                                    </c:when>
                                                    <c:when test="${rv.status == '1'}">
                                                        Chấp thuận                                                           
                                                    </c:when>
                                                    <c:otherwise>
                                                        Bị từ chối                                                    
                                                    </c:otherwise>
                                                </c:choose></td>                                          
                                            <td nowrap class="action" data-title="Action"> 
                                                <div class="">
                                                    <ul class="list-inline justify-content-center">                                                
                                                    </ul>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </table>
                        </div>


                    </div>
                </div>
                <!-- Row End -->
            </div>
            <!-- Container End -->
        </section>
    </body>
    <%@include file = "../../common/footer.jsp" %>
</html>>
