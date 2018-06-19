<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.util.Date"%>
<%@ page import="java.util.TreeMap"%>

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
			<p>${currentdate}</p>
				<div class='row text-center'>
					<h4>Kartica artikla za period od dana ${oddana} do dana
						${dodana} </h4> 						
				</div>
			</div>
			
		</div>
		<c:set value="${true}" var="unCheckFlag1"></c:set>
		<c:forEach items="${partkart}" var="partkart">


			<div class='row spacer-top-15' id='article-info-storage-location'>
				<div class='col-xs-2'>
					<p>Partner:</p>
				</div>
				
				<div class='col-xs-10'>

					<p>${partkart.code} ${partkart.name}</p>

				</div>
			</div>

		<c:forEach items="${magkart}" var="magkart">


			<div class='row spacer-top-15' id='article-info-storage-location'>
				<div class='col-xs-2'>
					<p>Magacin-objekat:</p>
				</div>
				
				<div class='col-xs-10'>

					<p>${magkart.code} ${magkart.name}</p>

				</div>
			</div>
<c:set value="${true}" var="unCheckFlag1"></c:set>
			<c:forEach items="${artkart}" var="artkart">				        
	        
<%-- 	        <c:forEach items="${kontrola}" var="kontrola"> --%>
<%-- 	            <c:out value="${kontrola}"></c:out>    			 --%>
<%--     			<c:out value="${kontrola.key}"></c:out> --%>
<%-- 			</c:forEach> --%>
									
<!-- 				<div class='row' id='article-info'> -->
<!-- 					<div class='col-xs-2'> -->
<%-- 						<p>Šifra: ${artkart.code}</p> --%>
<!-- 					</div> -->
<!-- 					<div class='col-xs-2'> -->
<%-- 						<p>${artkart.name}</p> --%>
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				<div class='row'> -->
<!-- 					<div class='col-xs-12'> -->
<!-- 						<table class='tableDocuments'> -->
<!-- 							<thead id="table-head-first-row"> -->
<!-- 								<th></th> -->
<!-- 								<th colspan="2">DOKUMENT</th> -->
<!-- 								<th class='text-right'>KOLIČINA</th> -->
<!-- 								<th class='text-right'>KOLIČINA</th> -->
<!-- 								<th></th> -->
<!-- 								<th></th> -->
<!-- 								<th class='text-right'>IZNOS</th> -->
<!-- 								<th class='text-right'>IZNOS</th> -->
<!-- 								<th></th> -->
<!-- 							</thead> -->
<!-- 							<thead id='table-head-second-row'> -->
<!-- 								<th style="width: 5%;">RB</th> -->
<!-- 								<th style="width: 10%;">DATUM</th> -->
<!-- 								<th style="width: 10%;">BROJ</th> -->
<!-- 								<th style="width: 10%;" class='text-right'>ULAZ</th> -->
<!-- 								<th style="width: 10%;" class='text-right'>IZLAZ</th> -->
<!-- 								<th style="width: 10%;" class='text-right'>STANJE</th> -->
<!-- 								<th style="width: 10%;" class='text-right'>CENA</th> -->
<!-- 								<th style="width: 10%;" class='text-right'>ULAZ</th> -->
<!-- 								<th style="width: 10%;" class='text-right'>IZLAZ</th> -->
<!-- 								<th style="width: 10%;" class='text-right'>STANJE</th> -->
<!-- 							</thead> -->
<!-- 							<tbody> -->
								<c:forEach items="${stavkart}" var="stavka">

									<c:set value="${false}" var="unCheckFlag"></c:set>
	
									
									<c:if test="${stavka.idDokument.partner.id==partkart.id && stavka.artikli.id==artkart.id && stavka.idDokument.magacini.id==magkart.id && (stavka.ulaz!=null || stavka.izlaz!=null)}">

									<c:if test="${'unCheckFlag'== false}"> 													
										<c:set value="${true}" var="unCheckFlag"></c:set> 
										<c:set value="${false}" var="unCheckFlag1"></c:set>
				<div class='row' id='article-info'>
					<div class='col-xs-2'>
						<p>Šifra: ${artkart.code}</p>
					</div>
					<div class='col-xs-2'>
						<p>${artkart.name}</p>
					</div>
				</div>

				<div class='row'>
					<div class='col-xs-12'>
						<table class='tableDocuments'>										
							<thead id="table-head-first-row">
								<th></th>
								<th colspan="2">DOKUMENT</th>
								<th class='text-right'>KOLIČINA</th>
								<th class='text-right'>KOLIČINA</th>
								<th></th>
								<th></th>
								<th class='text-right'>IZNOS</th>
								<th class='text-right'>IZNOS</th>
								<th></th>
							</thead>
							<thead id='table-head-second-row'>
								<th style="width: 5%;">RB</th>
								<th style="width: 10%;">DATUM</th>
								<th style="width: 10%;">BROJ</th>
								<th style="width: 10%;" class='text-right'>ULAZ</th>
								<th style="width: 10%;" class='text-right'>IZLAZ</th>
								<th style="width: 10%;" class='text-right'>STANJE</th>
								<th style="width: 10%;" class='text-right'>CENA</th>
								<th style="width: 10%;" class='text-right'>ULAZ</th>
								<th style="width: 10%;" class='text-right'>IZLAZ</th>
								<th style="width: 10%;" class='text-right'>STANJE</th>
							</thead>
							<tbody>
									</c:if>
									
 									<c:set var="totalKol" value="${totalKol + stavka.ulaz-stavka.izlaz}"/>
 									<c:set var="totalVred" value="${totalVred + stavka.duguje-stavka.potrazuje}"/>
 									<c:set var="totalUlaz" value="${totalUlaz + stavka.ulaz}"/>
 									<c:set var="totalIzlaz" value="${totalIzlaz + stavka.izlaz}"/>
 									<c:set var="totalDuguje" value="${totalDuguje + stavka.duguje}"/>
 									<c:set var="totalPotrazuje" value="${totalPotrazuje + stavka.potrazuje}"/>

<%-- 									<c:if test="${stavka.ulaz!=null || stavka.izlaz!=null}"> 									 --%>
										<tr>
											<td>${stavka.id}</td>
											<td>${stavka.datum}</td>
											<td>${stavka.idDokument.brojDokumenta}</td>
											<td class='text-right'>${stavka.ulaz}</td>
											<td class='text-right'>${stavka.izlaz}</td>
											<td class='text-right'>${totalKol}</td>
											<td class='text-right'>${stavka.cena}</td>
											<td class='text-right'>${stavka.duguje}</td>
											<td class='text-right'>${stavka.potrazuje}</td>
											<td class='text-right'>${totalVred}</td>
										</tr>
									</c:if>
<!-- 									stavka -->
<%-- 									</c:if> --%>

								</c:forEach>
								<c:if test="${'unCheckFlag1'== false}"> 													
										<c:set value="${true}" var="unCheckFlag1"></c:set> 
								<tr>
									<td colspan='3'>Ukupno za artikal:</td>
									<td class='text-right'>${totalUlaz}</td>
									<td class='text-right'>${totalIzlaz}</td>
									<td></td>
									<td></td>
									<td class='text-right'>${totalDuguje}</td>
									<td class='text-right'>${totalPotrazuje}</td>
									<td></td>
								</tr>
								
							</tbody>
						</table>
					</div>
				</div>
				
				
				<br/>
 				</c:if>					
 									<c:set var="totalKolm" value="${totalKolm + totalKol}"/>
 									<c:set var="totalVredm" value="${totalVredm + totalVred}"/>
 									<c:set var="totalUlazm" value="${totalUlazm + totalUlaz}"/>
 									<c:set var="totalIzlazm" value="${totalIzlazm + totalIzlaz}"/>
 									<c:set var="totalDugujem" value="${totalDugujem + totalDuguje}"/>
 									<c:set var="totalPotrazujem" value="${totalPotrazujem + totalPotrazuje}"/>
 									
 									<c:set var="totalKols" value="${totalKols + totalKol}"/>
 									<c:set var="totalVreds" value="${totalVreds + totalVred}"/>
 									<c:set var="totalUlazs" value="${totalUlazs + totalUlaz}"/>
 									<c:set var="totalIzlazs" value="${totalIzlazs + totalIzlaz}"/>
 									<c:set var="totalDugujes" value="${totalDugujes + totalDuguje}"/>
 									<c:set var="totalPotrazujes" value="${totalPotrazujes + totalPotrazuje}"/> 									
 									
 									<c:set var="totalKolp" value="${totalKolp + totalKol}"/>
 									<c:set var="totalVredp" value="${totalVredp + totalVred}"/>
 									<c:set var="totalUlazp" value="${totalUlazp + totalUlaz}"/>
 									<c:set var="totalIzlazp" value="${totalIzlazp + totalIzlaz}"/>
 									<c:set var="totalDugujep" value="${totalDugujep + totalDuguje}"/>
 									<c:set var="totalPotrazujep" value="${totalPotrazujep + totalPotrazuje}"/> 									

 									<c:set var="totalKol" value="0"/>
 									<c:set var="totalVred" value="0"/>
 									<c:set var="totalUlaz" value="0"/>
 									<c:set var="totalIzlaz" value="0"/>
 									<c:set var="totalDuguje" value="0"/>
 									<c:set var="totalPotrazuje" value="0"/> 									
<!--  							artkart						 -->
			</c:forEach>
								<table class='tableDocuments'>
								<thead id='table-head-second-row'>
								<th style="width: 5%;"></th>
								<th style="width: 10%;"></th>
								<th style="width: 10%;"></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
							    </thead>
								
								<tr>
									<td colspan='3'>Ukupno za magacin-objekat:</td>
									<td class='text-right'>${totalUlazm}</td>
									<td class='text-right'>${totalIzlazm}</td>
									<td></td>
									<td></td>
									<td class='text-right'>${totalDugujem}</td>
									<td class='text-right'>${totalPotrazujem}</td>
									<td></td>
								</tr>
								</table>
								
									<c:set var="totalKolm" value="0"/>
 									<c:set var="totalVredm" value="0"/>
 									<c:set var="totalUlazm" value="0"/>
 									<c:set var="totalIzlazm" value="0"/>
 									<c:set var="totalDugujem" value="0"/>
 									<c:set var="totalPotrazujem" value="0"/> 									
<!-- 						magkart		 -->
		</c:forEach>

<!-- 		</br> -->
		<div>dodato</div>
								<table class='tableDocuments'>
								<thead id='table-head-second-row'>
								<th style="width: 5%;"></th>
								<th style="width: 10%;"></th>
								<th style="width: 10%;"></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
							    </thead>
								
								<tr>
									<td colspan='3'>Ukupno za partnera:</td>
									<td class='text-right'>${totalUlazp}</td>
									<td class='text-right'>${totalIzlazp}</td>
									<td></td>
									<td></td>
									<td class='text-right'>${totalDugujep}</td>
									<td class='text-right'>${totalPotrazujep}</td>
									<td></td>
								</tr>
								</table>
								
									<c:set var="totalKolp" value="0"/>
 									<c:set var="totalVredp" value="0"/>
 									<c:set var="totalUlazp" value="0"/>
 									<c:set var="totalIzlazp" value="0"/>
 									<c:set var="totalDugujep" value="0"/>
 									<c:set var="totalPotrazujep" value="0"/>

<!-- 								partkart -->
		</c:forEach>

		</br>		
								<table class='tableDocuments'>
								<thead id='table-head-second-row'>
								<th style="width: 5%;"></th>
								<th style="width: 10%;"></th>
								<th style="width: 10%;"></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
							    </thead>
								
								<tr>
									<td colspan='3'>Ukupno za pregled: </td>
									<td class='text-right'>${totalUlazs}</td>
									<td class='text-right'>${totalIzlazs}</td>
									<td></td>
									<td></td>
									<td class='text-right'>${totalDugujes}</td>
									<td class='text-right'>${totalPotrazujes}</td>
									<td></td>
								</tr>
								</table>


	</div>
	</page>
	<script>
		
	</script>

</body>

</html>
