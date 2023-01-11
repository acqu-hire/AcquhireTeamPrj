<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="${contextPath}/resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/js/kakao-addressAPI.js" type="text/javascript"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${contextPath}/resources/js/validity.js"></script>
<!-- <script type="text/javascript">
	$(function() {
		$("#dbIdCheck").click(function() {
			var memberId = $("#memberId").val();
			if (memberId.search(/\s/) != -1) {	// 정규표현식과 주어진 스트링간에 첫번째로 매치되는 것의 인덱스를 반환한다. 찾지 못하면 -1 를 반환한다.) // \s 공백 정규식
				alert("아이디에는 공백이 들어갈 수 없습니다.");
			} else {
				if (memberId.trim().length != 0) {
					$.ajax({
						url : './IdCheck.me',
						type : 'get',
						data : {
							memberId : memberId
						},
						success : function(result) {
							console.log("아이디 값 - " + result);
							if ($.trim(result) == 1) {
								alert("이미 등록된 아이디 입니다.");
								$("#memberId").focus();
							} else {
								alert("등록할 수 있는 아이디입니다.");
								$("#idCheck").val("1");
								$("#memberPwd").focus();
							}
						}
					});
				} else {
					alert("아이디를 입력해주세요.");
				}
			}
		});
	});
</script> -->
</head>
<body>
	<!-- Header -->

<%@ include file="../include/header.jsp"%>

	<!-- Header -->

	<!-- 회원가입 폼 -->

<div class="container-fluid">
  <div class="row">
	<div class="col-md-12">
	  <main class="regForm">
		<div class="cotainer">
		  <div class="row justify-content-center">
			<div class="col-md-8">
			  <div class="card">
				<div class="card-header">
				  <h3>회원가입</h3>
				  <p align="right">
				  <span class="text-danger">*</span>표시는 필수입력 항목입니다.
				</div>
				<div class="card-body">
				  <form name="regForm" id="register" method="post" action="./register">
					<div class="form-group row">
					  <label for="name" class="col-md-4 col-form-label text-md-right">
					  	<span class="text-danger">*</span>이름
					  </label>
					  <div class="col-md-6">
						<input type="text" id="name" class="form-control" name="name" placeholder="Name">
					  </div>
					</div>
					<div class="form-group row">
					  <label for="id" class="col-md-4 col-form-label text-md-right">
					    <span class="text-danger">*</span>아이디
					  </label>
					  <div class="col-md-6">
					    <input type="text" id="id" class="form-control" name="id" placeholder="ID">
					  </div>
					  <button type="button" class="btn btn-warning" id="dbIdCheck">중복체크</button>
					  <input type="hidden" name="idCheck" id="idCheck">
					</div>
					<div class="form-group row">
					  <label for="password" class="col-md-4 col-form-label text-md-right">
					    <span class="text-danger">*</span>비밀번호
					  </label>
					  <div class="col-md-6">
						<input type="password" id="password" class="form-control" name="password" placeholder="Password">
					  </div>
					</div>
					<div class="form-group row">
					  <label for="pwdConfirm" class="col-md-4 col-form-label text-md-right">
					    <span class="text-danger">*</span>비밀번호 확인
					  </label>
					  <div class="col-md-6">
					    <input type="password" id="pwdConfirm" class="form-control" name="pwdConfirm" placeholder="Password">
					  </div>
					</div>
					<div class="form-group row">
					  <label for="gender" class="col-md-4 col-form-label text-md-right">
					    <span class="text-danger">*</span>성별
					  </label>
					  <label class="col-md-2 mt-2 radio-inline text-md-center"> 
					    <input type="radio" id="gender" name="gender" value="M">남자
					  </label> 
					  <label class="col-md-2 mt-2 radio-inline text-md-center"> 
					    <input type="radio" id="gender" name="gender" value="F">여자
					  </label>
					</div>
					<div class="form-group row">
					  <label for="address" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>주소</label>
					  <div class="col-md-2">
						<input type="text" id="postalcode" name="postalcode" placeholder="우편번호" class="form-control input-md" readonly>
					  </div>
					  <div>
						<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="findPostalcode">
					  </div>
					</div>
					<div class="form-group row">
					  <label for="address" class="col-md-4 col-form-label text-md-right"></label>
					  <div class="col-sm-5">
						<input type="text" id="address" name="address" placeholder="주소" class="form-control input-md" readonly>
						<input type="text" id="addressDetail" name="addressDetail" placeholder="상세주소" class="form-control input-md">
						<input type="text" id="addressExtra" name="addressExtra" placeholder="참고항목" class="form-control input-md" readonly>
					  </div>
					</div>
					<div class="form-group row">
					  <label for="phone_number" class="col-md-4 col-form-label text-md-right">
					    <span class="text-danger">*</span>휴대폰
					  </label>
					  <div class="col-md-6">
						<input type="text" name="phone_number" id="phone_number" class="form-control" placeholder="'-'을 제외한 숫자 10~11자리">
					  </div>
					</div>
					<div class="form-group row">
					  <label for="email" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>이메일</label>
						<div class="col-md-6">
							<input type="email" id="email" name="email" class="form-control" name="permanent-address" placeholder="Email">
						</div>
					</div>
					<div class="col-md-6 offset-md-4">
					  <button type="submit" class="btn btn-primary">가입</button>
					  <button type="reset" onclick="resetCheck()" class="btn btn-primary">취소</button>
					</div>
				 </form>
			  </div>
			</div>
		  </div>
		</div>
	  </div>
	</main>
   </div>
  </div>
 </div>


	<!-- Footer -->

<%@ include file="../include/footer.jsp"%>

	<!-- Footer -->

</body>
</html>