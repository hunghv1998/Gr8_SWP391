<%-- 
    Document   : createNews
    Created on : Mar 2, 2022, 4:39:29 PM
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
                <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-1">
                    <!-- Recently Favorited -->
                    <form action="EditAccount" method="POST">
                    <div class="widget dashboard-container my-adslist">
                           
                        <h2 class="widget-header">Edit Acount</h2>
                        <table class="table table-responsive product-dashboard-table">
                         
                                                               
                            <tbody>
                            <div class="col-lg-12">
                                <input type="hidden" name="oldUsername" value ="${username}">
                                <h6 class="font-weight-bold pt-4 pb-1">UserName : <a><input type="text" name="username" value="${username}"</a>  </h6>
                                                                                      
                                <h6 class="font-weight-bold pt-4 pb-1">PassWord :  <a><input type="text" name="password" value="${password}"</a>  </h6>
                               
                                <div class="dnx_content_form_item clearfix">
                                    <div class="dnx_content_form_item_lab">
                                        <h6 class="font-weight-bold pt-2 pb-1">Role</h6>
                                    </div>
                                    <div class="dnx_content_form_item_field">
                                        <select name="role">
                                            <option class="default-selected" value="0" >Select Role</option>
                                            <option class="default-selected" value="1" <c:if test="${role == 1}">selected</c:if>>Admin</option>
                                            <option class="default-selected" value="2" <c:if test="${role == 2}">selected</c:if>>Doctor</option>
                                            <option class="default-selected" value="3" <c:if test="${role == 3}">selected</c:if>>Patient</option>
                                           
                                        </select>
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
    <%@include file = "../common/footer.jsp" %>
</html>

