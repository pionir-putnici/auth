<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="top.jsp"%>

<body>

	<div id="wrapper">
		<%@ include file="horizontal-navigation.html"%>
		<%@ include file="vertical-menu.jsp"%>

		<div id="page-wrapper">
			<div class='row'>

				<div class='col-lg-12 '>
					<div class='panel panel-default margin-top-10 border-radius-0'>

						<div class='panel-heading'>${title}</div>

						<!-- 						<div class='panel-body'> -->
						<!-- 							<div class='row spacer-bottom'> -->
						<!-- 								<div class='col-lg-12'> -->
						<%-- 									<a href="${new_item}"> --%>
						<!-- 										<button -->
						<!-- 											class='btn btn-lg btn-success button-novi border-radius-0'> -->
						<!-- 											<span class='glyphicon glyphicon-file'></span> New -->
						<!-- 										</button> -->
						<%-- 									</a> <a href="${print_item}" target="_blank"> --%>
						<!-- 										<button -->
						<!-- 											class='btn btn-lg btn-success button-novi border-radius-0 margin-left-10'> -->
						<!-- 											<span class='fa fa-print'></span> Print -->
						<!-- 										</button> -->
						<!-- 									</a> -->
						<!-- 								</div> -->
						<!-- 							</div> -->
						<!-- 							<div class='row spacer-bottom border-bottom'></div> -->
						<!-- 							<table id="itemsTable" -->
						<!-- 								class="display table table-striped table-bordered table-hover border-radius-0"> -->
						<!-- 								Header Table -->
						<!-- 								<thead> -->
						<!-- 									<tr> -->
						<!-- 										<th style="width: 5%;">Id</th> -->
						<!-- 										<th style="width: 7%;">Šifra</th> -->
						<!-- 										<th style="width: 30%;">Naziv</th> -->
						<!-- 										<th style="width: 27%;">Napomena</th> -->
						<!-- 										<th style="width: 10%;">Vreme</th> -->
						<!-- 										<th style="width: 6%;">Act</th> -->
						<!-- 										<th style="width: 15%;">Akcija</th> -->
						<!-- 									</tr> -->
						<!-- 								</thead> -->
						<!-- 							</table> -->


						<!-- 						</div> -->

						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal" data-whatever="@mdo">Open
							modal for @mdo</button>
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal" data-whatever="@fat">Open
							modal for @fat</button>
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal" data-whatever="@getbootstrap">Open
							modal for @getbootstrap</button>

						<div class="myForm">
							<form:form method="POST" action="save-vrste-artikala.html"
								modelAttribute="vrsteArtikala">

								<div class="modal fade" id="exampleModal" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">New
													message</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<form>
													<div class="form-group">
														<label for="recipient-name" class="col-form-label">Recipient:</label>
														<input type="text" class="form-control"
															id="recipient-name">
													</div>
													<div class="form-group">
														<label for="message-text" class="col-form-label">Message:</label>
														<textarea class="form-control" id="message-text"></textarea>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
												<button type="button" class="btn btn-primary">Send
													message</button>
											</div>
										</div>
									</div>
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
					<!-- end of panel -->
				</div>
			</div>


		</div>

	</div>

	<%@ include file="scripts.jsp"%>
	<c:choose>
		<c:when test="${title == 'Type of articles'}">
			<script src="static/js/datatable-vrsteartikala.js"></script>
		</c:when>
		<c:when test="${title == 'Units of measure'}">
			<script src="static/js/datatable-jedinicemera.js"></script>
		</c:when>
		<c:when test="${title == 'Classifications'}">
			<script src="static/js/datatable-klasifikacije.js"></script>
		</c:when>
		<c:when test="${title == 'Poreske grupe'}">
			<script src="static/js/datatable-poreskegrupe.js"></script>
		</c:when>
		<c:when test="${title == 'Types of warehouse'}">
			<script src="static/js/datatable-vrstemagacina.js"></script>
		</c:when>
		<c:when test="${title == 'States'}">
			<script src="static/js/datatable-states.js"></script>
		</c:when>
		<c:when test="${title == 'Zip Codes'}">
			<script src="static/js/datatable-zipcodes.js"></script>
		</c:when>

		<c:when test="${title == 'Types of Documents'}">
			<script src="static/js/datatable-typesofdocuments.js"></script>
		</c:when>
	</c:choose>


	<script>
		function ConfirmDelete() {
			var x = confirm("Are you sure you want to delete?");
			if (x)
				return true;
			else
				return false;
		}
	</script>

</body>
</html>