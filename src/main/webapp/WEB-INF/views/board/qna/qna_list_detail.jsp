<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				  <form method="post" action="" id="boardForm">
					<table class="table">
						<tr>
							<th>조회수</th>
							
							<td>${boardDTO.readCount}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${boardDTO.writeDay}</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${boardDTO.id}</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${boardDTO.title}</td>
						</tr>
					</table>
				<hr/>
					<input type="hidden" name="bNo" value="${boardDTO.bNo}">
					<div class="col-12">
					${boardDTO.contents}
					</div>
					<div class="row">
 						<div class="col-12 text-right">
							<button type="button" class="btn btn-success" id="btnModify">글수정</button>
							<button type="button" class="btn btn-warning" id="btnRemove">글삭제</button>
							<button type="button" class="btn btn-primary" id="btnList">게시글 목록</button>
						</div>
					</div>
				  </form>
				</div>
			</div>
		</div>
	</div>
</div>


	<!-- Footer -->

<%@ include file="../../include/footer.jsp" %>

	<!-- Footer -->
<script>
	$(document).ready(function() {
		$('#btnList').on('click', function() {
			location.href="<c:url value='./list'/>${ph.getQueryString(ph.sc.page, ph.sc.category)}"
		})
		$('#btnRemove').on('click', function() {
			if(!confirm("게시글을 삭제하시겠습니까?")) return;
			
			var form = $("#boardForm");
			form.attr("action", "<c:url value='./delete'/>${ph.getQueryString(ph.sc.page, ph.sc.category)}");
			form.attr("method", "post");
			form.submit();
		})
		$('#btnModify').on('click', function() {
			var form = $("#boardForm");
			form.attr("action", "<c:url value='./update'/>${ph.getQueryString(ph.sc.page, ph.sc.category)}");
			form.attr("method", "get");
			form.submit();
			/* location.href="<c:url value='./update'/>${ph.getQueryString(ph.sc.page, ph.sc.category)}"; */
		})
	})
</script>
</body>
</html>