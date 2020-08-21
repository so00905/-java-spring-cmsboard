<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!-- 잠깐만-->
<%--form태그의 action값이 없다는 것이 포인트이다. postback으로 구현되어 있다.--%>
<%--이때 입력받은 아이디와 비밀번호는 UserDetailService와 PasswordEncoder가 처리하도록 정해져있다.--%>
<%--순서--%>
<%--1. DB에서 아이디와 패스워드로 사용자정보를 조회한다.--%>
<%--2. 입력받은 비밀번호를 인코딩한다.--%>
<%--3. 인코딩한 비밀번호와 사용자정보의 비밀번호를 교환한다.--%>


<div class="wrapper wrapper-full-page" style="background-color: cadetblue;">
    <div class="page-header login-page header-filter" filter-color="#01b9ff" >
        <!--   you can change the color of the filter page using: data-color="blue | purple | green | orange | red | rose " -->
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-8 ml-auto mr-auto">
                    <form name="f" id="formLogin" class="form" method="POST" action="authenticate">
                        <div class="card card-login">
                            <div class="card-body ">
                                <p class="card-description text-center" style="color: black;">MASTER LOGIN</p>
                                <span class="bmd-form-group">
                                <div class="input-group">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text">
                                      <i class="material-icons">face</i>
                                    </span>
                                      <div>
                                      </div>
                                  </div>
                                  <input type="text" class="form-control" placeholder="아이디를 입력해주세요" id="username" name="loginID" value="${loginID}">
                                </div>


                               </span>
                                <span class="bmd-form-group">
                                    <div class="input-group">
                                      <div class="input-group-prepend">
                                        <span class="input-group-text">
                                          <i class="material-icons">lock_outline</i>
                                        </span>
                                      </div>
                                      <input type="password" class="form-control" placeholder="암호를 입력해주세요"  id="password" name="loginPwd" value="${loginPwd}">
                                    </div>
                                </span>
                            <div class="card-footer justify-content-center">
                                    <button type="submit" name="submit" class="btn btn-rose btn-link btn-lg" onclick="goLogin()">LOGIN</button>
                            </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </div>

                            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                <font color="red">
                                    <div style="font-weight: bold; maxgin:5%;">
                                        로그인에 실패했습니다. <br />
                                          실패이유 :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                                    </div>
                                    <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
                                </font>
                            </c:if>


                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<!--   Core JS File  f-->
<script src="${pageContext.request.contextPath}assets/js/core/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}assets/js/core/popper.min.js"></script>
<script src="${pageContext.request.contextPath}assets/js/core/bootstrap-material-design.min.js"></script>
<script src="${pageContext.request.contextPath}assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!-- Chartist JS -->
<script src="${pageContext.request.contextPath}assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="${pageContext.request.contextPath}assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
<script src="${pageContext.request.contextPath}assets/js/material-dashboard.js?v=2.1.0" type="text/javascript"></script>
<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="${pageContext.request.contextPath}assets/demo/demo.js"></script>
<script>
    $(document).ready(function() {
        md.checkFullPageBackgroundImage();
        setTimeout(function() {
            // after 1000 ms we add the class animated to the login/register card
            $('.card').removeClass('card-hidden');
        }, 700);
    });
</script>
