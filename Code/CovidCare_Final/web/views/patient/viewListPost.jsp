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
                    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
                        <!-- Recently Favorited -->
                        <div class="widget dashboard-container my-adslist">
                            <c:if test="${message != null}">${message}</c:if>
                                <h3 class="widget-header">Danh sách đợt tiêm</h3>
                                <table  class="table table-responsive product-dashboard-table">
                                    <thead>
                                        <tr>
                                            <th class="text-center">Ngày bắt đầu</th>
                                            <th class="text-center">Loại Vaccine</th>
                                            <th class="text-center">Địa điểm</th> 
                                            <th class="text-center">Số mũi còn sẵn</th> 
                                            <th class="text-center">Trạng thái</th>                                      
                                            <th class="text-center">Action</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach items="${listPost}" var='pv'>
                                        <tr>                               
                                            <td  class="text-center">${pv.startDate}</td>
                                            <td class="text-center">${pv.vaccName}</td>                                          
                                            <td class="text-center">${pv.place}</td>                                          
                                            <td class="text-center">${pv.amount}</td>                                          
                                            <td class="text-center"><c:choose>
                                                    <c:when test="${pv.status}">
                                                        Đang tiến hành                                                           
                                                    </c:when>    
                                                    <c:otherwise>
                                                        Đã hết hạn                                                    
                                                    </c:otherwise>
                                                </c:choose></td>                                          
                                            <td class="action" data-title="Action"> 
                                                <div class="">
                                                    <ul class="list-inline justify-content-center">
                                                        <li class="list-inline-item">
                                                            <a href="addRequest?post_id=${pv.id}" onclick="return confirm('Bạn muốn đăng kí tiêm không?')" class="edit"><i class="fa-solid fa-pen"  title="Đăng kí tiêm"></i></a>
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
