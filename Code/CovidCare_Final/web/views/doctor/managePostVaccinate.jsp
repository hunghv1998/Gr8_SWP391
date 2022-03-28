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
                        <div class="sidebar">				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu" style="width:auto;">
                                <ul>
                                    <li>
                                        <a href="addPost">
                                            <i class=""></i> Tạo lịch tiêm
                                        </a>
                                    </li>   
                                    <li class="active">
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
                        <div class="widget dashboard-container my-adslist" style="width:auto;">
                            <c:if test="${message != null}">${message}</c:if>
                                <h3 class="widget-header">Danh sách đợt tiêm</h3>
                                <table  class="table table-responsive product-dashboard-table">
                                    <thead>
                                        <tr>
                                            <th nowrap class="text-center">Ngày bắt đầu</th>
                                            <th nowrap class="text-center">Loại Vaccine</th>   
                                            <th nowrap class="text-center">Địa điểm</th> 
                                            <th nowrap class="text-center">Số mũi còn sẵn</th> 
                                            <th nowrap class="text-center">Trạng thái</th>                                      
                                            <th nowrap class="text-center">Action</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach items="${listPost}" var='pv'>
                                        <tr>                               
                                            <td nowrap  class="text-center">${pv.startDate}</td>
                                            <td nowrap class="text-center">${pv.vaccName}</td>                                          
                                            <td nowrap class="text-center">${pv.place}</td>                                          
                                            <td nowrap class="text-center">${pv.amount}</td>                                          
                                            <td  nowrap class="text-center"><c:choose>
                                                    <c:when test="${pv.status}">
                                                        Đang tiến hành                                                           
                                                    </c:when>    
                                                    <c:otherwise>
                                                        Đã hết hạn                                                    
                                                    </c:otherwise>
                                                </c:choose></td>                                          
                                            <td nowrap class="action" data-title="Action"> 
                                                <div class="">
                                                    <ul class="list-inline justify-content-center">
                                                        <li class="list-inline-item">
                                                            <a href="managePost2?action=1&&post_id=${pv.id}" onclick="return confirm('Bạn muốn chỉnh sửa không?')" class="edit"><i class="fa-solid fa-pen"  title="Edit"></i></a>
                                                        </li>      
                                                        <li class="list-inline-item">
                                                            <a href="managePost2?action=2&&post_id=${pv.id}" class="edit"><i class="fa-solid fa-eye" title="View"></i></a>
                                                        </li>                                            
                                                        <li class="list-inline-item">
                                                            <a href="managePost2?action=3&&post_id=${pv.id}" onclick="return confirm('Bạn có muốn xóa mục này không?')" class="delete"><i class="fas fa-eraser" title="Delete"></i></a>
                                                        </li>
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
