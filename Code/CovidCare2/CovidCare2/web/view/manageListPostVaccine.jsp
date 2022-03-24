<%-- 
    Document   : manageListPostVaccine
    Created on : Mar 24, 2022, 9:34:42 AM
    Author     : Hoang Hung
--%>

<%@ page language="java" contentType="text/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">

        <%@include file = "../common/nav.jsp" %>

        <section class="dashboard section">
            <!-- Container Start -->
            <div class="container">
                <!-- Row Start -->
                <div class="row">                   
                    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
                        <!-- Recently Favorited -->
                        <div class="widget dashboard-container my-adslist">
                            <h3 class="widget-header">List Post Vaccine</h3>
                            <table  class="table table-responsive product-dashboard-table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th class="text-center">Date</th>
                                        <th class="text-center">Title</th>                                      
                                        <th class="text-center">Action</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach items="">
                                        <tr>

                                            <td class="">
                                                <a></a>
                                            <td  class="text-center"></td>
                                            <td class="text-center"></td>                                          
                                            <td class="action" data-title="Action"> 
                                                <div class="">
                                                    <ul class="list-inline justify-content-center">
                                                        <li class="list-inline-item">
                                                            <a href="" onclick="return confirm('Bạn muốn chỉnh sửa không?')" class="edit"><i class="fa-solid fa-pen"  title="Edit"></i></a>
                                                        </li>      
                                                        <li class="list-inline-item">
                                                            <a href="" class="edit"><i class="fa-solid fa-eye" title="View"></i></a>
                                                        </li>                                            
                                                        <li class="list-inline-item">
                                                            <a href="" onclick="return confirm('Bạn có muốn xóa mục này không?')" class="delete"><i class="fas fa-eraser" title="Delete"></i></a>
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
    <%@include file = "../common/footer.jsp" %>
</html>>
