<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="top.jsp"%>
<body>
	<div id="wrapper">
		<%@ include file="horizontal-navigation.html"%>
		<%@ include file="vertical-menu.jsp"%>
		<div id="page-wrapper">
			<%-- 	<%@ include file="index.jsp" %> --%>

			<div class='row'>

				<div class='col-lg-12 margin-top-10'>
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="static/important-images/image-slider/slika_1.jpg" alt="Los Angeles">
									<div class="carousel-caption">
							        <h3>Pionir DOO Subotica</h3>
							        <p>Privredno društvo za proizvodnju čokolade, bombona i peciva</p>
							      	</div>
							</div>

							<div class="item">
								<img src="static/important-images/image-slider/slika_2.jpg" alt="Chicago">
									<div class="carousel-caption">
							        <h3>Pionir DOO Subotica</h3>
							        <p>Privredno društvo za proizvodnju čokolade, bombona i peciva</p>
							      	</div>
							</div>

							<div class="item">
								<img src="static/important-images/image-slider/slika_3.jpg" alt="New York">
									<div class="carousel-caption">
							        <h3>Pionir DOO Subotica</h3>
							        <p>Privredno društvo za proizvodnju čokolade, bombona i peciva</p>
							      	</div>
							</div>
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="right carousel-control" href="#myCarousel"
							data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
				<div class='row spacer-top-20'>
					<div class='col-lg-12'>
						<div class='row'>
							<div class='col-lg-3' style='background-color:red; height:200px;'>
							</div>
							<div class='col-lg-3' style='background-color:blue; height:200px;'>
							</div>
							<div class='col-lg-3' style='background-color:green; height:200px;'>
							</div>
						</div>
					</div>
				</div>
					
				</div>

			</div>

		</div>
	</div>
	<%@ include file="scripts.jsp"%>
</body>
</html>