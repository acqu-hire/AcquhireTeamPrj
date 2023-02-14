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
				        <form action="./write" name="EventInsertForm" id="EventInsertForm" method="post" enctype="multipart/form-data">
				          <table class="table table-striped">
				            <tr>
			                	<th>카테고리</th>
				                	<td>
				                		<div class="input-group mx-auto">
											<label for="category"></label>
												<div class="col-xs-2">
													<select name="category" id="category" class="form-control">
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
				                <td><input type="text"  class="form-control" name="title" id="title"></td>
				            </tr>
 				             <tr>
				                <th>내용</th>
				                <td><textarea rows="12" cols="50" name="contents" id="contents" class="form-control"></textarea></td>
				            </tr>
				            <tr>
				                <td colspan="2"  class="text-right">
				                    <input type="submit" value="등록" class="btn btn-success" />
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

<!-- Footer -->

<%@ include file="../../include/footer.jsp" %>
<script>
    var editorConfig = {
        filebrowserUploadUrl : "${contextPath}/file/fileUpload",//이미지 업로드
        height : 400,
    };
    CKEDITOR.on('dialogDefinition', function( ev ){
        var dialogName = ev.data.name;
        var dialogDefinition = ev.data.definition;
        var dialog = ev.data.definition.dialog;
        if (dialogName == 'image') {
			dialog.on('show', function (obj) {
			this.selectPage('Upload'); //업로드텝으로 시작
		});
        }
        switch (dialogName) {
            case 'image': 
            dialogDefinition.removeContents('Link');
            dialogDefinition.removeContents('advanced');
            var infoTab = dialogDefinition.getContents( 'info' ); 
          	//info 탭 내에 불필요한 엘레멘트들 제거 
            infoTab.remove( 'txtAlt'); // 대체 문자열
            infoTab.remove( 'txtBorder'); // 테두리 
            infoTab.remove( 'txtHSpace'); // 세로여백 
            infoTab.remove( 'txtVSpace'); // 가로여백 
            infoTab.remove( 'ratioLock'); // 비율유지 
            infoTab.remove( 'browse'); //원래 크기로 	         
        
        }
    });
 window.onload = function(){
      ck = CKEDITOR.replace("contents", editorConfig);
 };
</script>
</body>
</html>