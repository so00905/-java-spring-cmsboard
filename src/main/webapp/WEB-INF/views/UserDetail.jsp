<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(document).ready(function (){

        //글수정
        $("#btnUpdate").click(function (){
            const id = $("#cId").val();
            const name = $("#cName").val();
            const password = $("#cPwd").val();
            const phone = $("#cPhone").val();
            const telCode = $("#telName option:selected").val();


            if(id == ""){
                alert("아이디를 입력해주세요");
                document.UserDetailForm.cId.focus();
                return;
            }
            if(name == ""){
                alert("이름을 입력해주세요");
                document.UserDetailForm.cName.focus();
                return;
            }
            if(password == ""){
                alert("비밀번호를 입력해주세요");
                document.UserDetailForm.cPwd.focus();
                return;
            }
            if(phone == ""){
                alert("핸드폰번호를 입력해주세요");
                document.UserDetailForm.cPhone.focus();
                return;
            }
            if(telCode == ""){
                alert("통신사를 선택해주세요");
                document.UserDetailForm.telName.focus();
                return;
            }

            document.UserDetailForm.action="/UserUpdate"
            document.UserDetailForm.submit();
        });

        //글삭제
        $("#btnDelete").click(function (){
           if(confirm("확인을 누르면 진짜 삭제됩니다...")){
               document.UserDetailForm.action = "/UserDelete"
               document.UserDetailForm.submit();

           }
        });
    });
</script>

<div style="margin-top: 150px"></div>
<div class="col-md-12">

    <form id="TypeValidation" name="UserDetailForm" class="form-horizontal" action="" method="post" novalidate="novalidate">
        <div class="card ">
            <div class="card-header card-header-warning card-header-text">
                <div class="card-text">
                    <h4 class="card-title" style="font-weight: 400">사용자 상세보기</h4>
                </div>
            </div>
            <div class="card-body ">
                <div class="row">
                    <label class="col-sm-2 col-form-label">아이디</label>
                    <div class="col-sm-7">
                        <div class="form-group bmd-form-group">
                            <input class="label-danger" type="text" name="cId" id="cId" required="true" aria-required="true" value="${UserDetail.cId}">

                        </div>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">이름</label>
                    <div class="col-sm-7">
                        <div class="form-group bmd-form-group">
                            <input type="text" id="cName" name="cName" value="${UserDetail.cName}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">비밀번호</label>
                    <div class="col-sm-7">
                        <div class="form-group bmd-form-group">
                            <input type="password" id="cPwd" name="cPwd" value="${UserDetail.cPwd}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">휴대폰번호</label>
                    <div class="col-sm-7">
                        <div class="form-group bmd-form-group">
                            <input type="text" id="cPhone" name="cPhone" value="${UserDetail.cPhone}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">통신사</label>
                    <div class="dropdown bootstrap-select">
                        <select class="selectpicker" name="TelName" id="TelName" data-size="7" data-style="btn btn-info btn-round" title="현재통신사 :${UserDetail.telName}" tabindex="-98">
                            <c:forEach items="${selectTelCode}" var="telCode">
                                <option value="<c:out value="${telCode.TelName}"/>">${telCode.TelName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="card-footer ml-auto mr-auto">
                <input type="hidden" name="cNo" value="${cNo}">
                <button type="button" class="btn btn-success" id="btnUpdate">수정하기</button>
                <button type="button" class="btn btn-outline-danger" id="btnDelete">삭제하기</button>
            </div>
            <div class="btnArea tr" style="margin: auto;">
                <button type="button" id="userListPage" class="btn btn-outline-secondary" onclick="location.href='userListPage'">목록으로</button>
            </div>
        </div>
    </form>
</div>
