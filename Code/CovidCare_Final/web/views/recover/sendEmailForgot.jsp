

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <%@include file = "../../common/head.jsp" %>

    <body class="body-wrapper">

        <%@include file = "../../common/nav.jsp" %>

         
<section class="login py-5 border-top-1">
  <div class="container">
      <div class="row justify-content-center">
          <div class="col-lg-5 col-md-8 align-item-center">
              <div class="border">
                  <h3 class="bg-gray p-4">Quên mật khẩu</h3>
                 
                      <fieldset class="p-4">
                                 <c:if test="${not empty message}">
                              <b>${message}</b>
                          </c:if> 
                               <form action="forgotPassword" method="POST">
                          <input type="text" placeholder="Vui lòng nhập tên tài khoản" name="username" class="border p-3 w-100 my-2" value="">                                                                                                                       
                          <button type="submit"
                                  class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3">Kiểm tra</button>                      
                            </form>
                      </fieldset>
                
              </div>
          </div>
      </div>
  </div>
</section>
    </body>

    <!--Footer-->

    <%@include file = "../../common/footer.jsp" %>

</html>