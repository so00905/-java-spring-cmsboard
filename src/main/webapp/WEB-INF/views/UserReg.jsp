<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    $(document).ready(function () {
        $('#insertSubmit').click(function () {
            const id = $("#insert_id").val();
            const name = $("#insert_name").val();
            const pwd = $("#insert_pwd").val();
            const phone = $("#insert_phone").val();
            const telCode = $("#insert_telCode option:selected").val();

            if (id == "") {
                alert("아이디를 입력해주세요");
                return;
            }
            if (name == "") {
                alert("이름을 입력해주세요");
                return;
            }
            if (pwd == "") {
                alert("비밀번호를 입력해주세요");
                return;
            }
            if (phone == "") {
                alert("휴대폰번호를 입력해주세요");
                return;
            }
            //핸드폰번호 정규표현식
            // //굳이 풀이 하자면 [01] <- 01로 시작하고
            // (0|1|6|7|8|9) <- 0 이거나 1이거나....
            // [-] <- - (하이폰)이고
            // (\d{4}|\d{3}) <- \d(숫자로 시작하는 자리수가 {4} 4자리이거나 3자리 이고
            //     [-] < -(하이폰) 이고
            // \d{4} <- 숫자로 시작하는 자릿수가 4자리이여야 한다.
            //출처: https://webprogrammer.tistory.com/1479 [개발자(開發者) a developer]
            if(phone != null){
                const passRule = /^(01[016789])[-](\d{4}|\d{3})[-]\d{4}$/g;
                if(!passRule.test($("input[id='insert_phone']").val())){
                    alert("휴대폰 번호는 000-0000-0000 형식으로 작성해야 합니다.");
                    return;
                }
            }
            if (telCode == "") {
                alert("통신사를 선택해주세요");
                return;
            }

            document.userInsert.submit();
        })
    })
</script>
<div style="margin-top: 150px"></div>
<div class="col-md-12">
    <form  class="form-horizontal" name="userInsert" action="/insertUser" method="post">
        <div class="card ">
            <div class="card-header card-header-warning card-header-text">
                <div class="card-text">
                    <h4 class="card-title" style="font-weight: 400">사용자 등록</h4>
                </div>
            </div>
            <div class="card-body ">
                <div class="row">
                    <label class="col-sm-2 col-form-label">아이디</label>
                    <div class="col-sm-4">
                        <div class="form-group bmd-form-group">
                            <input class="form-control" id="insert_id" type="text" name="cId" required="true" aria-required="true">
                        </div>
                    </div>
                </div>
                <div class="row">
                <label class="col-sm-2 col-form-label">이름</label>
                    <div class="col-sm-4">
                        <div class="form-group bmd-form-group">
                            <input class="form-control" id="insert_name" type="text" name="cName" required="true" aria-required="true">
                        </div>
                    </div>
                </div>
                <div class="row">
                <label class="col-sm-2 col-form-label">비밀번호</label>
                    <div class="col-sm-4">
                        <div class="form-group bmd-form-group">
                            <input class="form-control" id="insert_pwd" type="password" name="cPwd" required="true" aria-required="true">
                        </div>
                    </div>
                </div>
                <div class="row">
                <label class="col-sm-2 col-form-label">휴대폰번호</label>
                    <div class="col-sm-4">
                        <div class="form-group bmd-form-group">
                            <input class="form-control" id="insert_phone" type="text" name="cPhone" required="true" aria-required="true">
                        </div>
                    </div>
                </div>
                <div class="row">
                <label class="col-sm-2 col-form-label">통신사</label>
                    <div class="col-sm-3">
                        <div class="col-lg-5 col-md-6 col-sm-3">
                            <div class="dropdown bootstrap-select">
                                <select class="selectpicker" id="insert_telCode" name="telName" data-size="7" data-style="btn btn-info btn-round" title="통신사선택" tabindex="-98">
                                    <!--<option value="" selected>통신사선택</option>-->
                                    <c:forEach items="${selectTelCode}" var="telcode">
                                        <option value="<c:out value="${telcode.TelName}"/>">${telcode.TelName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <div class="card-footer ml-auto mr-auto">
        <button type="button" id="insertSubmit" class="btn btn-success">등록</button>
        <button type="button" id="indexPage" class="btn btn-outline-secondary" onclick="location.href='userListPage'">목록으로</button>
    </div>
</div>















