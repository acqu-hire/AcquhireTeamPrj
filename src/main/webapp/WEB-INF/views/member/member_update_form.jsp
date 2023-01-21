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
<script src="${contextPath}/resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/js/member.js"></script>
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
						<form action="./update" method="post" id="memberUpdateForm">
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
								<label for="address" class="col-md-4 col-form-label text-md-right">주소(변경)</label>
								<div class="col-md-2">
									<input type="text" id="zipNo" name="zipNo" placeholder="우편번호" class="form-control input-md" readonly>
								</div>
								<div>
									<input type="button" onclick="goPopup();" value="우편번호 찾기" id="findPostalcode">
								</div>
							</div>
							<div class="form-group row">
								<label for="address" class="col-md-4 col-form-label text-md-right"></label>
								<div class="col-sm-5">
									<input type="text" id="roadAddrPart1" name="roadAddrPart1" placeholder="주소" class="form-control input-md" readonly>
									<input type="text" id="addrDetail" name="addrDetail" placeholder="상세주소" class="form-control input-md" >
									<input type="text" id="roadAddrPart2" name="roadAddrPart2" placeholder="참고항목" class="form-control input-md" readonly>
									<input type="hidden" id="address" name="address">
								</div>
							</div>
							<div class="form-group row">
								<label for="old-address" class="col-md-4 col-form-label text-md-right">기존 주소</label>
								<div class="col-sm-5">
									<input type="text" name="old-address" value="${memberDTO.address}" class="form-control" readonly>
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