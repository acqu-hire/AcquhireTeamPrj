$(function() {

	/*********** QNA ***********/
	
	var maxAppend = $("#addFileBtn div.file-inline").data("fileSize");
    var inputCnt = $("#addFileBtn div.file-inline").data("fileSize");

    /* 카테고리 활성화 */

    const urlParams = new URL(location.href).searchParams;
		const category = urlParams.get("category");
        const current_category = $("#BtnCategory a[data-value='" + category + "']");
        current_category.addClass("active");

    /* 글쓰기 폼 유효성 검사 */

    $("#QnAWriteForm").submit( function() {
        
        if(inputCnt > 1){
            if(!$(".file-inline input[name='files']").val()){
            alert("파일을 첨부하거나 파일탭을 삭제해주세요.")					
            return false;
            }
        }
        
        if($("select[name='category']").val() == ""){
            alert("카테고리를 선택해주세요.");
            return false;
        };
        if(!$("input[name='title']").val()) {
            alert("제목을 입력하세요.");
            return false;
        }
        if(!$("textarea[name='contents']").val()) {
            alert("내용을 입력하세요.");
            return false;
        }
    });
    
    	$("#EventInsertForm").submit( function() {
        
        if($("select[name='category']").val() == ""){
            alert("카테고리를 선택해주세요.");
            return false;
        };
        if(!$("input[name='title']").val()) {
            alert("제목을 입력하세요.");
            return false;
        }
        if(!$("textarea[name='contents']").val()) {
            alert("내용을 입력하세요.");
            return false;
        }
    });

 
    /* 글쓰기, 수정 폼 파일 관련 이벤트 */
    var inputCnt = $(".file-inline input").length;
    var maxAppend = $("div.file-inline").attr("data-fileSize");
    
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
        inputCnt++;
    });
    
    $(".file-area").on("click", ".delBtn", function() {
        $(this).closest("div").remove();
        maxAppend--;
        inputCnt--;
    });

    $(".fa-trash").on("click", function() {
		if(!confirm("첨부파일을 삭제하시겠습니까?")) return;
		$btn = $(this);
		$btn.closest("div").html(
			'<input type="hidden" name="delAttach" value="' + $btn.data('fno') + '" />'
								);
		maxAppend--;
        inputCnt--;
	})

    $(document).on("change","input:file",function() {
        var resetFile = $("input[name='files']");
        if(resetFile.length < 1) {
        console.log("cancel was pressed");
        $(resetFile).wrap("<form></form>").closest("form").get(0).reset();
        $(resetFile).unwrap();
        } else {
        console.log(resetFile[0].name);
        }
    });

    /* 게시물 내 버튼 이벤트 */

	$('#btnList').on('click', function() {
		location.href="./list" + getQueryString
	})
	$('#btnRemove').on('click', function() {
		if(!confirm("게시글을 삭제하시겠습니까?")) return;
		
		if(sessionId != writer && sessionId != 'admin'){
			alert("삭제할 권한이 없습니다.");
		} else {
			var form = $("#boardForm");
			form.attr("action", "./delete" + getQueryString);
			form.attr("method", "post");
			form.submit();
		}
	})
	$('#btnModify').on('click', function() {
		if(sessionId != writer && sessionId != 'admin'){
			alert("수정할 권한이 없습니다.");
		} else {
			location.href="./update" + getQueryString + "&bno=" + bno;
		}
	})

    /* 업데이트 폼 전송 버튼 */

    $(document).on("click", "#btnUpdate", function() {
        if(inputCnt > 1){
            if(!$(".file-inline input[name='files']").val() || $(".file-inline input[name='files']").length == 0){
            alert("파일을 첨부하거나 파일탭을 삭제해주세요.")					
            return false;
            }
        }
        var title = $("input[name='title']").val();
        var contents = $("textarea").text();
		var form = $("#updateForm");
		form.attr("method", "post");
		form.attr("action", "./update" + getQueryString);
		form.submit();
	})

    /* 글쓰기 폼 전송 버튼 */
    $(document).on("click", "#submitWriteForm", function() {
        if(inputCnt >= 1){
            if(!$(".file-inline input[name='files']").val() || $(".file-inline input[name='files']").length == 0){
            alert("파일을 첨부하거나 파일탭을 삭제해주세요.")					
            return false;
            }
        }
		var form = $("#QnAWriteForm");
		form.attr("method", "post");
		form.attr("action", "./write");
		form.submit();
	})
	
	
	
	/*********** NOTICE ***********/
	
	$("#noticeInsertForm, #noticeUpdateForm").submit(function(){
		if(!$("input[name='title']").val()){
			alert("제목을 입력해주세요.");
			$("input[name='title']").focus();
			return false;
		}
		
		if(!$("textarea[name='contents']").val()){
			alert("내용을 입력해주세요.");
			$("textarea[name='contents']").focus();
			return false;
		}
		
		if($("select[name='category']").val() == ""){
			alert("카테고리를 선택해주세요.");
			return false;
		}
	})
})


	/*********** EVENT ***********/
    $("#EventInsertForm").submit( function() {
        
        if($("select[name='category']").val() == ""){
            alert("카테고리를 선택해주세요.");
            return false;
        };
        if(!$("input[name='title']").val()) {
            alert("제목을 입력하세요.");
            return false;
        }
        if(!$("textarea[name='contents']").val()) {
            alert("내용을 입력하세요.");
            return false;
        }
    });

	$("#EventUpdateForm").submit( function() {
    
		if($("select[name='category']").val() == ""){
        alert("카테고리를 선택해주세요.");
        return false;
		};
 	  if(!$("input[name='title']").val()) {
        alert("제목을 입력하세요.");
        return false;
 	  }
 	  if(!$("textarea[name='contents']").val()) {
        alert("내용을 입력하세요.");
        return false;
 	  	}
	});

