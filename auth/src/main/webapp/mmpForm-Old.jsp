<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="top.jsp"%>

<body>

	<div id="wrapper">
		<%@ include file="horizontal-navigation.html"%>
		<%@ include file="vertical-menu.jsp"%>

		<div id="page-wrapper">

			<div class="row">
				<div class="col-lg-6">
					<h6 class="page-header"></h6>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class='panel panel-default'>
						<div class='panel-heading'>${title}</div>
						<div class='panel-body'>

							<div class='row'>
								<div class='col-lg-6'>

									<form:form method="POST" action="save_mmp.html"
										modelAttribute="dokument">

										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />

										<form:input type="hidden" name="id" path="id"
											value="${dokument.id}" />

										<%-- 										<div class='form-group ${error != null ? 'has-error' : ''}'> --%>
										<!-- 											<label class='font-oxygen'>Šifra dokumenta</label> -->

										<%-- 											<form:input type="text" class="form-control " name="idVrstaDokumenta" --%>
										<%-- 												path="idVrstaDokumenta" value="${dokument.idVrstaDokumenta}" autofocus="true" --%>
										<%-- 												placeholder='Unesite šifru dokumenta' /> --%>

										<!-- 											<p class="help-block"> -->
										<%-- 												<form:errors path="idVrstaDokumenta" class="help-block text-danger" /> --%>
										<!-- 											</p> -->
										<!-- 										</div> -->



										<%-- 										<div class="form-group"${error != null ? 'has-error' : ''}'> --%>
										<!-- 											<label class='font-awesome'>Vrsta dokumenta</label> -->

										<%-- 											<form:select path="idVrstaDokumenta" class="form-control"> --%>
										<%-- 												<form:options items="${eTypesOfDocuments}" /> --%>
										<%-- 											</form:select> --%>

										<!-- 											<p class="help-block"> -->
										<%-- 												<form:errors path="idVrstaDokumenta" class="help-block" /> --%>
										<!-- 											</p> -->
										<!-- 										</div>											 -->

										<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Vrsta dokumenta</label>

											<form:select path="TypesOfDocuments.id" class="form-control">
												<form:options items="${eTypesOfDocuments}" />
											</form:select>

											<p class="help-block">
												<form:errors path="TypesOfDocuments.id" class="help-block" />
											</p>
										</div>

										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Broj dokumenta</label>
											<%-- <input class="form-control" name='name' path='name' placeholder='Unesite naziv' value="${task.name}"> --%>

											<form:input type="text" class="form-control"
												id="brojDokumenta" path="brojDokumenta"
												placeholder='brojDokumenta'
												value="${dokument.brojDokumenta}" />
											<p class="help-block">
												<form:errors path="brojDokumenta" class="help-block" />
											</p>
										</div>

										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>interniBrojDokumenta</label>
											<%-- 									<input class="form-control" name='name' path='name' placeholder='Unesite naziv' value="${task.name}"> --%>

											<form:input type="text" class="form-control"
												id="interniBrojDokumenta" path="interniBrojDokumenta"
												placeholder='interniBrojDokumenta'
												value="${dokument.interniBrojDokumenta}" readonly="true" />
											<p class="help-block">
												<form:errors path="interniBrojDokumenta" class="help-block" />
											</p>
										</div>

										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Datum</label>

											<form:input type="date" class="form-control" id="datum"
												path="datum" placeholder='Datum' value="${dokument.datum}" />
											<p class="help-block">
												<form:errors path="datum" class="help-block" />
											</p>
										</div>




										<div class="form-group" ${error != null ? 'has-error' : ''}>
											<label class='font-awesome'>Partner</label>

											<%-- 											<form:select path="Partner.id" class="form-control"> --%>
											<%-- 												<form:option value="0" label="--- Select One ---"></form:option> --%>
											<%-- 												<form:options  cssClass="${role.getKey()}" items="${ePartner}" /> --%>
											<%-- 											</form:select> --%>


											<select id="selectManuf" class="form-control"
												name="Partner.id">
												<c:forEach var="role" items="${ePartner}">
													<option class="${role.getKey()}" value="${role.getKey()}"
														${role.getKey() == dokument.partner.id ? 'selected' : ''}>
														${role.getValue()}</option>
												</c:forEach>
											</select>

											<p class="help-block">
												<form:errors path="Partner.id" class="help-block" />
											</p>
										</div>

										<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Magacin ulaza</label>

											<select id="selectModel" class="form-control"
												name="Magacini.id">

												<c:forEach var="role" items="${eMagacini}">
													<option class="${role.partner.getId()}"
														value="${role.getId()}"
														${role.getId() == dokument.magacini.id ? 'selected' : ''}>
														${role.getName()}</option>
													<c:out value="${role.partner.getId()}" />
												</c:forEach>
											</select>

											<p class="help-block">
												<form:errors path="Magacini.id" class="help-block" />
											</p>
										</div>

										<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Magacin izlaza</label>

											<select id="selectModel2" class="form-control"
												name="Magacini2.id">

												<c:forEach var="role2" items="${eMagacini}">
													<option class="${role2.partner.getId()}"
														value="${role2.getId()}"
														${role2.getId() == dokument.magacini2.id ? 'selected' : ''}>
														${role2.getName()}</option>
													<c:out value="${role2.partner.getId()}" />
												</c:forEach>
											</select>

											<p class="help-block">
												<form:errors path="Magacini2.id" class="help-block" />
											</p>
										</div>
																				
								</div>

								<%-- 										<c:out value="${dokument.partner.id}"/> --%>
								<%-- 										<c:out value="${dokument.partner.name}"/> --%>
								<%-- 										<c:out value="${ePartner['key']}"/> --%>

								<%-- 	<c:forEach var="hash" items="${ePartner['key']}"> --%>
								<!--         <option></option> -->
								<%--   </c:forEach> --%>
								
								<div class='col-lg-6'>
									<div class='form-group'>
										<label class='font-roboto'>Napomena</label>
										<%-- 									<textarea class="form-control" name='napomena' path='napomena'  placeholder='Unesite napomenu' value="${task.napomena}"></textarea> --%>
										<form:textarea type="text" class="form-control" id="napomena"
											path="napomena" value="${dokument.napomena}" rows="4" />
										<p class="help-block">
											<form:errors path="napomena" class="help-block" />
										</p>
									</div>

									<div class='form-group'>
										<label class='font-roboto'>Iznos</label>
										<%-- 									<textarea class="form-control" name='napomena' path='napomena'  placeholder='Unesite napomenu' value="${task.napomena}"></textarea> --%>
										<form:input type="number" class="form-control" id="napomena"
											path="iznos" value="${dokument.iznos}" />
										<p class="help-block">
											<form:errors path="iznos" class="help-block" />
										</p>
									</div>


									<div class='form-group ${error != null ? 'has-error' : ''}'>
										<label class='font-awesome'>Osnov prijema:</label>

										<form:input type="text" class="form-control" id="osnov"
											path="osnov" placeholder='osnov' value="${dokument.osnov}" />
										<p class="help-block">
											<form:errors path="osnov" class="help-block" />
										</p>
									</div>

									<div class='col-lg-6 clear-padding'>
										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Predao:</label>

											<form:input type="text" class="form-control" id="predao"
												path="predao" placeholder='predao'
												value="${dokument.predao}" />
											<p class="help-block">
												<form:errors path="predao" class="help-block" />
											</p>
										</div>
									</div>
									
									<div class='col-lg-6 clear-padding'>
										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Primio:</label>

											<form:input type="text" class="form-control" id="primio"
												path="primio" placeholder='primio'
												value="${dokument.primio}" />
											<p class="help-block">
												<form:errors path="primio" class="help-block" />
											</p>
										</div>

									</div>
									<%-- 										<c:out value="${model.dokument.aktivan}" /> --%>

									<%-- 										<c:if test="${dokument.aktivan}"> --%>
									<%-- 											<c:out value="${dokument.code}" /> --%>
									<%-- 										</c:if> --%>

									<c:set var="salary" scope="session" value="checked">
									</c:set>
									<c:set var="salary1" scope="session" value="">
									</c:set>

									<c:if test="${dokument.aktivan == true}">
										<c:set var="salary" scope="session" value="checked" />
										<c:set var="salary1" scope="session" value="" />
									</c:if>

									<c:if test="${dokument.aktivan == false}">
										<c:set var="salary1" scope="session" value="checked" />
										<c:set var="salary" scope="session" value="" />
									</c:if>

									<c:if test="${(empty salary) and (empty salary1)}">
										<c:set var="salary" scope="session" value="checked" />
									</c:if>

									<div class='form-group spacer-bottom-30'>
										<label>Aktivan</label><br /> <label class="radio-inline">
											<!--                                     	<input type="radio" name="aktivan"  path='aktivan' -->
											<%--                                     	 checked  value="${task.aktivan}" >Da   --%>
											<input type="radio" name="aktivan" value="1" path='aktivan'
											<c:out value="${salary}"/> />
										</label> <label class="radio-inline"> <%--                                     	<input type="radio" class="col-sm-1" name="aktivan"  path='aktivan' value="${task.aktivan}">Ne --%>
											<input type="radio" class="col-sm-1" name="aktivan" value="0"
											path='aktivan' <c:out value="${salary1}"/> />
										</label>
									</div>


								</div>


							</div>
							<!--  end row  -->

							<div class="row margin-top-10">
								<div class="col-lg-12 text-center">
									<button type="submit" class="btn-lg button-novi">
										<i class='fa fa-floppy-o'></i> Save
									</button>
									<input type="button" onclick="location.href='dokument.html';"
										value="Cancel" class="btn-lg button-novi" />
									<!-- 										<button type="reset" class="btn-lg button-novi"> -->
									<!-- 											<i class='fa fa-reply'></i> Cancel -->
									<!-- 										</button> -->

									<!-- 										<button type="reset" class="btn-lg button-novi"> -->
									<!-- 											<i class='fa fa-reply'></i> Cancel -->
									<!-- 										</button> -->

									</form:form>
								</div>
							</div>

						</div>
						<!-- end of panel -->
					</div>
				</div>


			</div>
			<!-- page wrapper -->

		</div>

		<%@ include file="scripts.jsp"%>
		<script src="https://code.angularjs.org/1.2.32/angular.js"></script>
		<script src="ui-bootstrap-tpls-0.10.0.min.js"></script>
		<script src="dokumentItems.js"></script>

		<script>
			$(document).ready(
					function() {
						var allOptions = $('#selectModel option')
						$('#selectManuf').change(
								function() {
									$('#selectModel option').remove();
									var classN = $(
											'#selectManuf option:selected')
											.prop('class');
									var opts = allOptions.filter('.' + classN);
									$.each( opts, function(i, j) {
										$(j).appendTo('#selectModel')
									});
									
								});				
					}
			
			);

			$(document).ready(function myFunction1() {
				var allOptions = $('#selectModel option');
				// var sviPocetni = allOptions;
				$('#selectModel option').remove()
				var classN = $('#selectManuf option:selected').prop('class');
				var opts = allOptions.filter('.' + classN);
				$.each(opts, function(i, j) {
					$(j).appendTo('#selectModel');
				});
				// alert("Page is loaded 123");
				// allOptions = sviPocetni;
			});

// 			function myFunction1() {
// 				var allOptions = $('#selectModel option');
// 				var sviPocetni = allOptions;
// 				$('#selectModel option').remove()
// 				var classN = $('#selectManuf option:selected').prop('class');
// 				var opts = allOptions.filter('.' + classN);
// 				$.each(opts, function(i, j) {
// 					$(j).appendTo('#selectModel');
// 				});
// 				alert("Page is loaded 123");
// 				//  allOptions = sviPocetni;
// 			}

			function myFunction1() {
				alert("Page is loaded");
			}
			
		</script>
</body>
</html>