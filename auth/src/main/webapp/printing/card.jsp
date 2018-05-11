<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>PrintDocument</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel='stylesheet' href='/printing/style.css' type='text/css' />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>

<body>

	<page size="A4" class="print">

	<div class='container-fluid'>
		<div class='row spacer-top-20' id='article-card-title'>
			<div class='col-xs-12'>
				<div class='row text-center'>
					<h4>Kartica artikla za period od dana ${oddana} do dana ${dodana}</h4> 
				</div>
			</div>
			<div class='col-xs-12 spacer-top-15' id="document-info">
				<div class='row'>
					<div class='col-xs-2'>
						<p>Datum izrade:</p>
					</div>
					<div class='col-xs-2'>
						<p>${currentdate}</p>
					</div>
				</div>
			</div>
		</div>
		<div class='row spacer-top-15' id='article-info-storage-location'>
			<div class='col-xs-2'>
				<p>Magacin:</p>
				
			</div>
			<div class='col-xs-10'>

				<c:forEach items="${magkart}" var="magkart">
					
							<p>	${magkart.code} ${magkart.name} </p>
							
				</c:forEach>
			</div>
		</div>
		<div class='row' id='article-info'>
			<div class='col-xs-2'>
				<p>Šifra</p>
			</div>
			<div class='col-xs-2'>
				<p>naziv</p>
			</div>
		</div>
		<div class='row'>
			<div class='col-xs-12'>
				<table class='tableDocuments'>
					<thead id="table-head-first-row">
						<th></th>
						<th colspan="2">DOKUMENT</th>
						<th>KOLIČINA</th>
						<th>KOLIČINA</th>
						<th></th>
						<th></th>
						<th>IZNOS</th>
						<th>IZNOS</th>
						<th></th>
					</thead>
					<thead id='table-head-second-row'>
						<th style="width: 5%;">RB</th>
						<th style="width: 10%;">DATUM</th>
						<th style="width: 10%;">BROJ</th>
						<th style="width: 10%;">ULAZ</th>
						<th style="width: 10%;">IZLAZ</th>
						<th style="width: 10%;">STANJE</th>
						<th style="width: 10%;">CENA</th>
						<th style="width: 10%;">ULAZ</th>
						<th style="width: 10%;">IZLAZ</th>
						<th style="width: 10%;">STANJE</th>
					</thead>
					<tbody>
						<tr>
							<td>1.</td>
							<td>30.04.2018</td>
							<td>000001</td>
							<td>100</td>
							<td>0</td>
							<td>100</td>
							<td>300,00</td>
							<td>30.000,00</td>
							<td>0,00</td>
							<td>100</td>
						</tr>

						<c:forEach items="${stavke}" var="stavka">
							<tr>
								<td>${stavka.id}</td>
								<td>${stavka.datum}</td>
								<td>${stavka.idDokument.brojDokumenta}</td>
								<td>${stavka.ulaz}</td>
								<td class='text-right'>${stavka.izlaz}</td>
								<td class='text-right'>${stavka.izlaz}</td>
								<td class='text-right'>${stavka.cena}</td>
							</tr>
						</c:forEach>

						<tr>
							<td colspan='3'>TOTAL</td>
							<td>Total ulaz</td>
							<td>Total izlaz</td>
							<td>Total stanje</td>
							<td></td>
							<td>Total ulaz</td>
							<td>Total izlaz</td>
							<td>Total stanje</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	</page>
	<script>
		
	</script>

</body>

</html>
