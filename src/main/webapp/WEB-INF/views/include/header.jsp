<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>
<meta charset="UTF-8">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="url_" value="${requestScope['javax.servlet.forward.servlet_path']}" />
<c:set var="url" value="${fn:toLowerCase(url_)}" />
<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<link rel="shortcut icon" href="/resources/img/favicon.ico" type="image/x-icon"/>
<script src="${contextPath}/resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/js/board.js?ver=1" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js" ></script>
<script src="${contextPath}/resources/ckeditor/ckeditor.js" type="text/javascript"></script>
</head>
<header style="padding-top : 68px;">
	<div>
  <nav class="navbar navbar-expand-lg navbar-light bg-white fixed-top" style="border-bottom : 2px solid #000;">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMenu">
		  <span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" style="margin-left: 27rem" href="<c:url value='/' />"><img width="40" height="40" src="../resources/img/logo.png"> <b> ACQHIRE</b> </a>
		<div class="collapse navbar-collapse" id="navbarMenu">
		  <ul class="navbar-nav mx-auto">
			<li class="nav-item">
			  <a class="nav-link ${url == '/'?'active':''}" href="<c:url value='/' />">
				<i class="fa-solid fa-house"></i>Home
			  </a>
			</li>
	 		<c:choose>
			  <c:when test="${!empty sessionScope.id}">
				<li class="nav-item">
				  <a class="nav-link ${fn:contains(url ,'notice')?'active':''}" href="<c:url value='/notice/select_all_view'/>">공지사항</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link ${fn:contains(url ,'qna')?'active':''}" href="<c:url value='/QnA/list' />">QnA</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link ${fn:contains(url ,'event')?'active':''}" href="<c:url value='/Event/list' />">이벤트</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link ${fn:contains(url ,'community')?'active':''}" href="<c:url value='/community/list' />">커뮤니티</a>
				</li>
				<li class="nav-item dropdown">
				  <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
					${sessionScope.name}님
				  </a>
				  <div class="dropdown-menu">
				    <a class="dropdown-item" href="<c:url value='/member/detail?id=${sessionScope.id}'/>">회원정보</a>
				    <div class="dropdown-divider"></div>
				    <a class="dropdown-item" id="logout" href="#">로그아웃</a>
				    <c:if test="${sessionScope.id == 'admin'}">
				      <a class="dropdown-item" href="#"><i class="fa-solid fa-user-tie"></i>관리자 페이지</a>
				    </c:if>
				  </div>
				</li>
			  </c:when>
				<c:otherwise>
				  <li class="nav-item">
				    <a class="nav-link ${fn:contains(url ,'notice')?'active':''}" href="<c:url value='/notice/select_all_view'/>">공지사항</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link ${fn:contains(url ,'qna')?'active':''}" href="<c:url value='/QnA/list' />">QnA</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link ${fn:contains(url ,'event')?'active':''}" href="<c:url value='/Event/list' />">이벤트</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link ${fn:contains(url ,'community')?'active':''}" href="<c:url value='/community/list' />">커뮤니티</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link ${fn:contains(url ,'register')?'active':''}" href="<c:url value='/member/register'/>">회원가입</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link ${fn:contains(url ,'login')?'active':''}" href="<c:url value='/login/login'/>">로그인</a>
				  </li>
				</c:otherwise>
		    </c:choose>
		  </ul>
		</div>
  </nav>
	</div>
</header>
<script>
	$("#logout").on("click", function() {
		if(!confirm('로그아웃 하시겠습니까?')) return
		location.href="<c:url value='/login/logout'/>"
	})
var bno = "${boardDTO.bno}";
var sessionId = "${sessionScope.id}";
var writer = "${boardDTO.id}";
var getQueryString = "${cri.getQueryString(cri.getPage(), cri.getCategory())}";
</script>