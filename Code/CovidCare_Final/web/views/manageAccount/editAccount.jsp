<%-- 
    Document   : createNews
    Created on : Mar 2, 2022, 4:39:29 PM
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
                    <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-1">
                        <!-- Recently Favorited -->
                        <c:if test="${not empty message}">
                              <b>${message}</b>
                          </c:if>
                        <form action="editAccount" method="POST">
                            <input type="hidden" name="userId" value="${user.userId}">
                            <div class="widget dashboard-container my-adslist">

                                <h2 class="widget-header">Chỉnh sửa tài khoản</h2>
                                <table class="table table-responsive product-dashboard-table">
                                    <tbody>
                                    <div class="col-lg-12">
                                        <h6 class="font-weight-bold pt-4 pb-1">Trạng thái :<a><c:choose>
                                                    <c:when test="${user.activeStatus}">Hoạt động</c:when>    
                                                    <c:otherwise>
                                                        Bị cấm
                                                    </c:otherwise>
                                                </c:choose></a> 
                                                <c:choose>
                                                    <c:when test="${user.activeStatus}">
                                                    <li class="list-inline-item">
                                                        <a href="changeStatusAccount?userId=${user.userId}" onclick="return confirm('Bạn có muốn cấm tài khoản này không?')" class="delete"><i class="fas fa-eraser" title="Cấm"></i></a>
                                                    </li> 
                                                </c:when>    
                                                <c:otherwise>
                                                    <li class="list-inline-item">
                                                        <a href="changeStatusAccount?userId=${user.userId}" onclick="return confirm('Bạn có muốn kích hoạt lại tài khoản này không?')" class="delete"><i class="fas fa-eraser" title="Kích hoạt"></i></a>
                                                    </li> 
                                                </c:otherwise>
                                            </c:choose></h6>
                                        <h6 class="font-weight-bold pt-4 pb-1">Tài khoản : <a>${user.username}</a> </h6>                             
                                        <h6 class="font-weight-bold pt-4 pb-1">Mật khẩu :<a><input type="text" name="password" value="${user.password}"</a></h6>                      
                                        <div class="dnx_content_form_item clearfix">
                                            <div class="dnx_content_form_item_lab">
                                                <h6 class="font-weight-bold pt-2 pb-1">Vai trò:<a><c:choose>
                                                            <c:when test="${user.userType == 1}">Admin</c:when> 
                                                            <c:when test="${user.userType == 2}">Bác sĩ</c:when>    
                                                            <c:otherwise>
                                                                Bệnh nhân
                                                            </c:otherwise>
                                                        </c:choose></a></h6>
                                            </div>                             
                                        </div> 
                                    </div>
                                    </tbody>
                                    <div class="col-md-12 col-lg-12" style="align-items: center; justify-content: center; margin-left: 310px;">
                                        <button  type="submit" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3">Cập nhật</button>
                                    </div>
                                </table>                                                       
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
    <%@include file = "../../common/footer.jsp" %>
</html>

