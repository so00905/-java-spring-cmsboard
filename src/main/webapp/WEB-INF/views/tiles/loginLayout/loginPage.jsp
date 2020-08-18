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


<!DOCTYPE html>
<html lang="en" class="perfect-scrollbar-off">
<head>
    <title>Hello, world!</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- Material Kit CSS -->
    <link href="${pageContext.request.contextPath}assets/css/material-dashboard.css" rel="stylesheet">

    <script type="text/javascript">
        function goLogin(){
            if($("#username").val() == ""){
                alert("아이디를 입력해주세요");
                return;
                $("#username").focus();
            }else if($("#password").val() == ""){
                alert("암호를 입력해주세요");
                return;
                $("#password").focus();
            }
            $("#formLogin").submit();
        }
    </script>


</head>
<body>
<div class="wrapper ">
    <tiles:insertAttribute name="header" />  <!--공통으로 쓸 메인헤더-->
    <tiles:insertAttribute name="body"/>   <!--요청에의해 바뀌는 body부분-->
    <tiles:insertAttribute name="footer"/>

</div>
</body>



</html>
