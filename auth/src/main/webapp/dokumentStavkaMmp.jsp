<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="top.jsp"%>

<!-- youtube thymeleaf, spring controller, jquery -->
<!-- https://www.youtube.com/watch?v=lIgFe20dYq4&t=1849s -->

<body>

	<div id="wrapper">
		<%@ include file="horizontal-navigation.html"%>
		<%@ include file="vertical-menu.jsp"%>




		<div id="page-wrapper">
			<div class='row'>

				<div class='col-lg-12 '>
					<div class='panel panel-default margin-top-10 border-radius-0'>


						<div class='panel-heading'>${title}</div>

						<div class='panel-body'>
							<div class='row spacer-bottom'>

								<div class='col-lg-12'>

									<c:url value="mmp.html" var="displayURL">
<%-- 										<c:param name="brDokumenta" value="${param.id}" /> --%>
<%-- 										<c:param name="page" value="${param.page}" /> --%>
									</c:url>
									
									<a href='<c:out value="${displayURL}" />'>
										<button
											class='btn btn-lg btn-success button-novi border-radius-0'>
											<span class='glyphicon glyphicon-arrow-left'></span> Back
										</button>										
									</a> 


									<c:url value="dokumentStavkeMmp_new.html" var="displayURL">
										<c:param name="brDokumenta" value="${param.id}" />
										<c:param name="page" value="${param.page}" />
									</c:url>

									<a href='<c:out value="${displayURL}" />'>
										<button
											class='btn btn-lg btn-success button-novi border-radius-0'>
											<span class='glyphicon glyphicon-file'></span> New
										</button>										
									</a> 
									
									<a href="${print_item}" target="_blank">
										<button
											class='btn btn-lg btn-success button-novi border-radius-0 margin-left-10'>
											<span class='fa fa-print'></span> Print
										</button>
									</a>
								</div>
							</div>
							<div class='row spacer-bottom border-bottom'></div>
							<table id="itemsTable"
								class="display table table-striped table-bordered table-hover border-radius-0">
								<!-- Header Table -->
								<thead>
									<tr>
										<th style="width: 5%;">Id</th>
										<th style="width: 7%;">Sifra</th>
										<th style="width: 30%;">Naziv</th>
										<th style="width: 7%;">Jm</th>
										<th style="width: 10%;">Kolicina</th>
										<th style="width: 10%;">Cena</th>
										<th style="width: 10%;">Iznos</th>
										<th style="width: 6%;">Act</th>
										<th style="width: 7%;">Akcija</th>
										<th style="width: 8%;">Akcija</th>
									</tr>
								</thead>
								<tbody>
									<tr th:each="country :${data}">
										<td th:text="${country.id}"></td>
										<!-- <td th:text="${country.id}"></td> -->
										<!-- <td th:text="${country.id}"></td> -->
									</tr>
									<c:forEach items="${dokumentStavke}" var="tester">
										<tr>
											<td>${tester.id}</td>
											<td>${tester.artikli.code}</td>
											<td>${tester.artikli.name}</td>
											<td>${tester.artikli.jediniceMera.name}</td>
											<td>${tester.kolicina}</td>
											<td>${tester.cena}</td>
											<td>${tester.iznos}</td>
											<td>${tester.idDokument.id}</td>
											<%-- 											<a href="/Portfolio/${page}">Click Here</a> --%>
											<td><a
												href="/update_dokumentStavkeMmp.html?id=${tester.id}&brDokumenta=${tester.idDokument.id}"
												class="btn btn-primary eBtn"> Edit</a></td>
											<td><a onClick="return ConfirmDelete();"
												href="/delete_dokumentStavkeMmp.html?id=${tester.id}&brDokumenta=${tester.idDokument.id}"
												class="btn btn-danger  dBtn"> Delete</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>


						</div>
					</div>
					<!-- end of panel -->
				</div>
			</div>


		</div>


		<div class="myForm">
			<form th:action="@{/save_dokumentStavke.html}" method="post">

				<%-- 										<form:form method="POST" action="save_dokumentStavke.html" --%>
				<%-- 										modelAttribute="dokumentStavke"> --%>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<div class="modal fade" id="exampleModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Create or
									update</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">

								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<%-- 										<form:input type="hidden" name="id" path="id" --%>
								<%-- 											value="${dokumentStavke.id}" /> --%>

								<%-- 										<div class='form-group ${error != null ? 'has-error' : ''}'> --%>
								<!-- 											<label class='font-oxygen'>Šifra</label> -->

								<%-- 											<form:input type="text" class="form-control " name="code" --%>
								<%-- 												path="code" value="${dokumentStavke.artikal.code}" autofocus="true" --%>
								<%-- 												placeholder='Unesite šifru' /> --%>

								<!-- 											<p class="help-block"> -->
								<%-- 												<form:errors path="code" class="help-block text-danger" /> --%>
								<!-- 											</p> -->
								<!-- 										</div> -->

								<div class="form-group">
									<label for="sifra" class="col-form-label">Sifra:</label> <input
										type="text" class="form-control" id="sifra" name="sifra"
										value="" />
								</div>

								<div class="form-group">
									<label for="kolicina" class="col-form-label">Kolicina:</label>
									<input type="text" class="form-control" id="kolicina"
										name="kolicina" value="" />
								</div>

								<div class="form-group">
									<label for="cena" class="col-form-label">Cena:</label> <input
										type="text" class="form-control" id="cena" name="cena"
										value="" />
								</div>

								<div class="form-group">
									<label for="iznos" class="col-form-label">Iznos:</label> <input
										type="text" class="form-control" id="iznos" name="iznos"
										value="" />
								</div>
								<!-- 								<div class="form-group"> -->
								<!-- 									<label for="kolicina" class="col-form-label">Kolicina:</label> -->
								<!-- 									<input type="text" class="form-control" id="kolicina" -->
								<!-- 										name="kolicina" value="" /> -->
								<!-- 								</div> -->
								<!-- 								<div class="form-group"> -->
								<!-- 									<label for="message-text" class="col-form-label">Message:</label> -->
								<!-- 									<textarea class="form-control" id="message-text"></textarea> -->
								<!-- 								</div> -->

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<input type="submit" class="btn btn-primary" value="save" />
							</div>
						</div>
					</div>

				</div>
			</form>
			<%-- 									</form:form> --%>
		</div>



	</div>


	<%@ include file="scripts.jsp"%>

	<script>
		function ConfirmDelete() {
			var x = confirm("Are you sure you want to delete?");
			if (x)
				return true;
			else
				return false;
		}
	</script>

	<script>
		$(document).ready(function() {
			$('.table .eBtn').on('click', function(event) {
				event.preventDefault();
				var href = $(this).attr('href');
				
				$.get(href.function(dokumentStavke,status)){
					$('.myForm #id').val(dokumentStavke.id);
					$('.myForm #code').val(dokumentStavke.code);
					$('.myForm #kolicina').val(dokumentStavke.kolicina);
					$('.myForm #cena').val(dokumentStavke.cena);
					$('.myForm #iznos').val(dokumentStavke.iznos);
				}
				$('.myForm #exampleModal').modal();
			});
		});
	</script>

</body>
</html>