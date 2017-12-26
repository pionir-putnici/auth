<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="top.jsp"%>

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
										<div class='form-group'>
											<label class='font-oxygen'>Napomena</label>
											<textarea ng-model="stateForm.remark" class="form-control"></textarea>
										</div>

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
			</div>
			<div class="pagination text-center" ng-show="paginator.pageCount() > 1">
    <ul>
        <li ng-click="paginator.firstPage()" ng-class="paginator.isFirstPage() && 'disabled'">
            <a>
                <i class="icon-fast-backward" ng-class="paginator.isFirstPage() && 'icon-white'"></i>
            </a>
        </li>
        <li ng-click="paginator.perviousPage()" ng-class="paginator.isFirstPage() && 'disabled'">
            <a>
                <i class="icon-step-backward" ng-class="paginator.isFirstPage() && 'icon-white'"></i>
            </a>
        </li>
        <li ng-click="paginator.setPage(i)" ng-repeat="i in [] | forLoop:0:paginator.pageCount()" ng-class="paginator.page==i && 'active'">
            <a>{{i+1}}</a>
        </li>
        <li ng-click="paginator.nextPage()" ng-class="paginator.isLastPage() && 'disabled'">
            <a>
                <i class="icon-step-forward" ng-class="paginator.isLastPage() && 'icon-white'"></i>
            </a>
        </li>
        <li ng-click="paginator.lastPage()" ng-class="paginator.isLastPage() && 'disabled'">
            <a>
                <i class="icon-fast-forward" ng-class="paginator.isLastPage() && 'icon-white'"></i>
            </a>
        </li>
    </ul>
</div>
  </script>
  <div class="container" ng-controller="TestCrtl">
      <h1>AngularJS client side pagination module example</h1>
      <h2><a target="_blank" href="http://www.cacodaemon.de/">by cacodaemon.de</a></h2>
      <table class="table table-bordered table-condensed">
          <thead>
              <tr>
                  <td>Value<td>
              </tr>
          </thead>
          <tbody>
              <tr ng-repeat="value in testValues | paginate:rowsPerPage">
                  <td>{{value}}</td>
              </tr>
          </tbody>
          <tfoot>
              <tr>
                  <td>
                      <div class="control-group">
                          <label class="control-label" for="rows-per-page">Rows per page</label>
                          <div class="controls">
                            <select id="rows-per-page"" ng-model="rowsPerPage" class="input-xlarge">
                              <option>50</option>
                              <option>100</option>
                              <option>200</option>
                              <option>500</option>
                            </select>
                          </div>
                      </div>
                  </td>
              </tr>
              <tr>
                  <td>
                      <paginator></paginator>
                  </td>
              </tr>
          </tfoot>
      </table>

  </div>
	<%@ include file="scripts.jsp"%>

	<script src="static/js/datatable-artikli.js"></script>
</body>
</html>