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
					<h2 class="page-header">Vrste paleta</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class='panel panel-default'>
						<div class='panel-heading'>Unos nove palete</div>
						<div class='panel-body'>
							<div class='row'>
								<div class='col-lg-6'>

									<form:form method="POST" action="save-vrste-paleta.html"
										modelAttribute="vrstePaleta">

										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />

										<form:input type="hidden" name="uid" path="uid"
											value="${vrstePalata.uid}" />


										<div class='form-group'>
											<label class='font-roboto'>Šifra</label>
											<!-- 									<input class="form-control" name='code' path='code' -->
											<%-- 												placeholder='Unesite šifru' value="${task.code}"> --%>
											<form:input type="text" class="form-control" name="code"
												path="code" value="${vrstePalata.code}" autofocus="true"
												placeholder='Unesite šifru' />
											<p class="help-block">
												<form:errors path="code" class="help-block" />
											</p>
										</div>

										<div class='form-group'>
											<label class='font-roboto'>Naziv</label>
											<%-- 									<input class="form-control" name='name' path='name' placeholder='Unesite naziv' value="${task.name}"> --%>

											<form:input type="text" class="form-control" id="name"
												path="name" placeholder='Unesite naziv'
												value="${vrstePalata.name}" />
											<p class="help-block">
												<form:errors path="name" class="help-block" />
											</p>
										</div>

										<div class='form-group'>
											<label class='font-roboto'>Napomena</label>
											<%-- 									<textarea class="form-control" name='remark' path='remark'  placeholder='Unesite napomenu' value="${task.remark}"></textarea> --%>
											<form:textarea type="text" class="form-control" id="remark"
												path="remark" value="${vrstePalata.remark}" />
											<p class="help-block">
												<form:errors path="remark" class="help-block" />
											</p>
										</div>



										<!--         value="1" value="0" -->

										<c:out value="${model.vrstePaleta.aktivan}" />


										<c:if test="${vrstePaleta.aktivan}">
											<c:out value="${vrstePaleta.code}" />
										</c:if>


										<c:set var="salary" scope="session" value="checked">
										</c:set>
										<c:set var="salary1" scope="session" value="">
										</c:set>

										<c:if test="${vrstePaleta.aktivan == true}">
											<c:set var="salary" scope="session" value="checked" />
											<c:set var="salary1" scope="session" value="" />
										</c:if>

										<c:if test="${vrstePaleta.aktivan == false}">
											<c:set var="salary1" scope="session" value="checked" />
											<c:set var="salary" scope="session" value="" />
										</c:if>

										<c:if test="${(empty salary) and (empty salary1)}">
											<c:set var="salary" scope="session" value="checked" />
										</c:if>

										<div class='form-group'>
											<label>Aktivan</label><br /> <label class="radio-inline">
												<!--                                     	<input type="radio" name="aktivan"  path='aktivan' -->
												<%--                                     	 checked  value="${task.aktivan}" >Da   --%>
												<input type="radio" name="aktivan" value="1" path='aktivan'
												<c:out value="${salary}"/> />
											</label> <label class="radio-inline"> <%--                                     	<input type="radio" class="col-sm-1" name="aktivan"  path='aktivan' value="${task.aktivan}">Ne --%>
												<input type="radio" class="col-sm-1" name="aktivan"
												value="0" path='aktivan' <c:out value="${salary1}"/> />
											</label>
										</div>


										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />

										<button type="submit"
											class="btn btn-success btn-circle btn-lg">
											<i class="fa fa-check"></i>
										</button>
										<button type="reset" class="btn btn-danger btn-circle btn-lg">
											<i class="fa fa-times"></i>
										</button>

<!-- 										</form> -->
												</form:form>
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