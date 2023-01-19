$(function(){

	replyList(bNo); // 댓글 전체조회
	
	$("#regReplyBtn").on("click", function() {
		var contents = $("#replyContents").val();
		if(contents.trim() == "") {
			alert("댓글의 내용을 입력해주세요.")
			return;
		}
		var replyCnt = $("span.reply-tab").text();
		$.ajax({
			type : "POST",
			url : "/listDetail/reply?bNo=" + bNo,
			headers : {"content-type" : "application/json"},
			data : JSON.stringify({
						contents : contents,
						 id  : sessionId
						 }),
			success : function(result) {
				$("span.reply-tab").text(replyCnt.replace(replyCnt, "댓글목록("+result+")"));
				$("#replyContents").val("");
				replyList(bNo);
			},
			error : function() {
				alert("error");
			}
		}) // ajax
	})


$(document).on("click","#replyRemove",function() {
	var rno = $(this).data("rno");
	var replyCnt = $("span.reply-tab").text();
	if(sessionId == writer) {
		if(!confirm("댓글을 삭제하시겠습니까?")) return;
		$.ajax({
			type : "DELETE",
			url : "/listDetail/reply/"+rno+"?bNo="+bNo,
			headers : {"content-type" : "application/json"},
			data : JSON.stringify({
				rno : rno
			}),
			success : function(result) {
				$("span.reply-tab").text(replyCnt.replace(replyCnt, "댓글목록("+result+")"));
				replyList(bNo);
			},
			error : function() {
				alert("error!!");
			}
		}) // ajax
	} else {
		alert("삭제할 권한이 없습니다.");
	}	 
})
})
var replyList = function(bNo) {
	$.ajax({
		type : "GET",
		url : "/listDetail/reply?bNo="+ bNo,
		success : function(data) {
			if(data!=""){
				var list = '<div class="card mt-2">';
				$.each(data, function(index, data) {
					list += ' <div class="card-header p-2 bg-dark text-light" data-rno=' + data.rno + '>';
				  	list += ' <table>';
					list +=	' <tbody>';
					list += ' <tr class="align-middle">';
					list += ' <td rowspan="2" class="pr-2"><i class="fa fa-user-o fa-2x"></i></td>';				 	    
					list += ' <td class="ml">' + data.id + '</td>';
					list += ' </tr>';
					list += ' <tr>';
					list += ' <td>';
					list += ' <font size="2">' + data.writeDay + '</font>'; 
					list += ' <span style="cursor:pointer" id="replyRemove" data-rno=' + data.rno +' data-writer=' + data.id + '>';
					list += ' <i class="fa fa-window-close fa" aria-hidden="true"></i></span> ';
					list += ' </td>';
					list += ' </tr>';
					list += ' </tbody>';
				  	list += ' </table>';
			    	list += ' </div>';
			 	    list += ' <div class="card-body" data-rno=>';
					list += ' <p class="card-text">' + data.contents + '</p>';
					list += ' <span class="badge badge-dark" style="cursor:pointer"><a onclick="javascript:showReReplyArea(176,126);">답글</a></span>';
					list += ' </div>';
					list += ' </div>';
				});
				$(".reply-inline").html(list);
			} else {
				$(".reply-inline").html("등록된 댓글이 없습니다.");
			}},
		error : function () {
			alert('error!!');
		}
	}) // ajax
}
