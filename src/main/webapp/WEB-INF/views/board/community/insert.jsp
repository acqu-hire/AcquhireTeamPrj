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
						width: 100%;
					}

					.uploadResult ul {
						display: flex;
						flex-flow: row;
						justify-content: center;
						align-items: center;
					}

					.uploadResult ul li {
						list-style: none;
						padding: 10px;
						align-content: center;
						text-align: center;
					}

					.uploadResult ul li img {
						width: 100px;
					}

					.uploadResult ul li span {
						color: rgb(0, 0, 0);
					}

					.bigPictureWrapper {
						position: absolute;
						display: none;
						justify-content: center;
						align-items: center;
						top: 0%;
						width: 100%;
						height: 100%;
						background-color: gray;
						z-index: 100;
						background-color: rgba(255, 255, 255, 0.5);
					}

					.bigPicture {
						position: relative;
						display: flex;
						justify-content: center;
						align-items: center;
					}

					.bigPicture img {
						width: 600px;
					}
				</style>
				<script type="text/javascript">
					function showImage(fileCallPath) {
						$(".bigPictureWrapper").css("display", "flex").show();
						$(".bigPicture").html("<img src='/display?fileName=" + encodeURI(fileCallPath) + "'>").animate({ width: '100%', height: '100%' }, 1000);
					}

					$(document).ready(function () {

						var formObj = $("#postform");
						console.log('formObj :>> ', formObj);
						$("input[type='submit']").on("click", function () {
							var str = "";

								$(".uploadResult ul li").each(function (index, obj) {
								var jobj = $(obj);
								console.dir(jobj);
								str += "<input type='hidden' name='attachList["+index+"].fileName' value='"+jobj.data("filename")+"'>";
								str += "<input type='hidden' name='attachList["+index+"].uuid' value='"+jobj.data("uuid")+"'>";
								str += "<input type='hidden' name='attachList["+index+"].uploadPath' value='"+jobj.data("path")+"'>";
								str += "<input type='hidden' name='attachList["+index+"].fileType' value='"+jobj.data("type")+"'>";
							});
							console.log('str :>> ',str);
							formObj.append(str).submit();
						});

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

						$(".uploadResult").on("click", "span", function () {
							var targetFile = $(this).data("file");
							var type = $(this).data("type");
							var targetLi = $(this).closest("li");
							$.ajax({
								url: "/deleteFile",
								data: {
									fileName: targetFile,
									type: type
								},
								dataType: "text",
								type: "post",
								success: function (result) {
									alert(result)
									targetLi.remove();
								}
							});
						});

						$("#uploadBtn").on("click", function () {
							var clonObj = $(".uploadDiv").clone();

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

						function ShowUploadedFile(uploadResultArr) {
							var uploadResult = $(".uploadResult ul");

							var str = "";

							$(uploadResultArr).each(function (i, obj) {
								if (obj.image) {
									var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
									str += "<li data-path='" + obj.uploadPath + "'";
									str += " data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.image + "'";
									str += "><div>";
									str += "<span> " + obj.fileName + "</span>";
									str += "<button type = 'button' data-file=\'" + fileCallPath + "\'";
									str += "data-type='image' class='btn btn-warning btn-circle'>";
									str += "<i class='fa fa-times'></i></button><br>";
									str += "<img src='/display?fileName=" + fileCallPath + "'></a>";
									str += "</div></li>";
								}
								else {
									var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
									var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");

									str += "<li data-path='" + obj.uploadPath + "'";
									str += " data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.image + "'";
									str += "><div>";
									str += "<span> " + obj.fileName + "</span>";
									str += "<button type = 'button' data-file=\'" + fileCallPath + "\'";
									str += "data-type='file' class='btn btn-warning btn-circle'>";
									str += "<i class='fa fa-times'></i></button><br>";
									str += "<img src='${contextPath}/resources/img/attach.png'>";
									str += "</div></li>";
								}
							});
							uploadResult.append(str);
						}

						$(".bigPictureWrapper").on("click", function () {
							$(".bigPicture").animate({ width: '0%', height: '0%' }, 1000);
							setTimeout(() => {
								$(this).hide();
							}, 1000);
						});
					});
				</script>
			</head>

			<body>
				<div class="bigPictureWrapper">
					<div class="bigPicture">

					</div>
				</div>
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

										<form method="post" id="postform" action="./insert_view" enctype="multipart/form-data">
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
														<input type="button" value="전체 게시글 보기"class="btn btn-primary" onclick="location.href='./select_all_view'">
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