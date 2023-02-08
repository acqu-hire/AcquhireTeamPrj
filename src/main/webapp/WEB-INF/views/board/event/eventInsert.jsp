<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<html>
<head>
<title>이벤트 게시물 작성</title>
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
				        <form action="./eventInsert" name="EventInsertForm" id="EventInsertForm" method="post" enctype="multipart/form-data">
				          <table class="table table-striped">
				            <tr>
			                	<th>카테고리</th>
				                	<td>
				                		<div class="input-group mx-auto">
											<label for="category"></label>
												<div class="col-xs-2">
													<select name="category" class="form-control">
														<option value="">==카테고리선택==</option>
														<option value="EVENT_IT_EVENT">IT 이벤트</option>
														<option value="EVENT_MARKETING">이벤트 마케팅</option>
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
				                <td>내용</td>
				                <td><textarea name="contents" class="form-control"></textarea></td>
				            </tr>
				            <!--<tr>
				            	<td>첨부파일</td>
				            	<td><input type="file" name="file" /></td>
				            </tr>-->
				            <tr>
				                <td colspan="2"  class="text-right">
				                    <input type="submit" value="등록" class="btn btn-success" />
				                    <button type="button"  class="btn btn-primary" onclick="location.href='./menu_select_all'">전체 게시글보기</button>
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