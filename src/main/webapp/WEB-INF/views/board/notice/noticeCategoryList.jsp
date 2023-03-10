<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<html>
<head>
<title>NOTICE 게시판</title>
</head>
<body>

	<!-- Board -->

	<section>
		<div class="container-fluid">
			<div class="row justify-content-center">
				<div class="col-8">
					<div class="card">
						<div class="card-header">
							<h3 align="center">글목록</h3>
							<div align="right">
								전체 글 : <strong>${Pagination.listCnt}</strong>
							</div>
						</div>
						<div class="card-body">
 							<div align="center">
								<button type="button" class="btn btn-primary float-end" name="kind" value="NOTICE_ALL" onclick="location.href='./select_all_view' ">전체</button>								
								<button type="button" class="btn btn-primary float-end" name="kind" value="NOTICE_NOTICE" onclick="location.href='./select_category_view?category=NOTICE_NOTICE' ">공지사항</button>
								<button type="button" class="btn btn-primary float-end" name="kind" value="NOTICE_EVENT" onclick="location.href='./select_category_view?category=NOTICE_EVENT' ">이벤트</button>
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
									<c:set var="bno" value="${Pagination.listCnt - ((Pagination.criteria.page-1) * 10) }"/>
									<c:forEach varStatus="status" var="board" items="${categorySelectAll}">
										<tr>
											<th>${bno}</th>
											<%-- <th>${(boardListCount-status.index)-((page-1)*10)}</th> --%>
											<td class="text-truncate" style="max-width: 500px;"><a href="./select_Detail_view${Pagination.getListLink(Pagination.page)}&bno=${board.bno}">${board.title}</a></td>
											<td>${board.id}</td>
											<td>${board.writeDay}</td>
											<td>${board.readCount}</td>
										</tr>
										<c:set var="bno" value="${bno-1}"></c:set>
									</c:forEach>
								</tbody>
							</table>
							<table class="table table-hover text-center">
								<c:if test="${boardCategoryCount==0}">
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
									<c:when test="${Pagination.startPage <= 1}">
										<li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous-PageBlock"> <span
												aria-hidden="true">&laquo;</span> <span class="sr-only">페이지 이전블럭 이동</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link" href="/notice/select_category_view${Pagination.getListLink(Pagination.startPage-1)}"
											aria-label="Previous-PageBlock"> <span aria-hidden="true">&laquo;</span> <span class="sr-only">페이지
													이전블럭 이동</span>
										</a></li>
									</c:otherwise>
								</c:choose> 

								<c:choose>
									<c:when test="${Pagination.page <= 1}">
										<li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous-Page"> <span
												aria-hidden="true">&lt;</span> <span class="sr-only">이전 페이지 한칸 이동</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a  class="page-link" href="/notice/select_category_view${Pagination.getListLink(Pagination.page-1)}"
											aria-label="Previous-Page"> <span aria-hidden="true">&lt;</span> <span class="sr-only">이전 페이지 한칸
													이동</span>
										</a></li>
									</c:otherwise>
								</c:choose>

								<!-- Page Number -->
								<c:forEach begin="${Pagination.startPage}" end="${Pagination.endPage}" var="number">
								   <c:choose>
										<c:when test="${Pagination.page==number}">
											<li class="page-item active"><a class="page-link">${number}</a></li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a class="page-link" href="/notice/select_category_view${Pagination.getListLink(number)}">${number}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								
								<!-- Next Button -->

								<c:choose>
									<c:when test="${Pagination.page >= Pagination.pageCnt}">
										<li class="page-item disabled"><a class="page-link" href="#" aria-label="Next"> <span
												aria-hidden="true">&gt;</span> <span class="sr-only">다음 페이지 한칸 이동</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link" href="/notice/select_category_view${Pagination.getListLink(Pagination.page+1)}" aria-label="Next"> <span
												aria-hidden="true">&gt;</span> <span class="sr-only">다음 페이지 한칸 이동</span>
										</a></li>
									</c:otherwise>
								</c:choose>

								<c:choose>
								
									<c:when test="${Pagination.endPage == Pagination.pageCnt}">
										<li class="page-item disabled"><a class="page-link" href="#" aria-label="Next"> <span
												aria-hidden="true">&raquo;</span> <span class="sr-only">페이지 다음블럭 이동</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link" href="/notice/select_category_view${Pagination.getListLink(Pagination.endPage+1)}" aria-label="Next">
												<span aria-hidden="true">&raquo;</span> <span class="sr-only">페이지 다음블럭 이동</span>
										</a></li>
									</c:otherwise>
								
								</c:choose> 

							</ul>
						</nav>


						<!-- Search -->

						<section id="search" class="mb-3 bg-light">
							<div class="container">
								<div class="form-row justify-content-center">
									<form action="/notice/select_category_view${Pagination.getListLink(Pagination.page)}" method="get" name="type" id="signupForm"
										enctype="application/x-www-form-urlencoded">
										<fieldset>
											<div class="input-group mx-auto">
												<label for="keyword"></label>
												<div class="col-xs-2">
													<select name="type" class="form-control">
														해당 항목을 기본 선택으로 지정하여 검색한다.
														<option value="all" selected="selected">전체 검색</option>
														<option value="title">제목</option>
														<option value="memberId">아이디</option>
														<option value="content">내용</option>
													</select>
												</div>
												<div><input type="hidden" name="category" value="${Pagination.criteria.getCategory()}"/></div>
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

	<%@ include file="../../include/footer.jsp"%>

</body>
</html>