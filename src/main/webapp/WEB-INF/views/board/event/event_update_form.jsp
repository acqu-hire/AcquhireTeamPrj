<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp"%>
<html>
<head>
<title>이벤트 게시물 수정</title>

</head>

<body>

	<!-- Board Insert Form -->

	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-8 mt-3 mb-3">
				<div class="card">
					<div class="card-header">
						<h2 class="text-center mt-4 mb-4">
							<strong>게시물 수정</strong>
						</h2>
					</div>
					<div class="card-body">
						<form method="post" action="./update" id="EventUpdateForm">
						<input type="hidden"  class="form-control" name="bno" value="${boardDTO.bno}">
							<table class="table table-striped">
								<tr>
									<th>작성자</th>
									<td><input type="text" class="form-control" name="id"
										value="${boardDTO.id}" readonly></td>
								</tr>
								<tr>
									<th>제목</th>
									<td><input type="text" class="form-control" name="title"
										value="${boardDTO.title}"></td>
								</tr>
								<tr>
									<th>글내용</th>
									<td><textarea rows="10" cols="50" name="contents"
											class="form-control">${boardDTO.contents}</textarea></td>
								</tr>
								<tr>
									<td colspan="2" class="text-right">
										<button type="submit" class="btn btn-success">글저장</button>
										<button type="reset"  class="btn btn-warning" id="btnReset">다시작성</button>
										<button type="button" class="btn btn-primary" id="btnList">게시글
											목록</button>
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

	<%@ include file="../../include/footer.jsp"%>

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