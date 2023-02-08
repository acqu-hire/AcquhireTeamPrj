<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<html>
<head>
<title>NOTICE 수정</title>
</head>

<body>

	<!-- Board Insert Form -->
	
	<div class="container-fluid">
		<div class="row justify-content-center">
		    <div class="col-md-8 mt-3 mb-3">
		    	<div class="card">
		    	<div class="card-header">
		        <h2 class="text-center mt-4 mb-4"><strong>안내문 작성</strong></h2>
		    	</div>
			    	<div class="card-body">
				        <form action="./update" method="post" enctype="multipart/form-data" id="noticeUpdateForm">
				          <table class="table table-striped">
				            <tr>
			                	<th>카테고리</th>
				                	<td>
				                		<div class="input-group mx-auto">
											<label for="category"></label>
												<div class="col-xs-2">
													<select name="category" class="form-control">
														<option value="">==카테고리선택==</option>
														<option value="NOTICE_NOTICE">공지사항</option>
														<option value="NOTICE_EVENT">이벤트</option>
													</select>
												</div>
										</div>
									</td>
			            	</tr>
			       
				            <tr>
				                <th>작성자</th>
				                <td>
				                	${boardDTO.id}
				                	<input type="hidden" name="bno" id="fileBno" value="${boardDTO.bno}" readonly="readonly" />
				                </td>
				            </tr>
				            <tr>
				                <th>제목</th>
				                <td><input type="text"  class="form-control"  name="title"></td>
				            </tr>
 				             <tr>
				                <td>글내용</td>
				                <td><textarea rows="10" cols="50" name="contents" class="form-control"></textarea></td>
				            </tr>
				            <tr>
				            	<td>첨부파일</td>
				            	<td>
				            		<c:forEach items="${fileNoList}" var="fileNoList" varStatus="idx" step="1">
				            			<p class="index" id="destroy_block">
											<a class="downlink" href="${fileNoList.original_file_name}"  data-uuids="${fileNoList.uuid}">${fileNoList.original_file_name}</a> 
											<!-- <span id="fileUuid" style="display:none;">${fileNoList.uuid}</span>-->
											<button type="button" id="destroy_btn" >삭제</button>
										</p>
									</c:forEach>
				            	</td>
				            </tr>
				            <tr>
				            	<td>첨부파일 추가</td>
				            	<td><input type="file" name="uploadFile" multiple="multiple" /></td>
				            </tr>
				            <tr>
				                <td colspan="2"  class="text-right">
				                    <input type="submit" value="글쓰기" class="btn btn-success" id="btn-success" onclick="deletFile()"/>
				                    <input type="reset" value="다시작성" class="btn btn-warning" />
				                    <c:choose>
										<c:when test="${empty criteria.category}">
											<button type="button" class="btn btn-primary" onclick="location.href='./select_all_view?page=${criteria.page}'">전체 게시글보기</button>
										</c:when>
										<c:otherwise>
											<button type="button" class="btn btn-primary" onclick="location.href='./select_category_view?page=${criteria.page}&category=${criteria.category}'">공지 게시글보기</button>
										</c:otherwise>
									</c:choose>
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

</body>
<script type="text/javascript">
$(document).ready(function() {
	  $(".downlink").click(function(e){ 
	    e.preventDefault();
	    var fileName = $(this).attr("href");
	    var bno = $("#fileBno").attr("value");
	    window.location = "fileDownLoad?fileName=" + fileName + "&bno=" + bno; 
	  });
	

		  
		  const destroyBtn = document.querySelectorAll("#destroy_btn");
		  console.log("삭제버튼개수"+destroyBtn.length);
		  destroyBtn.forEach((el, index) => {
			  el.onclick = () => {
				  console.log("삭제버튼번호"+index)
				  const destroyBlock = document.querySelectorAll("#destroy_block");
				  console.log("삭제구역개수"+Object.keys(destroy_block).length);
				  if(Object.keys(destroy_block).length > 0){
					  destroyBlock.forEach((el1, num) => {
						  if(index === num){
							  console.log("index : " + index)
							  console.log("num : " + num)
							  destroy_block[num].style.display='none';
							  
							  var input = document.createElement('input');
							  input.setAttribute("type","hidden");
							  input.setAttribute("name","uuid");
							  input.setAttribute("value",$($(".downlink")[num]).data("uuids"));
							  destroy_block[num].appendChild(input);
						  }
					  });
				  }else{
					  console.log("여기");
					  destroy_block.style.display='none';
					  var input = document.createElement('input');
					  input.setAttribute("type","hidden");
					  input.setAttribute("name","uuid");
					  input.setAttribute("value",$(".downlink").data("uuids"));
					  destroy_block.appendChild(input);
				  }
				  
				  
				  
			  }
		  });
		 
	  
	  
	 
});
</script>
</html>