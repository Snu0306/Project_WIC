<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="resource/style/bootstrap-grid.css">
<link rel="stylesheet" href="resource/style/bootstrap.min.css">
<link rel="stylesheet" href="resource/style/bootstrap-utilities.css">
<link rel="stylesheet" href="resource/style/top-style.css">
<link rel="stylesheet" href="resource/style/bottom-style.css">
</head>
<style>
.section {
	margin-top: 10%;
	margin-bottom: 10%;
}

.container {
	
}

.nav-item-right {
	display: flex;
	flex-direction: row-reverse;
}

.nav-item {
	padding: 2%;
}

.logos {
	text-align: center;
	padding: 5%;
}

.search_wrap {
	text-align: center;
	color: gray;
}

.text {
	width: 70%;
}

.img {
	display: grid;
}

.col-md-2 {
	border: 1px solid gray;
}

.cercle {
	width: 150px;
	height: 150px;
	border-radius: 50%
}

.pictop5 {
	border-radius: 50%;
}
</style>

<body>
	<jsp:include page="/WEB-INF/views/common/Top.jsp"></jsp:include>

	<div class="section">
		<div class="container mt-4 mx-auto">
			<div class="row">
				<div class="col-6 ">
					<div class="logos">
						<div class="col-12">
							<h1>
								What's In Your <br>Closet
							</h1>
						</div>
					</div>
					<div class="search_wrap">
						<input class="text" type="text" name="search"> <input
							type="button" value="검색" onclick="">
					</div>
				</div>
				<div class="col-6 justify-content-between">
					<div class="img">

						<div id="carouselExampleIndicators" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carouselExampleIndicators" data-slide-to="0"
									class="active"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
								<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="resource/image/Main_IMG2.jpg" class="d-block w-100"
										alt="...">
								</div>
								<div class="carousel-item">
									<img src="resource/image/Main_IMG3.jpg" class="d-block w-100"
										alt="...">
								</div>
								<div class="carousel-item">
									<img src="resource/image/Main_IMG4.jpg" class="d-block w-100"
										alt="...">
								</div>
							</div>
							<a class="carousel-control-prev"
								href="#carouselExampleIndicators" role="button"
								data-slide="prev"> <span class="carousel-control-prev-icon"
								aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
							</a> <a class="carousel-control-next"
								href="#carouselExampleIndicators" role="button"
								data-slide="next"> <span class="carousel-control-next-icon"
								aria-hidden="true"></span> <span class="visually-hidden">Next</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="section">
	<div class="container  mx-auto">
		<div class="row">
			<div class="col-md-2 mx-2 ">
				<div class="cercle mx-auto">
					<img src="resource/image/Main_IMG_5.jpg"
						class=" pictop5 w-100 h-100 ">
						<p>현빈</p>
				</div>
				<p class="text-center"></p>
			</div>
			<div class="col-md-2 mx-2">
				<div class="cercle mx-auto">
					<img src="resource/image/Main_IMG_1.jpg"
						class="pictop5 w-100 h-100 ">
				</div>
			</div>
			<div class="col-md-2 mx-2">
				<div class="cercle mx-auto">
					<img src="resource/image/Main_IMG_4.jpg"
						class="pictop5 w-100 h-100 ">
				</div>
			</div>
			<div class="col-md-2 mx-2">
				<div class="cercle mx-auto">
					<img src="resource/image/Main_IMG_2.jpg"
						class="pictop5 w-100 h-100 ">
				</div>
			</div>
			<div class="col-md-2 mx-2">
				<div class="cercle mx-auto">
					<img src="resource/image/Main_IMG_3.jpg"
						class="pictop5 w-100 h-100 ">
				</div>
			</div>
		</div>


		</div>
	</div>
	
	



	<jsp:include page="/WEB-INF/views/common/Bottom.jsp"></jsp:include>
</body>
</html>