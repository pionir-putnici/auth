<!-- <!DOCTYPE html> -->
<!-- <html xmlns:th="http://www.thymeleaf.org"> -->
<!-- <head> -->
<!-- <meta charset="UTF-8" /> -->
<!-- <script type="text/javascript" -->
<!-- 	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script> -->
<!-- <script type="text/javascript" -->
<!-- 	src="static/vendor/bootstrap/js/bootstrap.js"></script> -->
<!-- <link href="static/vendor/bootstrap/css/bootstrap.min.css" -->
<!-- 	rel="stylesheet"> -->
<!-- 	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script> -->
<!-- 	<script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script> -->
<!-- <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="static/vendor/bootstrap/js/bootstrap.js"></script>
<link href="static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>	
	
<body>
<h1>help</h1>
<h1>${title}</h1>
	<div class="container">
	<div class="card">
		<div class="card-block">
<table class="table table-hover">
			<tbody>

				<tr th:each="country :${data.content}">
					<td th:text="${country.id}"></td>
					<!-- <td th:text="${country.id}"></td> -->
					<!-- <td th:text="${country.id}"></td> -->
				</tr>
			</tbody>
			</table>
			<hr/>
			<ul class="nav nav-pills">
			<li class="nav-item"
			th:each="i : ${#numbers.sequence(0,data.totalPages-1)}">
			<a th:text="${i}" class="nav-link"></a> 
			</li>
			
			</ul>
		</div>
		</div>
	</div>


</body>
</html>