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
					<h2 class="page-header">Artikli</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class='panel panel-default'>
						<div class='panel-heading'>Unos artikala</div>
						<div class='panel-body'>
							<div class='row'>
								<div class='col-lg-6'>

									<form:form method="POST" action="save-artikli.html"
										modelAttribute="artikli">

										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />

										<form:input type="hidden" name="id" path="id"
											value="${artikli.id}" />


										<!-- 			<div> -->
										<%-- 			<c:out value="${error}" />			 --%>
										<!-- 			</div> -->


										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-oxygen'>Šifra</label>
											<!-- 									<input class="form-control" name='code' path='code' -->
											<%-- 												placeholder='Unesite šifru' value="${task.code}"> --%>
											<form:input type="text" class="form-control " name="code"
												path="code" value="${artikli.code}" autofocus="true"
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
												value="${artikli.name}" />
											<p class="help-block">
												<form:errors path="name" class="help-block" />
											</p>
										</div>

										<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Vrsta artikala</label>

											<form:select path="vrsteArtikala.id" class="form-control">
<%-- 												<form:option value="0" label="--- Select ---" /> --%>
												<form:options items="${eDept}" />
											</form:select>

											<p class="help-block">
												<form:errors path="vrsteArtikala.id" class="help-block" />
											</p>

										</div>

										<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Poreska grupa</label>

											<form:select path="poreskeGrupe.id" class="form-control">
<%-- 												<form:option value="0" label="--- Select ---" /> --%>
												<form:options items="${ePg}" />
											</form:select>

											<p class="help-block">
												<form:errors path="poreskeGrupe.id" class="help-block" />
											</p>

										</div>
	
											<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Jedinica mere</label>

											<form:select path="jediniceMera.id" class="form-control">
<%-- 												<form:option value="0" label="--- Select ---" /> --%>
												<form:options items="${ePjm}" />
											</form:select>

											<p class="help-block">
												<form:errors path="jediniceMera.id" class="help-block" />
											</p>
										</div>	
	
												<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Klasifikacija</label>

											<form:select path="klasifikacije.id" class="form-control">
<%-- 												<form:option value="0" label="--- Select ---" /> --%>
												<form:options items="${ePkl}" />
											</form:select>

											<p class="help-block">
												<form:errors path="klasifikacije.id" class="help-block" />
											</p>
										</div>	
																											
										<div class='form-group'>
											<label class='font-roboto'>Napomena</label>
											<%-- 									<textarea class="form-control" name='remark' path='remark'  placeholder='Unesite napomenu' value="${task.remark}"></textarea> --%>
											<form:textarea type="text" class="form-control" id="remark"
												path="remark" value="${artikli.remark}" />
											<p class="help-block">
												<form:errors path="remark" class="help-block" />
											</p>
										</div>



										<!--         value="1" value="0" -->

										<%-- 										<c:out value="${model.magacini.aktivan}" /> --%>


										<%-- 										<c:if test="${magacini.aktivan}"> --%>
										<%-- 											<c:out value="${magacini.code}" /> --%>
										<%-- 										</c:if> --%>


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

										<button type="submit" class="btn-lg button-novi">
											<i class='fa fa-floppy-o'></i> Save
										</button>
										<button type="reset" class="btn-lg button-novi">
											<i class='fa fa-reply'></i> Cancel
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