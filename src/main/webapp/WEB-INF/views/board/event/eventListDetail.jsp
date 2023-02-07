<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 게시판</title>
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
				<div class="card-body" >
					<table class="table">
						<tr>
							<th>제목</th>
							<td><c:out value="${boardDTO.title}"/></td>
						</tr>
					
						<tr>
							<th>작성자</th>
							<td>${boardDTO.id}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${boardDTO.writeDay}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td></td>
							
					</table>
				<hr/>
					<div class="col-12">
					<c:out value="${boardDTO.contents}"/>
					</div>
					<input type="hidden" name="bno" value="${boardDTO.bno}">
					<div class="row">
 						<div class="col-12 text-right">
							<input type="button" value="수정" class="btn btn-success" onclick="location.href='./eventUpdate_view?bno=${boardDTO.bno}'"> 
							<input type="button" value="삭제" class="btn btn-warning" onclick="location.href='./eventDelete?bno=${boardDTO.bno}'">
							<button type="button" class="btn btn-primary" onclick="location.href='./menu_select_all'">전체 게시글보기</button>
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