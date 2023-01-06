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
<title>NOTICE 작성</title>
<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
<script src="${contextPath}/resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js"></script>
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
		        <h2 class="text-center mt-4 mb-4"><strong>안내문 작성</strong></h2>
		    	</div>
			    	<div class="card-body">
				        <form action="./update" method="post" enctype="multipart/form-data">
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
			            	<tr style="display:none;">
				                <th>글번호</th>
				                <td><input type="text" name="bNo" value="${boardDTO.bNo}" readonly="readonly" /> </td>
				            </tr>
				            <tr>
				                <th>작성자</th>
				                <td>${boardDTO.id}</td>
				            </tr>
				            <tr>
				                <th>제목</th>
				                <td><input type="text"  class="form-control" name="title"></td>
				            </tr>
 				             <tr>
				                <td>글내용</td>
				                <td><textarea rows="10" cols="50" name="contents" class="form-control"></textarea></td>
				            </tr>
				            <!--<tr>
				            	<td>첨부파일</td>
				            	<td><input type="file" name="file" /></td>
				            </tr>-->
				            <tr>
				                <td colspan="2"  class="text-right">
				                    <input type="submit" value="글쓰기" class="btn btn-success" />
				                    <input type="reset" value="다시작성" class="btn btn-warning" />
				                    <button type="button"  class="btn btn-primary" onclick="location.href='./select_all_view'">전체 게시글보기</button>
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


</body>
</html>