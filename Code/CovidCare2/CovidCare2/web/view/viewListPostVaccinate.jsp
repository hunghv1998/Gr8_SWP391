<%-- 
    Document   : viewListPostVaccinate
    Created on : Mar 20, 2022, 10:49:05 PM
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
        Chon loai Vaccin: <select name="vaccin_id">
            <c:forEach items="${listVaccin}" var='v'>
                <option value="${v.Id}">${v.vaccName}</option>
            </c:forEach>
        Ngày bắt đầu: 
        Ngày kết thúc:
        Bệnh viên:
        Địa điểm tiêm:
        Loại Vaccin:
        Tổng số lượng vaccin:
        Số lượng vaccin da duoc dang ki:
        Số lượng vaccin con lại:
        
        
                
        </select>
        
        
    </body>
</html>
