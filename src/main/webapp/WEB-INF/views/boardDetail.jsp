<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(document).ready(function (){

        //글수정
        $("#btnUpdate").click(function (){
            const title = $("#bTitle").val();
            const telCode = $("#TelName option:selected").val();
            const content = $("#bContent").val();

            if(title == ""){
                alert("제목을 입력해주세요");
                document.detailForm.bTitle.focus();
            }
            if(telCode == ""){
                alert("통신사를 선택해주세요");
                document.detailForm.TelName.focus();
            }
            if(content == ""){
                alert("내용을 입력해주세요");
                document.detailForm.bContent.focus();
            }

            document.detailForm.action="/boardUpdate"
            document.detailForm.submit();
        });

        //글삭제
        $("#btnDelete").click(function (){
           if(confirm("확인을 누르면 진짜 삭제됩니다...")){
               document.detailForm.action = "/boardDelete"
               document.detailForm.submit();

           }
        });
    });
</script>

<div style="margin-top: 150px"></div>
<div class="col-md-12">
    <form id="TypeValidation" name="detailForm" class="form-horizontal" action="" method="post" novalidate="novalidate">
        <div class="card ">
            <div class="card-header card-header-warning card-header-text">
                <div class="card-text">
                    <h4 class="card-title" style="font-weight: 400">글 상세보기</h4>
                </div>
            </div>
            <div class="card-body ">
                <p>조회수 : ${boardDetail.bHit}</p>
                <p>작성일 : <fmt:formatDate value="${boardDetail.bDate}" dateStyle="default"/></p>
                <div class="row">

                    <label class="col-sm-2 col-form-label">제목</label>
                    <div class="col-sm-7">
                        <div class="form-group bmd-form-group">
                            <input class="label-danger" type="text" name="bTitle" id="bTitle" required="true" aria-required="true" value="${boardDetail.bTitle}">

                        </div>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">통신사</label>
                    <div class="dropdown bootstrap-select">
                        <select class="selectpicker" name="TelName" id="TelName" data-size="7" data-style="btn btn-info btn-round" title="현재통신사 : ${boardDetail.telNameDetail}" tabindex="-98">
                            <!--<option value="" selected>통신사선택</option>-->
                            <%--${boardDetail.telNameDetail}--%>
                            <c:forEach items="${selectTelCode}" var="telcode">
                                <option value="<c:out value="${telcode.TelName}"/>">${telcode.TelName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">내용</label>
                    <div class="col-sm-7">
                        <div class="form-group bmd-form-group">
                            <input type="text" id="bContent" name="bContent" value="${boardDetail.bContent}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-footer ml-auto mr-auto">
                <input type="hidden" name="bNo" value="${bNo}">
                <button type="button" class="btn btn-success" id="btnUpdate">수정하기</button>
                <button type="button" class="btn btn-outline-danger" id="btnDelete">삭제하기</button>

            </div>
            <div class="btnArea tr" style="margin: auto;">
                <button type="button" id="indexPage" class="btn btn-outline-secondary" onclick="location.href='indexPage'">목록으로</button>
            </div>
        </div>
    </form>
</div>
