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
					
						<div class='panel-heading'>${title} </div>
<%-- 						<div>${dokumentStavke.typesOfDocuments}</div> --%>
<%-- 						<div>${typesOfDocuments} aaaaaaaaaaaaa</div> --%>
<%-- 						<div>${dokumentStavke.magacini} bbbbbbbbbb</div> --%>
<%-- 						<div>${magacini} ccccccccccccccc</div> --%>
						
						<div class='panel-body'>
							<div class='row'>
								<div class='col-lg-3'>

									<form:form method="POST" action="/save_typesOfDocuments.html"
  										modelAttribute="typesOfDocuments">  

 										<input type="hidden" name="${_csrf.parameterName}" 
 											value="${_csrf.token}" /> 

 										<form:input type="hidden" name="id" path="id" 
 											value="${typesOfDocuments.id}" /> 
 											 										
        
<%--         								<form:select path="strana" items="${phonesMap}"/> --%>
        								
<!--         								**************************************************************** -->
<!--         								form:select u path prima samo ime kolone a ne ime tabele.kolona -->
<!--         								**************************************************************** -->
        								
										<div class="form-group"${error != null ? 'has-error' : ''}'>
 											<label class='font-awesome'>Sifra tipa promene</label> 

											<form:select path="strana" items="${eStrana}" class="form-control" tabindex="1">
 												<form:options items="${eStrana}" /> 
											</form:select>

 											<p class="help-block"> 
												<form:errors path="strana" class="help-block" />
 											</p> 
 										</div> 

<%-- 										<div class="form-group"${error != null ? 'has-error' : ''}'> --%>
<!-- 											<label class='font-awesome'>Tip dokumenta</label> -->

<%-- 											<form:select path="typesOfDocuments.id" class="form-control"> --%>
<%--  												<form:option value="0" label="--- Select ---" /> --%> 
<%-- 												<form:options items="${eTypesOfDocuments}" /> --%>
<%-- 											</form:select> --%>

<!-- 											<p class="help-block"> -->
<%-- 												<form:errors path="typesOfDocuments.id" class="help-block" /> --%>
<!-- 											</p> -->
<!-- 										</div> -->


<!-- start of hidden -->

							<!-- nikako neide types of documents - save page not found -->

<%-- 										<div class='form-group ${error != null ? 'has-error' : ''}'>											 --%>
<%--  											<form:input type="hidden" name="" class="form-control" id="typesOfDocuments"  --%>
<%--    												path="typesOfDocuments" placeholder='abc typesOfDocuments'   --%>
<%--     												value="${typesOfDocuments}"  />      --%>
<!-- 											<p class="help-block"> -->
<%--     												<form:errors path="typesOfDocuments" class="help-block" />     --%>
<!--    											</p>    -->
<!--    										</div>	  -->


<%-- 										<div class='form-group ${error != null ? 'has-error' : ''}'>											 --%>
<%--  											<form:input type="hidden" name="" class="form-control" id="magacini"  --%>
<%--   												path="magacini" placeholder='magacini'   --%>
<%--   												value="${magacini}"   />    --%>
<!-- 											<p class="help-block"> -->
<%--   												<form:errors path="magacini" class="help-block" />   --%>
<!--  											</p> -->
<!--  										</div>		 -->

<!-- end of hidden -->



<%-- 										<div class="form-group"${error != null ? 'has-error' : ''}'> --%>
<!-- 											<label class='font-awesome'>Magacini</label> -->

<%-- 											<form:select path="magacini.id" class="form-control"> --%>
<%--  												<form:option value="0" label="--- Select ---" /> --%> 
<%-- 												<form:options items="${eMagacini}" /> --%>
<%-- 											</form:select> --%>

<!-- 											<p class="help-block"> -->
<%-- 												<form:errors path="magacini.id" class="help-block" /> --%>
<!-- 											</p> -->
<!-- 										</div> -->


										
										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-oxygen'>Sifra</label>
 											<form:input type="text" class="form-control" id="code" 
 												path="code" placeholder='Code' tabindex="2"
 												value="${typesOfDocuments.code}" /> 
											<p class="help-block">
 												<form:errors path="code" class="help-block" /> 
											</p>
										</div>

										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-oxygen'>Name</label>
 											<form:input type="text" class="form-control" id="name" 
 												path="name" placeholder='Name'  tabindex="3"
 												value="${typesOfDocuments.name}" /> 
											<p class="help-block">
 												<form:errors path="name" class="help-block" /> 
											</p>
										</div>
														
<%-- 										<div class='form-group ${error != null ? 'has-error' : ''}'> --%>
<!-- 											<label class='font-oxygen'>Strana</label> -->
<%--  											<form:input type="number" class="form-control" id="strana"  --%>
<%--  												path="name" placeholder='Strana'  tabindex="4" --%>
<%--  												value="${typesOfDocuments.strana}"  readonly='true'/>  --%>
<!-- 											<p class="help-block"> -->
<%--  												<form:errors path="strana" class="help-block" />  --%>
<!-- 											</p> -->
<!-- 										</div>																 -->
										
										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-oxygen'>Napomena</label>
 											<form:textarea type="text" class="form-control" id="remark" 
 												path="remark" placeholder='remark' tabindex="5"
 												value="${typesOfDocuments.remark}" onclick="location.href='typesOfDocuments.html" /> 
											<p class="help-block">
 												<form:errors path="remark" class="help-block" /> 
											</p>
										</div>
												
																						
										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-oxygen'>Tip dokumenta (1-prijemnica, otpremnica, 2 - medjumagacinski dokument)</label>
 											<form:input type="text" class="form-control" id="type" 
 												path="type" placeholder='tip dokumenta 1-prijemnica, otpremnica, 2 - medjumagacinski dokument' tabindex="5"
 												value="${typesOfDocuments.type}" onclick="location.href='typesOfDocuments.html" /> 
											<p class="help-block">
 												<form:errors path="type" class="help-block" /> 
											</p>
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
												<!--                                     	<input type="radio" name="aktivan"  path='aktivan' -->
												<%--                                     	 checked  value="${task.aktivan}" >Da   --%>
												<input type="radio" name="aktivan" value="1" path='aktivan'
												<c:out value="${salary}"/> />
											</label> <label class="radio-inline"> <%--                                     	<input type="radio" class="col-sm-1" name="aktivan"  path='aktivan' value="${task.aktivan}">Ne --%>
												<input type="radio" class="col-sm-1" name="aktivan"
												value="0" path='aktivan' <c:out value="${salary1}"/> />
											</label>
										</div>
										
<%-- 									<a href='<c:out value="${param.id}" />'></a>												 --%>
																												
<%-- 										<div class='form-group ${error != null ? 'has-error' : ''}'>											 --%>
<%--  											<form:input type="hidden" name="" class="form-control" id="idDokument"  --%>
<%--  												path="idDokument" placeholder='idDokument'  --%>
<%--  												value="${idDokument}"  readonly='true' />   --%>
<!-- 											<p class="help-block"> -->
<%--  												<form:errors path="idDokument" class="help-block" />  --%>
<!-- 											</p> -->
<!-- 										</div>																							 -->

										<button type="submit" class="btn-lg button-novi" tabindex="5">
											<i class='fa fa-floppy-o'></i> Save
										</button>
										
										
										<input type="button" onclick="location.href='/typesOfDocuments.html'" value="Cancel"  class="btn-lg button-novi" tabindex="6"/>
<!-- 										<button type="reset" class="btn-lg button-novi"> -->
<!-- 											<i class='fa fa-reply'></i> Cancel -->
<!-- 										</button> -->

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