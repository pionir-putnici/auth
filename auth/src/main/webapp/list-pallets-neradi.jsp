<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>

<body>

<div id="wrapper">
<%@ include file="vertical-menu.jsp" %>

<div id="page-wrapper">
<div class='row'>
	<div class='col-lg-12'>
		<h2 class='page-header'>Lista paleta</h2>
	</div>
</div>
<div class='row'>
	<div class='col-lg-12'>
		<div class='panel panel-default'>
			<div class='panel-heading'>
				Pregled paleta po tabelama
			</div>
			<div class='panel-body'>
				<table style="width:100%;" class="table table-striped table-bordered table-hover" id="listaPaleta">
					<thead>
						<tr>
							<th style='width:10%;'>Id</th>
							<th style='width:10%;'>Šifra</th>
							<th>Naziv</th>
							<th>Napomena</th>
							<th>Aktivan</th>
							<th>Datum</th>
							<th>Modifikacije</th>
						</tr>
					</thead>
					<tbody>
							<c:forEach var="task" items="${tasks}">
								<tr>
									<td>${task.uid}</td>
									<td>${task.code}</td>
									<td class="text-left">${task.name}</td>
									<td class="text-left">${task.remark}</td>
									<td>${task.aktivan}</td>
									<td><fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss"
											value="${task.timestamp}" /></td>

									<td><a href="update-vrste-paleta.html?id=${task.uid}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-vrste-paleta.html?id=${task.uid}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="#myModal_${task.uid}" role="button" class="btn btn-small btn-danger" data-toggle="modal">Delete</a></td></tr>
									
                                <div id="myModal_${task.uid}" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">Confirm Delete</h4>
                                            </div>

                                            <div class="modal-body">
                                                <p>Are you sure you want to delete this data? </p>
                                            </div>
                                            <div class="modal-footer">

                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <a href="${pageContext.request.contextPath}/delete-vrste-paleta.html?id=${task.uid}" title="Delete"><i  class="glyphicon glyphicon-trash"></i>-Delete</a> 
                                                <!--                class="fa fa-trash-o"-->
                                            </div>
                                        </div>
                                    </div>
                                </div>  								
								
							</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- end of panel -->
	</div>
</div>


</div> 

</div> 

<%@ include file="scripts.jsp" %>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#listaPaleta').DataTable({
            responsive: true
        });
    });
    </script>
</body>
</html>