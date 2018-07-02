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

									<form:form method="POST" action="save_dokument.html"
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
											<label class='font-awesome'>Magacin</label>

											<%-- 											<form:select path="Magacini.id" class="form-control">  --%>
											<%-- 												<form:options items="${eMagacini}" />  --%>
											<%-- 											</form:select>  --%>

											<!-- 											<select id="selectModel" class="form-control" name="Magacini.id" > -->
											<%--     											<c:forEach var="role" items="${eMagacini}">    											 --%>
											<%--       											<option class="${role.getKey()}" value="${role.getKey()}" ${role.getKey() == dokument.magacini.id ? 'selected' : ''}> ${role.getValue()}</option> --%>
											<%--     											</c:forEach> --%>
											<!-- 											</select> -->

											<%-- <c:out value="${eMagacini}"/> --%>
											<%-- <c:out value="${dokument.id}"/> --%>
											<%-- <c:if test="${dokument.id==null}"> --%>
											<%-- <c:out value="dokument.id je null"/> --%>
											<%-- </c:if> --%>
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




				<!-- <div ng-app="myDokumentStavke" class='row'> -->
				<!-- <div class='col-lg-12' ng-controller="dokumentStavkeCrtl"> -->
				<!-- <!-- <br/> -->
				<!-- <blockquote><h4> <a href="http://angularcode.com/angularjs-datagrid-paging-sorting-filter-using-php-and-mysql/">Simple Datagrid with search, sort and paging using AngularJS + PHP + MySQL</a></h4></blockquote> -->
				<!-- <!-- <br/> -->
				<!--     <div class="row"> -->
				<!--         <div class="col-md-2">PageSize: -->
				<!--             <select ng-model="entryLimit" class="form-control"> -->
				<!--                 <option>5</option> -->
				<!--                 <option>10</option> -->
				<!--                 <option>20</option> -->
				<!--                 <option>50</option> -->
				<!--                 <option>100</option> -->
				<!--             </select> -->
				<!--         </div> -->
				<!--         <div class="col-md-3">Filter: -->
				<!--             <input type="text" ng-model="search" ng-change="filter()" placeholder="Filter" class="form-control" /> -->
				<!--         </div> -->
				<!--         <div class="col-md-4"> -->
				<!--             <h5>Filtered {{ filtered.length }} of {{ totalItems}} total customers</h5> -->
				<!--         </div> -->
				<!--     </div> -->
				<!--     <br/> -->
				<!--     <div class="row"> -->
				<!--         <div class="col-md-12" ng-show="filteredItems > 0"> -->
				<!--             <table class="display table table-striped table-bordered table-hover border-radius-0"> -->
				<!--             <thead> -->
				<!--             <th style="width: 7%;">ID&nbsp;<a ng-click="sort_by('id');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a></th> -->
				<!--             <th style="width: 10%;">Iznos&nbsp;<a ng-click="sort_by('akcija');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a> </th> -->
				<!--             <th style="width: 12%;">AKCIJA&nbsp;<a ng-click="sort_by('akcija');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a></th> -->
				<!--             </thead> -->
				<!--             <tbody> -->
				<!--                 <tr ng-repeat="data in filtered = (list | filter:search | orderBy : predicate :reverse) | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit"> -->
				<!--                     <td>{{data.id}}</td> -->
				<!--                     <td>{{data.iznos | number:2}}</td> -->

				<!--                     <td><a href="update_dokument.html?id={{data.id}}"><i class="fa fa-pencil-square-o edit-delete-icon"></i></a> <a href="delete_dokument.html?id={{data.id}}" onClick="return ConfirmDelete();"><i class="fa fa-trash-o edit-delete-icon"></i></a></td> -->

				<!--                 </tr> -->
				<!--             </tbody> -->
				<!--             </table> -->
				<!--         </div> -->
				<!--         <div class="col-md-12" ng-show="filteredItems == 0"> -->
				<!--             <div class="col-md-12"> -->
				<!--                 <h4>No document items found</h4>             		 -->
				<!--             </div> -->

				<!--         </div> -->
				<!--         <div class="col-md-12" ng-show="filteredItems > 0">     -->
				<!--             <div pagination="" page="currentPage" on-select-page="setPage(page)" boundary-links="true" total-items="filteredItems" items-per-page="entryLimit" class="pagination-small" previous-text="&laquo;" next-text="&raquo;"></div> -->


				<!--         </div> -->
				<!--     </div> -->
				<!-- </div> -->
				<!-- </div>  -->




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
									$('#selectModel option').remove()
									var classN = $(
											'#selectManuf option:selected')
											.prop('class');
									var opts = allOptions.filter('.' + classN);
									$.each(opts, function(i, j) {
										$(j).appendTo('#selectModel');
									});
								});

					});

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

			function myFunction1() {
				var allOptions = $('#selectModel option');
				var sviPocetni = allOptions;
				$('#selectModel option').remove()
				var classN = $('#selectManuf option:selected').prop('class');
				var opts = allOptions.filter('.' + classN);
				$.each(opts, function(i, j) {
					$(j).appendTo('#selectModel');
				});
				alert("Page is loaded 123");
				//  allOptions = sviPocetni;
			}

			function myFunction() {
				alert("Page is loaded");
			}
		</script>
</body>
</html>