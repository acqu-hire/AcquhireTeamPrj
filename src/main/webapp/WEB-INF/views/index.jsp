<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="<c:url value='../resources/img/fabicon.ico'/>" type="image/x-icon"/>
<meta charset="UTF-8">
<title>Acq-Hire</title>
</head>

<style>
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  position: relative;
  margin: auto;
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.dot_active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  animation-name: fade;
  animation-duration: 2.5s;
}

.col-md-8{
	margin : 0 auto;
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}


</style>


<body>

	<!-- Header -->

	<%@ include file="include/header.jsp"%>

	<!-- Header -->

	<section>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="row align-items-center">
						<div class="col-md-8">
								<div class="slideshow-container">
									<div class="mySlides fade">
									
										<div class="numbertext">1 / 3</div>
										<a href="#">
										<img src="../resources/img/banner2.png" style="width: 100%">
										</a>
									</div>

									<div class="mySlides fade">
										<div class="numbertext">2 / 3</div>
										<a href="#">
										<img src="../resources/img/banner1.png" style="width: 100%">
										</a>
									</div>

									<div class="mySlides fade">
										<div class="numbertext">3 / 3</div>
										<a href="#">
										<img src="../resources/img/banner3.png" style="width: 100%">
										</a>
									</div>
								</div>
								<div style="text-align: center">
									<span class="dot"></span>
									<span class="dot"></span>
									<span class="dot"></span>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section>
		<div class="row align-items-center justify-content-center">

			<div class="col-md-2 " style="background-color: rgb(108, 177, 241);">
			<b>공지사항</b>
			<div>가나다라마바사아자차카타파낭ㄴ망남ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</div>
			</div>
			<div class="col-md-2" style="background-color: rgb(156, 224, 128);">커뮤니티</div>
			<div class="col-md-2" style="background-color: rgb(161, 147, 245);">QNA</div>
			<div class="col-md-2" style="background-color: rgb(156, 224, 128);">이벤트</div>
		</div>
	</section>
	<!-- Footer -->

	<%@ include file="include/footer.jsp"%>

	<!-- Footer -->
	<c:if test="${!empty param.msg}">
		<script>alert("${param.msg}")</script>
	</c:if>
	
	<script>
let slideIndex = 0;
showSlides();

function showSlides() {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" dot_active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " dot_active";
  setTimeout(showSlides, 3000); // Change image every 3 seconds
}
</script>
</body>
</html>