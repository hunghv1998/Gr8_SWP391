<%-- 
    Document   : createNews
    Created on : Feb 25, 2022, 4:39:29 PM
    Author     : Hoang Hung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                    <div class="col-md-10 offset-md-1 col-lg-3 offset-lg-0">
                        <div class="sidebar">				
                            <!-- Dashboard Links -->
                            <div class="widget user-dashboard-menu">
                                <ul>
                                    <li class="active"><a href=""><i class=""></i> Create News </a></li>
                                    <li>
                                        <a href=""><i class=""></i> List News <span>5</span></a>
                                    </li>
                                    <li >
                                        <a href=""><i class=""></i> Manager profiles <span>12</span></a>
                                    </li>
                                    <li>
                                        <a href=""><i class=""></i> List Profiles <span>23</span></a>
                                    </li>													
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-0">
                        <!-- Recently Favorited -->
                        <div class="widget dashboard-container my-adslist">
                            <h3 class="widget-header">Create News</h3>
                            <table class="table table-responsive product-dashboard-table">		
                                <tbody>
                                <div class="col-lg-12">
                                    <h6 class="font-weight-bold pt-4 pb-1">Title :</h6>
                                    <input type="text" class="border w-100 p-2 bg-white text-capitalize" placeholder="Ad title go There">                             
                                    <div class="choose-file text-center my-4 py-4 rounded">
                                        <label for="file-upload">
                                            <span class="d-block font-weight-bold text-dark">Drop files anywhere to upload</span>
                                            <span class="d-block">or</span>
                                            <span class="d-block btn bg-primary text-white my-3 select-files">Select files</span>
                                            <span class="d-block">Maximum upload file size: 500 KB</span>
                                            <input type="file" class="form-control-file d-none" id="file-upload" name="file">
                                        </label>
                                    </div>
                                    <h6 class="font-weight-bold pt-4 pb-1">Description:</h6>
                                    <textarea name="" id="" class="border p-3 w-100" rows="7" placeholder="Write details about news"></textarea>
                                </div>
                                </tbody>
                            </table>
                            <!-- submit button -->                 
                            <button type="submit" class="btn btn-primary d-block mt-2">Post News</button>
                        </div>


                    </div>
                </div>
                <!-- Row End -->
            </div>
            <!-- Container End -->
        </section>

    </body>
    <%@include file = "../common/footer.jsp" %>
</html>
