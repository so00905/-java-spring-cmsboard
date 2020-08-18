<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div style="margin-top: 150px"></div>
<div class="col-md-12">
    <form id="TypeValidation" class="form-horizontal" action="" method="" novalidate="novalidate">
        <div class="card ">
            <div class="card-header card-header-warning card-header-text">
                <div class="card-text">
                    <h4 class="card-title" style="font-weight: 400">글 상세보기</h4>
                </div>
            </div>
            <div class="card-body ">
                <div class="row">
                    <label class="col-sm-2 col-form-label">제목</label>
                    <div class="col-sm-7">
                        <div class="form-group bmd-form-group">
                            <input class="label-danger" type="text" name="required" required="true" aria-required="true" value="${boardDetail.bTitle}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">통신사</label>
                    <div class="col-sm-3">
                        <div class="label-info">
                            <input class="label-danger" type="text" name="required" required="true" aria-required="true" value="${boardDetail.telNameDetail}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-2 col-form-label">내용</label>
                    <div class="col-sm-7">
                        <div class="form-group bmd-form-group">
                            <input type="text" value="${boardDetail.bContent}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-footer ml-auto mr-auto">
                <button type="submit" class="btn btn-success">등록</button>
            </div>
            <div class="btnArea tr" style="margin: auto;">
                <button type="button" id="indexPage" class="btn btn-outline-secondary" onclick="location.href='indexPage'">목록으로</button>
            </div>
        </div>
    </form>
</div>
