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
		  <form method="post" action="" id="updateForm" enctype="multipart/form-data">
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
              <tr>
                <td colspan="2"  class="text-right">
                  <button type="button" class="btn btn-success" id="btnUpdate">글저장</button>
                  <button type="reset"  class="btn btn-warning">다시작성</button>
                  <button type="button"  class="btn btn-primary" id="btnList">게시글 목록</button>
				</td>
			  </tr>
			</table>
			<input type="hidden"  class="form-control" name="bNo" value="${boardDTO.bNo}">
			<c:if test="${!empty boardDTO.fileList}">
			<div class="row col-12">
			  <table id="fileArea">
			    <tr>
			 	 <th>첨부파일 <button type="button" id="addFileBtn">추가</button></th>
			      <td class="file-area">
			    	<c:forEach var="files" items="${boardDTO.fileList}" varStatus="status">
			    	  <div class="file-inline" data-fno="${files.fNo}">
			    	    파일${status.count}. 
						<c:out value="${files.originName}(${files.fmtFileSize})"/> <a href="#"><i class="fas fa-trash" data-fno="${files.fNo}"></i></a> <br/>
			    	  </div>
					</c:forEach>
				  </td>
				</tr>
			  </table>
			</div>
			</c:if>
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
$(function() {
 	$("#btnList").on("click", function() {
		location.href="<c:url value='/QnA/list'/>${sc.getQueryString(sc.page, sc.category)}"
	})
	
	$("#btnUpdate").on("click", function() {
		var form = $("#updateForm");
		form.attr("method", "post");
		form.attr("action", "<c:url value='./update'/>${sc.getQueryString(sc.page,sc.category)}");
		form.submit();
	})
	
	var maxAppend = "${boardDTO.fileList.size()}";
	$("#addFileBtn").on("click", function() {
		if(maxAppend >= 5) {
			alert("파일첨부 최대개수는 5개 입니다.");
			return;
		}
		$(".file-area").append('<div class="row file-inline">'
		+ '<input type="file" name="files">'
		+ '<button type="button" class="delBtn btn btn-sm float-right">삭제</button>'
		+ '</div>');
		maxAppend++;
	});
	
	$(".file-area").on("click", ".delBtn", function() {
		$(this).closest("div").remove();
		maxAppend--;
	});
	
	$(".fa-trash").on("click", function() {
		if(!confirm("첨부파일을 삭제하시겠습니까?")) return;
		$btn = $(this);
		$btn.closest("div").html(
								'<input type="hidden" name="delAttach" value="' + $btn.data('fno') + '" />'
								);
		maxAppend--;
	})
})

$(document).on("change","input:file",function() {
		var resetFile = $("input[name='files']");
		  if(resetFile.length < 1){
		    console.log("cancel was pressed");
		    $(resetFile).wrap("<form></form>").closest("form").get(0).reset();
		    $(resetFile).unwrap();
		  }
		  else {
		    console.log(resetFile[0].name);
		  }
	});

</script>
</body>
</html>