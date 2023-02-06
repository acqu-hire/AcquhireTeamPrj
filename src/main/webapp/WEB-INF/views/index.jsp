<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
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

.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.title {
  color: grey;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}


.icon{
font-size: 22px;
text-decoration: none;
color: white;
}
.icon :hover {
  opacity: 0.7;
  color: white;
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
						<div class="col-md-8" style="padding : 0;">
								<div class="slideshow-container">
									<div class="mySlides fade">
									
										<div class="numbertext">1 / 3</div>
										<a href="#">
										<img src="./resources/img/banner2.png" style="width: 100%">
										</a>
									</div>

									<div class="mySlides fade">
										<div class="numbertext">2 / 3</div>
										<a href="#">
										<img src="./resources/img/banner1.png" style="width: 100%">
										</a>
									</div>

									<div class="mySlides fade">
										<div class="numbertext">3 / 3</div>
										<a href="#">
										<img src="./resources/img/banner3.png" style="width: 100%">
										</a>
									</div>
								</div>
								<div style="text-align: center; padding:15px 0;">
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

			<!-- KSH -->
			<div class="col-md-2 ">

				<div class="card">
					<img src="https://avatars.githubusercontent.com/u/117618309?v=4" alt="image" style="width: 100%;">
					<h1><b>KSH</b></h1>
					<p class="title">PM</p>
					<p>Q&A</p>
					<div style="margin: 15px 0 0 0;">
						<div style="font-size: 18px;"><i class="fa fa-envelope" aria-hidden="true"></i> makemegrowup4@gmail.com </div>
					</div>
					<p>
						<div style="background-color: black; padding: 8px;">
							<a class="icon" href="https://github.com/makemegrowup">
								<i class="fa fa-github"></i>
							</a>
						</div>
					</p>
				</div>	
			</div>
			
			<!-- KDY -->
			<div class="col-md-2 ">

				<div class="card">
					<img src="https://avatars.githubusercontent.com/u/119023832?v=4" alt="image" style="width: 100%;">
					<h1><b>KDY</b></h1>
					<p class="title">PA</p>
					<p>공지사항</p>
					<div style="margin: 15px 0 0 0;">
						<div style="font-size: 18px;"><i class="fa fa-envelope" aria-hidden="true"></i> last_1234@naver.com </div>
					</div>
					<p>
						<div style="background-color: black; padding: 8px;">
							<a class="icon" href="https://github.com/kimdoyeon12"><i class="fa fa-github"></i>
							</a>
						</div>
					</p>
				</div>	
			</div>
			
			<!-- ESG -->
			<div class="col-md-2 ">

				<div class="card">
					<img src="https://avatars.githubusercontent.com/u/114354313?v=4" alt="image" style="width: 100%;">
					<h1><b>ESG</b></h1>
					<p class="title">PL</p>
					<p>커뮤니티</p>
					<div style="margin: 15px 0 0 0;">
						<div style="font-size: 18px;"><i class="fa fa-envelope" aria-hidden="true"></i> e_s_g@naver.com </div>
					</div>
					<p>
						<div style="background-color: black; padding: 8px;">
							<a class="icon" href="https://github.com/Devesg"> <i class="fa fa-github"></i>
							</a>
						</div>
					</p>
				</div>	
			</div>
			
			<!-- PSY -->
			<div class="col-md-2 ">

				<div class="card">
					<img src="https://avatars.githubusercontent.com/u/119025218?v=4" alt="image" style="width: 100%;">
					<h1><b>PSY</b></h1>
					<p class="title">PA</p>
					<p>이벤트</p>
					<div style="margin: 15px 0 0 0;">
						<div style="font-size: 18px;"><i class="fa fa-envelope" aria-hidden="true"></i> wytts6783@naver.com </div>
					</div>
					<p>
						<div style="background-color: black; padding: 8px;">
							<a class="icon" href="https://github.com/ori52"> <i class="fa fa-github"></i>
							</a>
						</div>
					</p>
				</div>	
			</div>
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