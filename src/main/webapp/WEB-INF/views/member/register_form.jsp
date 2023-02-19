<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<html>
<head>
<title>회원가입</title>
</head>
<body>


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
					    <input type="radio" id="male" name="gender" value="M">남자
					  </label> 
					  <label class="col-md-2 mt-2 radio-inline text-md-center"> 
					    <input type="radio" id="female" name="gender" value="F">여자
					  </label>
					</div>
					<div class="form-group row">
					  <label for="address" class="col-md-4 col-form-label text-md-right"><span class="text-danger adr-line">*</span>주소</label>
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
						<input type="text" id="addrDetail" name="addrDetail" placeholder="상세주소" class="form-control input-md">
						<input type="text" id="roadAddrPart2" name="roadAddrPart2" placeholder="참고항목" class="form-control input-md" readonly>
						<input type="hidden" id="address" name="address">
					  </div>
					</div>
					<div class="form-group row">
					  <label for="phone_number" class="col-md-4 col-form-label text-md-right">
					    <span class="text-danger">*</span>휴대폰
					  </label>
					  <div class="col-md-6">
						<input type="text" maxlength=11 name="phone_number" id="phone_number" class="form-control" placeholder="'-'을 제외한 숫자 10~11자리">
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
<script src="${contextPath}/resources/js/register.js"></script>
</body>
</html>