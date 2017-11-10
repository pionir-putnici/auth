<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

<title>Task Manager | Home</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="container text-center">
		<h3>Manage Task</h3>
		<hr>
		<form class="form-horizontal" method="POST" action="hello">

			<%-- 					<input type="hidden" name="id" value="${task.id}"/> --%>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
<!-- 			becouse security	 -->

			<div class="form-group">
				<label class="control-label col-md-3">Name</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="name" value="${name}" />
					<%-- 							value="${task.name}"/> --%>
				</div>
			</div>

			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Save" />
			</div>
		</form>
	</div>
</body>
</html>

