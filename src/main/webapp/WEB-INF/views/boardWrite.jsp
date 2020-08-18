<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div style="margin-top: 150px"></div>
<div class="col-md-12">
    <form name="boardInsert" class="form-horizontal" action="insertBoard" method="post">
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
                            <input class="form-control" id="insert_title" type="text" name="required" required="true" aria-required="true">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">통신사</label>
                        <div class="col-sm-3">
                            <div class="col-lg-5 col-md-6 col-sm-3">
                                <div class="dropdown bootstrap-select">
                                    <select class="selectpicker" id="insert_telCode" data-size="7" data-style="btn btn-info btn-round" title="통신사선택" tabindex="-98">
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
                            <textarea rows="10" cols="50" id="insert_content" class="form-control"  name="number" number="true" placeholder="내용을 입력해주세요" required="true" aria-required="true"></textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
            <div class="card-footer ml-auto mr-auto">
                <button type="button" id="insertSubmit" class="btn btn-success">등록</button>
                <button type="button" id="indexPage" class="btn btn-outline-secondary" onclick="location.href='indexPage'">목록으로</button>
            </div>
        </div>















