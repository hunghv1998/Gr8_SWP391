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
                    <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0" >
                        <div class="sidebar" >				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu" style="width:auto;">
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
                        <div class="widget dashboard-container my-adslist" style="width:auto;">
                            <h3 class="widget-header">Manage Patient</h3>
                            <table class="table table-responsive product-dashboard-table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th class="text-center" >Name</th>    
                                        <th class="text-center">Address</th>
                                        <th class="text-center">Vaccine Status</th>
                                        <th class="text-center">Covid Status</th>
                                        <th class="text-center">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${patients}" var="p">
                                        <tr>

                                            <td class="">
                                                <a href="patient?id=${p.userId}">${p.name}</a>
                                            <td  class="text-center" style="width:60%;">${p.address}</td>
                                            <td class="text-center">
                                                ${p.covidStatus}
                                            </td>
                                            <td class="text-center">${p.vaccineStatus}</td>
                                            <td class="action" data-title="Action"> 
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
