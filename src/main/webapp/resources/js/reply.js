$(function () {
	var page = 1;

	replyList(bno, page); // 댓글 전체조회 함수실행

	$("#regReplyBtn").on("click", function () {
		var contents = $("#replyContents").val();
		if (contents.trim() == "") {
			alert("댓글의 내용을 입력해주세요.")
			return;
		}
		var replyCnt = $("span.reply-tab").text();
		$.ajax({
			type: "POST",
			url: "/reply?bno=" + bno,
			headers: { "content-type": "application/json" },
			data: JSON.stringify({
				contents: contents,
				id: sessionId
			}),
			success: function (result) {
				$("span.reply-tab").text(replyCnt.replace(replyCnt, "댓글목록(" + result + ")"));
				$("#replyContents").val("");
				replyList(bno, page);
			},
			error: function () {
				alert("error");
			}
		}) // ajax 댓글 등록
	})

	$(document).on("click", "#replyRemove", function () {
		var rno = $(this).parents("div.reply-card").data("rno");
		var rWriter = $(this).parents("div.reply-header").data("writer");
		var replyCnt = $("span.reply-tab").text();
		if (sessionId == rWriter || sessionId == 'admin') {
			if (!confirm("댓글을 삭제하시겠습니까?")) return;
			$.ajax({
				type: "DELETE",
				url: "/reply/" + rno + "?bno=" + bno,
				headers: { "content-type": "application/json" },
				data: JSON.stringify({
					rno: rno
				}),
				success: function (result) {
					$("span.reply-tab").text(replyCnt.replace(replyCnt, "댓글목록(" + result + ")"));
					replyList(bno, page);
				},
				error: function () {
					alert("error!!");
				}
			}) // ajax 댓글 삭제
		} else {
			alert("삭제할 권한이 없습니다.");
		}
	})
	// 댓글 수정버튼 클릭 이벤트
	$(document).on("click", "button.modReply", function () {
		var contents = $(this).prev("span.card-text").text();
		var rWriter = $(this).parent("div").siblings().data("writer");
		var modReplyBox = '<textarea class="form-control" name="changeContents" rows="3">';
		if (sessionId == rWriter || sessionId == 'admin') {
			if (!confirm("댓글을 수정하시겠습니까?")) return;
			modReplyBox += contents;
			modReplyBox += ' </textarea>';
			modReplyBox += ' <button type="button" class="btn btn-primary mt-3 reply-submit">전송</button>';
			modReplyBox += ' <button type="button" class="btn btn-primary mt-3 reply-cancel">취소</button>';
			$(this).closest("div.reply-body").html(contents.replace(contents, modReplyBox));
		} else {
			alert("수정 권한이 없습니다.");
		}
	})
	$(document).on("click", "button.reply-submit", function () {
		var rno = $(this).parents("div.reply-card").data("rno");
		var contents = $("textarea[name='changeContents']").val();
		if (!confirm("수정사항을 반영하시겠습니까?")) return;
		$.ajax({
			type: "PATCH",
			url: "/reply/" + rno,
			headers: { "content-type": "application/json" },
			data: JSON.stringify({
				contents: contents
			}),
			success: function (result) {
				replyList(bno, page);
			},
			error: function () {
				alert("error!!");
			}
		}) // ajax 댓글 수정
	})
	$(document).on("click", "button.reply-cancel", function () {
		if (!confirm("수정을 취소하시겠습니까?")) return;
		replyList(bno, page);
	})

	$(document).on("click" ,"button.btn-reReply", function(){
		var displyStatus = $("#reReplyForm").children().css("display");
		if(displyStatus == "none"){
			$("#reReplyForm").appendTo($(this).closest("div.card"));
			// 버튼 클릭시 대댓글 폼 보여주기
			$("#reReplyForm").children().css("display", "block");
		} else {
			$("#reReplyForm").children().css("display", "none");
		}
	})

	$(document).on("click", "#regReReplyBtn", function () {
		var contents = $("#reReplyContents").val();
		var prno = $("#reReplyForm").parent("div.reply-card").data("prno");
		if (contents.trim() == "") {
			alert("댓글의 내용을 입력해주세요.")
			return;
		}
		var replyCnt = $("span.reply-tab").text();
		$.ajax({
			type: "POST",
			url: "/reply?bno=" + bno,
			headers: { "content-type": "application/json" },
			data: JSON.stringify({
				prno : prno,
				contents: contents,
				id: sessionId
			}),
			success: function (result) {
				$("span.reply-tab").text(replyCnt.replace(replyCnt, "댓글목록(" + result + ")"));
				
				replyList(bno, page);
			},
			error: function () {
				alert("error");
			}
		}) // ajax 대댓글 등록
		
		$("#reReplyContents").val("");
		$("#reReplyForm").children().css("display","none");
		$("#reReplyForm").appendTo("body");
	})
})
// 댓글 전체 리스트 조회
var replyList = function (bno, page) {
	$.ajax({
		type: "GET",
		url: "/reply/" + page + "?bno=" + bno,
		dataType : "json",
		success: function (data) {
			var pageInfo = data.cri;
			var replyList = data.list;
			if (replyList.length !== 0) {
				var list = '';
				$.each(replyList, function (index, data) {
					list += ' <div class="d-flex">';
					if(data.prno != data.rno)
						list += ' <div class="p-2 reReply-icon"><i class="mt-3 fa fa-reply fa fa-rotate-180" aria-hidden="true"></i></div>';
					list += ' <div class="card mt-2 reply-card flex-fill" data-rno=' + data.rno + ' data-prno =' + data.prno + ' data-bno = '+ bno +'>';
					list += ' <div class="card-header p-2 bg-secondary text-light reply-header" data-writer = ' + data.id + '>';
					list += ' <table>';
					list += ' <tbody>';
					list += ' <tr class="align-middle">';
					list += ' <td rowspan="2" class="pr-2"><i class="fa fa-user-o fa-2x"></i></td>';
					list += ' <td class="ml"><span class="replyWriter">' + data.id + '</span></td>';
					list += ' </tr>';
					list += ' <tr>';
					list += ' <td>';
					list += ' <font size="2">' + data.writeDay + '</font>'
					if(data.contents != ""){
						if(data.id == sessionId || sessionId == "admin")
							list += ' <span style="cursor:pointer" id="replyRemove"><i class="fa fa-window-close fa" aria-hidden="true"></i></span>';
					}
					list += ' </td>';
					list += ' </tr>';
					list += ' </tbody>';
					list += ' </table>';
					list += ' </div>';
					list += ' <div class="card-body reply-body">';
					if(data.contents == "") {
						list += ' <span class="-text">삭제된 댓글 입니다.</span>';
					} else {
						list += ' <span class="card-text">' + data.contents + '</span>';
						if(data.id == sessionId || sessionId == "admin")
							list += ' <button class="badge badge-dark modReply">수정</button>';
						if(data.rno == data.prno)
							list += ' <button class="badge badge-dark btn-reReply">답글</button>';
					}
					list += ' </div>';
					list += ' </div>';
					list += ' </div>';
					list += ' </div>';
				});
				$(".reply-inline").html(list);
				pagenation(pageInfo);
			} else {
				$(".reply-inline").html("등록된 댓글이 없습니다.");
			}
		},
		error: function () {
			alert('error!!');
		}
	}) // ajax
}

var pagenation = function(pageInfo) {
	var pagenation = ' <ul class="pagination pg-blue justify-content-center">';

		if(pageInfo.startPage != 1){
			pagenation += ' <li class="page-item"><a class="page-link" onclick="replyList(' + bno + ',' + (pageInfo.startPage-1) + ');">';
			pagenation += ' <span aria-hidden="true">&laquo;</span></a></li>';
		} else {
			pagenation += ' <li class="page-item disabled"><a class="page-link">';
			pagenation += ' <span aria-hidden="true">&laquo;</span></a></li>';
		}	
		for(var i = pageInfo.startPage; i <= pageInfo.endPage; i++) {
			pagenation += '<li class="page-item';
			if(pageInfo.page == i)
				pagenation += ' active';
			pagenation += ' "><a class="page-link" onclick="replyList(' + bno + ',' + i + ');">' + i + '</a></li>';
		}
		if(pageInfo.endPage != pageInfo.totalPage){
			pagenation += '<li class="page-item"><a class="page-link" onclick="replyList(' + bno + ',' + (pageInfo.endPage+1) + ');">';
			pagenation += ' <span aria-hidden="true">&raquo;</span></a></li>';
		} else {
			pagenation += '<li class="page-item disabled"><a class="page-link">';
			pagenation += ' <span aria-hidden="true">&raquo;</span></a></li>';
		}	
		$(".reply-pagenation nav").html(pagenation);
}