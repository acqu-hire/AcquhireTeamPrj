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
<title>${memberDTO.id}님의 회원정보</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js"></script>
<script type="text/javascript">
	function memberDelete() {
		if(confirm("${memberDTO.name}님 회원을 탈퇴 하시겠습니까?")) {
			location.href = "../include"
		}
	}
</script>
</head>
<body>
<!-- Header -->

<%@ include file="../include/header.jsp" %>

<!-- Header -->

	<!-- Board Insert Form -->

<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="col-md-8 mt-3 mb-3">
			<div class="card">
				<div class="card-header">
					<h2 class="text-center mt-4 mb-4">회원정보</h2>
				</div>
				<div class="card-body">
					<table class="table text-center">
						<tr>
							<th>회원 ID</th>
							<td>${memberDTO.id}</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>${memberDTO.name}</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>${memberDTO.address}</td>
						</tr>
						<tr>
							<th>휴대폰</th>
							<td>${memberDTO.phone_number}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${memberDTO.email}</td>
						</tr>	
						<tr>
							<th>가입일</th>
							<td>${memberDTO.reg_date}</td>
						</tr>
						
					</table>
				
					<%-- <div class="row">
						<div class="col-12 text-right">
							<input type="button" value="회원수정" class="btn btn-success" onclick="location.href='./MemberUpdateView.me?memberId=${memberDTO.memberId}'"> 
							<input type="button" value="회원탈퇴" class="btn btn-warning" onclick="memberDelete()">
							<!-- <button type="button" class="btn btn-primary" onclick="location.href='./BoardList.do'">회원 목록</button> -->
						</div>
					</div> --%>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Footer -->

<%@ include file="../include/footer.jsp" %>

<!-- Footer -->
</body>
</html>