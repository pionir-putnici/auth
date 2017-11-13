<!DOCTYPE HTML>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>

<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="vrste-paleta.html">Vrste paleta</a></li>
					<li><a href="new-task">New Task</a></li>
					<li><a
						href="http://10.11.124.11/pallete-management/pages/list-partners.php">Lista
							partnera</a></li>
					<li><a href="welcome">Logout</a></li>
				</ul>
			</div>
		</div>
	</div>



	<div class="container text-center">
		<h3>Manage ${title}</h3>
		<hr>



		 method="POST" action="save-vrste-paleta.html"
			modelAttribute="vrstePaleta">


			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

<!-- 			<div class="form-group"> -->
<!-- 				<label class="control-label col-md-3">Id</label> -->
<!-- 				<div class="col-md-7"> -->
<%-- 					<form:input type="text" class="form-control" name="uid" path="uid" --%>
<%-- 						value="${vrstePalata.uid}"  />  --%>
<!-- 					<div class="has-error"> -->
<%-- 						<form:errors path="uid" class="help-inline" /> --%>
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

					<form:input type="hidden" class="form-control" name="uid" path="uid"
						value="${vrstePalata.uid}"  /> 

			<div class="form-group">
				<label class="control-label col-md-3">Code</label>
				<div class="col-md-7">
					<form:input type="text" class="form-control" name="code"
						path="code" value="${vrstePalata.code}" autofocus="true" />
					<%-- 						<span>${error}</span> --%>
					<div class="has-error">
						<form:errors path="code" class="help-inline" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3">Name</label>
				<div class="col-md-7">
					<form:input type="text" class="form-control" id="name" path="name"
						value="${vrstePalata.name}" />
					<%-- 					<span>${error}</span> --%>
					<div class="has-error">
						<form:errors path="name" class="help-inline" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3">Remark</label>
				<div class="col-md-7">
					<form:textarea type="text" class="form-control" id="remark"
						path="remark" value="${vrstePalata.remark}" />
					<%-- 					<span>${error}</span> --%>
					<div class="has-error">
						<form:errors path="remark" class="help-inline" />
					</div>
				</div>
			</div>


			<c:out value="${model.vrstePaleta.aktivan}" />


			<c:if test="${vrstePaleta.aktivan}">
				<c:out value="${vrstePaleta.code}" />
			</c:if>


			<c:set var="salary" scope="session" value="checked">
			</c:set>
			<c:set var="salary1" scope="session" value="">
			</c:set>

			<c:if test="${vrstePaleta.aktivan == true}">
				<c:set var="salary" scope="session" value="checked" />
				<c:set var="salary1" scope="session" value="" />
			</c:if>

			<c:if test="${vrstePaleta.aktivan == false}">
				<c:set var="salary1" scope="session" value="checked" />
				<c:set var="salary" scope="session" value="" />
			</c:if>
			
			<c:if test="${(empty salary) and (empty salary1)}">
				<c:set var="salary" scope="session" value="checked" />
			</c:if>

salary
            <c:out value="${salary}"/>
            salary1
             <c:out value="${salary1}"/>

            Aktivan
             <c:out value="${vrstePaleta.aktivan}"/>
             
             
             
			<%-- <c:choose> --%>
			<%--    <c:when "${vrstePaleta.aktivan == true}"> --%>
			<%--       <c:set var="flag" value="checked" /> --%>
			<%--    </c:when> --%>
			<%--    <c:otherwise> --%>
			<%--       <c:set var="flag" value="" />   --%>
			<%--    </c:otherwise> --%>
			<%-- </c:choose>         --%>

			<div class="form-group">
				<label class="control-label col-md-3">Aktivan</label>
				<div class="col-md-7">
					<input type="radio" class="col-sm-1" name="aktivan" value="1"
						path='aktivan'  <c:out value="${salary}"/> />
					<div class="col-sm-1">Yes</div>
					<input type="radio" class="col-sm-1" name="aktivan" value="0"
						path='aktivan'  <c:out value="${salary1}"/> />
					<div class="col-sm-1">No</div>
				</div>
			</div>
	
			
 Aktivan 
 
 <div>${vrstePaleta.code} ${vrstePaleta.name}
				${vrstePaleta.aktivan}</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Save" />
			</div>

		</form:form>
	</div>

	<!-- 		<table> -->
	<!-- 			<tr> -->
	<!-- 				<td>First Name:</td> -->
	<%-- 				<td><form:input path="code" /></td> --%>
	<%-- 				<td><form:errors cssClass="error" path="code" /></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>Last Name:</td> -->
	<%-- 				<td><form:input path="name" /></td> --%>
	<%-- 				<td><form:errors cssClass="error" path="name" /></td> --%>
	<!-- 			</tr> -->

	<!-- 			<tr> -->
	<!-- 				<td colspan="3"><input type="submit" value="Submit" /></td> -->
	<!-- 			</tr> -->
	<!-- 		</table> -->


</body>


</html>