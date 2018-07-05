<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- <%@ page import="java.util.Date"%> -->
<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> -->
<!-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> -->
<!-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> -->

<html ng-app="myApp"> 
<!--  ng-app lang="en" -->
<head>
<!--  first part -->

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<!-- Bootstrap Core CSS -->
<link href="static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="static/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="static/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

	<link rel="stylesheet" href="static/css/style.css">
<!--  second part -->
    <meta charset="utf-8">
    <style type="text/css">
    ul>li, a{cursor: pointer;}
    </style>

<title>Unos reklamacionog zapisnika</title>
</head>
<body>

	<div id="wrapper">
		<%@ include file="horizontal-navigation.html"%>
		<%@ include file="vertical-menu.jsp"%>

		<div id="page-wrapper">

			<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">Reklamacioni zapisnici</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class='panel panel-default'>
						<div class='panel-heading'>Unos reklamacionog zapisnika</div>
						<div class='panel-body'>
							<div class='row'>
								<div class='col-lg-12'>
									<form:form method="POST" action="zapisnici-save"
										modelAttribute="zapisnici">
										
										
										
										<div class='col-lg-6'>
										
										<!-- Ovde ce ici select sa dokumentom -->
										
										<!-- *********************************** -->
										
										<!-- Dodati FK zapisnici.dokument_id ->dokument.id -->
										
										<div class='form-group'>
											<label class='font-roboto'>Dokument na koji se odnosi zapisnik</label>
											<%-- 									<textarea class="form-control" name='napomena' path='napomena'  placeholder='Unesite napomenu' value="${task.napomena}"></textarea> --%>
											<select id="selectManuf" class="form-control" name="dokument.id" >
    											<c:forEach var="role" items="${eDokument}">
      											<option class="${role.getKey()}" value="${role.getKey()}" ${role.getKey() == zapisnici.dokument.id ? 'selected' : ''}> ${role.getValue()}</option>
    											</c:forEach>
											</select>
											<p class="help-block">
												<form:errors path="dokument.id" class="help-block" />
											</p>
										</div>
										
										<div class='form-group'>
											<label class='font-roboto'>Napomena</label>
											<form:textarea type="text" class="form-control" id="napomena"
												path="remark" value="zapisnici.remark" rows="4"/>
											<p class="help-block">
												<form:errors path="remark" class="help-block" />
											</p>
										</div>
										
										<div class='form-group'>
											<label class='font-roboto'>Predao</label>
											<%-- 									<textarea class="form-control" name='napomena' path='napomena'  placeholder='Unesite napomenu' value="${task.napomena}"></textarea> --%>
											<form:input type="text" class="form-control" id="predao"
												path="predao" value="${zapisnici.predao}" />
											<p class="help-block">
												<form:errors path="predao" class="help-block" />
											</p>
										</div>
										
										<div class='form-group'>
											<label class='font-roboto'>Primio</label>
											<%-- 									<textarea class="form-control" name='napomena' path='napomena'  placeholder='Unesite napomenu' value="${task.napomena}"></textarea> --%>
											<form:input type="text" class="form-control" id="predao"
												path="primio" value="${zapisnici.primio}" />
											<p class="help-block">
												<form:errors path="predao" class="help-block" />
											</p>
										</div>
										
										<div class='form-group'>
										<button type="submit" class="btn-lg button-novi">
										<i class='fa fa-floppy-o'></i> Save
										</button>
											<input type="button" onclick="location.href='reklamacioni-zapisnici.html';"
										value="Cancel" class="btn-lg button-novi" />
										</div>
										
										</div>
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