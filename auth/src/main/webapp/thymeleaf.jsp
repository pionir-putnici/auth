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
									<a href="${new_item}">
										<button
											class='btn btn-lg btn-success button-novi border-radius-0'>
											<span class='glyphicon glyphicon-file'></span> New
										</button>
									</a> <a href="${print_item}" target="_blank">
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
										<th style="width: 7%;">Šifra</th>
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
									<tr th:each="country :${dokumentStavke}">
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
											<td>${tester.idDokument.brojDokumenta}</td>
											<td><a th:href="@{findOne/(id=${tester.id} })}"
												class="btn btn-primary eBtn"> Edit</a></td>
											<td><a href="dokumentStavka.html"
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
			<form th:action="@{/update_dokumentStavke.html}" method="post">
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

								<input type="hidden"
									name="${_csrf.parameterName}" value="${_csrf.token}" />

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
								<div class="form-group">
									<label for="kolicina" class="col-form-label">Kolicina:</label>
									<input type="text" class="form-control" id="kolicina"
										name="kolicina" value="" />
								</div>
								<div class="form-group">
									<label for="message-text" class="col-form-label">Message:</label>
									<textarea class="form-control" id="message-text"></textarea>
								</div>

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
		</div>
		MyForm


	</div>
	zadnji od

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
				$('.myForm #exampleModal').modal();
			});
		});
	</script>

</body>
</html>