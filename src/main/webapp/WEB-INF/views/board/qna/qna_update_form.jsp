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
<title>게시글 수정</title>

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
		  <h2 class="text-center mt-4 mb-4"><strong>게시글 수정</strong></h2>
		</div>
		<div class="card-body">
		  <form method="post" name="boardForm">
			<table class="table table-striped">
			  <tr>
				<th>게시글 번호</th>
				<td><input type="text"  class="form-control" name="bNo" value="${boardDTO.bNo}" readonly></td>
			  </tr>
			  <tr>
				<th>작성자</th>
				<td><input type="text"  class="form-control" name="id" value="${boardDTO.id}" readonly></td>
			  </tr>
	          <tr>
                <th>제목</th>
                <td><input type="text"  class="form-control" name="title" value="${boardDTO.title}"></td>
              </tr>
              <tr>
                <td>글내용</td>
                <td><textarea rows="10" cols="50" name="contents" class="form-control">${boardDTO.contents}</textarea></td>
              </tr>
              <tr>
                <td colspan="2"  class="text-right">
                  <input type="submit" value="글저장" class="btn btn-success">
                  <input type="reset" value="다시작성" class="btn btn-warning">
                  <button type="button"  class="btn btn-primary"  id="btnList">게시글 목록</button>
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
<script>
$(document).ready(function() {
	$('#btnList').on('click', function() {
		location.href="<c:url value='./list'/>${ph.getQueryString(ph.sc.page, ph.sc.category)}"
	})
})

</script>
</body>
</html>