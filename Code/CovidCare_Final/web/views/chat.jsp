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
                                    <ul class="list-unstyled">
                                        <li class="media p-2">
                                            <img class="mr-3 avatar online" src="img/1.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Yan <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet, in gravida</p>

                                            </div>
                                        </li>
                                        <li class="media contact-active p-2">
                                            <img class="mr-3 avatar online" src="img/2.jpg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Linda <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero, in gravida</p>
                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/3.png" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact ">Jamal <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero, in gravida</p>
                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar online" src="img/4.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Cristian <span>12/7/18 8:58 AM</span></h6>
                                                <p>Sit amet nibh libero, in gravida</p>

                                            </div>
                                        </li>
                                        <li class="media p-2 ">
                                            <img class="mr-3 avatar online" src="img/5.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Jack <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero, in gravida</p>
                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/6.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Angelica <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet, in gravida</p>
                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/7.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Marcia <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero,</p>

                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/7.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Marcia <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero,</p>

                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/7.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Marcia <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero,</p>

                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/7.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Marcia <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero,</p>

                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/7.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Marcia <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero,</p>

                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/7.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Marcia <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero,</p>

                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/7.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Marcia <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero,</p>

                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/7.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Marcia <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero,</p>

                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/7.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Marcia <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero,</p>

                                            </div>
                                        </li>
                                        <li class="media p-2">
                                            <img class="mr-3 avatar offline" src="img/7.jpeg" alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="mt-0 mb-1 name-contact">Marcia <span>12/7/18 8:58 AM</span></h6>
                                                <p>Cras sit amet nibh libero,</p>

                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <!-- list user -->
                            </div>
                            <div class="col-md-8 col-12 no-pad dark">
                                <div id="chatbox" class="dark">
                                    <div id="message-container">
                                        <!-- Drop menu -->
                                        <div  id="drop-menu" class="card"> 
                                            <div class="card-body text-right">
                                                <ul>
                                                    <li id="ligth">
                                                        Light  <span  class="badge badge-ligth">D</span>
                                                    </li>
                                                    <li id="dark">
                                                        Dark  <span  class="badge badge-dark">D</span>
                                                    </li>
                                                    <li id="hot">
                                                        Heat <span  class="badge badge-hot">D</span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <!-- drop menu -->
                                        <ul>
                                            <li>
                                                <div class="alert alert-primary me">
                                                    hello
                                                </div>
                                                <span class="me-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                            <li>
                                                <img class="mr-3 avatar other-img" src="img/2.jpg" alt="Generic placeholder image">
                                                <div class="alert alert-primary other">
                                                    hey there
                                                </div>
                                                <span class="other-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                            <li>
                                                <div class="alert alert-primary me">
                                                    great are you ok
                                                </div>
                                                <span class="me-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                            <li>
                                                <img class="mr-3 avatar other-img" src="img/2.jpg" alt="Generic placeholder image">
                                                <div class="alert alert-primary other">
                                                    way!!!
                                                </div>
                                                <span class="other-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                            <li>
                                                <img class="mr-3 avatar other-img" src="img/2.jpg" alt="Generic placeholder image">
                                                <div class="alert alert-primary other">
                                                    Great is on this Quidem adipisci, aperiam eaque quia
                                                </div>
                                                <span class="other-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                            <li>
                                                <img class="mr-3 avatar other-img" src="img/2.jpg" alt="Generic placeholder image">
                                                <div class="alert alert-primary other">
                                                    Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                                                </div>
                                                <span class="other-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                            <li>
                                                <div class="alert alert-primary me">
                                                    amet consectetur, adipisicing elit.
                                                </div>
                                                <span class="me-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                            <li>
                                                <div class="alert alert-primary me">
                                                    Lorem ipsum dolor sit amet consectetur, adipisicing elit.
                                                </div>
                                                <span class="me-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                            <li>
                                                <div class="alert alert-primary me">
                                                    great are you ok
                                                </div>
                                                <span class="me-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                            <li>
                                                <div class="alert alert-primary me">
                                                    great are you ok amet consectetur, adipisicing elit.
                                                </div>
                                                <span class="me-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                            <li>
                                                <img class="mr-3 avatar other-img" src="img/2.jpg" alt="Generic placeholder image">
                                                <div class="alert alert-primary other">
                                                    Lorem ipsum dolor sit ?
                                                </div>
                                                <span class="other-date">sent on: 9/27/18 10:52 AM</span>
                                            </li>
                                        </ul>
                                    </div>
                                    <div id="input-message">
                                        <input type="text" class="form-control" placeholder="Your message">
                                        <button class="btn btn-primary btn-sm" type="submit">
                                            <i class="material-icons">
                                                near_me
                                            </i>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--col-md-12-->
        </div>
        <!--</div>-->
        <div>
            <h1>Chat application</h1>
            <input id="username_input" placeholder="Your username">
            <div id="output"></div>
            <input id="message_input" type="text">
            <button onclick="send()">Send message</button>
            <script src="js/websocket.js"></script>
        </div>

        <script src="js/jQuery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <script src="js/chat.js"></script>
        <%@include file = "../common/footer.jsp" %>
    </body>

</html>