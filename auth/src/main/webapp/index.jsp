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
				<div class="col-lg-12">
					<h4 class="page-header">Evidencija proizvoda i robe (Records of goods and packaging) </h4>
				</div>
				<div class='col-lg-12 '>
					<div class='row spacer-bottom'>
						<div class='col-lg-12'>
							<%@ include file="carousel.html"%>
						</div><!-- end of col-lg-12 for slider -->
					</div><!-- end of row for slider -->
					<div class='row border-bottom margin-top-10'>
							
					</div>
					<div class='row padding-align-15px text-center margin-top-10'>
						<div class='col-lg-3 col-lg-offset-1 thumbnail-border'>
							<div class='row border-bottom thumbnail-header'>
								<div class='col-lg-12'>
<!-- 									<h4>Prijemnice</h4> -->
								</div>
							</div>
							<div class='row'>
								<div class='col-lg-12 margin-top-bottom-40'>
									<a href='#' class='thumbnail-link'><i class="fa fa-file-o thumbnail-icon-size" aria-hidden="true"></i><br />Prijemnice</a>
								</div>
							</div>
						</div><!-- end of col-lg-4 for content -->
						<div class='col-lg-3 col-lg-offset-1 thumbnail-border margin-thumbnail-align'>
							<div class='row border-bottom thumbnail-header'>
								<div class='col-lg-12'>
<!-- 									<h4>Otpremnice</h4> -->
								</div>
							</div>
							<div class='row'>
								<div class='col-lg-12 margin-top-bottom-40'>
									<a href='#' class='thumbnail-link'><i class="fa fa-file-o thumbnail-icon-size" aria-hidden="true"></i><br />Otpremnice</a>
								</div>
							</div>
						</div><!-- end of col-lg-4 for content -->
						<div class='col-lg-3 thumbnail-border'>
							<div class='row border-bottom thumbnail-header'>
								<div class='col-lg-12'>
<!-- 									<h4>Pregled magacina</h4> -->
								</div>
							</div>
							<div class='row'>
								<div class='col-lg-12 margin-top-bottom-40'>
									<a href='#' class='thumbnail-link'><i class="fa fa-file-o thumbnail-icon-size" aria-hidden="true"></i><br />Pregled magacina</a>
								</div>
							</div>		
						</div><!-- end of col-lg-4 for content -->
					</div>
				</div>
		</div><!-- end of page wrapper -->
	</div>
	</div><!-- end of wrapper -->
	
	<%@ include file="scripts.jsp"%>
</body>
</html>