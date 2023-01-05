<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>

	<nav class="navbar navbar-expand-lg navbar-light bg-warning static-top">

		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMenu">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="<c:url value='/' />"><i class="far fa-smile-wink"></i> Aqh</a>
		<div class="collapse navbar-collapse" id="navbarMenu">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item"><a class="nav-link active" href="<c:url value='/' />"><i class="fa-solid fa-house"></i>Home</a></li>
<%-- 				<c:choose>
					<c:when test="${!empty sessionScope.id}">
						<li class="nav-item"><a class="nav-link" href="#">게시판</a></li>
						<li class="nav-item dropdown">
					        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
					          ${sessionScope.name}님
					        </a>
					    <div class="dropdown-menu">
					        <a class="dropdown-item" href="./MemberListDetail.me?memberId=${sessionScope.id}">회원정보</a>
					    <div class="dropdown-divider"></div>
					        <a class="dropdown-item" href="./Logout.me">로그아웃</a>
					     </div>
					      </li>
					</c:when>
					<c:otherwise> --%>
						<li class="nav-item"><a class="nav-link" href="<c:url value='/notice/select_all_view' />">공지사항</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value='/QnA/list' />">QnA</a></li>
						<li class="nav-item"><a class="nav-link" href="#">이벤트</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value='/community/select_all_view' />">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
						<li class="nav-item"><a class="nav-link" href="#">로그인</a></li>
				<%-- 	</c:otherwise>
				</c:choose> --%>
			</ul>


<!-- 			<form class="form-inline">
				<input class="form-control mr-sm-2" type="text" />
				<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
			</form> -->

		</div>
	</nav>
	
</header>
<script type="text/javascript">
	$(function() {
		$("ul.navbar-nav li").on("click", function() {
			$("ul.navbar-nav li").remove("active");
			$(this).addClass("active");			
		})
	})
</script>
</body>
</html>