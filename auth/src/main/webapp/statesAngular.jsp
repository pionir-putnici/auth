<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="top.jsp"%>

<!-- <html> -->

<!--   <head> -->
<!--     <link data-require="bootstrap-css@2.3.2" data-semver="2.3.2" rel="stylesheet" href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" /> -->
<!--     <script data-require="angular.js@1.1.5" data-semver="1.1.5" src="http://code.angularjs.org/1.1.5/angular.min.js"></script> -->
<!--     <script data-require="angular-ui-bootstrap@0.3.0" data-semver="0.3.0" src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.3.0.min.js"></script> -->
<!--     <link rel="stylesheet" href="style.css" /> -->
<!--     <script src="stateController.js"></script> -->
<!--   </head> -->


<body>

	<div id="wrapper">
		<%@ include file="horizontal-navigation.html"%>
		<%@ include file="vertical-menu.jsp"%>

		<div id="page-wrapper">

			<div class="row" ng-app="StatesManagement"
				ng-controller="StatesAngularJSController">
				<div class="col-lg-12">
					<div class='panel panel-default spacer-top-30'>
						<div class='panel-heading'>Novi / Izmena</div>

						<div class='panel-body'>
							<div class='row'>
								<div class='col-lg-12'>
									<div class='row'>
										<div class='col-lg-6'>
											<form ng-submit="submitState()">
												<input type="hidden" name="${_csrf.parameterName}"
													value="${_csrf.token}" />

												<!-- 			<tr> -->
												<!-- 				<td>Id</td> -->
												<!-- 				<td><input type="text" ng-model="stateForm.id" /></td> -->
												<!-- 			</tr> -->
												<div class='form-group'>
													<label class='font-oxygen'>Šifra</label> <input type="text"
														ng-model="stateForm.code" class='form-control' />
												</div>
												<div class='form-group'>
													<label class='font-oxygen'>Naziv</label> <input type="text"
														ng-model="stateForm.name" class='form-control' />
												</div>
										</div>
										<div class='col-lg-6'>
											<div class='form-group'>
												<label class='font-oxygen'>Napomena</label>
												<textarea rows='3' ng-model="stateForm.remark"
													class="form-control textarea-resize-disable"></textarea>
											</div>
										</div>
									</div>
									<div class='row'>
										<div class='col-lg-12'>
											<c:set var="salary" scope="session" value="checked">
											</c:set>
											<c:set var="salary1" scope="session" value="">
											</c:set>

											<c:if test="${artikli.aktivan == true}">
												<c:set var="salary" scope="session" value="checked" />
												<c:set var="salary1" scope="session" value="" />
											</c:if>

											<c:if test="${artikli.aktivan == false}">
												<c:set var="salary1" scope="session" value="checked" />
												<c:set var="salary" scope="session" value="" />
											</c:if>

											<c:if test="${(empty salary) and (empty salary1)}">
												<c:set var="salary" scope="session" value="checked" />
											</c:if>


											<div class='form-group spacer-bottom-30'>
												<label>Aktivan</label><br /> <label class="radio-inline">
													<input type="radio" name="aktivan" value="1" path='aktivan'
													<c:out value="${salary}"/> />Da
												</label> <label class="radio-inline"> <%--                                     	<input type="radio" class="col-sm-1" name="aktivan"  path='aktivan' value="${task.aktivan}">Ne --%>
													<input type="radio" class="col-sm-1" name="aktivan"
													value="0" path='aktivan' <c:out value="${salary1}"/> />Ne
												</label>
											</div>
											<div class='form-group'>
												<input type="submit" value="Submit"
													class="btn-lg button-novi" />
												</td>
											</div>
											</form>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
					<div class='panel panel-default'>
						<div class='panel-heading'>Lista</div>
						<div class='panel-body'>
							<div class='row'>
								<div class='col-lg-6'>

									<table
										class="display table table-striped table-bordered table-hover border-radius-0">
										<tr>

											<th>ID</th>
											<th>Šifra</th>
											<th>Naziv</th>
											<th>Napomena</th>
											<th>Akcija</th>
										</tr>

										<tr ng-repeat="state in states">

											<td>{{ state.id }}</td>
											<td>{{ state.code }}</td>
											<td>{{ state.name }}</td>
											<td>{{ state.remark }}</td>

											<td><a ng-click="editState(state)" class="blue-button">Edit</a>
												<a ng-click="deleteState(state)" class="red-button">Delete</a></td>
										</tr>

									</table>
								</div>
							</div>

						</div>


					</div>
				</div>

				<div>
					<h1>Todos</h1>
					<h4>{{states.length}} remain</h4>
					<h4>{{test}} test</h4>
					<h4>{{currentPage}} currentPage</h4>
					<h4>{{numPages}} numPages</h4>
<!-- 					<h4>{{states}} states - filteredTodos</h4> -->
					<h4>{{watch}} watch</h4>
					<h4>{{begin}} begin</h4>
					<ul>
						<!--       <li ng-repeat="todo in filteredTodos">{{todo.text}}</li> -->
						<table>
							<tr ng-repeat="state in states">
								<td>{{ state.id }}</td>
								<td>{{ state.code }}</td>
								<td>{{ state.name }}</td>
								<td>{{ state.remark }}</td>

								<td><a ng-click="editState(state)" class="blue-button">Edit</a>
									<a ng-click="deleteState(state)" class="red-button">Delete</a></td>
							</tr>

						</table>
					</ul>

					<div data-pagination="" data-num-pages="numPages()"
						data-current-page="currentPage" data-max-size="maxSize"
						data-boundary-links="true">
					</div>
					
					
    <h1>Todos</h1>
    <h4>{{todos.length}} remain</h4>
    <ul>
      <li ng-repeat="todo in filteredTodos">{{todo.text}}</li>
    </ul>
    <div data-pagination="" data-num-pages="numPages()" 
      data-current-page="currentPage" data-max-size="maxSize"  
      data-boundary-links="true">
      asdfasdfasdf
     </div>					
					
					
				</div>

			</div>


			<%@ include file="scripts.jsp"%>
			<script src="stateController.js"></script>
			<!-- 	<script src="static/js/datatable-artikli.js"></script> -->
</body>
</html>