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
					
						<div class='panel-heading'>${title} dat ${dokumentStavke.idDokument.datum} id ${dokumentStavke.idDokument.id}</div>
<%-- 						<div>${dokumentStavke.typesOfDocuments}</div> --%>
<%-- 						<div>${typesOfDocuments} aaaaaaaaaaaaa</div> --%>
<%-- 						<div>${dokumentStavke.magacini} bbbbbbbbbb</div> --%>
<%-- 						<div>${magacini} ccccccccccccccc</div> --%>
						
						<div class='panel-body'>
							<div class='row'>
								<div class='col-lg-3'>

									<form:form method="POST" action="/save_dokumentStavke.html"
  										modelAttribute="dokumentStavke">  

 										<input type="hidden" name="${_csrf.parameterName}" 
 											value="${_csrf.token}" /> 

 										<input type="hidden" name="aktivan" 
 											value="1" /> 
 											 											
<!--  										<input type="hidden" name="datum"  -->
<%--  											value="${dokumentStavke.idDokument.datum}" />  --%>
 											
 										<form:input type="hidden" name="id" path="id" 
 											value="${dokumentStavke.id}" /> 
 											
 											
										<div class="form-group"${error != null ? 'has-error' : ''}'>
											<label class='font-awesome'>Sifra artikala</label>

											<form:select path="artikli.id" class="form-control" tabindex="1">
<%-- 												<form:option value="0" label="--- Select ---" /> --%>
												<form:options items="${eArtikli}" />
											</form:select>

											<p class="help-block">
												<form:errors path="artikli.id" class="help-block" />
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
											<label class='font-oxygen'>Kolicina</label>
 											<form:input type="text" class="form-control" id="kolicina" 
 												path="kolicina" placeholder='Kolicina' tabindex="2"
 												value="${dokumentStavke.kolicina}" /> 
											<p class="help-block">
 												<form:errors path="kolicina" class="help-block" /> 
											</p>
										</div>

										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-oxygen'>Cena</label>
 											<form:input type="text" class="form-control" id="kolicina" 
 												path="cena" placeholder='Cena'  tabindex="3"
 												value="${dokumentStavke.cena}" /> 
											<p class="help-block">
 												<form:errors path="cena" class="help-block" /> 
											</p>
										</div>
																
										
										<div class='form-group ${error != null ? 'has-error' : ''}'>
											<label class='font-oxygen'>Iznos</label>
 											<form:input type="text" class="form-control" id="kolicina" 
 												path="iznos" placeholder='Iznos' tabindex="4"
 												value="${dokumentStavke.iznos}" /> 
											<p class="help-block">
 												<form:errors path="iznos" class="help-block" /> 
											</p>
										</div>
												
									<a href='<c:out value="${param.id}" />'></a>												
																												
										<div class='form-group ${error != null ? 'has-error' : ''}'>											
 											<form:input type="hidden" name="" class="form-control" id="idDokument" 
 												path="idDokument" placeholder='idDokument' 
 												value="${idDokument}"  readonly='true' />  
											<p class="help-block">
 												<form:errors path="idDokument" class="help-block" /> 
											</p>
										</div>																							

										<button type="submit" class="btn-lg button-novi" tabindex="5">
											<i class='fa fa-floppy-o'></i> Save
										</button>
										
										
										<input type="button" onclick="location.href='dokumentstavkefinal.html?page=0&id=${dokumentStavke.idDokument.id}';" value="Cancel"  class="btn-lg button-novi" tabindex="6"/>
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