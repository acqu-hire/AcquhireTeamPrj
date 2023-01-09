<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- <c:if test="${empty sessionScope.id}">
            <script type="text/javascript">
                location.href = "./LoginView.me"
            </script>
            </c:if> --%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/bootstrap.min.css">
<script src="${contextPath}/resources/js/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js"></script>
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
								전체 글 : <strong>${boardListCount}</strong>
							</div>
						</div>
						<div class="card-body">
							<div align="center">
								<button type="button" class="btn btn-primary float-end"
									name="category" value="COMMUNITY_ALL"
									onclick="location.href='./select_all_view'">전체</button>
								<button type="button" class="btn btn-primary float-end"
									name="category" value="COMMUNITY_LIFE"
									onclick="location.href='./select_all_view?category=COMMUNITY_LIFE'">사는
									얘기</button>
								<button type="button" class="btn btn-primary float-end"
									name="category" value="COMMUNITY_GROUP"
									onclick="location.href='./select_all_view?category=COMMUNITY_GROUP'">모임&스터디</button>
							</div>
							<div class="d-flex justify-content-end">
								<a class="btn btn-warning float-end" href="./insert"> <i
									class="fas fa-edit"></i> 글 작성
								</a>
							</div>
							<table class="table table-hover table-striped text-center"
								style="table-layout: fixed">
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
									<c:forEach varStatus="status" var="board" items="${boardList}">
										<tr>
											<th>${board.bNo}</th>
											<td class="text-truncate" style="max-width: 500px;"><a
												href="./selectdetail_view?bNo=${board.bNo}">${board.title}</a>
											</td>
											<td>${board.id}</td>
											<td>${board.writeDay}</td>
											<td>${board.readCount}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<table class="table table-hover text-center">
								<c:if test="${searchBoardCount==0}">
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
                           <c:when test="${pagination.page <= 1}">
                              <li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous-PageBlock"> <span
                                    aria-hidden="true">&laquo;</span> <span class="sr-only">페이지 이전블럭 이동</span>
                              </a></li>
                           </c:when>
                           <c:otherwise>
                              <li class="page-item"><a class="page-link" href="./select_all_view?page=${pagination.startPage-1}"
                                 aria-label="Previous-PageBlock"> <span aria-hidden="true">&laquo;</span> <span class="sr-only">페이지
                                       이전블럭 이동</span>
                              </a></li>
                           </c:otherwise>
                        </c:choose>

                        <c:choose>
                           <c:when test="${pagination.page <= 1}">
                              <li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous-Page"> <span
                                    aria-hidden="true">&lt;</span> <span class="sr-only">이전 페이지 한칸 이동</span>
                              </a></li>
                           </c:when>
                           <c:otherwise>
                              <li class="page-item"><a class="page-link" href="./select_all_view?page=${pagination.prevPage}"
                                 aria-label="Previous-Page"> <span aria-hidden="true">&lt;</span> <span class="sr-only">이전 페이지 한칸
                                       이동</span>
                              </a></li>
                           </c:otherwise>
                        </c:choose>

                        <!-- Previous Button -->


                        <!-- Page Number -->

                        <c:forEach var="pageNumber" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                           <c:choose>
                              <c:when test="${pageNumber==page}">
                                 <li class="page-item active"><a class="page-link">${pageNumber}</a></li>
                              </c:when>
                              <c:otherwise>
                                 <li class="page-item"><a class="page-link" href="./select_all_view?page=${pageNumber}">${pageNumber}</a></li>
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>

                        <!-- Page Number -->

                        <!-- Next Button -->

                        <c:choose>
                           <c:when test="${pagination.page >= pagination.endPage}">
                              <li class="page-item disabled"><a class="page-link" href="#" aria-label="Next"> <span
                                    aria-hidden="true">&gt;</span> <span class="sr-only">다음 페이지 한칸 이동</span>
                              </a></li>
                           </c:when>
                           <c:otherwise>
                              <li class="page-item"><a class="page-link" href="./select_all_view?page=${pagination.nextPage}" aria-label="Next"> <span
                                    aria-hidden="true">&gt;</span> <span class="sr-only">다음 페이지 한칸 이동</span>
                              </a></li>
                           </c:otherwise>
                        </c:choose>

                        <c:choose>
                           <c:when test="${endPage == maxPage}">
                              <li class="page-item disabled"><a class="page-link" href="#" aria-label="Next"> <span
                                    aria-hidden="true">&raquo;</span> <span class="sr-only">페이지 다음블럭 이동</span>
                              </a></li>
                           </c:when>
                           <c:otherwise>
                              <li class="page-item"><a class="page-link" href="./select_all_view?page=${pagination.nextPage}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span> <span class="sr-only">페이지 다음블럭 이동</span>
                              </a></li>
                           </c:otherwise>
                        </c:choose>

                        <!-- Next Button -->

                     </ul>
                  </nav>

                  <!-- Pagination -->


					</div>
				</div>
			</div>
		</div>

	</section>

</body>

</html>