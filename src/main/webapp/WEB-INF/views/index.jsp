<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acqu-Hire</title>
<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
<script src="${contextPath}/resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js" ></script>
</head>
<body>

<!-- Header -->
<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false"/>
<%-- <%@ include file="include/header.jsp" %>
 --%>
<!-- Header -->

<section>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row align-items-center">
					<div class="col-md-2">
						<ul class="nav flex-column">
							<li class="nav-item"><a class="nav-link" href="#">1</a></li>
							<li class="nav-item"><a class="nav-link" href="#">2</a></li>
							<li class="nav-item"><a class="nav-link" href="#">3</a></li>
							<li class="nav-item"><a class="nav-link" href="#">4</a></li>

						</ul>
					</div>
					<div class="col-md-10">
						<div class="jumbotron">
							<h2>Acquhire Team Project</h2>
							<p>준비중...</p>
<!-- 							<p>
								<a class="btn btn-primary btn-large" href="#">Learn more</a>
							</p> -->
						</div>
					</div>
				</div>
			</div>
		</div>

<!-- 					<div class="row">
						<div class="col-md-4">
							<a><img alt="" src="img/cloth.png"></a>
						</div>
						<div class="col-md-4">
							<a><img alt="" src="img/cloth.png"></a>
						</div>
						<div class="col-md-4">
							<a><img alt="" src="img/cloth.png"></a>
						</div>
					</div> -->
<!-- 					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
					</div> -->
	</div>
</section>
<!-- Footer -->

<%@ include file="include/footer.jsp" %>

<!-- Footer -->

</body>
</html>