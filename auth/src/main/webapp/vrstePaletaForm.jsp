<!DOCTYPE HTML>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

<title>${title}</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/sb-admin-2.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<!-- <body>  -->
<body onload="SetDate();">
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="vrste-paleta.html">Vrste paleta</a></li>
					<li><a href="new-task">New Task</a></li>
					<li><a href="all-tasks">All Tasks</a></li>
					<li><a href="welcome">Logout</a></li>
				</ul>
			</div>
		</div>
	</div>


	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to ${title}</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_TASKS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My  ${title}</h3>
				<hr>
				<div class="table-responsive">
				<a href="new-vrste-paleta.html">New</a>
					<table class="table table-striped table-bordered table-hover" >  
<!-- 					text-left -->
						<thead>
							<tr>
								<th style="width:5%" >Id</th>
								<th style="width:5%">Code</th>
								<th style="width:40%">Name</th>
								<th style="width:30%">Remark</th>
								<th style="width:5%">Aktivan</th>
								<th style="width:15%">Date Created</th>
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
		</c:when>
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage  ${title}</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-vrste-paleta.html">
				
				    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				
					<input type="hidden" name="id" value="${task.uid}" />
					
					<div class="form-group">
						<label class="control-label col-md-3">Code</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="code"
								value="${task.code}" />
						<div class="has-error">
                    		<form:errors path="code" class="help-inline"/>
                		</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${task.name}" />
						<div class="has-error">
                    		<form:errors path="name" class="help-inline"/>
                		</div>								
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Timestamp</label>
						<div class="col-md-7">
							<input type="date" class="form-control" name="timestamp" id="timestamp
								value="${task.timestamp}" />
						<div class="has-error">
                    		<form:errors path="timestamp" class="help-inline"/>
                		</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Active</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="finished" value="true" />
							<div class="col-sm-1">Yes</div>
							<input type="radio" class="col-sm-1" name="finished"
								value="false" checked />
							<div class="col-sm-1">No</div>
						</div>
					</div>					
					
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>

	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script type="text/javascript">

	function SetDate()
	{
	var date = new Date();
	var day = date.getDate();
	var month = date.getMonth() + 1;
	var year = date.getFullYear();
	if (month < 10) month = "0" + month;
	if (day < 10) day = "0" + day;	
	var today = year + "-" + month + "-" + day;
	document.getElementById('timestamp').value = today;
	}
</script>
</body>
</html>