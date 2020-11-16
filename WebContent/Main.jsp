<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,700,900">
<link rel="stylesheet" href="resource/style/bootstrap-grid.css">
<link rel="stylesheet" href="resource/style/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="resource/javascript/bootstrap.min.js"></script>
<link rel="stylesheet" href="resource/style/top-style.css">
<link rel="stylesheet" href="resource/style/bottom-style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">
<script type="text/javascript">
</script>
</head>
<style>
.section {
	margin-top: 10%;
	margin-bottom: 10%;
}

.search {
	position: absolute;
	left: 0;
	right: 0;
	padding: 20px 0;
	text-align: center;
	box-shadow: 0 5px 5px rgba(0, 0, 0, . 1);
	margin-bottom: 20%;
}

.search input[type="text"] {
	height: 40px;
	border: none;
	border-bottom: 1px solid #34404b;
	width: 540px;
	display: inline-block;
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
	
}

.cercle {
	width: 150px;
	height: 150px;
	border-radius: 50%
}

.pictop5 {
	border-radius: 50%;
}

p .{
	text-align: center;
}
</style>


<body>
	<header>
		<%@ include file="/WEB-INF/views/common/Top.jsp"%>
	</header>
	<div id="carouselExampleFade" class="carousel slide"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="resource/image/Title1.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="resource/image/Title2.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="resource/image/Title4.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="resource/image/Title3.jpg" class="d-block w-100" alt="...">
			</div>
			
		</div>
		<a class="carousel-control-prev" href="#carouselExampleFade"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleFade"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="visually-hidden">Next</span>
		</a>
	</div>

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
					<form action="<%=request.getContextPath()%>/ProductSearchPage.Pd" method="get">
						<div class="search_wrap">
							<input class="text" id="productName" type="text" name="search"> 
							<button type="submit">search</button>
							<input type="button" value="검색" >
						</div>
					</form>
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
									<img src="resource/image/Main_IMG1.jpg" class="d-block w-100"
										alt="1">
								</div>
								<div class="carousel-item">
									<img src="resource/image/Main_IMG2.jpg" class="d-block w-100"
										alt="1">
								</div>
								<div class="carousel-item">
									<img src="resource/image/Main_IMG3.jpg" class="d-block w-100"
										alt="1">
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
		<!-- <div class="search">
		<form   action="#" method="get">
			<input class="text" type="text" name="search"> 
			<input type="button" value="검색" onclick="">
		</form>
	</div> -->
	</div>

	<div class="section">
		<div class="container  mx-auto ">
			<h1 class="text-center mb-4"> TOP 5 </h1>
			<div class="row justify-content-between">
				<c:set var="Top5" value="${requestScope.Top5 }"/>
				<c:forEach var="member" items="${Top5 }">
				<div class="col-md-2 mx-2">
					<div class="cercle mx-auto">
						<img src="upload/${member.profile_pic }"
							class="pictop5 w-100 h-100 ">
				<a href="<%=request.getContextPath() %>/"></a>		<p class="text-center mt-2">${member.name }</p>
					</div>
				</div>
				</c:forEach>
				
			</div>


		</div>
	</div>




	<%@ include file="/WEB-INF/views/common/Bottom.jsp"%>

</body>
</html>