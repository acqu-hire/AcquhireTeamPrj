<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<!-- Header -->

<%@ include file="../include/header.jsp" %>

	<!-- Header -->

	<!-- Login Form -->
<div id="login">
  <h3 class="text-center text-white pt-5">Login form</h3>
	<div class="container">
	  <div id="login-row" class="row justify-content-center align-items-center">
		<div id="login-column" class="col-md-6">
		  <div id="login-box" class="col-md-12">
			<form id="loginForm" class="form" method="post">
			  <h3 class="text-center text-info">Login</h3>
			  <c:if test="${!empty param.msg}">
				<div class="alert alert-danger">
	      		  <strong><i class="fas fa-exclamation-circle"></i> 로그인 실패</strong> <br> 
	      		  ${param.msg}
				</div>
			  </c:if>
			  <div class="form-group">
				<label for="id" class="text-info">ID:</label><br> 
				<input type="text" name="id" id="id" class="form-control" value="${cookie.id.value}">
			  </div>
			  <div class="form-group">
				<label for="password" class="text-info">Password:</label><br> 
				<input type="password" name="password" id="password" class="form-control">
			  </div>
			  <input type="hidden" name="requestURL" value="${requestURL}">
			  <div class="form-group">
				<label for="save" class="text-info"><span>Remember me</span> 
				  <span><input name="rememberId" type="checkbox" value="on" ${!empty cookie.id.value?'checked':''}></span>
				</label><br>
				<button type="submit" class="btn btn-info btn-md">로그인</button>
			  </div>
			  <div id="register-link" class="text-right">
				<a href="/member/register" class="text-info">회원가입</a>
			  </div>
			</form>
			  
		  </div>
		</div>
	  </div>
	</div>
</div>
	
	<!-- Login Form -->

	<!-- Footer -->

<%@ include file="../include/footer.jsp" %>

	<!-- Footer -->
</body>
</html>