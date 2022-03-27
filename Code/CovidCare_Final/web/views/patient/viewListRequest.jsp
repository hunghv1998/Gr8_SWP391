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
