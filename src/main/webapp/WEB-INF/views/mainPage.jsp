<!--
=========================================================
Material Dashboard PRO - v2.1.0
=========================================================

Product Page: https://www.creative-tim.com/product/material-dashboard-pro
Copyright 2019 Creative Tim (https://www.creative-tim.com)

Coded by Creative Tim

=========================================================

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en" class="perfect-scrollbar-off">
<head>
    <title>Hello, world!</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">

</head>
<body>
<div class="wrapper ">

    <tiles:insertAttribute name="sidebar"/>
    <tiles:insertAttribute name="header" />  <!--공통으로 쓸 메인헤더-->
    <tiles:insertAttribute name="body"/>   <!--요청에의해 바뀌는 body부분-->
    <tiles:insertAttribute name="footer"/>


</div>
</body>



</html>
