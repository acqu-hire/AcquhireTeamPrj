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
				<title>Community 작성</title>
				<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css">
				<script src="${contextPath}/resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
				<script src="${contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
				<script src="https://kit.fontawesome.com/58abbffa46.js"></script>
				<style>
					.uploadResult {
						width:100%;
					}
					.uploadResult ul
					{
						display: flex;
						flex-flow: row;
						justify-content: center;
						align-items: center;
					}
					.uploadResult ul li
					{
						list-style: none;
						padding : 10px;
					}
					.uploadResult ul li img
					{
						width: 20px;
						height: 20px;
					}
				</style>
				<script>
					$(document).ready(function () {


						function checkExtension(fileName, fileSize) {
							var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
							var maxSize = 5242880; // 5MB

							if (fileSize >= maxSize) {
								alert("파일 사이즈 초과");
								return false;
							}
							if (regex.test(fileName)) {
								alert("해당 종류의 파일은 업로드할 수 없습니다.")
								return false;
							}
							return true;
						}

						var clonObj = $(".uploadDiv").clone();

						$("#uploadBtn").on("click", function () {

							var formData = new FormData();

							var inputFile = $("input[name='files']");
							
							var files = inputFile[0].files;
							
							console.log('files :>> ', files);

							for (var i = 0; i < files.length; i++) {
								if (!checkExtension(files[i].name, files[i].size)) {
									return false;
								}
								formData.append("files", files[i]);
							}
							$.ajax({
								url: "/uploadAjaxAction",
								processData: false,
								contentType: false,
								data: formData,
								type: "post",
								dataType: "json",
								success: function (result) {
									console.log('result :>> ', result);
									ShowUploadedFile(result)
									$(".uploadDiv").html(clonObj.html());
								}
							});
						});

						var uploadResult = $(".uploadResult ul");
						function ShowUploadedFile(uploadResultArr) {

							var str = "";

							$(uploadResultArr).each(function (i, obj) {
								if (!obj.image) {
									str += "<il><img src='${contextPath}/resources/img/attach.png'>" + obj.fileName + "</li>";
								}
								else { 
									var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
									str += "<il>" + obj.fileName + "</il>";
									str += "<il><img src='/display?fileName="+fileCallPath+"'></li>";
								}
							});
							uploadResult.append(str);
						}
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
										<h2 class="text-center mt-4 mb-4">
											<strong>커뮤니티 작성</strong>
										</h2>
									</div>
									<div class="card-body">
										
											<div class="uploadDiv">
												<input type="file" name="files" multiple>
											</div>

											<div class="uploadResult">
												<ul>

												</ul>
											</div>
											<button id="uploadBtn">Upload</button>

										<form method="post" enctype="multipart/form-data">
											<table class="table table-striped">
												<tr>
													<th>카테고리</th>
													<td>
														<div class="input-group mx-auto">
															<label for="category"></label>
															<div class="col-xs-2">
																<select name="category" class="form-control">
																	<option value="">==카테고리선택==</option>
																	<option value="COMMUNITY_LIFE">사는 얘기</option>
																	<option value="COMMUNITY_GROUP">모임&스터디</option>

																</select>
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<th>작성자</th>
													<td><input type="text" class="form-control" name="id" value="admin"
															readonly></td>
												</tr>
												<tr>
													<th>제목</th>
													<td><input type="text" class="form-control" name="title"></td>
												</tr>
												<tr>
													<th>첨부파일</th>
													<td>
													</td>
												</tr>
												<tr>
													<td>글내용</td>
													<td><textarea rows="10" cols="50" name="contents"
															class="form-control"></textarea></td>
												</tr>
												<tr>
													<td colspan="2" class="text-right">
														<input type="submit" value="글쓰기" class="btn btn-success">
														<input type="reset" value="다시작성" class="btn btn-warning">
														<button type="button" class="btn btn-primary"
															onclick="location.href='./select_all_view'">전체
															게시글보기</button>
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

						<!-- Footer -->
						<script type="text/javascript">
							// $(function () {
							// 	$("form").submit(function () {
							// 		if ($("select[name='category']").val() == "") {
							// 			alert("카테고리를 선택해주세요.")
							// 			return false;
							// 		};
							// 		if (!$("input[name='title']").val()) {
							// 			alert("제목을 입력하세요.")
							// 			return false;
							// 		}
							// 		if (!$("textarea[name='contents']").val()) {
							// 			alert("내용을 입력하세요.")
							// 			return false;
							// 		}
							// 	})
							// });
						</script>
			</body>

			</html>