<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<html>
<head>
<script src="${contextPath}/resources/js/reply.js?ver=1" type="text/javascript"></script>
<title>커뮤니티 게시판</title>

</head>
<body>

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
					<input type="hidden" name="bno" value="${boardDTO.bno}">
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
					    	  <div data-fno="${files.fno}" class="file-inline">
					    	    파일${status.count}<a href="<c:out value='/file/download/${files.fno}'/>"><i class="fa-sharp fa-solid fa-download"></i></a>
								<c:out value="${files.originName}(${files.fmtFileSize})"/> <br/>
					    	  </div>
					    	   <input type="hidden" name="delAttach" value="${files.fno}">
							</c:forEach>
						  </td>
						</tr>
					  </table>
					</div>
				</c:if>
			 </form>
			 
			 
				<c:if test="${!empty sessionScope.id}">
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
						  </div>
						  <textarea class="form-control" id="replyContents" rows="3"></textarea>
						  <button type="button" class="btn btn-dark mt-3" id="regReplyBtn">등록</button>
		   				</li>
					  </ul>
					</div>
				  </div>
				 </c:if>
				 
				 
				 
				  <hr/>
				  <!-- reply contents -->
				    <div class="p-1 bg-warning"><span class="reply-tab">댓글목록(${boardDTO.replyCnt})</span></div>
				      <div class="reply-inline">
					  </div>
					  <div class="reply-pagenation">
					   <nav aria-label="Page navigation">
					   </nav>
					</div>
			  </div>
			</div>
		</div>
	</div>
</div>
  <div class="d-flex" id="reReplyForm">
  	<div class="p-2 icon" style="display: none;"><i class="mt-3 fa fa-reply fa fa-rotate-180" aria-hidden="true"></i></div>
  	<div class="flex-fill content"  style="display: none;">
  <div class="card mb-2" >
	<div class="card-header bg-light">
     		  <i class="fa fa-comment fa"></i> 댓글
	</div>
	<div class="card-body">
	  <ul class="list-group list-group-flush">
 		<li class="list-group-item">
		  <div class="form-inline mb-2">
			<label for="replyId"><i class="fa fa-user-circle-o fa-2x"></i></label>
			<input type="text" class="form-control ml-2" id="reReplyId" value="${sessionScope.id}" readOnly>
		  </div>
		  <textarea class="form-control" id="reReplyContents" rows="3"></textarea>
		  <button type="button" class="btn btn-dark mt-3" id="regReReplyBtn">등록</button>
		  <button type="button" class="btn btn-dark mt-3 reply-cancel">취소</button>
 		</li>
	  </ul>
	</div>
  </div>
  </div>
  </div>

<%@ include file="../../include/footer.jsp" %>

<script>
var bno = "${boardDTO.bno}";
var sessionId = "${sessionScope.id}";
var writer = "${boardDTO.id}";
var getQueryString = "${cri.getQueryString(cri.getPage(), cri.getCategory())}";
</script>
</body>
</html>