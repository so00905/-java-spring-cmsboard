<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<%--<div style="border: black 1px solid;width: 300px;font-weight: bold;float: right;" >--%>
<%--    <p>여기에 값이 나와야 하는데요?</p>--%>
<%--    <p>현재시간 : [ <c:out value="${now}"/>  ]</p> --%>
<%--</div>--%>

<script>

    function goBoardDetail(bNo) {
    // console.log('view');
    location.href='/boardDetail?bNo='+bNo;
}
</script>
<script>
$(document).ready(function() {

        //logout
        function selChange() {
            const sel = document.getElementById('cntPerPage').value;
            location.href="indexPage?nowPage=${paging.nowPage}&cntPerPage="+sel;
        }

    });


            //selectBox값 input hidden에 담아서 selected유지하기
            $('#SearchTelCode,#selectType').change(selectChange);

            function selectChange(){
            const selectTel = $('#SearchTelCode option:selected').val();
            const selectType = $('#selectType option:selected').val();
            $('input#selectTel_hid').val(selectTel);
            $('input#selectType_hid').val(selectType);

        }

        //button click시 url주소
        $(document).on('click','#btnSearch',function (e){
            e.preventDefault();
            let url = "${pageContext.request.contextPath}/indexPage";
            url = url + "?selectTel=" + $('#SearchTelCode').val();
            url = url + "&selectType=" + $('#selectType').val();
            url = url + "&keyword=" + $('#keyword').val();

            location.href = url;
            console.log(url);


        });

</script>


<div class="content">
    <div class="card">
        <div class="card-header card-header-text card-header-warning" style="font-weight: bolder">
            <div class="card-text" >
                <h4 class="card-title">게시판관리</h4>
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
                                    <form name="searchForm" action="">
                                    <div class="col-sm-3">
                                        <div class="dropdown">
                                                <div class="ripple-container"></div>
                                            <select class="selectpicker" id="SearchTelCode"  name="selectTel" data-size="7" data-style="btn btn-outline-warning btn-round"  tabindex="-98">
                                                <option value="" >통신사선택</option>
                                                <c:forEach items="${selectTelCode}" var="telcode">
                                                    <option value="${telcode.TelName}" ${paging.selectTel==telcode.TelName?"selected":""}>${telcode.TelName}</option>
                                                </c:forEach>
<%--                                                <option value="SKT"<c:out value="${paging.searchType=='SKT'?'selected':''}"/>>SKT</option>--%>
<%--                                                <option value="KT"<c:out value="${paging.searchType=='KT'?'selected':''}"/>>KT</option>--%>
<%--                                                <option value="LGT"<c:out value="${paging.searchType=='LGT'?'selected':''}"/>>LGT</option>--%>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="dropdown">
                                                <select class="selectpicker" id="selectType"   name="selectType" data-size="7" data-style="btn btn-outline-warning btn-round" tabindex="-98">
                                                    <option value="" selected>검색옵션</option>
                                                    <option value="title" ${paging.selectType=='title'?'selected':''}>제목</option>
                                                    <option value="content" ${paging.selectType=='content'?'selected':''}>내용</option>
                                                </select>
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
                                        <p>
                                            <input type="hidden" id="selectType_hid" name="selectType" value="${paging.selectType}">
                                            <input type="hidden" id="selectTel_hid" name="selectTel" value="${paging.selectTel}">
                                        </p>


                                    </form>
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
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 60px;" >통신사
                                    </th>
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 119px;">제목
                                    </th>
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 42px;">조회수
                                    </th>
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 102px;">등록자
                                    </th>
                                    <th class="" tabindex="0" aria-controls="datatables" rowspan="1" colspan="1" style="width: 102px;">등록일
                                    </th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:choose>
                                    <c:when test="${fn:length(board) > 0}">
                                        <c:forEach items="${board}" var="list">
                                            <tr role="row" class="odd" onclick="goBoardDetail(${list.bNo})">
                                                <th scope="row">${list.bNo}</th>
                                                <td><c:out value="${list.telCode}"/></td>
                                                <td><c:out value="${list.bTitle}"/></td>
                                                <td><c:out value="${list.bHit}"/></td>
                                                <td><c:out value="${list.mNo}"/></td>
                                                <td><fmt:formatDate value="${list.bDate}" dateStyle="default"/></td>
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
                                            <a class="paginate_button page-item" href="indexPage?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&selectTel=${paging.selectTel}&selectType=${paging.selectType}&keyword=${paging.keyword}">&lt;</a>
                                        </c:if>
                                        <c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
                                            <c:choose>
                                                <c:when test="${p == paging.nowPage }">
                                                    <b>${p }</b>
                                                </c:when>
                                                <c:when test="${p != paging.nowPage }">
                                                    <li class="paginate_button page-item active">
                                                        <a href="indexPage?nowPage=${p }&cntPerPage=${paging.cntPerPage}&selectTel=${paging.selectTel}&selectType=${paging.selectType}&keyword=${paging.keyword}"
                                                           aria-controls="datatables" data-dt-idx="2" tabindex="0" class="page-link">${p }
                                                        </a>
                                                    </li>
                                                </c:when>
                                             </c:choose>
                                        </c:forEach>

                                        <c:if test="${paging.endPage != paging.lastPage}">
                                            <a class="paginate_button page-item" href="?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&selectTel=${paging.selectTel}&selectType=${paging.selectType}&keyword=${paging.keyword}">&gt;</a>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </table>

