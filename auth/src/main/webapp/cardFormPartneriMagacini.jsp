<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="top.jsp"%>

<body>

	<div id="wrapper">
		<%@ include file="horizontal-navigation.html"%>
		<%@ include file="vertical-menu.jsp"%>

		<div id="page-wrapper">

			<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">Parametri izveštaja Artikal Partner Magacin</h2>
				</div>
															<c:forEach items="${izabraneVrednostiPartneriPma}"
																var="izabraneVrednostiPartneriPma">
																	${izabraneVrednostiPartneriPma.code}
																	${izabraneVrednostiPartneriPma.name} vvvvv"/>
															</c:forEach>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class='panel panel-default'>
						<div class='panel-heading'>*</div>
						<div class='panel-body'>

							<div class='row'>

								<div class='col-lg-12'>

									<div class='row'>
									
										<div class='col-lg-5' id='input-warehouse-article'>

											<form action="/add_articlep_session_parameter_pma.html">
												<div class='row'>
													<div class='col-lg-6'>
														<label for="allArticles1">Article: </label> 
														<input class='input-warehouse-article form-control'
															list="allArticles1" name="id_roba" multiple
															autofocus="true" placeholder='Insert article' autocomplete='off'>
														<datalist id="allArticles1">
															<c:forEach items="${allArticles}" var="article">
																<option value="${article.id}">${article.code}
																	${article.name}</option>
															</c:forEach>
														</datalist>
													</div>
													<div class='col-lg-6'> <br/>
													<button type="submit" class="btn-lg button-novi">
														<i class='glyphicon glyphicon-plus'></i> Dodaj artikal
													</button>
													</div>
												</div>

											</form>


											<form action="/add_partner_session_parameter_pma.html">
												<div class='row'>
													<div class='col-lg-6'>

														<label for="allWarehouses">Partner: </label> 
														<input class='input-warehouse-article form-control'
															list="allWarehouses" name="id_magacin" multiple
															placeholder='Insert warehouses' autocomplete='off'>
														<datalist id="allWarehouses">
															<c:forEach items="${allWarehouses}" var="warehouse">
																<option value="${warehouse.id}">${warehouse.code}
																	${warehouse.name}</option>
															</c:forEach>
														</datalist>
													</div>
													
													<div class='col-lg-6'> <br/>
													
													<button type="submit" class="btn-lg button-novi">
														<i class='glyphicon glyphicon-plus'></i> Dodaj partnera
													</button>
													</div>
												</div>
											</form>

										</div>




										<div class='col-lg-7'>
											<div class='row' id='selected-warehouse-articles'>

												<form method="POST" action="find_article_for_warehouse.html">
													<div class='col-lg-6'>
													
													<div class='row'> 
													<div class='col-lg-8'>
													<h4>Selected partners</h4>
													</div>
													</div>
													
													<div class='row'>
													<div class='col-lg-8'>
														<select name="select1" size="10" multiple="multiple"
															tabindex="1">

															<c:forEach items="${izabraneVrednostiPartneriPma}"
																var="izabraneVrednostiPartneriPma">
																<option value="${izabraneVrednostiPartneriPma.id}" selected>
																	${izabraneVrednostiPartneriPma.code}
																	${izabraneVrednostiPartneriPma.name}</option>
															</c:forEach>

														</select>
														</div>
													<div class='col-lg-4'>
													<button type="submit" class="btn-lg button-novi inline-button" name="action" value="cancel-partner-magacin">
														<i class='glyphicon glyphicon-minus'></i> 
													</button>
													</div>
													</div>
													</div>

													<div class='col-lg-6'>
													
													<div class='row'> 
													<div class='col-lg-8'>
													<h4>Selected articles</h4>
													</div>
													</div>
													
													<div class='row'>
													<div class='col-lg-8'>
														<select name="select2" size="10" multiple="multiple"
															tabindex="1"  class="inline-button">

															<c:forEach items="${izabraneVrednostiArtikliPma}"
																var="izabraneVrednostiArtikliPma">
																<option value="${izabraneVrednostiArtikliPma.id}" selected>
																	${izabraneVrednostiArtikliPma.code}
																	${izabraneVrednostiArtikliPma.name}
															     </option>
															</c:forEach>

														</select>
														</div>
														<div class='col-lg-4'>
													<button type="submit" class="btn-lg button-novi inline-button" name="action" value="cancel-articlep-magacin">
														<i class='glyphicon glyphicon-minus'></i> 
													</button>
													</div>
													</div>
													</div>
											</div>
											
											<div class='row spacer-top-20' >
											<div class='col-lg-6'>
											<label for="oddana">Od dana: </label>
												<input id="oddana" type="date" name="oddana" class='form-control' value='${currentdate}'>
											</div>
											<div class='col-lg-6'>
											<label for="dodana">Do dana: </label>
												<input id="dodana" type="date" name="dodana" class='form-control' value='${currentdate}'>
											</div>																						 
											</div>
											
											<div class='row text-center spacer-top-20'>
												<div class='col-lg-12'>
													<button type="submit" formtarget="_blank" class="btn-lg button-novi" name="action" value="main-submit-artical-partner-magacin">
														<i class='fa fa-floppy-o'></i> Izvestaj
			
													</button>
<!-- 													<button type="reset" class="btn-lg button-novi"> -->
<!-- 														<i class='glyphicon glyphicon-remove'></i> Reset -->
<!-- 													</button> -->
													<button class="btn-lg button-novi" onclick="goBack()" name="action" value="mainPage">Go Back</button>
												</div>
												
												</form>
												
											</div>

										</div>
										


										
									</div>
								</div>

							</div>
							
							<div class='row'>
							<div class='col-lg-12'>
										<% if( request.getSession().getAttribute("ev") != null)
											{
											%>
											<h4 class="error-text">
												<c:out value='${sessionScope.ev}'/>
											</h4>
										<%	
										session.setAttribute("ev", null);	
										System.out.printf("hello");
											}
 										%>
 										
							</div>
							</div>
							
						</div>
					</div>
					<!-- end of panel -->
				</div>
			</div>

		</div>

	</div>

	<%@ include file="scripts.jsp"%>
	
	<script>
		function goBack() {
    	window.history.back()
	}
	</script>
</body>
</html>