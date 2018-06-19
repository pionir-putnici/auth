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
<title>Cards of articles grouped by partners, warehouses - object and articles</title>
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
						${dodana}</h4>

				</div>
			</div>

		</div>

		<div class='row'>
			<div class='col-xs-12'>

				<c:set value="${true}" var="stampaZaglavljaArtikla"></c:set>
				<c:set var="aktivniArtikal" value="0" />

				<c:set value="${true}" var="stampaZaglavljaMagacina"></c:set>
				<c:set var="aktivniMagacin" value="0" />

<%-- 								<c:out value='${stavkart}' default='guest' /> --%>
<!-- 								<br /> -->

				<%-- 				<c:out value='${stampaZaglavljaArtikla}' default='guest' /> --%>
				<%-- 				<c:out value='${aktivniArtikal}' default='guest' /> --%>
				<!-- 				<br /> -->


				<!-- ********************* POCETAK CITANJA STAVAKA ********************************** -->

				<c:forEach items="${stavkart}" var="stavka">

<%-- 					<c:if test="${aktivniArtikal!=stavka.artikli.id }"> --%>
<%-- 						<c:set value="${true}" var="stampaZaglavljaArtikla"></c:set> --%>
<%-- 					</c:if> --%>
					
<%-- 					<c:if test="${aktivniMagacin!=stavka.idDokument.magacini.id }"> --%>
<%-- 						<c:set value="${true}" var="stampaZaglavljaMagacina"></c:set> --%>
<%-- 					</c:if> --%>

					<c:if test="${stampaZaglavljaMagacina==true}">

						<c:set value="${false}" var="stampaZaglavljaMagacina"></c:set>
						<c:set value="${stavka.idDokument.magacini.id}" var="aktivniMagacin"></c:set>

						<br/>
						<div class='row' id='article-info'>
							<div class='col-xs-2'>
								<p>Magacin Šifra: ${stavka.idDokument.magacini.id}
									${stavka.idDokument.magacini.code}</p>
								<%-- <p>Id: ${stavka.artikli.id} aktivni ${aktivniArtikal}</p> --%>
							</div>
							<div class='col-xs-2'>
								<p>${stavka.idDokument.magacini.name}</p>
							</div>
						</div>

					</c:if>


<!-- ***************** zaglavlje artikla ************* -->

					<c:if test="${stampaZaglavljaArtikla==true}">

						<c:set value="${false}" var="stampaZaglavljaArtikla"></c:set>
						<c:set value="${stavka.artikli.id}" var="aktivniArtikal"></c:set>

						<div class='row' id='article-info'>
							<div class='col-xs-2'>
								<p>Artikal Šifra: ${stavka.artikli.id}
									${stavka.artikli.code}</p>
								<%-- <p>Id: ${stavka.artikli.id} aktivni ${aktivniArtikal}</p> --%>
							</div>
							<div class='col-xs-2'>
								<p>${stavka.artikli.name}</p>
							</div>
						</div>

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
<!-- ***************** kraj zaglavlje artikla ************* -->

								<!-- ************************* UKUPNO ZA ARTIKAL ********************************  -->

								<c:if test="${aktivniArtikal !=stavka.artikli.id }">
									<%-- <c:out value="artikli nisu isti" /> --%>
							</tbody>
						</table>
						<table class='tableDocuments'>
							<thead id="table-head-first-row">
								<th style="width: 5%;"></th>
								<th style="width: 10%;">Za artikal</th>
								<th style="width: 10%;"></th>
								<th style="width: 10%;" class='text-right'>${totalUlaz}</th>
								<th style="width: 10%;" class='text-right'>${totalIzlaz}</th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'>${totalDuguje}</th>
								<th style="width: 10%;" class='text-right'>${totalPotrazuje}</th>
								<th style="width: 10%;" class='text-right'></th>
							</thead>

						</table>

						<c:set var="totalKol" value="0" />
						<c:set var="totalVred" value="0" />
						<c:set var="totalUlaz" value="0" />
						<c:set var="totalIzlaz" value="0" />
						<c:set var="totalDuguje" value="0" />
						<c:set var="totalPotrazuje" value="0" />

						<c:set value="${true}" var="stampaZaglavljaArtikla"></c:set>
						<c:set var="aktivniArtikal" value="${stavka.artikli.id}" />

						<!-- ************************* KRAJ UKUPNO ZA ARTIKAL ********************************  -->

<!-- ispis ukupno za magacin ukoliko je novi magacin -->

							<!-- ********************* ukupno za magacin ************************ -->

								<c:if test="${aktivniMagacin!=stavka.idDokument.magacini.id }">
									<%-- <c:out value="artikli nisu isti" /> --%>
							</tbody>
						</table>
						<table class='tableDocuments'>
							<thead id="table-head-first-row">
								<th style="width: 5%;"></th>
								<th style="width: 10%;">Za magacin:</th>
								<th style="width: 10%;"></th>
								<th style="width: 10%;" class='text-right'>${totalUlazm}</th>
								<th style="width: 10%;" class='text-right'>${totalIzlazm}</th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'>${totalDugujem}</th>
								<th style="width: 10%;" class='text-right'>${totalPotrazujem}</th>
								<th style="width: 10%;" class='text-right'></th>
							</thead>

						</table>

						<c:set var="totalKolm" value="0" />
						<c:set var="totalVredm" value="0" />
						<c:set var="totalUlazm" value="0" />
						<c:set var="totalIzlazm" value="0" />
						<c:set var="totalDugujem" value="0" />
						<c:set var="totalPotrazujem" value="0" />

						<c:set value="${true}" var="stampaZaglavljaMagacina"></c:set>
						<c:set var="aktivniMagacin" value="${stavka.idDokument.magacini.id}" />

						<!-- ************************* KRAJ UKUPNO ZA MAGACIN ********************************  -->

						<!-- *************** ispis zaglavlja artikla *********************** -->

						<c:set value="${false}" var="stampaZaglavljaMagacina"></c:set>
						<c:set var="aktivniMagacin" value="${stavka.idDokument.magacini.id}" />

						<div class='row' id='article-info'>
							<div class='col-xs-2'>
								<p>Magacin Šifra: ${stavka.idDokument.magacini.id}
									${stavka.idDokument.magacini.code}</p>
								<%-- <p>Id: ${stavka.artikli.id} aktivni ${aktivniArtikal}</p> --%>
							</div>
							<div class='col-xs-2'>
								<p>${stavka.idDokument.magacini.name}</p>
							</div>
						</div>

					</c:if>
					
<!-- ********************* kraj ukupno za magacin ************************ -->

<!-- kraj ukupno za magacin ukoliko je novi magacin -->


						<!-- *************** ispis zaglavlja artikla *********************** -->

						<c:set value="${false}" var="stampaZaglavljaArtikla"></c:set>
						<c:set value="${stavka.artikli.id}" var="aktivniArtikal"></c:set>

						<div class='row' id='article-info'>
							<div class='col-xs-2'>
								<p>Artikal Šifra: ${stavka.artikli.id}
									${stavka.artikli.code}</p>
								<%-- <p>Id: ${stavka.artikli.id} aktivni ${aktivniArtikal}</p> --%>
							</div>
							<div class='col-xs-2'>
								<p>${stavka.artikli.name}</p>
							</div>
						</div>

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
					
							<!-- *************** kraj ispis zaglavlja artikla *********************** -->

							<!-- ********************* ukupno za magacin ************************ -->

								<c:if test="${aktivniMagacin!=stavka.idDokument.magacini.id }">
									<%-- <c:out value="artikli nisu isti" /> --%>
							</tbody>
						</table>
						<table class='tableDocuments'>
							<thead id="table-head-first-row">
								<th style="width: 5%;"></th>
								<th style="width: 10%;">Za magacin:</th>
								<th style="width: 10%;"></th>
								<th style="width: 10%;" class='text-right'>${totalUlazm}</th>
								<th style="width: 10%;" class='text-right'>${totalIzlazm}</th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'>${totalDugujem}</th>
								<th style="width: 10%;" class='text-right'>${totalPotrazujem}</th>
								<th style="width: 10%;" class='text-right'></th>
							</thead>

						</table>

						<c:set var="totalKolm" value="0" />
						<c:set var="totalVredm" value="0" />
						<c:set var="totalUlazm" value="0" />
						<c:set var="totalIzlazm" value="0" />
						<c:set var="totalDugujem" value="0" />
						<c:set var="totalPotrazujem" value="0" />

						<c:set value="${true}" var="stampaZaglavljaMagacina"></c:set>
						<c:set var="aktivniMagacin" value="${stavka.idDokument.magacini.id}" />

						<!-- ************************* KRAJ UKUPNO ZA MAGACIN ********************************  -->

						<!-- *************** ispis zaglavlja artikla *********************** -->

						<c:set value="${false}" var="stampaZaglavljaMagacina"></c:set>
						<c:set var="aktivniMagacin" value="${stavka.idDokument.magacini.id}" />

						<div class='row' id='article-info'>
							<div class='col-xs-2'>
								<p>Magacin Šifra: ${stavka.idDokument.magacini.id}
									${stavka.idDokument.magacini.code}</p>
								<%-- <p>Id: ${stavka.artikli.id} aktivni ${aktivniArtikal}</p> --%>
							</div>
							<div class='col-xs-2'>
								<p>${stavka.idDokument.magacini.name}</p>
							</div>
						</div>

					</c:if>
					
<!-- ********************* kraj ukupno za magacin ************************ -->




					<c:set var="totalKol" value="${totalKol + stavka.ulaz-stavka.izlaz}" />
					<c:set var="totalVred" 	value="${totalVred + stavka.duguje-stavka.potrazuje}" />
					<c:set var="totalUlaz" value="${totalUlaz + stavka.ulaz}" />
					<c:set var="totalIzlaz" value="${totalIzlaz + stavka.izlaz}" />
					<c:set var="totalDuguje" value="${totalDuguje + stavka.duguje}" />
					<c:set var="totalPotrazuje" value="${totalPotrazuje + stavka.potrazuje}" />

					<c:set var="totalKolm" value="${totalKolm + stavka.ulaz-stavka.izlaz}" />
					<c:set var="totalVredm" value="${totalVredm + stavka.duguje-stavka.potrazuje}" />
					<c:set var="totalUlazm" value="${totalUlazm + stavka.ulaz}" />
					<c:set var="totalIzlazm" value="${totalIzlazm + stavka.izlaz}" />
					<c:set var="totalDugujem" value="${totalDugujem + stavka.duguje}" />
					<c:set var="totalPotrazujem" value="${totalPotrazujem + stavka.potrazuje}" />

					<!-- 								<table class='tableDocuments'> -->
					<tr>
						<td style="width: 5%;">${stavka.id}</td>
						<td style="width: 10%;">${stavka.datum}</td>
						<td style="width: 10%;">${stavka.idDokument.brojDokumenta}</td>
						<td style="width: 10%;" class='text-right'>${stavka.ulaz}</td>
						<td style="width: 10%;" class='text-right'>${stavka.izlaz}</td>
						<td style="width: 10%;" class='text-right'>${totalKol}</td>
						<td style="width: 10%;" class='text-right'>${stavka.cena}</td>
						<td style="width: 10%;" class='text-right'>${stavka.duguje}</td>
						<td style="width: 10%;" class='text-right'>${stavka.potrazuje}</td>
						<td style="width: 10%;" class='text-right'>${totalVred}</td>
					</tr>


				</c:forEach>

				<!-- ************************* UKUPNO ZA ARTIKAL ********************************  -->

				</tbody>
				</table>
				
				<table class='tableDocuments'>
					<thead id="table-head-first-row">
						<th style="width: 5%;"></th>
						<th style="width: 10%;">Za artikal</th>
						<th style="width: 10%;"></th>
						<th style="width: 10%;" class='text-right'>${totalUlaz}</th>
						<th style="width: 10%;" class='text-right'>${totalIzlaz}</th>
						<th style="width: 10%;" class='text-right'></th>
						<th style="width: 10%;" class='text-right'></th>
						<th style="width: 10%;" class='text-right'>${totalDuguje}</th>
						<th style="width: 10%;" class='text-right'>${totalPotrazuje}</th>
						<th style="width: 10%;" class='text-right'></th>
					</thead>

				</table>

				<c:set var="totalKol" value="0" />
				<c:set var="totalVred" value="0" />
				<c:set var="totalUlaz" value="0" />
				<c:set var="totalIzlaz" value="0" />
				<c:set var="totalDuguje" value="0" />
				<c:set var="totalPotrazuje" value="0" />

				<%-- 									<c:set value="${true}" var="stampaZaglavljaArtikla"></c:set> --%>
				<%-- 									<c:set var="aktivniArtikal" value="${stavka.artikli.id}" /> --%>

				<!-- ************************* KRAJ UKUPNO ZA ARTIKAL ********************************  -->
				
						</table>
						<table class='tableDocuments'>
							<thead id="table-head-first-row">
								<th style="width: 5%;"></th>
								<th style="width: 10%;">Za magacin:</th>
								<th style="width: 10%;"></th>
								<th style="width: 10%;" class='text-right'>${totalUlazm}</th>
								<th style="width: 10%;" class='text-right'>${totalIzlazm}</th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'>${totalDugujem}</th>
								<th style="width: 10%;" class='text-right'>${totalPotrazujem}</th>
								<th style="width: 10%;" class='text-right'></th>
							</thead>

						</table>				

			</div>
		</div>
	</div>
	</page>
</body>
</html>
