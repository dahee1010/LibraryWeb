<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/imageslide.css">
</head>
<body>
	<section>

		<div id="homepage-slider" class="st-slider">
		
		<input type="radio" class="cs_anchor radio" name="slider" id="slide1" />
		<input type="radio" class="cs_anchor radio" name="slider" id="slide2" />
		<input type="radio" class="cs_anchor radio" name="slider" id="slide3" />
		<input type="radio" class="cs_anchor radio" name="slider" id="play1" checked="" />

			<div class="images">
				<div class="images-inner">
					<div class="image-slide">
						<img src="css/main1.png" alt="main1" width="100%">
					</div>

					<div class="image-slide">
						<img src="css/main2.png" alt="main2" width="100%">

					</div>
					<div class="image-slide">
						<img src="css/main3.png" alt="main2" width="100%">
					</div>
				</div>
			</div>

			<div class="labels">
				<label for="slide1" class="label"></label>
				<label for="slide2" class="label"></label>
				<label for="slide3" class="label"></label>

				<div class="fake-radio">
					<label for="slide1" class="radio-btn"></label>
					<label for="slide2" class="radio-btn"></label>
					<label for="slide3" class="radio-btn"></label>
				</div>
			</div>
		</div>
	</section>
</body>
</html>