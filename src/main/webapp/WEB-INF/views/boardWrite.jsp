<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

    $(document).ready(function (){
       $("#insertSubmit").click(function (){
           const title = $("#bTitle").val();
           const telCode = $("#TelName option:selected").val();
           const content = $("#bContent").val();
           if (title == "") {
               alert("제목을 입력해주세요");
               document.boardInsert.bTitle.focus();
               return;
           }
           if (telCode == "") {
               alert("통신사를 선택해주세요");
               document.boardInsert.TelName.focus();
               return;
           }
           if (content == "") {
               alert("내용을 입력해주세요");
               document.boardInsert.bContent.focus();
               return;
           }
           document.boardInsert.submit();
       });
    });




</script>
<div style="margin-top: 150px"></div>
<div class="col-md-12">
    <form name="boardInsert" class="form-horizontal" action="/insertBoard" method="post" >
        <div class="card ">
            <div class="card-header card-header-warning card-header-text">
                <div class="card-text">
                    <h4 class="card-title" style="font-weight: 400">게시글 등록</h4>
                </div>
            </div>
            <div class="card-body ">
                <div class="row">
                    <label class="col-sm-2 col-form-label">제목</label>
                    <div class="col-sm-7">
                        <div class="form-group bmd-form-group">
                            <input class="form-control" id="bTitle" type="text" name="bTitle" required="true" aria-required="true">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">통신사</label>
                        <div class="col-sm-3">
                            <div class="col-lg-5 col-md-6 col-sm-3">
                                <div class="dropdown bootstrap-select">
                                    <select class="selectpicker" name="TelName" id="TelName" data-size="7" data-style="btn btn-info btn-round" title="통신사선택" tabindex="-98">
                                        <!--<option value="" selected>통신사선택</option>-->
                                    <c:forEach items="${selectTelCode}" var="telcode">
                                        <option value="<c:out value="${telcode.TelName}"/>">${telcode.TelName}</option>
                                    </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">내용</label>
                    <div class="col-sm-7">
                        <div class="form-group bmd-form-group">
                            <textarea rows="10" cols="50" id="bContent" class="form-control"  name="bContent" number="true" placeholder="내용을 입력해주세요" required="true" aria-required="true"></textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%--        <button type="submit" value="test" />--%>
    </form>
            <div class="card-footer ml-auto mr-auto">
                <button type="button" id="insertSubmit" class="btn btn-success">등록</button>
                <button type="button" id="indexPage" class="btn btn-outline-secondary" onclick="location.href='indexPage'">목록으로</button>
            </div>
        </div>















