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
					<h2 class="page-header">Parametri izveštaja</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class='panel panel-default'>
						<div class='panel-heading'>*</div>
						<div class='panel-body'>
							<div class='row'>
								<div class='col-lg-6'>


									<form action="/add_article_session_parameter.html">
										<div>
											<label for="allArticles1">Article: </label> <input
												list="allArticles1" name="id_roba" multiple autofocus="true"
												placeholder='Insert article'>
											<datalist id="allArticles1">
												<c:forEach items="${allArticles}" var="article">
													<option value="${article.id}">${article.code}
														${article.name}</option>
												</c:forEach>
											</datalist>
										</div>

										<input type="submit">
									</form>

									<form action="/add_warehouse_session_parameter.html">
										<div>
											<label for="allWarehouses">Warehouse: </label> <input
												list="allWarehouses" name="id_magacin" multiple 
												placeholder='Insert warehouses'>
											<datalist id="allWarehouses">
												<c:forEach items="${allWarehouses}" var="warehouse">
													<option value="${warehouse.id}">${warehouse.code}
														${warehouse.name}</option>
												</c:forEach>
											</datalist>
										</div>

										<input type="submit">
									</form>

									<form method="POST" action="find_article_for_warehouse.html">

<!-- 										<div> -->
<!-- 											<label for="allArticles">Article: </label> <input -->
<!-- 												list="allArticles" name="id_roba" multiple autofocus="true" -->
<!-- 												placeholder='Insert article'> -->
<!-- 											<datalist id="allArticles"> -->
<%-- 												<c:forEach items="${allArticles}" var="article"> --%>
<%-- 													<option value="${article.id}">${article.code} --%>
<%-- 														${article.name}</option> --%>
<%-- 												</c:forEach> --%>
<!-- 											</datalist> -->
<!-- 										</div> -->

<!-- 										<div> -->
<!-- 											<label for="allWarehouses">Warehouse: </label> <input -->
<!-- 												list="allWarehouses" name="id_magacin" -->
<!-- 												placeholder='Insert warehouse'> -->
<!-- 											<datalist id="allWarehouses"> -->

<%-- 												<c:forEach items="${allWarehouses}" var="warehouse"> --%>
<%-- 													<option value="${warehouse.id}">${warehouse.code} --%>
<%-- 														${warehouse.name}</option> --%>
<%-- 												</c:forEach> --%>
<!-- 											</datalist> -->
<!-- 										</div> -->

										<select name="select1[]" size="10" multiple="multiple"
											tabindex="1">

											<c:forEach items="${izabraneVrednostiMagacini}"
												var="izabraneVrednostiMagacini">
												<option value="${izabraneVrednostiMagacini.id}" selected> 
													${izabraneVrednostiMagacini.code} ${izabraneVrednostiMagacini.name}</option>
											</c:forEach>

										</select>
										
										<select name="select2[]" size="10" multiple="multiple"
											tabindex="1">

											<c:forEach items="${izabraneVrednostiArtikli}"
												var="izabraneVrednostiArtikli">
												<option value="${izabraneVrednostiArtikli.id}" selected> 
													${izabraneVrednostiArtikli.code} ${izabraneVrednostiArtikli.name}</option>
											</c:forEach>

										</select>

										<button type="submit" class="btn-lg button-novi">
											<i class='fa fa-floppy-o'></i> Save
										</button>
										<button type="reset" class="btn-lg button-novi">
											<i class='fa fa-reply'></i> Cancel
										</button>

									</form>
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
</body>
</html>