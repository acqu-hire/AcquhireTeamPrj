<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${empty sessionScope.id}">
	<script type="text/javascript">
		location.href = "<c:url value='/login/login'/>"
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판</title>
</head>
<body>

	<!-- Header -->

<%@ include file="../../include/header.jsp"%>

	<!-- Header -->

	<!-- Board -->

<section>
  <div class="container-fluid">
	<div class="row justify-content-center">
	  <div class="col-8">
		<div class="card">
		  <div class="card-header">
			<h3 align="center">QnA</h3>
			<div align="right">
				전체 글 : <strong>${ph.boardListCount}</strong>
			</div>
		  </div>
		  <div class="card-body">
			<div id="BtnCategory" class="category" align="center">
			  <a class="btn btn-primary float-end" 
			  href="<c:url value='./list'/>?category=&keyfield=${ph.sc.keyfield}&keyword=${ph.sc.keyword}">전체</a>								
			  <a class="btn btn-warning float-end" 
			  href="<c:url value='./list'/>?&category=QNA_TECH&keyfield=${ph.sc.keyfield}&keyword=${ph.sc.keyword}">기술</a>
			  <a class="btn btn-warning float-end" 
			  href="<c:url value='./list'/>?&category=QNA_CAREER&keyfield=${ph.sc.keyfield}&keyword=${ph.sc.keyword}">커리어</a>
			  <a class="btn btn-warning float-end" 
			  href="<c:url value='./list'/>?&category=QNA_ETC&keyfield=${ph.sc.keyfield}&keyword=${ph.sc.keyword}">기타</a>
			</div>
			<div class="d-flex justify-content-end">
			  <a class="btn btn-warning float-end" href="<c:url value='./write'/>${ph.sc.getQueryString(ph.sc.page, ph.sc.category)}">
			 	 <i class="fas fa-edit"></i> 글 작성
			  </a>
			</div>
			<table class="table table-hover table-striped text-center" id="QnaBoardList" style="table-layout: fixed">
			  <thead class="thead-dark">
				<tr>
				  <th width="4%">번호</th>
				  <th width="7%">카테고리</th>
				  <th width="20%">제목</th>
				  <th width="5%">작성자</th>
				  <th width="10%">작성일</th>
				  <th width="4%">조회수</th>
				</tr>
			  </thead>
			  <tbody>
				<c:forEach varStatus="status" var="board" items="${boardList}">
				<tr>
				  <th>${(ph.boardListCount-status.index)-((ph.sc.page-1)*10)}</th>
				  <td>${board.category}</td>
				  <c:choose>
				    <c:when test="${fn:length(board.title)>15}">
				      <td title="${board.title}">
				        <a href="./listDetail${ph.sc.getQueryString(ph.sc.page, ph.sc.category)}&bno=${board.bno}">
				          <c:out value="${fn:substring(board.title,0,14)}"/>...</a> 
				          <span class="replyCnt" style="color: red;">${board.replyCnt > 0? [board.replyCnt] : ""}</span>
				      </td>
				    </c:when>
				    <c:otherwise>
				      <td title="${board.title}">
				        <a href="./listDetail${ph.sc.getQueryString(ph.sc.page, ph.sc.category)}&bno=${board.bno}">
				         <c:out value="${board.title}"/></a> 
				         <span class="replyCnt" style="color: red;">${board.replyCnt > 0? [board.replyCnt] : ""}</span>
				      </td>
				    </c:otherwise>
				  </c:choose>
				  <td>${board.id}</td>
				  <td>${board.writeDay}</td>
				  <td>${board.readCount}<input type="hidden" name="bno" value="${board.bno}"></td>
				</tr>
				</c:forEach>
			  </tbody>
			</table>
			<table class="table table-hover text-center">
			  <c:if test="${ph.boardListCount==0}">
			  <tr>
				<td>등록된 게시글이 없습니다.</td>
			  </tr>
			  </c:if>
			</table>
		  </div>

	<!-- Pagination -->
		  <nav>
			<ul class="pagination justify-content-center">

	<!-- Previous Button -->
			<c:choose>
			  <c:when test="${ph.startPage <= 1}">
				<li class="page-item disabled">
				  <a class="page-link" href="#" aria-label="Previous-PageBlock"> 
				    <span aria-hidden="true">&laquo;</span> 
					<span class="sr-only">페이지 이전블럭 이동</span>
				  </a>
				</li>
			  </c:when>
			  <c:otherwise>
				<li class="page-item">
				  <a class="page-link" href="./list${ph.sc.getQueryString(ph.startPage-1, ph.sc.category)}" 
				  	 aria-label="Previous-PageBlock"> 
				    <span aria-hidden="true">&laquo;</span> 
				    <span class="sr-only">페이지 이전블럭 이동</span>
				  </a>
				</li>
			  </c:otherwise>
			</c:choose>
			<c:choose>
			  <c:when test="${ph.sc.page <= 1}">
				<li class="page-item disabled">
				  <a class="page-link" href="#" aria-label="Previous-Page"> 
					<span aria-hidden="true">&lt;</span> 
					<span class="sr-only">이전 페이지 한칸 이동</span>
				  </a>
				</li>
			  </c:when>
			  <c:otherwise>
				<li class="page-item">
				  <a  class="page-link" href="./list${ph.sc.getQueryString(ph.sc.page-1, ph.sc.category)}"
					aria-label="Previous-Page"> 
				    <span aria-hidden="true">&lt;</span> 
				    <span class="sr-only">이전 페이지 한칸 이동</span>
				  </a>
				</li>
			  </c:otherwise>
			</c:choose>

	<!-- Previous Button -->


	<!-- Page Number -->

			<c:forEach var="pageNumber" begin="${ph.startPage}" end="${ph.endPage}" step="1">
			<c:choose>
			  <c:when test="${pageNumber eq ph.sc.page}">
				<li class="page-item active">
				  <a class="page-link">${pageNumber}</a>
				</li>
			  </c:when>
			  <c:otherwise>
				<li class="page-item"><a class="page-link" href="./list${ph.sc.getQueryString(pageNumber, ph.sc.category)}">${pageNumber}</a></li>
			  </c:otherwise>
			</c:choose>
			</c:forEach>

	<!-- Page Number -->

	<!-- Next Button -->

			<c:choose>
			  <c:when test="${ph.sc.page >= ph.totalPage}">
				<li class="page-item disabled">
				  <a class="page-link" href="#" aria-label="Next"> 
				    <span aria-hidden="true">&gt;</span> 
				    <span class="sr-only">다음 페이지 한칸 이동</span>
				  </a>
				</li>
			  </c:when>
			  <c:otherwise>
				<li class="page-item">
				  <a class="page-link" href="./list${ph.sc.getQueryString(ph.sc.page+1, ph.sc.category)}" 
					 aria-label="Next"> 
				    <span aria-hidden="true">&gt;</span> 
				    <span class="sr-only">다음 페이지 한칸 이동</span>
				  </a>
				</li>
			  </c:otherwise>
			</c:choose>

			<c:choose>
			  <c:when test="${ph.endPage == ph.totalPage}">
				<li class="page-item disabled">
				  <a class="page-link" href="#" aria-label="Next"> 
				   <span aria-hidden="true">&raquo;</span> 
				    <span class="sr-only">페이지 다음블럭 이동</span>
				  </a>
				</li>
			  </c:when>
			  <c:otherwise>
				<li class="page-item">
				  <a class="page-link" href="./list${ph.sc.getQueryString(ph.endPage+1, ph.sc.category)}" 
					 aria-label="Next">
					<span aria-hidden="true">&raquo;</span> <span class="sr-only">페이지 다음블럭 이동</span>
				  </a>
				</li>
			  </c:otherwise>
			</c:choose>
			</ul>
		  </nav>

	<!-- Next Button -->


	<!-- Pagination -->


	<!-- Search -->

	    	<section id="search" class="mb-3 bg-light">
	    	  <div class="container">
	    		<div class="form-row justify-content-center">
	    		  <form action="./list" method="get" name="search" id="searchForm"
	    				enctype="application/x-www-form-urlencoded">
	    			<fieldset>
	    			  <div class="input-group mx-auto">
	    				<label for="keyword"></label>
	    			    <div class="col-xs-2">
	    				  <select id= "keyfield" name="keyfield" class="form-control">
		    				  <optgroup label="검색항목">
		    				    <option value="title" ${ph.sc.keyfield eq 'title'?'selected':''}>제목</option>
		    				    <option value="contents" ${ph.sc.keyfield eq 'contents'?'selected':''}>내용</option>
		    				    <option value="title-contents" ${ph.sc.keyfield eq 'title-contents'?'selected':''}>제목+내용</option>
		    				    <option value="id" ${ph.sc.keyfield eq 'id'?'selected':''}>아이디</option>
		    				  </optgroup>
	    				  </select>
	    				</div>
	    				<div class="col-xs-6">
	    				  <input type="search" id="keyword" name="keyword" class="form-control" placeholder="검색어 입력" value="${ph.sc.keyword}">
	    				</div>
	    				<button class="btn btn-outline-danger input-group-append" type="submit">
	    				  <i class="fas fa-search"></i>검색
	    				</button>
	    				<div>
	    				  <input type="hidden" id="category" name="category" value="${ph.sc.category}">
	    				</div>
	    			  </div>
	    			</fieldset>
	    		  </form>
	    		</div>
	    	  </div>
	    	</section>

	<!-- Search -->
		</div>
	  </div>
	</div>
  </div>
</section>
	<!-- Footer -->

<%@ include file="../../include/footer.jsp"%>

	<!-- Footer -->

<script>
	$(function() {
		const urlParams = new URL(location.href).searchParams;
		const category = urlParams.get('category');
		if(category == 'QNA_TECH') {
			$(".category a[href*='QNA_TECH']").addClass("active");
		}
		if(category == 'QNA_CAREER') {
			$(".category a[href*='QNA_CAREER']").addClass("active");
		}
		if(category == 'QNA_ETC') {
			$(".category a[href*='QNA_ETC']").addClass("active");
		}
		if(category == '') {
			$(".category a[href*='category=&']").addClass("active");
		}
	})
</script>

</body>
</html>