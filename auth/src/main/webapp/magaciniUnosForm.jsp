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
					<h2 class="page-header">Magacini</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class='panel panel-default'>
						<div class='panel-heading'>Unos magacina</div>
						<div class='panel-body'>
							<div class='row'>
								<div class='col-lg-6'>

									<form:form method="POST" action="save-magacini.html"
										modelAttribute="magacini">

										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />

										<form:input type="hidden" name="id" path="id"
											value="${magacini.id}" />


										<!-- 			<div> -->
										<%-- 			<c:out value="${error}" />			 --%>
										<!-- 			</div> -->


										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-oxygen'>Šifra</label>
											<!-- 									<input class="form-control" name='code' path='code' -->
											<%-- 												placeholder='Unesite šifru' value="${task.code}"> --%>
											<form:input type="text" class="form-control " name="code"
												path="code" value="${magacini.code}" autofocus="true"
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
												value="${magacini.name}" />
											<p class="help-block">
												<form:errors path="name" class="help-block" />
											</p>
										</div>

										<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Vrsta magacina</label>

											<form:select path="vrsteMagacina.id" class="form-control">
												<form:option value="" label="--- Select ---" />
												<form:options items="${eDept}" />
											</form:select>

											<p class="help-block">
												<form:errors path="vrsteMagacina.id" class="help-block" />
											</p>
										</div>
										
										<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Partner</label>

											<form:select path="partner.id" class="form-control">
												<form:option value="" label="--- Select ---" />
												<form:options items="${eDeptPt}" />
											</form:select>

											<p class="help-block">
												<form:errors path="partner.id" class="help-block" />
											</p>
										</div>										

										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-oxygen'>Adresa</label>
											<form:input type="text" class="form-control " name="adresa"
												path="adresa" value="${magacini.adresa}" 
												placeholder='Unesite adresu' />

											<p class="help-block">
												<form:errors path="adresa" class="help-block text-danger" />
											</p>
										</div>

										<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Ptt broj</label>

											<form:select path="pttBrojevi.id" class="form-control">
												<form:option value="" label="--- Select ---" />
												<form:options items="${eDeptPtt}" />
											</form:select>

											<p class="help-block">
												<form:errors path="pttBrojevi.id" class="help-block" />
											</p>
										</div>	

										<div class='form-group'>
											<label class='font-roboto'>Napomena</label>
											<%-- 									<textarea class="form-control" name='remark' path='remark'  placeholder='Unesite napomenu' value="${task.remark}"></textarea> --%>
											<form:textarea type="text" class="form-control" id="remark"
												path="remark" value="${magacini.remark}" />
											<p class="help-block">
												<form:errors path="remark" class="help-block" />
											</p>
										</div>



										<!--         value="1" value="0" -->

										<%-- 										<c:out value="${model.magacini.aktivan}" /> --%>


										<%-- 										<c:if test="${magacini.aktivan}"> --%>
										<%-- 											<c:out value="${magacini.code}" /> --%>
										<%-- 										</c:if> --%>


										<!-- setovanje da li se ucitava aktivan ili neaktivan -->
										
										<c:set var="rb_active" scope="session" value="checked">
										</c:set>
										<c:set var="rb_inactive" scope="session" value="">
										</c:set>

										<c:if test="${magacini.aktivan == true}">
											<c:set var="rb_active" scope="session" value="checked" />
											<c:set var="rb_inactive" scope="session" value="" />
										</c:if>

										<c:if test="${magacini.aktivan == false}">
											<c:set var="rb_inactive" scope="session" value="checked" />
											<c:set var="rb_active" scope="session" value="" />
										</c:if>

										<c:if test="${(empty rb_active) and (empty rb_inactive)}">
											<c:set var="rb_active" scope="session" value="checked" />
										</c:if>

										
										<!-- kraj setovanje da li se ucitava aktivan ili neaktivan -->
										
										<div class='form-group spacer-bottom-30'>
											<label>Aktivan</label><br /> <label class="radio-inline">
												<!--                                     	<input type="radio" name="aktivan"  path='aktivan' -->
												<%--                                     	 checked  value="${task.aktivan}" >Da   --%>
												<input type="radio" name="aktivan" value="1" path='aktivan'
												<c:out value="${rb_active}"/> />
											</label> <label class="radio-inline"> <%--                                     	<input type="radio" class="col-sm-1" name="aktivan"  path='aktivan' value="${task.aktivan}">Ne --%>
												<input type="radio" class="col-sm-1" name="aktivan"
												value="0" path='aktivan' <c:out value="${rb_inactive}"/> />
											</label>
										</div>


										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />

										<button type="submit" class="btn-lg button-novi">
											<i class='fa fa-floppy-o'></i> Save
										</button>
										<input type="button"
											onclick="location.href='/list-magacini.jsp'" value="Cancel"
											class="btn-lg button-novi" />

										<!-- 										<button type="reset" class="btn-lg button-novi"> -->
										<!-- 											<i class='fa fa-reply'></i> Cancel -->
										<!-- 										</button> -->

										<!-- 										<button type="reset" class="btn-md button-novi"><i class='fa fa-reply'></i> Cancel</button> -->


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