<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty sessionScope.id}">
	<script type="text/javascript">
		location.href = "<c:url value='/login/login'/>"
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 작성</title>

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
		  <h2 class="text-center mt-4 mb-4"><strong>질문글 작성</strong></h2>
		</div>
		<div class="card-body">
		  <form method="post" name="QnAWriteForm">
			<table class="table table-striped">
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
				   <td><input type="text"  class="form-control" name="id" value="bacd" readonly></td>
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
				 <td colspan="2"  class="text-right">
				   <input type="submit" value="글쓰기" class="btn btn-success">
				   <input type="reset" value="다시작성" class="btn btn-warning">
				   <button type="button"  class="btn btn-primary" onclick="location.href='./list'">전체 게시글보기</button>
				 </td>
			   </tr>
			 </table>
		   </form>
		 </div>
		</div>
	  </div>
  </div>
</div>
	

<!-- Footer -->

<%@ include file="../../include/footer.jsp" %>

<!-- Footer -->
<script type="text/javascript">
	$(function() {
		$("form").submit(function() {
			if($("select[name='category']").val() == ""){
				alert("카테고리를 선택해주세요.")
				return false;
			};
			if(!$("input[name='title']").val()) {
				alert("제목을 입력하세요.")
				return false;
			}
			if(!$("textarea[name='contents']").val()) {
				alert("내용을 입력하세요.")
				return false;
			}
			
		})
	});
</script>
</body>
</html>