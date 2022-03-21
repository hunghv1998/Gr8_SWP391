<%-- 
    Document   : addPostVaccinate
    Created on : Mar 22, 2022, 1:04:53 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="addPostVaccinate" method="post">
            Chọn loại Vaccine:
            <select name="vacc_id">
                <c:forEach items="${listVaccine}" var='v'>
                    <option value="${v.vaccId}">${v.vaccName}</option>
                </c:forEach>
            </select><br>
            Ngày bắt đầu tiêm:    
            <input type="date" name="start_date"><br>
            Ngày kết thúc tiêm:
            <input type="date" name="expired_date"><br>
            Địa điểm cụ thể:
            <input type="text" name="place"> <br>
            Ghi chú: 
            <textarea name="note"></textarea><br>
            Số lượng mũi tiêm sẵn có:
            <input type="number" name="amount"><br>
            <input type="submit" value="Post">
        </form>


    </body>
</html>
