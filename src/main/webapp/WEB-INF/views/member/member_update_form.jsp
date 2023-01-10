<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:if test="${empty sessionScope.id}">
	<script type="text/javascript">
		location.href = "<c:url value='/login/login'/>"
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${memberDTO.id}님의회원정보 수정페이지</title>
<script src="${contextPath}/resources/js/kakao-addressAPI.js" type="text/javascript"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<!-- Header -->
	<%@ include file="../include/header.jsp"%>
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
						<form action="./update" method="post" name="memberUpdateForm">
							<div class="form-group row">
								<label for="id" class="col-md-4 col-form-label text-md-right">회원ID</label>
								<div class="col-sm-5">
									<input type="text" id="id" class="form-control" name="id" value="${memberDTO.id}" readonly>
								</div>
							</div>
							<div class="form-group row">
								<label for="name" class="col-md-4 col-form-label text-md-right">이름</label>
								<div class="col-sm-5">
									<input type="text" id="name" class="form-control" name="name" value="${memberDTO.name}">
								</div>
							</div>
							<div class="form-group row">
								<label for="address" class="col-md-4 col-form-label text-md-right">주소</label>
								<div class="col-md-2">
									<input type="text" id="postalcode" name="postalcode" placeholder="우편번호" class="form-control input-md" value="" readonly>
								</div>
								<div>
									<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="findPostalcode">
								</div>
							</div>
							<div class="form-group row">
								<label for="address" class="col-md-4 col-form-label text-md-right"></label>
								<div class="col-sm-5">
									<input type="text" id="address" name="address" placeholder="주소" class="form-control input-md" value="" readonly>
									<input type="text" id="addressDetail" name="addressDetail" placeholder="상세주소" class="form-control input-md" value="">
									<input type="text" id="addressExtra" name="addressExtra" placeholder="참고항목" class="form-control input-md" value="" readonly>
								</div>
							</div>
							<div class="form-group row">
								<label for="phone_number" class="col-md-4 col-form-label text-md-right">휴대폰</label>
								<div class="col-sm-5">
									<input type="text" id="phone_number" class="form-control" name="phone_number" value="${memberDTO.phone_number}">
								</div>
							</div>
							<div class="form-group row">
								<label for="email" class="col-md-4 col-form-label text-md-right">이메일</label>
								<div class="col-sm-5">
									<input type="email" id="email" class="form-control" name="email" value="${memberDTO.email}">
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-sm-12 ml-5 text-center">
									<input type="submit" value="수정완료" class="btn btn-success"> 
									<input type="reset" value="다시작성" class="btn btn-warning">
									<button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/member/detail"/>?id=${memberDTO.id}'">수정취소</button>
									<c:if test="${sessionScope.id == 'admin'}">
										<button type="button" class="btn btn-primary" onclick="">회원목록</button>
									</c:if>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@ include file="../include/footer.jsp"%>
	<!-- Footer -->
</body>
</html>