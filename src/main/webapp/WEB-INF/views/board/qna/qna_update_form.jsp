<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 수정</title>

</head>

<body>

	<!-- Board Insert Form -->
	
<div class="container-fluid">
  <div class="row justify-content-center">
	<div class="col-md-8 mt-3 mb-3">
	  <div class="card">
		<div class="card-header">
		  <h2 class="text-center mt-4 mb-4"><strong>게시글 수정</strong></h2>
		</div>
		<div class="card-body">
		  <form method="post" action="" id="updateForm" enctype="multipart/form-data">
		  <input type="hidden"  class="form-control" name="bno" value="${boardDTO.bno}">
			<table class="table table-striped">
			  <tr>
				<th>작성자</th>
				<td><input type="text"  class="form-control" name="id" value="${boardDTO.id}" readonly></td>
			  </tr>
	          <tr>
                <th>제목</th>
                <td><input type="text"  class="form-control" name="title" value="${boardDTO.title}"></td>
              </tr>
              <tr>
                <th>글내용</th>
                <td><textarea rows="10" cols="50" name="contents" class="form-control">${boardDTO.contents}</textarea></td>
              </tr>
			<c:choose>
			  <c:when test="${!empty boardDTO.fileList}">
		  	    <tr>
		 		 <th>첨부파일 <button type="button" id="addFileBtn">추가</button></th>
		     	   <td class="file-area">
		    		<c:forEach var="files" items="${boardDTO.fileList}" varStatus="status">
		    		  <div class="file-inline" data-fno="${files.fno}" data-fileSize="${boardDTO.fileList.size()}">
		    	   		 파일${status.count}. 
					    <c:out value="${files.originName}(${files.fmtFileSize})"/> <a href="#"><i class="fas fa-trash" data-fno="${files.fno}"></i></a> <br/>
		    	  	  </div>
					</c:forEach>
			 	  </td>
				</tr>
			  </c:when>
			  <c:otherwise>
			  <tr>
		        <th>파일 <button type="button" id="addFileBtn">추가</button></th>
			     <td class="file-area">
			       <div class="row file-inline" data-fileSize="${boardDTO.fileList.size()}">
			       </div>
			     </td>
			   </tr>
			  </c:otherwise>
			</c:choose>
			  <tr>
                <td colspan="2" class="text-right">
                  <button type="button" class="btn btn-success" id="btnUpdate">글저장</button>
                  <button type="reset"  class="btn btn-warning">다시작성</button>
                  <button type="button"  class="btn btn-primary" id="btnList">게시글 목록</button>
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

<script>
var getQueryString = "${cri.getQueryString(cri.getPage(), cri.getCategory())}";
</script>
</body>
</html>