<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- <c:if test="${empty sessionScope.id}">
	<script type="text/javascript">
		location.href = "./LoginView.me"
	</script>
</c:if> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTICE 게시판</title>

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
							<h3 align="center">글목록</h3>
							<div align="right">
								전체 글 : <strong>${PaginationNotice.count}</strong>
							</div>
						</div>
						<div class="card-body">
 							<div align="center">
								<button type="button" class="btn btn-primary float-end" name="category" value="NOTICE_ALL" onclick="location.href='./select_all_view' ">전체</button>							
								<button type="button" class="btn btn-primary float-end" name="category" value="NOTICE_NOTICE" onclick="location.href='./select_category_view?category=NOTICE_NOTICE' ">공지사항</button>
								<button type="button" class="btn btn-primary float-end" name="category" value="NOTICE_EVENT" onclick="location.href='./select_category_view?category=NOTICE_EVENT' ">이벤트</button>
							</div>
							<div class="d-flex justify-content-end">
								<a class="btn btn-warning float-end" href="./insert_view"> <i class="fas fa-edit"></i> 글 작성
								</a>
							</div>
							<table class="table table-hover table-striped text-center"  style="table-layout: fixed">
								<thead class="thead-dark">
									<tr>
										<th width="5%">번호</th>
										<th width="25%">제목</th>
										<th width="5%">작성자</th>
										<th width="10%">작성일</th>
										<th width="4%">조회수</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="bNo" value="${PaginationNotice.count - ((PaginationNotice.criteriaNotice.num-1) * 5) }"/>
									<c:forEach varStatus="status" var="board" items="${menuSelectAll}">
										<tr>
											<th>${bNo}</th>
											<%-- <th>${(boardListCount-status.index)-((page-1)*10)}</th> --%>
											<td class="text-truncate" style="max-width: 500px;"><a href="./select_Detail_view?bNo=${board.bNo}">${board.title}</a></td>
											<td>${board.id}</td>
											<td>${board.writeDay}</td>
											<td>${board.readCount}</td>
										</tr>
										<c:set var="bNo" value="${bNo-1}"></c:set>
									</c:forEach>
								</tbody>
							</table>
							<table class="table table-hover text-center">
								<c:if test="${PaginationNotice.count==0}">
									<tr>
										<td>등록된 게시글이 없습니다.</td>
									</tr>
								</c:if>
							</table>
						</div>

						<!-- Pagination -->
						<c:if test="">

						</c:if>
						<nav>
							<ul class="pagination justify-content-center">

								<!-- Previous Button -->
								
								<c:choose>
									<c:when test="${PaginationNotice.startPageNum <= 1}">
										<li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous-PageBlock"> <span
												aria-hidden="true">&laquo;</span> <span class="sr-only">페이지 이전블럭 이동</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link" href="/notice/select_all_view${PaginationNotice.getUrlLink(PaginationNotice.startPageNum-1)}"
											aria-label="Previous-PageBlock"> <span aria-hidden="true">&laquo;</span> <span class="sr-only">페이지
													이전블럭 이동</span>
										</a></li>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${PaginationNotice.num <= 1}">
										<li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous-Page"> <span
												aria-hidden="true">&lt;</span> <span class="sr-only">이전 페이지 한칸 이동</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a  class="page-link" href="/notice/select_all_view${PaginationNotice.getUrlLink(PaginationNotice.num-1)}"
											aria-label="Previous-Page"> <span aria-hidden="true">&lt;</span> <span class="sr-only">이전 페이지 한칸
													이동</span>
										</a></li>
									</c:otherwise>
								</c:choose>

								<!-- Page Number -->
								<c:forEach begin="${PaginationNotice.startPageNum}" end="${PaginationNotice.endPageNum}" var="number">
								   <c:choose>
										<c:when test="${PaginationNotice.num==number}">
											<li class="page-item active"><a class="page-link">${number}</a></li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a class="page-link" href="/notice/select_all_view${PaginationNotice.getUrlLink(PaginationNotice.num)}">${number}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								
								<!-- Next Button -->

								<c:choose>
									<c:when test="${PaginationNotice.num >= PaginationNotice.endPageNum_tmp}">
										<li class="page-item disabled"><a class="page-link" href="#" aria-label="Next"> <span
												aria-hidden="true">&gt;</span> <span class="sr-only">다음 페이지 한칸 이동</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link" href="/notice/select_all_view${PaginationNotice.getUrlLink(PaginationNotice.num+1)}" aria-label="Next"> <span
												aria-hidden="true">&gt;</span> <span class="sr-only">다음 페이지 한칸 이동</span>
										</a></li>
									</c:otherwise>
								</c:choose>

								<c:choose>
								
									<c:when test="${!PaginationNotice.next}">
										<li class="page-item disabled"><a class="page-link" href="#" aria-label="Next"> <span
												aria-hidden="true">&raquo;</span> <span class="sr-only">페이지 다음블럭 이동</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link" href="/notice/select_all_view${PaginationNotice.getUrlLink(PaginationNotice.endPageNum+1)}" aria-label="Next">
												<span aria-hidden="true">&raquo;</span> <span class="sr-only">페이지 다음블럭 이동</span>
										</a></li>
									</c:otherwise>
								
								</c:choose>
	

								

							</ul>
						</nav>

						<!-- Pagination -->


						<!-- Search -->

						<section id="search" class="mb-3 bg-light">
							<div class="container">
								<div class="form-row justify-content-center">
									<form action="/notice/select_all_view${PaginationNotice.getUrlLink(PaginationNotice.num)}" get="get" name="searchType" id="signupForm"
										enctype="application/x-www-form-urlencoded">
										<fieldset>
											<div class="input-group mx-auto">
												<label for="keyword"></label>
												<div class="col-xs-2">
													<select name="searchType" class="form-control">
														해당 항목을 기본 선택으로 지정하여 검색한다.
														<option value="all" selected="selected">전체 검색</option>
														<option value="id">아이디</option>
														<option value="title">제목</option>
														<option value="contents">내용</option>
														<option value="titleContents">제목+내용</option>
													</select>
												</div>
												<div class="col-xs-6">
													<input type="search" id="keyword" name="keyword" class="form-control" placeholder="검색어 입력">
												</div>
													<button class="btn btn-outline-danger input-group-append" type="submit">
														<i class="fas fa-search"></i>검색
													</button>
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

</body>
</html>