<%-- 
    Document   : questionForgot
    Created on : Mar 20, 2022, 2:51:14 PM
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
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
                               <form action="verify" method="Get">
                          <input type="hidden" name="userId" class="border p-3 w-100 my-2" value="${userId}">
                          <select name="question_id">
                              <c:forEach items="${listQuestion}" var='q'>
                                  <option value="${q.id}">${q.content}</option>
                              </c:forEach>
                          </select>
                          <input type="text" placeholder="Vui lòng nhập câu trả lời của bạn" name="answer" class="border p-3 w-100 my-2">
                          <button type="submit"
                                  class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3">Tạo mật khẩu mới</button>                      
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
