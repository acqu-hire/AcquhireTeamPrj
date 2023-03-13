<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>
<html>
<head>
<title>QnA 게시판</title>
</head>
<body>

	<!-- Board -->

<section>
  <div class="container-fluid">
	<div class="row justify-content-center">
	  <div class="col-8">
		<div class="card">
		  <div class="card-header">
			<h3 align="center">QnA</h3>
			<div align="right">
				전체 글 : <strong>${pagination.listCnt}</strong>
			</div>
		  </div>
		  <div class="card-body">
			<div id="BtnCategory" class="category" align="center">
			  <a class="btn btn-primary float-end all-category-btn" data-value=""
			  href="<c:url value='./list'/>?category=&type=${pagination.criteria.type}&keyword=${pagination.criteria.keyword}">전체</a>								
			  <a class="btn btn-warning float-end" data-value="QNA_TECH"
			  href="<c:url value='./list'/>?&category=QNA_TECH&type=${pagination.criteria.type}&keyword=${pagination.criteria.keyword}">기술</a>
			  <a class="btn btn-warning float-end" data-value="QNA_CAREER"
			  href="<c:url value='./list'/>?&category=QNA_CAREER&type=${pagination.criteria.type}&keyword=${pagination.criteria.keyword}">커리어</a>
			  <a class="btn btn-warning float-end" data-value="QNA_ETC"
			  href="<c:url value='./list'/>?&category=QNA_ETC&type=${pagination.criteria.type}&keyword=${pagination.criteria.keyword}">기타</a>
			</div>
			<div class="d-flex justify-content-end">
			  <a class="btn btn-warning float-end" href="<c:url value='./write'/>${pagination.getListLink(pagination.criteria.page)}">
			 	 <i class="fas fa-edit"></i> 글 작성
			  </a>
			</div>
			<table class="table table-hover table-striped text-center" id="QnaBoardList" style="table-layout: fixed">
			  <thead class="thead-dark">
				<tr>
				  <th width="4%">번호</th>
				  <th width="20%">제목</th>
				  <th width="5%">작성자</th>
				  <th width="10%">작성일</th>
				  <th width="4%">조회수</th>
				</tr>
			  </thead>
			  <tbody>
				<c:forEach varStatus="status" var="board" items="${boardList}">
				<tr>
				  <th>${(pagination.listCnt-status.index)-((pagination.criteria.page-1)*10)}</th>
				  <c:choose>
				    <c:when test="${fn:length(board.title)>15}">
				      <td title="${board.title}">
				        <a href="./listDetail${pagination.getListLink(pagination.criteria.page)}&bno=${board.bno}">
				          <c:out value="${fn:substring(board.title,0,14)}"/>...</a> 
				          <span class="replyCnt" style="color: red;">${board.replyCnt > 0? [board.replyCnt] : ""}</span>
				      </td>
				    </c:when>
				    <c:otherwise>
				      <td title="${board.title}">
				        <a href="./listDetail${pagination.getListLink(pagination.criteria.page)}&bno=${board.bno}">
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
			  <c:if test="${pagination.listCnt==0}">
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
			  <c:when test="${pagination.startPage <= 1}">
				<li class="page-item disabled">
				  <a class="page-link" href="#" aria-label="Previous-PageBlock"> 
				    <span aria-hidden="true">&laquo;</span> 
					<span class="sr-only">페이지 이전블럭 이동</span>
				  </a>
				</li>
			  </c:when>
			  <c:otherwise>
				<li class="page-item">
				  <a class="page-link" href="./list${pagination.getListLink(pagination.startPage-1)}" 
				  	 aria-label="Previous-PageBlock"> 
				    <span aria-hidden="true">&laquo;</span> 
				    <span class="sr-only">페이지 이전블럭 이동</span>
				  </a>
				</li>
			  </c:otherwise>
			</c:choose>
			<c:choose>
			  <c:when test="${pagination.criteria.page <= 1}">
				<li class="page-item disabled">
				  <a class="page-link" href="#" aria-label="Previous-Page"> 
					<span aria-hidden="true">&lt;</span> 
					<span class="sr-only">이전 페이지 한칸 이동</span>
				  </a>
				</li>
			  </c:when>
			  <c:otherwise>
				<li class="page-item">
				  <a  class="page-link" href="./list${pagination.getListLink(pagination.criteria.page-1)}"
					aria-label="Previous-Page"> 
				    <span aria-hidden="true">&lt;</span> 
				    <span class="sr-only">이전 페이지 한칸 이동</span>
				  </a>
				</li>
			  </c:otherwise>
			</c:choose>

	<!-- Previous Button -->


	<!-- Page Number -->

			<c:forEach var="pageNumber" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
			<c:choose>
			  <c:when test="${pageNumber eq pagination.criteria.page}">
				<li class="page-item active">
				  <a class="page-link">${pageNumber}</a>
				</li>
			  </c:when>
			  <c:otherwise>
				<li class="page-item">
				  <a class="page-link" href="./list${pagination.getListLink(pageNumber)}">${pageNumber}</a>
				</li>
			  </c:otherwise>
			</c:choose>
			</c:forEach>

	<!-- Page Number -->

	<!-- Next Button -->

			<c:choose>
			  <c:when test="${pagination.criteria.page >= pagination.pageCnt}">
				<li class="page-item disabled">
				  <a class="page-link" href="#" aria-label="Next"> 
				    <span aria-hidden="true">&gt;</span> 
				    <span class="sr-only">다음 페이지 한칸 이동</span>
				  </a>
				</li>
			  </c:when>
			  <c:otherwise>
				<li class="page-item">
				  <a class="page-link" href="./list${pagination.getListLink(pagination.criteria.page+1)}" 
					 aria-label="Next"> 
				    <span aria-hidden="true">&gt;</span> 
				    <span class="sr-only">다음 페이지 한칸 이동</span>
				  </a>
				</li>
			  </c:otherwise>
			</c:choose>

			<c:choose>
			  <c:when test="${pagination.endPage == pagination.pageCnt}">
				<li class="page-item disabled">
				  <a class="page-link" href="#" aria-label="Next"> 
				   <span aria-hidden="true">&raquo;</span> 
				    <span class="sr-only">페이지 다음블럭 이동</span>
				  </a>
				</li>
			  </c:when>
			  <c:otherwise>
				<li class="page-item">
				  <a class="page-link" href="./list${pagination.getListLink(pagination.endPage+1)}" 
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
	    				  <select id= "type" name="type" class="form-control">
		    				  <optgroup label="검색항목">
		    				    <option value="all" ${pagination.criteria.type eq 'all'?'selected':''}>전체</option>
		    				    <option value="title" ${pagination.criteria.type eq 'title'?'selected':''}>제목</option>
		    				    <option value="contents" ${pagination.criteria.type eq 'contents'?'selected':''}>내용</option>
		    				    <option value="id" ${pagination.criteria.type eq 'id'?'selected':''}>아이디</option>
		    				  </optgroup>
	    				  </select>
	    				</div>
	    				<div class="col-xs-6">
	    				  <input type="search" id="keyword" name="keyword" class="form-control" placeholder="검색어 입력" value="${pagination.criteria.keyword}">
	    				</div>
	    				<button class="btn btn-outline-danger input-group-append" type="submit">
	    				  <i class="fas fa-search"></i>검색
	    				</button>
	    				<div>
	    				  <input type="hidden" id="category" name="category" value="${pagination.criteria.category}">
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

<%@ include file="../../include/footer.jsp"%>

</body>
</html>