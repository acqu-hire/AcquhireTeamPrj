<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<%-- <c:if test="${empty sessionScope.memberId}">
			<script type="text/javascript">
				location.href = "./LoginView.me"
			</script>
			</c:if> --%>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>커뮤니티 게시판</title>
				<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
				<script src="https://kit.fontawesome.com/58abbffa46.js"></script>
				<script type="text/javascript" src="${contextPath}/resources/js/reply.js"> </script>
				<script src="${contextPath}/resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
				<script src="${contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
				<script type="text/javascript">
					//for replyService add test
					console.log('=====================');
					console.log('JS  TESTczxcz');
					var bnoValue = '<c:out value="${boardDTO.bNo}"/>';
					replyService.remove(55, function (count) {
						console.log(count);
						if (count === "success") { alert("REMOVED") }
					}, function (err) { alert("ERROR.."); })

				</script>
			</head>

			<body>
				<!-- Header -->

				<%@ include file="../../include/header.jsp" %>

					<!-- Header -->

					<!-- Board Insert Form -->

					<div class="container-fluid">
						<div class="row justify-content-center">
							<div class="col-md-8 mt-3 mb-3">
								<div class="card">
									<div class="card-header">
										<h2 class="text-center mt-4 mb-4">게시글</h2>
									</div>
									<div class="card-body">
										<table class="table">
											<tr>
												<th>게시글 번호</th>
												<td>
													<c:out value="${boardDTO.bNo}" />
												</td>
											</tr>
											<tr>
												<th>조회수</th>
												<td>
													<c:out value="${boardDTO.readCount}" />
												</td>
											</tr>
											<tr>
												<th>작성일</th>
												<td>
													<c:out value="${boardDTO.writeDay}" />
												</td>
											</tr>
											<tr>
												<th>작성자</th>
												<td>
													<c:out value="${boardDTO.id}" />
												</td>
											</tr>
											<tr>
												<th>제목</th>
												<td>
													<c:out value="${boardDTO.title}" />
												</td>
											</tr>
										</table>
										<hr />
										<div class="col-12">
											<c:out value="${boardDTO.contents}" />
										</div>

										<div>

											<form method="post" action="/replies/write">

												<p>
													<label>댓글 작성자</label> <input type="text" name="id" value="admin">
												</p>
												<p>
													<textarea rows="5" cols="50" name="contents"></textarea>
												</p>
												<p>
													<input type="hidden" name="bno" value="${boardDTO.bNo}">
													<button type="submit">댓글 작성</button>
												</p>
											</form>
										</div>
										<div class="row">
											<div class="col-12 text-right">
												<input type="button" value="글수정" class="btn btn-success"
													onclick="location.href='./update?bNo=${boardDTO.bNo}&id=${boardDTO.id}'">
												<input type="button" value="글삭제" class="btn btn-warning"
													onclick="location.href='./delete?bNo=${boardDTO.bNo}&id=${boardDTO.id}'">
												<button type="button" class="btn btn-primary"
													onclick="location.href='./select_all_view'">전체 게시글보기</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


					<!-- Footer -->

					<%@ include file="../../include/footer.jsp" %>

						<!-- Footer -->
			</body>

			</html>