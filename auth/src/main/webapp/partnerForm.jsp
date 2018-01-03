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

									<form:form method="POST" action="save_partner.html"
										modelAttribute="partner">

										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />

										<form:input type="hidden" name="id" path="id"
											value="${partner.id}" />

										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-oxygen'>Šifra</label>

											<form:input type="text" class="form-control " name="code"
												path="code" value="${partner.code}" autofocus="true"
												placeholder='Unesite šifru' />

											<p class="help-block">
												<form:errors path="code" class="help-block text-danger" />
											</p>
										</div>


										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Naziv</label>
											<%-- 									<input class="form-control" name='name' path='name' placeholder='Unesite naziv' value="${task.name}"> --%>

											<form:input type="text" class="form-control" id="name"
												path="name" placeholder='Unesite naziv'
												value="${partner.name}" />
											<p class="help-block">
												<form:errors path="name" class="help-block" />
											</p>
										</div>
										
										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Pib</label>
											<%-- 									<input class="form-control" name='name' path='name' placeholder='Unesite naziv' value="${task.name}"> --%>

											<form:input type="text" class="form-control" id="pib"
												path="pib" placeholder='Unesite pib'
												value="${partner.pib}" />
											<p class="help-block">
												<form:errors path="name" class="help-block" />
											</p>
										</div>										
										
										<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Ptt broj</label>

											<form:select path="ptt_broj_id" class="form-control">
												<form:options items="${eDept}" />
											</form:select>

											<p class="help-block">
												<form:errors path="ptt_broj_id" class="help-block" />
											</p>

										</div>										

										<div class='form-group'>
											<label class='font-roboto'>Napomena</label>
											<%-- 									<textarea class="form-control" name='remark' path='remark'  placeholder='Unesite napomenu' value="${task.remark}"></textarea> --%>
											<form:textarea type="text" class="form-control" id="remark"
												path="remark" value="${partner.remark}" />
											<p class="help-block">
												<form:errors path="remark" class="help-block" />
											</p>
										</div>

<%-- 										<c:out value="${model.partner.aktivan}" /> --%>

<%-- 										<c:if test="${partner.aktivan}"> --%>
<%-- 											<c:out value="${partner.code}" /> --%>
<%-- 										</c:if> --%>

										<c:set var="salary" scope="session" value="checked">
										</c:set>
										<c:set var="salary1" scope="session" value="">
										</c:set>

										<c:if test="${partner.aktivan == true}">
											<c:set var="salary" scope="session" value="checked" />
											<c:set var="salary1" scope="session" value="" />
										</c:if>

										<c:if test="${partner.aktivan == false}">
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
												<input type="radio" class="col-sm-1" name="aktivan"
												value="0" path='aktivan' <c:out value="${salary1}"/> />
											</label>
										</div>

										<button type="submit" class="btn-lg button-novi">
											<i class='fa fa-floppy-o'></i> Save
										</button>
										<button type="reset" class="btn-lg button-novi">
											<i class='fa fa-reply'></i> Cancel
										</button>

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