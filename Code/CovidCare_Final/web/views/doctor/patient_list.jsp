<%-- 
    Document   : patient_list
    Created on : Mar 23, 2022, 2:22:31 PM
    Author     : chinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file = "../../common/head.jsp" %>
    <body>
        <%@include file = "../../common/nav.jsp" %>

        <section class="dashboard section">
            <!-- Container Start -->
            <div class="container">
                <!-- Row Start -->
                <div class="row">
                    <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0"  >
                        <div class="sidebar" >				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu"  style="width:auto;">
                                <ul>
                                    <li>
                                        <a href="">
                                            <i class=""></i> Danh sách bệnh nhân
                                        </a>
                                    </li>																			
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 offset-md-1 col-lg-9 offset-lg-0" >
                        <!-- Recently Favorited -->
                        <div class="widget dashboard-container my-adslist"  style="width:auto;" >
                            <h3 class="widget-header">Quản Lý Bệnh Nhân</h3>
                            <table class="table table-responsive product-dashboard-table">
                                <thead>
                                    <tr>
                                        <th nowrap class="text-center">ID</th>
                                        <th nowrap class="text-center" >Tên Bệnh Nhân</th>    
                                        <th nowrap class="text-center">Địa Chỉ</th>
                                        <th nowrap class="text-center">Vaccine Status</th>
                                        <th nowrap class="text-center">Covid Status</th>
                                        <th nowrap class="text-center">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${patients}" var="p">
                                        <tr>
                                            <td>
                                                ${p.userId}
                                            </td>
                                            <td nowrap class="text-center">
                                                <a href="patient?id=${p.userId}">${p.name}</a>
                                            <td nowrap  class="text-center" >${p.address}</td>                                           
                                            <td nowrap class="text-center">${p.vaccineStatus}</td>
                                            <td nowrap class="text-center">
                                                ${p.covidStatus}
                                            </td>
                                            <td nowrap class="action" data-title="Action"> 
                                                <div class="">
                                                    
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

        <%@include file = "../../common/footer.jsp" %>
    </body>
</html>
