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
						<div class='panel-heading'>Magacini</div>
						<div class='panel-body'>
							<div class='row spacer-bottom'>
								<div class='col-lg-12'>
								<a href="/new-magacini.html">
								<button class = 'btn btn-lg btn-success button-novi border-radius-0'><span class='glyphicon glyphicon-file'></span> Novi</button>
								</a>
								<a href="/magacini_pdf.html">
								<button class = 'btn btn-lg btn-success button-novi border-radius-0 margin-left-10'><span class='fa fa-print'></span> Štampa</button>
								</a>
								</div>
							</div>
							<div class='row spacer-bottom border-bottom'>
							
							</div>
							<table id="magaciniTable" class="display table table-striped table-bordered table-hover border-radius-0">
								<!-- Header Table -->
								<thead>
									<tr>
										<th style="width: 5%;">Id</th>
										<th style="width: 7%;">Šifra</th>
										<th style="width: 15%;">Naziv</th>
										<th style="width: 15%;">Partner</th>										
										<th style="width: 20%;">Adresa</th>
										<th style="width: 8%;">Ptt</th>
										<th style="width: 10%;">Tip</th>
										<th style="width: 6%;">Act</th>
										<th style="width: 14%;">Akcija</th>
									</tr>
								</thead>
							</table>


						</div>
					</div>
					<!-- end of panel -->
				</div>
			</div>


		</div>

	</div>

	<%@ include file="scripts.jsp"%>
	<script src="static/js/datatable-magacini.js"></script>
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
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