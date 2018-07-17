<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>PrintDocument</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel='stylesheet' href='/printing/style.css' type='text/css' />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>

<body>

	<page size="A4">
	
	<!-- Document header start -->

	<section id='printPageHeader' class='spacer-top-20'>

		<div class='container-fluid'>
			<div class='row' id='pageHeaderContainerTop'>
				<div class='col-xs-6'>
					<img src='/printing/pionir-logo.png' alt='Logo Pionir DOO'
						title='Logo Pionir DOO' />
				</div>
				<div class='col-xs-6'>
					<div class='row'>
						<div class='col-xs-12'>
							<h2>Međumagacinski prenos</h2>
						</div>
					</div>
				</div>
			</div>
			<div class='row' id='pageHeaderContainerBottom'>
				<div class='col-xs-6'>
					<div class='row'>
						<div class='col-xs-12'>
							<h2>Magacin otpreme</h2>
						</div>
					</div>
					<div class='row spacer-top-10'>
						<div class='col-xs-3'>
						Dokument
						</div>
						<div class='col-xs-9'>
						${dokument.id }
						</div>
					</div>
					<div class='row'>
						<div class='col-xs-3'>
						Magacin
						</div>
						<div class='col-xs-9' style='height:3em;'>
						${dokument.magacini.id } - ${dokument.magacini.name}
						</div>
					</div>
					<div class='row'>
						<div class='col-xs-3'>
						Datum
						</div>
						<div class='col-xs-9'>
						${dokument.datum }
						</div>
					</div>
				</div>
				<div class='col-xs-6'>
					<div class='row'>
						<div class='col-xs-12'>
							<h2>Magacin prijema</h2>
						</div>
					</div>
					<div class='row spacer-top-10'>
						<div class='col-xs-3'>
						Dokument
						</div>
						<div class='col-xs-9'>
						${dokument.veza }
						</div>
					</div>
					<div class='row'>
						<div class='col-xs-3'>
						Magacin
						</div>
						<div class='col-xs-9' style='height:3em;'>
						${dokument.magacini2.id } - ${dokument.magacini2.name }
						</div>
					</div>
					<div class='row'>
						<div class='col-xs-3'>
						Datum
						</div>
						<div class='col-xs-9'>
						${dokument.datum }
						</div>
					</div>
				</div>
				</div>
			</div>
		</div>

	</section>
	<!-- Document header end -->
	
	<!-- Document body start -->

	<section id='printPageBody'>
		<div class='container-fluid'>
			<div class='row'>
				<div class='col-xs-12'>
					<table class='tableDocuments spacer-top-30'>
						<thead>
							<th>RB</th>
							<th>ŠIFRA</th>
							<th>NAZIV</th>
							<th>JM</th>
							<th class='text-right'>KOLIČINA</th>
							<th class='text-right'>CENA</th>
							<th class='text-right'>IZNOS</th>
						</thead>
						<tbody>
						<c:forEach items="${dokumentStavke}" var="dokumentStavke">                     
                            <tr>
                                <td>${dokumentStavke.id}</td>
                                <td>${dokumentStavke.artikli.code}</td>
                                <td>${dokumentStavke.artikli.name}</td>
                                <td>${dokumentStavke.artikli.jediniceMera.name}</td>
                                <td class='text-right'>${dokumentStavke.kolicina}</td>
                                <td class='text-right'>${dokumentStavke.cena}</td>
                                <td class='text-right'>${dokumentStavke.iznos}</td>
                            </tr>

							<c:set var="totalIzn" value="${totalIzn + dokumentStavke.iznos}"/>
                            
                            </c:forEach>
						</tbody>
					</table>
				</div>
				<div class='col-xs-12' id='totalAmount'>
					<div class='col-xs-4 col-xs-offset-8 clear-padding'>
						<table class='tableDocuments spacer-top-20'>
							<tr><td>UKUPNO</td><td class='text-right'>${totalIzn} DIN</td></tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<!-- Document body end -->
	
	<!-- Document footer start -->
	
	<section id='printPageFooter' class='spacer-top-30'>
		<div class='container-fluid'>
			<!-- Remark -->
			<div class='row'>
				<div class='col-xs-12' id='remarkTitle'>
					<h3>Napomena</h3>
				</div>
				<div class='col-xs-12' id='remarkBody'>
					<p>${dokument.napomena }</p>
				</div>
			</div>
			<!-- Remark end-->
			<!-- Signature -->
			<div class='row spacer-top-30' id='signature'>
				<div class='col-xs-4'>
					<div class='row'>
						<div class='col-xs-6'>
						<p>Predao</p>
						</div>
					</div>
					<div class='row' id='signatureLineLeft'>
						<div class='col-xs-12'>
						 <hr />
						</div>
						<div class='col-xs-12'>
							${dokument.predao }
						</div>
					</div>
				</div>
				<div class='col-xs-4 col-xs-offset-4'>
					<div class='row'>
						<div class='col-xs-6'>
						<p>Primio</p>
						</div>
					</div>
					<div class='row' id='signatureLineRight'>
						<div class='col-xs-12'>
							<hr />
						</div>
						<div class='col-xs-12'>
							${dokument.primio }
						</div>
					</div>
				</div>
			</div>
			<!-- Signature end -->
		</div>
	</section>
	<!-- Document footer end -->
	</page>

</body>