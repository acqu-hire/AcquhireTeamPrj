<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<html>
<head>
<title>이벤트 게시판</title>
</head>
<body>

	<!-- Board Insert Form -->

<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="col-md-8 mt-3 mb-3">
			<div class="card">
				<div class="card-header">
					<h2 class="text-center mt-4 mb-4">게시글</h2>
				</div>
				<div class="card-body" >
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
							<td><c:out value="${boardDTO.title}"/></td>
						</tr>
						
					</table>
				<hr/>
					<input type="hidden" name="bno" value="${boardDTO.bno}">
					<div class="card-header bg-light">
	        		  <i class="fas fa-laugh-beam"></i> Contents
					</div>
					<div class="card-body">
					  ${boardDTO.contents}
					</div>
					<div class="row">
 						<div class="col-12 text-right">
							<button type="button" class="btn btn-success" id="btnModify">글수정</button>
							<button type="button" class="btn btn-warning" id="btnRemove">글삭제</button>
							<button type="button" class="btn btn-primary" id="btnList">게시글 목록</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="../../include/footer.jsp" %>

</body>
</html>