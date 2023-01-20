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
<script src="${contextPath}/resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/js/reply-test.js" type="text/javascript"></script>
<meta charset="UTF-8">
<title>QnA 게시판</title>

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
				  <form method="get" action="" id="boardForm">
					<table class="table">
						<tr>
							<th>조회수</th>
							
							<td>${boardDTO.readCount}</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>${boardDTO.writeDay}</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${boardDTO.id}</td>
						</tr>
						<tr>
							<th>제목</th>
							<td><c:out value="${boardDTO.title}"/></td>
						</tr>
						
					</table>
				<hr/>
					<input type="hidden" name="bNo" value="${boardDTO.bNo}">
					<div class="card-header bg-light">
	        		  <i class="fas fa-laugh-beam"></i> Contents
					</div>
					<div class="card-body">
					  <c:out value="${boardDTO.contents}"/>
					</div>
					<div class="row">
 						<div class="col-12 text-right">
							<button type="button" class="btn btn-success" id="btnModify">글수정</button>
							<button type="button" class="btn btn-warning" id="btnRemove">글삭제</button>
							<button type="button" class="btn btn-primary" id="btnList">게시글 목록</button>
						</div>
					</div>
				<hr/>
				<c:if test="${!empty boardDTO.fileList}">
				  <div class="row col-12">
					<table id="fileArea">
					   <tr>
					 	 <th>첨부파일</th>
					      <td>
					    	<c:forEach var="files" items="${boardDTO.fileList}" varStatus="status" >
					    	  <div data-fno="${files.fNo}" class="file-inline">
					    	    파일${status.count}<a href="<c:out value='/file/download/${files.fNo}'/>"><i class="fa-sharp fa-solid fa-download"></i></a>
								<c:out value="${files.originName}(${files.fmtFileSize})"/> <br/>
					    	  </div>
					    	   <input type="hidden" name="delAttach" value="${files.fNo}">
							</c:forEach>
						  </td>
						</tr>
					  </table>
					</div>
				</c:if>
				  </form>
				  <div class="card mb-2">
					<div class="card-header bg-light">
	        		  <i class="fa fa-comment fa"></i> 댓글
					</div>
					<div class="card-body">
					  <ul class="list-group list-group-flush">
		   				<li class="list-group-item">
						  <div class="form-inline mb-2">
							<label for="replyId"><i class="fa fa-user-circle-o fa-2x"></i></label>
							<input type="text" class="form-control ml-2" id="replyId" value="${sessionScope.id}" readOnly>
							<!-- <label for="replyPassword" class="ml-4"><i class="fa fa-unlock-alt fa-2x"></i></label>
							<input type="password" class="form-control ml-2" placeholder="Enter password" id="replyPassword"> -->
						  </div>
						  <textarea class="form-control" id="replyContents" rows="3"></textarea>
						  <button type="button" class="btn btn-dark mt-3" id="regReplyBtn">등록</button>
		   				</li>
					  </ul>
					</div>
				  </div>
				  <hr/>
				  <!-- reply contents -->
				    <div class="p-1 bg-warning"><span class="reply-tab">댓글목록(${boardDTO.replyCnt})</span></div>
				      <div class="reply-inline">
					  </div>
			  </div>
			</div>
		</div>
	</div>
</div>


	<!-- Footer -->

<%@ include file="../../include/footer.jsp" %>

	<!-- Footer -->
<script>
var bNo = "${boardDTO.bNo}";
var sessionId = "${sessionScope.id}";
var writer = "${boardDTO.id}";
$(function() {
	$('#btnList').on('click', function() {
		location.href="<c:url value='./list'/>${sc.getQueryString(sc.page, sc.category)}"
	})
	$('#btnRemove').on('click', function() {
		if(!confirm("게시글을 삭제하시겠습니까?")) return;
		
		var writer = '${boardDTO.id}';
		if(sessionId != writer){
			alert("삭제할 권한이 없습니다.");
		} else {
			var form = $("#boardForm");
			form.attr("action", "<c:url value='./delete'/>${sc.getQueryString(sc.page, sc.category)}");
			form.attr("method", "post");
			form.submit();
		}
	})
	$('#btnModify').on('click', function() {
		var writer = '${boardDTO.id}';
		if(sessionId != writer){
			alert("수정할 권한이 없습니다.");
		} else {
			location.href="<c:url value='./update'/>${sc.getQueryString(sc.page, sc.category)}&bNo=${boardDTO.bNo}";
		}
	})
})
</script>
</body>
</html>