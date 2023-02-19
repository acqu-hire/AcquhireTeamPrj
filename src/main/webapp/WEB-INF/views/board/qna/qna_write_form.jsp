<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>

<html>
<head>
<title>QnA 작성</title>
</head>
<body>

	<!-- Board Insert Form -->
	
<div class="container-fluid">
  <div class="row justify-content-center">
	<div class="col-md-8 mt-3 mb-3">
	  <div class="card">
		<div class="card-header">
		  <h2 class="text-center mt-4 mb-4"><strong>질문글 작성</strong></h2>
		</div>
		<div class="card-body">
		  <form method="post" name="QnAWriteForm" id="QnAWriteForm" enctype="multipart/form-data">
			<table class="table">
			  <tr>
			    <th>카테고리</th>
			  	  <td>
			    	<div class="input-group mx-auto">
				 	  <label for="category"></label>
					  <div class="col-xs-2">
					    <select name="category" class="form-control">
						  <option value="">==카테고리선택==</option>
						  <option value="QNA_TECH">테크</option>
						  <option value="QNA_CAREER">커리어</option>
						  <option value="QNA_ETC">기타</option>
					    </select>
					  </div>
				    </div>
				  </td>
			   </tr>
			   <tr>
				 <th>작성자</th>
				   <td><input type="text"  class="form-control" name="id" value="${sessionScope.id}" readonly></td>
			   </tr>
			   <tr>
				 <th>제목</th>
				   <td><input type="text"  class="form-control" name="title"></td>
			   </tr>
 			   <tr>
				 <th>글내용</th>
				 <td><textarea rows="10" cols="50" name="contents" class="form-control"></textarea></td>
			   </tr>
			   <tr>
				 <th>파일 <button type="button" id="addFileBtn">추가</button></th>
				   <td class="file-area">
				     <div class="row file-inline" data-fileSize="${boardDTO.fileList.size()}">
				     </div>
				   </td>
			   </tr>
			   <tr>
				 <td colspan="2"  class="text-right">
				   <input type="button" value="글쓰기" class="btn btn-success" id="submitWriteForm">
				   <button type="reset"  class="btn btn-warning" id="btnReset">다시작성</button>
				   <button type="button"  class="btn btn-primary" id="btnList">전체 게시글보기</button>
				 </td>
			   </tr>
			 </table>
		   </form>
		 </div>
		</div>
	  </div>
  </div>
</div>
	
<%@ include file="../../include/footer.jsp" %>
<script src="${contextPath}/resources/js/ckeditor.js?ver=1" type="text/javascript"></script>
</body>
</html>