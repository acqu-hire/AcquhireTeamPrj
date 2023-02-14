<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<html>
<head>
<title>${memberDTO.id}님의 회원정보</title>
</head>
<body>

	<!-- Board Insert Form -->

<div class="container-fluid">
  <div class="row justify-content-center">
	<div class="col-md-8 mt-3 mb-3">
	  <div class="card">
		<div class="card-header">
		  <h2 class="text-center mt-4 mb-4">회원정보</h2>
		</div>
		<div class="card-body">
		  <form action="" method="get" id="memberInfoForm">
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
			<div class="row">
			  <div class="col-12 text-right">
				<button type="button" class="btn btn-success" id="updateBtn">회원수정</button>
				<button type="button" class="btn btn-warning" id="deleteBtn">회원탈퇴</button>
		   		<!-- <button type="button" class="btn btn-primary" onclick="location.href='./BoardList.do'">회원 목록</button> -->
			  </div>
			</div>
		  </form>
		</div>
	  </div>
	</div>
  </div>
</div>

<%@ include file="../include/footer.jsp" %>

<script type="text/javascript">
	$("#deleteBtn").on("click", function() {
		var form = $('#memberInfoForm');
		if(!confirm("${memberDTO.id}님 회원을 탈퇴 하시겠습니까?")) return;
		form.attr("action", "<c:url value='/member/delete'/>?id=${memberDTO.id}");
		form.attr("method", "post");
		form.submit();
		alert("${memberDTO.id}님의 회원탈퇴가 완료되었습니다.")
	})
	$("#updateBtn").on("click", function() {
		location.href="<c:url value='/member/update'/>?id=${memberDTO.id}";
	})
</script>
</body>
</html>