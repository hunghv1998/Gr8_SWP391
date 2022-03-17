<%-- 
    Document   : createTimetable.jsp
    Created on : Mar 15, 2022, 4:25:52 PM
    Author     : asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

    <%@include file = "../common/head.jsp" %>

    <body class="body-wrapper">

        <%@include file = "../common/nav.jsp" %>

        <section class="dashboard section">
            <!-- Container Start -->
            <div class="container">
                <!-- Row Start -->
                <div class="row">
                    <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0">
                        <div class="sidebar">				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu">
                                <ul>
                                    <li class="active"><a href="CreateNews"><i class=""></i> Tạo Mới Việc Cần Làm </a></li>   
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
                        <form action="CreateTimetable" method="post">
                            <div class="widget dashboard-container my-adslist">

                                <h3 class="widget-header">Tạo Mới Việc Cần Làm</h3>
                                <table class="table table-responsive product-dashboard-table">


                                    <tbody>
                                    <div class="col-lg-12">
                                        <h6 class="font-weight-bold pt-4 pb-1">Việc Cần Làm :</h6>
                                        <input type="text" class="border w-100 p-2 bg-white text-capitalize" name="action" placeholder="Việc Cần Làm">                             
                                        <h6 class="font-weight-bold pt-4 pb-1">Ngày Giờ Bắt Đầu :</h6>
                                        <input type="datetime-local" class="border w-100 p-2 bg-white text-capitalize" name="start">                                                                      
                                        <h6 class="font-weight-bold pt-4 pb-1">Ngày Giờ Kết Thúc:</h6>
                                        <input type="datetime-local" class="border w-100 p-2 bg-white text-capitalize" name="end">                                                                      
                                    </div>
                                    </tbody>
                                </table>                                            
                                <input type="submit" class="btn btn-primary d-block mt-2" value="Tạo Mới">
                            </div>
                        </form>
                    </div>
                </div>
                <!-- Row End -->
            </div>
            <!-- Container End -->
        </section>

    </body>
    <%@include file = "../common/footer.jsp" %>
</html>

