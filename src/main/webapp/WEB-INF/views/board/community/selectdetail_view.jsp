<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<title>커뮤니티 게시판</title>
				<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
				<script src="https://kit.fontawesome.com/58abbffa46.js"></script>
				<script type="text/javascript" src="${contextPath}/resources/js/reply.js"> </script>
				<script src="${contextPath}/resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
				<script src="${contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
				<script type="text/javascript">
					$(document).ready(function () {
						var bnoValue = '<c:out value="${boardDTO.bNo}"/>';
						var replyUL = $(".chat");

						showList(1);
						function showList(page) {
							replyService.getList({ bno: bnoValue, page: page || 1 }, function (list) {
								var str = "";
								if (list == null || list.length == 0) {
									replyUL.html("");
									return;
								}
								for (var i = 0, len = list.length || 0; i < len; i++) {
									str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>";
									str += "<div><div class='header'><strong class='primary-font'>" + list[i].id + "</Strong>";
									str += "<small class='pull-right text-muted'>" + list[i].writeDay + "</small></div>";
									str += "<p>" + list[i].contents + "</p></div></li>";
								}
								replyUL.html(str);
							})
						}

						var modal = $(".modal");
						var modalInputId = modal.find("input[name='id']");
						var modalInputContents = modal.find("input[name='contents']");
						var modalInputReplyData = modal.find("input[name='writeDay']");

						var modalModBtn = $("#modalModBtn");
						var modalRemoveBtn = $("#modalRemoveBtn");
						var modalRegisterBtn = $("#modalRegisterBtn");
						var modalCloseBtn = $("#modalCloseBtn");
						
						modalCloseBtn.on("click",function () {
							modal.modal("hide")
						  })

						// if addREplyBtn click -> show modal
						$("#addReplyBtn").on("click", function (e) {
							modal.find("input").val("");
							modalInputReplyData.closest("div").hide();
							modal.find("button[id !='modalCloseBtn']").hide();
							modalRegisterBtn.show();
							modal.modal("show");
						});

						// if 댓글 click -> show modal
						$(".chat").on("click", "li", function (e) {
							var rno = $(this).data("rno");
							console.log('rno :>> ', rno);
							replyService.get(rno,function (reply) {
								console.log('reply :>> ', reply);
								modalInputId.val(reply.id);
								modalInputContents.val(reply.contents);
								modalInputReplyData.val(reply.writeDay).attr("readonly","readonly");
								modal.data("rno",reply.rno);

								modal.find("button[id !='modalCloseBtn']").hide();
								modalModBtn.show();
								modalRemoveBtn.show();

								modal.modal("show");
							  })
						});

						modalRegisterBtn.on("click", function (e) {
							console.log("123214214");
							var reply = {
								bno: bnoValue,
								id: modalInputId.val(),
								contents: modalInputContents.val()
							};
							replyService.add(reply, function (result) {
								alert(result);
								modal.find("input").val("");
								modal.modal("hide");
								showList(1);
							})
						});

						// if modalmodifyBtn Click -> hide model and showlist
						modalModBtn.on("click", function (e) {
							var reply = {rno:modal.data("rno"), contents: modalInputContents.val()}
							replyService.update(reply,function (result) {
								alert(result);
								modal.modal("hide");
								showList(1);
							})							
						});

						modalRemoveBtn.on("click", function (e) {
							var rno = modal.data("rno");

							replyService.remove(rno,function (result) {
								alert(result);
								modal.modal("hide");
								showList(1);
							  })
						  })
					});

				</script>
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
										<h2 class="text-center mt-4 mb-4">게시글</h2>
									</div>
									<div class="card-body">
										<table class="table">
											<tr>
												<th>게시글 번호</th>
												<td>
													<c:out value="${boardDTO.bNo}" />
												</td>
											</tr>
											<tr>
												<th>조회수</th>
												<td>
													<c:out value="${boardDTO.readCount}" />
												</td>
											</tr>
											<tr>
												<th>작성일</th>
												<td>
													<c:out value="${boardDTO.writeDay}" />
												</td>
											</tr>
											<tr>
												<th>작성자</th>
												<td>
													<c:out value="${boardDTO.id}" />
												</td>
											</tr>
											<tr>
												<th>제목</th>
												<td>
													<c:out value="${boardDTO.title}" />
												</td>
											</tr>
										</table>
										<hr />
										<div class="col-12">
											<c:out value="${boardDTO.contents}" />
										</div>

										<div class="row">
											<div class="col-lg-12">

												<div class="pannel pannel-default">
													<div class="pannel-heading">
														<i class="fa fa-comments fa-fw"></i> 댓글
													</div>

													<div class="pannel-body">
														<ul class="chat">
															<!-- Start Reply -->
															<li class="left clearfix" data-rno='12'>
																<div>
																	<div class="header">
																		<strong class="primary-font">user00</strong>
																		<small class="pull-right text-muted">2018-01-01
																			13:13</small>
																	</div>
																	<p>good job</p>
																</div>
															</li>
															<!-- end Reply-->
														</ul>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-12 text-right">
												<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">댓글 달기</button>
												<input type="button" value="글수정" class="btn btn-success"
													onclick="location.href='./update?bNo=${boardDTO.bNo}&id=${boardDTO.id}'">
												<input type="button" value="글삭제" class="btn btn-warning"
													onclick="location.href='./delete?bNo=${boardDTO.bNo}&id=${boardDTO.id}'">
												<button type="button" class="btn btn-primary"
													onclick="location.href='./select_all_view'">전체 게시글보기</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
						aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">댓글</h4>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label>Reply</label>
										<input class="form-control" name='contents' value='New Reply!!!!'>
									</div>
									<div class="form-group">
										<label>Replyer</label>
										<input class="form-control" name='id' value='replyer'>
									</div>
									<div class="form-group">
										<label>Reply Date</label>
										<input class="form-control" name='writeDay' value='2018-01-01 13:13'>
									</div>

								</div>
								<div class="modal-footer">
									<button id='modalModBtn' type="button" class="btn btn-warning">수정</button>
									<button id='modalRemoveBtn' type="button" class="btn btn-danger">삭제</button>
									<button id='modalRegisterBtn' type="button" class="btn btn-primary">등록</button>
									<button id='modalCloseBtn' type="button" class="btn btn-default">닫기</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->

					<!-- Footer -->

					<%@ include file="../../include/footer.jsp" %>

						<!-- Footer -->
			</body>

			</html>