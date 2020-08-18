<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    function goUserDetail(cNo) {
        // console.log('view');
        location.href='/UserBoardDetail?cNo='+cNo;
    }
</script>

<c:url var="getBoardList" value="mainPage.jsp"></c:url>
<script>
    //키워드검색버튼 눌렀을 때 실행되는 스크립트
    $(document).on('click', '#btnSearch', function(){
        alert(222);
        let url = "${getBoardList}";
        url = url + "?searchType=" + $('#searchType').val();
        url = url + "&keyword=" + $('#keyword').val();
        location.href = url;
        console.log(url);
    });


</script>
<script>
    function selChange() {
        var sel = document.getElementById('cntPerPage').value;
        location.href="indexPage?nowPage=${paging.nowPage}&cntPerPage="+sel;
    }

</script>


<%--<div style="border: black 1px solid;width: 300px;font-weight: bold;float: right;" >--%>
<%--    <p>여기에 값이 나와야 하는데요?</p>--%>
<%--    <p>현재시간 : [ <c:out value="${now}"/>  ]</p> --%>
<%--</div>--%>

<div class="content">
    <div class="card">
        <div class="card-header card-header-text card-header-info" style="font-weight: bolder">
            <div class="card-text" >
                <h4 class="card-title">사용자관리</h4>
                <p class="card-category">ER-SOLUTION</p>
            </div>
        </div>
        <div class="card-body table-responsive">
            <table class="table table-hover">
                <thead class="text-warning"></thead>
                <div class="material-datatables">
                    <div id="datatables_wrapper" class="dataTables_wrapper dt-bootstrap4">
                        <div class="col-sm-12">
                            <div class="dataTables_length" id="datatables_length">
                                <div class="search_text">
                                    <span>총 <em><c:out value="${paging.total}"/></em>건의 게시물이 있습니다.</span>
                                </div>
                                <div class="row" >
                                    <div class="col-sm-3">
                                        <div class="dropdown">
                                            <button class="dropdown-toggle btn btn-outline-warning btn-round btn-block" type="button" id="multiDropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                통신사선택
                                                <div class="ripple-container"></div></button>
                                            <div class="dropdown-menu" aria-labelledby="multiDropdownMenu" x-placement="bottom-start" style="position: absolute; top: 41px; left: 1px; will-change: top, left;">
                                                <c:forEach items="${selectTelCode}" var="telcode">
                                                    <a class="dropdown-item" href="#"><c:out value="${telcode.TelName}"/></a>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="dropdown">
                                            <button class="dropdown-toggle btn btn-outline-warning btn-round btn-block" type="button" id="multiDropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                검색옵션
                                                <div class="ripple-container"></div></button>
                                                <div class="dropdown-menu" name="searchType" id="searchType" aria-labelledby="multiDropdownMenu" x-placement="bottom-start" style="position: absolute; top: 41px; left: 1px; will-change: top, left;">
                                                    <option value="title" class="dropdown-item" <c:out value="${paging.searchType=='id'?'selected':''}"/>>아이디</option>
                                                    <option value="content" class="dropdown-item" <c:out value="${paging.searchType=='name'?'selected':''}"/>>이름</option>
                                                    <option value="content" class="dropdown-item" <c:out value="${paging.searchType=='phone'?'selected':''}"/>>휴대폰번호</option>
                                                </div>
                                        </div>
                                    </div>
                                    <div id="datatables_filter" class="dataTables_filter">
                                        <label>
                                                <span class="bmd-form-group bmd-form-group-sm">
                                                    <input type="text" name="keyword" id="keyword" value="${paging.keyword}" class="form-control form-control-lg" aria-controls="datatables">
                                                    <button class="btn btn-outline-info" type="button" id="btnSearch">
                                                        <i class="fa fa-search" aria-hidden="true"></i> 검색
                                                    </button>
                                                </span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <table id="datatables" class="table table-striped table-no-bordered table-hover dataTable dtr-inline" cellspacing="0" width="100%" style="width: 100%;font-weight: bolder;text-align: center;" role="grid" aria-describedby="datatables_info">
                                <thead>
                                <tr role="row" style="font-weight: bold">
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 60px;" >번호
                                    </th>
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 60px;" >아이디
                                    </th>
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 119px;">이름
                                    </th>
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 42px;">통신사
                                    </th>
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 102px;">휴대폰번호
                                    </th>
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 102px;">가입일자
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:choose>
                                    <c:when test="${fn:length(UserBoard) > 0}">
                                        <c:forEach items="${UserBoard}" var="User">
                                            <tr role="row" class="odd" onclick="goUserDetail(${User.cNo})">
                                                <th scope="row">${User.cNo}</th>
                                                <td><c:out value="${User.cId}"/></td>
                                                <td><c:out value="${User.cName}"/></td>
                                                <td><c:out value="${User.telCode}"/></td>
                                                <td><c:out value="${User.cPhone}"/></td>
                                                <td><fmt:formatDate value="${User.cDate}" dateStyle="default"/></td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="5">조회된 결과가 없습니다.</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                                </tbody>

                            </table>
                            <a href="/boardWrite" role="button" class="btn btn-success" style="margin-left: 85%">글쓰기</a>
                        </div>


                        <div class="row" style="margin: auto;">
                            <div class="col-sm-12 col-md-7">
                                <div class="dataTables_paginate paging_full_numbers" id="datatables_paginate">
                                    <ul class="pagination">
                                        <c:if test="${paging.startPage != 1 }">
                                            <a class="paginate_button page-item" href="userListPage?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
                                        </c:if>
                                        <c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
                                            <c:choose>
                                                <c:when test="${p == paging.nowPage }">
                                                    <b>${p }</b>
                                                </c:when>
                                                <c:when test="${p != paging.nowPage }">
                                                    <li class="paginate_button page-item active">
                                                        <a href="userListPage?nowPage=${p }&cntPerPage=${paging.cntPerPage}" aria-controls="datatables" data-dt-idx="2" tabindex="0" class="page-link">${p }</a>
                                                    </li>
                                                </c:when>
                                             </c:choose>
                                        </c:forEach>

                                        <c:if test="${paging.endPage != paging.lastPage}">
                                            <a class="paginate_button page-item" href="userListPage?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </div>


                    </div>

            </table>
        </div>

