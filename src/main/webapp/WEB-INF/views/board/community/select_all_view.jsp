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
								전체 글 : <strong>${pagination.listCnt}</strong>
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
											<th>${board.bno}</th>
											<td class="text-truncate" style="max-width: 500px;"><a
												href="./selectdetail_view?bno=${board.bno}">${board.title}</a>
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
                           <c:when test="${pagination.startPage <= 1}">
                              <li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous-PageBlock"> <span
                                    aria-hidden="true">&laquo;</span> <span class="sr-only">페이지 이전블럭 이동</span>
                              </a></li>
                           </c:when>
                           <c:otherwise>
                              <li class="page-item"><a class="page-link" href="./select_all_view?page=${pagination.page-10}"
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

                        <c:forEach var="pageNumber" begin="${pagination.startPage}" end="${pagination.endPage}">
                           <c:choose>
                              <c:when test="${pageNumber==pagination.page}">
                                 <li class="page-item active"><a class="page-link">${pageNumber}</a></li>
                              </c:when>
                              <c:otherwise>
                                 <li class="page-item"><a class="page-link" href="./select_all_view${pagination.getListLink(pageNumber)}">${pageNumber}</a></li>
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>

                        <!-- Page Number -->

                        <!-- Next Button -->

                        <c:choose>
                           <c:when test="${pagination.page >= pagination.pageCnt}">
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
                           <c:when test="${(pagination.page+9) >= pagination.pageCnt}">
                              <li class="page-item disabled"><a class="page-link" href="#" aria-label="Next"> <span
                                    aria-hidden="true">&raquo;</span> <span class="sr-only">페이지 다음블럭 이동</span>
                              </a></li>
                           </c:when>
                           <c:otherwise>
                              <li class="page-item"><a class="page-link" href="./select_all_view?page=${pagination.page + 10}" aria-label="Next">
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
 <!-- Search -->

                  <section id="search" class="mb-3 bg-light">
                     <div class="container">
                        <div class="form-row justify-content-center">
                           <form action="./select_all_view${pagination.getListLink(pageNumber)}" method="get" name="search" id="signupForm"
                              enctype="application/x-www-form-urlencoded">
                              <fieldset>
                                 <div class="input-group mx-auto">
                                    <label for="keyword"></label>
                                    <div class="col-xs-2">
                                       <select name="type" class="form-control">
                                          <%--해당 항목을 기본 선택으로 지정하여 검색한다.--%>
                                          <option value="all" selected="selected">전체 검색</option>
                                          <option value="id">아이디</option>
                                          <option value="contents">내용</option>
                                       </select>
                                    </div>
                                    <div> <input type="hidden" name="category" value="${pagination.criteria.getCategory()}"> </div>
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


   <!-- Footer -->

</body>

</html>