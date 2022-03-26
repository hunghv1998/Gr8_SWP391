<%-- 
    Document   : chat
    Created on : Mar 17, 2022, 11:31:42 AM
    Author     : chinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <% request.setAttribute("title", "Hỗ trợ trực tuyến");%>
    <%@include file = "../common/head.jsp" %>

    <body>
        <%@include file = "../common/nav.jsp" %>
        <!--<div class="container mt-5">-->
        <div class="row">
            <div class="col-12 text-center">
            </div>
            <div class="col-md-12">
                <div id="wrap-chat">
                    <div class="card chat-body">
                        <div class="row mod-row-right">
                            <div class="col-md-4 contact dark">
                                <!-- list user -->
                                <div class="list-contact">
                                    <ul class="list-unstyled" id="chatroom">
                                        <c:forEach items="${listOfChatRooms}" var="chatroom">
                                            <li class="media p-2" onclick="window.location.href = '/chat?id=${chatroom.fromId}'">
                                                <img class="mr-3 avatar online" src="../images/uploads/${chatroom.senderPhoto}" alt="${chatroom.senderName}'s profile pic">
                                                <div class="media-body">
                                                    <h6 class="mt-0 mb-1 name-contact">${chatroom.senderName} <span>${chatroom.lastMessageTime}</span></h6>
                                                    <p>${chatroom.lastMessage}</p>

                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <!-- list user -->
                            </div>
                            <div class="col-md-8 col-12 no-pad dark">
                                <div id="chatbox" class="dark">
                                    <div id="message-container">
                                        <!-- drop menu -->
                                        <c:choose>
                                            <c:when test="${not errorMsg eq ''}">
                                                <div class="alert alert-primary">
                                                    ${errorMsg}
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <ul>
                                                    <c:forEach items="${dialog}" var="msg">
                                                        <li>
                                                            <c:choose>
                                                                <c:when test="${user.userId == msg.fromId}">
                                                                    <div class="alert alert-primary me">
                                                                        ${msg.message}
                                                                    </div>
                                                                    <span class="me-date">
                                                                        <c:if test="${msg.readState == 1}">
                                                                            Read -
                                                                        </c:if>
                                                                        sent on: ${msg.messageDate}</span>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                    <div class="alert alert-primary other">
                                                                        ${msg.message}
                                                                    </div>
                                                                    <span class="other-date">sent on: ${msg.messageDate}</span>
                                                                </c:otherwise>
                                                            </c:choose>

                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div id="input-message">
                                        <form action="" method="POST">
                                            <input type="text" class="form-control" id="message_input" name="newMsg" placeholder="Your message">
                                            <button class="btn btn-primary btn-sm" type="submit" name="submit">
                                                <i class="material-icons">
                                                    near_me
                                                </i>
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file = "../common/footer.jsp" %>
    </body>

</html>