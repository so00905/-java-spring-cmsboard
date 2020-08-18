<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<body class="">
<div class="wrapper ">
    <div class="sidebar" data-color="rose" background-color="black" data-image="${pageContext.request.contextPath}assets/img/sidebar-1.jpg">
        <!--
          Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

          Tip 2: you can also add an image using data-image tag
      -->
        <div class="logo">
            <a href="http://www.creative-tim.com" class="simple-text logo-mini">
                ER
            </a>
            <a href="http://www.creative-tim.com" class="simple-text logo-normal">
                yeom so
            </a>
        </div>
        <div class="sidebar-wrapper">
            <div class="user">
                <div class="user-info" style="margin-left: 50px;">
                      <span>
                          <c:if test="${pageContext.request.userPrincipal.name != null}">
                          <label type="button" class="btn btn-outline-warning">
                             <a href="javascript:document.getElementById('logout').submit()" style="font-weight: bold;">로그아웃</a>
                          </label>
                          </c:if>
                          <form id="logout" action="<c:url value="/logout"/>" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                          </form>
                      </span>
                    </a>
                </div>
            </div>
            <ul class="nav">
                <li class="nav-item ">
                    <a class="nav-link" href="indexPage">
                        <i class="material-icons">dashboard</i>
                        <p style="font-weight: bold"> 게시판 관리 </p>
                    </a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="userListPage">
                        <i class="material-icons">dashboard</i>
                        <p style="font-weight: bold"> 사용자 관리 </p>
                    </a>
                </li>

            </ul>
        </div>
        <div class="sidebar-background" style="background-image: url(${pageContext.request.contextPath}assets/img/sidebar-1.jpg) ">

        </div>
    </div>
    <div class="main-panel">