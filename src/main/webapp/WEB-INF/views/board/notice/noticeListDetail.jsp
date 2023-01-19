<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- <c:if test="${empty sessionScope.memberId}">
	<script type="text/javascript">
		location.href = "./LoginView.me"
	</script>
</c:if> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTICE 게시판</title>

</head>
<body>
<!-- Header -->

<%@ include file="../../include/header.jsp" %>

<!-- Header -->

	<!-- Board Insert Form -->

<div class="container-fluid">
	<div class="row justify-content-center">
		<div class="col-md-8 mt-3 mb-3">
			<div class="card">
				<div class="card-header">
					<h2 class="text-center mt-4 mb-4">게시글</h2>
				</div>
				
				<div class="card-body">
					<table class="table">
						<tr>
							<th>작성자</th>
							<td>${selectDetail.id}</td>
						</tr>
						<tr style="display:none;">
							<th>게시글 번호</th>
							<td><a id="filebNo" class="downlink" href="${selectDetail.bNo}">${selectDetail.bNo}</a></td>
						</tr>
						<tr>
							<th>게시판메뉴</th>
							<td>${selectDetail.menu} > ${selectDetail.category}</td>
						</tr>
						<tr>
							<th>조회수</th>
							<td>${selectDetail.readCount}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${selectDetail.writeDay}</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${selectDetail.title}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>${selectDetail.contents}</td>
						</tr>
						<tr>
							<th>파일</th>
							<td>
								<c:forEach items="${fileNoList}" var="fileNoList" varStatus="idx" step="1">
									<p>
										<a class="downlink" href="${fileNoList.original_file_name}">${fileNoList.original_file_name}</a> 
									</p>		
								</c:forEach>
							</td>
						</tr>
					</table>
				<hr/>
					<div class="col-12">
					${boardDTO.contents}
					</div>
					<div class="row">
 						<div class="col-12 text-right">
							<input type="button" value="글수정" class="btn btn-success" onclick="location.href='./update_view?bNo=${selectDetail.bNo}'"> 
							<input type="button" value="글삭제" class="btn btn-warning" onclick="location.href='./delete?bNo=${selectDetail.bNo}'">
							<button type="button" class="btn btn-primary" onclick="location.href='./select_all_view?num=1'">전체 게시글보기</button>
						</div> 
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Footer -->

<%@ include file="../../include/footer.jsp" %>

<!-- Footer -->

</body>
<script type="text/javascript">
$(document).ready(function() {
	  $(".downlink").click(function(e){ 
	    e.preventDefault();
	    var fileName = $(this).attr("href");
	    var bNo = $("#filebNo").attr("href");
	    window.location = "fileDownLoad?fileName=" + fileName + "&bNo=" + bNo; 
	  });
	});
</script>
</html>