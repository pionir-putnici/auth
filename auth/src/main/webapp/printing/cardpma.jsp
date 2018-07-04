<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.util.Date"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="com.hellokoding.auth.model.SpecifikacijaKartica"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.math.BigDecimal"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Cards of articles grouped by partners, warehouses -
	object and articles</title>
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
<!-- 					<h4> -->
<!-- 						Kartica artikla za period od dana -->
<%-- 						<fmt:formatDate value="${oddana}" type="both" dateStyle="medium" /> --%>
<!-- 						do dana -->
<%-- 						<fmt:formatDate value="${dodana}" type="both" dateStyle="medium" /> --%>
<!-- 					</h4> -->
				</div>
			</div>

		</div>

		<div class='row'>
			<div class='col-xs-12'>

				<c:set value="${true}" var="stampaZaglavljaArtikla"></c:set>
				<c:set var="aktivniArtikal" value="0" />
				<c:set var="aktivniArtikalCode" value="0" />
				<c:set var="aktivniArtikalName" value="0" />

				<c:set value="${true}" var="stampaZaglavljaMagacina"></c:set>
				<c:set var="aktivniMagacin" value="0" />
				<c:set var="aktivniMagacinCode" value="0" />
				<c:set var="aktivniMagacinName" value="0" />

				<c:set value="${true}" var="stampaZaglavljaPartnera"></c:set>
				<c:set var="aktivniPartner" value="0" />
				<c:set var="aktivniPartnerCode" value="0" />
				<c:set var="aktivniPartnerName" value="0" />

				<c:set value="${true}" var="firstTime"></c:set>

				<%
					ArrayList<SpecifikacijaKartica> theArray = new ArrayList<SpecifikacijaKartica>();
				%>

				<%-- 								<c:out value='${stavkart}' default='guest' /> --%>
				<!-- 								<br /> -->

				<%-- 				<c:out value='${stampaZaglavljaArtikla}' default='guest' /> --%>
				<%-- 				<c:out value='${aktivniArtikal}' default='guest' /> --%>
				<!-- 				<br /> -->


				<!-- ********************* POCETAK CITANJA STAVAKA ********************************** -->
				<%
					SpecifikacijaKartica sk1 = new SpecifikacijaKartica();
				%>

				<c:forEach items="${stavkart}" var="stavka">

					<%--  					<c:out value="${receiveNewsletter}" />  --%>
					<%-- 					<c:out value="${karticeStanje}" />  --%>
					<%-- 					<c:out value="aktivni parner name i idDokument.partner.name" /> --%>
					<%-- 					<c:out value="${aktivniPartnerName}"/> --%>
					<%-- 					<c:out value="${stavka.idDokument.partner.name}"/> --%>
					<c:if
						test="${(aktivniArtikal !=stavka.artikli.id || aktivniMagacin!=stavka.idDokument.magacini.id || aktivniPartner!=stavka.idDokument.partner.id) }">
						<c:if test="${firstTime==false}">
							<%-- <c:out value="artikli nisu isti" /> --%>
							</tbody>
							</table>
							<table class='tableDocuments'>
								<thead id="table-head-first-row">
									<th style="width: 5%;">Artikal</th>
									<!-- 								<th style="width: 10%;"></th> -->
									<th style="width: 22.5%;">${aktivniArtikalName}</th>
									<th style="width: 10%;" class='text-right'>${totalUlaz}</th>
									<th style="width: 10%;" class='text-right'>${totalIzlaz}</th>
									<th style="width: 10%;" class='text-right'>${totalKol}</th>
									<th style="width: 10%;" class='text-right'></th>
									<th style="width: 10%;" class='text-right'>${totalDuguje}</th>
									<th style="width: 10%;" class='text-right'>${totalPotrazuje}</th>
									<th style="width: 10%;" class='text-right'>${totalVred}</th>
								</thead>

							</table>
							<%
								SpecifikacijaKartica sk = new SpecifikacijaKartica();
											try {
												// 				long s = Long.parseLong(dic[1]);
												Long mm = (Long) pageContext.getAttribute("aktivniArtikal");
												System.out.println(" mm " + mm);
												sk.setIdArtikal(mm);
												sk.setIdArtikal((Long) pageContext.getAttribute("aktivniArtikal"));
												sk.setIdMagacin((Long) pageContext.getAttribute("aktivniMagacin"));
												sk.setIdPartner((Long) pageContext.getAttribute("aktivniPartner"));
												sk.setUlaz((BigDecimal) pageContext.getAttribute("totalUlaz"));
												sk.setIzlaz((BigDecimal) pageContext.getAttribute("totalIzlaz"));
												sk.setDuguje((BigDecimal) pageContext.getAttribute("totalDuguje"));
												sk.setPotrazuje((BigDecimal) pageContext.getAttribute("totalPotrazuje"));
											} catch (Exception nfe) {
												System.out.println("NumberFormatException: " + nfe.getMessage());
											}
											if (sk.getIdArtikal() == null) {

											} else {
												theArray.add(sk);
											}
							%>

							<c:set var="totalKol" value="0" />
							<c:set var="totalVred" value="0" />
							<c:set var="totalUlaz" value="0" />
							<c:set var="totalIzlaz" value="0" />
							<c:set var="totalDuguje" value="0" />
							<c:set var="totalPotrazuje" value="0" />



						</c:if>

						<c:set value="${true}" var="stampaZaglavljaArtikla"></c:set>
						<c:set var="aktivniArtikal" value="${stavka.artikli.id}" />
						<c:set var="aktivniArtikalName" value="${stavka.artikli.name}" />

						<!-- ************************* KRAJ UKUPNO ZA ARTIKAL ********************************  -->
					</c:if>

					<!-- ********************* ukupno za magacin ************************ -->

					<c:if
						test="${(aktivniMagacin!=stavka.idDokument.magacini.id || aktivniPartner!=stavka.idDokument.partner.id) }">
						<c:if test="${firstTime==false}">
							</tbody>
							</table>
							<table class='tableDocuments'>
								<thead id="table-head-first-row">
									<!-- 								<th style="width: 5%;"></th> -->
									<th style="width: 5%;">Mag:</th>
									<th style="width: 22.5%;">${aktivniMagacinName}</th>
									<th style="width: 10%;" class='text-right'>${totalUlazm}</th>
									<th style="width: 10%;" class='text-right'>${totalIzlazm}</th>
									<th style="width: 10%;" class='text-right'>${totalKolm}</th>
									<th style="width: 10%;" class='text-right'></th>
									<th style="width: 10%;" class='text-right'>${totalDugujem}</th>
									<th style="width: 10%;" class='text-right'>${totalPotrazujem}</th>
									<th style="width: 10%;" class='text-right'>${totalVredm}</th>
								</thead>

							</table>

							<c:set var="totalKolm" value="0" />
							<c:set var="totalVredm" value="0" />
							<c:set var="totalUlazm" value="0" />
							<c:set var="totalIzlazm" value="0" />
							<c:set var="totalDugujem" value="0" />
							<c:set var="totalPotrazujem" value="0" />

						</c:if>
						<c:set value="${true}" var="stampaZaglavljaMagacina"></c:set>
						<c:set var="aktivniMagacin"
							value="${stavka.idDokument.magacini.id}" />
						<c:set var="aktivniMagacinName"
							value="${stavka.idDokument.magacini.name}" />

						<!-- ************************* KRAJ UKUPNO ZA MAGACIN ********************************  -->


					</c:if>
					<!--  end if za magacin -->

					<c:if test="${aktivniPartner!=stavka.idDokument.partner.id }">
						<%-- <c:out value="artikli nisu isti" /> --%>
						</tbody>
						</table>
						<c:if test="${firstTime==false}">
							<table class='tableDocuments'>
								<thead id="table-head-first-row">
									<!-- 								<th style="width: 5%;"></th> -->
									<th style="width: 5%;">Part:</th>
									<th style="width: 22.5%;">${aktivniPartnerName}</th>
									<th style="width: 10%;" class='text-right'>${totalUlazp}</th>
									<th style="width: 10%;" class='text-right'>${totalIzlazp}</th>
									<th style="width: 10%;" class='text-right'>${totalKolp}</th>
									<th style="width: 10%;" class='text-right'></th>
									<th style="width: 10%;" class='text-right'>${totalDugujep}</th>
									<th style="width: 10%;" class='text-right'>${totalPotrazujep}</th>
									<th style="width: 10%;" class='text-right'>${totalVredp}</th>
								</thead>

							</table>

							<c:set var="totalKolp" value="0" />
							<c:set var="totalVredp" value="0" />
							<c:set var="totalUlazp" value="0" />
							<c:set var="totalIzlazp" value="0" />
							<c:set var="totalDugujep" value="0" />
							<c:set var="totalPotrazujep" value="0" />
						</c:if>
						<c:set value="${true}" var="stampaZaglavljaPartnera"></c:set>
						<c:set var="aktivniPartner"
							value="${stavka.idDokument.partner.id}" />
						<c:set var="aktivniPartnerName"
							value="${stavka.idDokument.partner.name}" />
						<br />
					</c:if>



					<!-- ***************** zaglavlje partner ************* -->

					<c:if
						test="${stampaZaglavljaPartnera==true && karticeStanje=='kartice'}">

						<c:set value="${false}" var="stampaZaglavljaPartnera"></c:set>

						<br />
						<div class='row' id='article-info'>
							<div class='col-xs-3'>
								<p>Partner Šifra: ${stavka.idDokument.partner.id}
									${stavka.idDokument.partner.code}</p>
								<%-- <p>Id: ${stavka.artikli.id} aktivni ${aktivniArtikal}</p> --%>
							</div>
							<div class='col-xs-6'>
								<p>${stavka.idDokument.partner.name}</p>
							</div>
						</div>

					</c:if>

					<!-- ***************** kraj zaglavlje partner ************* -->


					<c:if
						test="${stampaZaglavljaMagacina==true && karticeStanje=='kartice'}">

						<c:set value="${false}" var="stampaZaglavljaMagacina"></c:set>

						<!-- 						<br/> -->
						<div class='row' id='article-info'>
							<div class='col-xs-3'>
								<p>Magacin Šifra: ${stavka.idDokument.magacini.id}
									${stavka.idDokument.magacini.code}</p>
								<%-- <p>Id: ${stavka.artikli.id} aktivni ${aktivniArtikal}</p> --%>
							</div>
							<div class='col-xs-6'>
								<p>${stavka.idDokument.magacini.name}</p>
							</div>
						</div>

					</c:if>


					<!-- ***************** zaglavlje artikla ************* -->

					<c:if
						test="${stampaZaglavljaArtikla==true && karticeStanje=='kartice'}">

						<c:set value="${false}" var="stampaZaglavljaArtikla"></c:set>

						<div class='row' id='article-info'>
							<div class='col-xs-3'>
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
								<th colspan="3">DOKUMENT</th>
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
								<th style="width: 5%;">VD</th>
								<th style="width: 5%;">BROJ</th>
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


								<c:set var="totalKol"
									value="${totalKol + stavka.ulaz-stavka.izlaz}" />
								<c:set var="totalVred"
									value="${totalVred + stavka.duguje-stavka.potrazuje}" />
								<c:set var="totalUlaz" value="${totalUlaz + stavka.ulaz}" />
								<c:set var="totalIzlaz" value="${totalIzlaz + stavka.izlaz}" />
								<c:set var="totalDuguje" value="${totalDuguje + stavka.duguje}" />
								<c:set var="totalPotrazuje"
									value="${totalPotrazuje + stavka.potrazuje}" />

								<c:set var="totalKolm"
									value="${totalKolm + stavka.ulaz-stavka.izlaz}" />
								<c:set var="totalVredm"
									value="${totalVredm + stavka.duguje-stavka.potrazuje}" />
								<c:set var="totalUlazm" value="${totalUlazm + stavka.ulaz}" />
								<c:set var="totalIzlazm" value="${totalIzlazm + stavka.izlaz}" />
								<c:set var="totalDugujem"
									value="${totalDugujem + stavka.duguje}" />
								<c:set var="totalPotrazujem"
									value="${totalPotrazujem + stavka.potrazuje}" />

								<c:set var="totalKolp"
									value="${totalKolp + stavka.ulaz-stavka.izlaz}" />
								<c:set var="totalVredp"
									value="${totalVredp + stavka.duguje-stavka.potrazuje}" />
								<c:set var="totalUlazp" value="${totalUlazp + stavka.ulaz}" />
								<c:set var="totalIzlazp" value="${totalIzlazp + stavka.izlaz}" />
								<c:set var="totalDugujep"
									value="${totalDugujep + stavka.duguje}" />
								<c:set var="totalPotrazujep"
									value="${totalPotrazujep + stavka.potrazuje}" />

								<c:set var="totalKols"
									value="${totalKols + stavka.ulaz-stavka.izlaz}" />
								<c:set var="totalVreds"
									value="${totalVreds + stavka.duguje-stavka.potrazuje}" />
								<c:set var="totalUlazs" value="${totalUlazs + stavka.ulaz}" />
								<c:set var="totalIzlazs" value="${totalIzlazs + stavka.izlaz}" />
								<c:set var="totalDugujes"
									value="${totalDugujes + stavka.duguje}" />
								<c:set var="totalPotrazujes"
									value="${totalPotrazujes + stavka.potrazuje}" />
								<c:set var="tipDokumentaIBrojDokumenta"
									value="${stavka.idDokument.typesOfDocuments.name || stavka.idDokument.brojDokumenta}" />
								<!-- 								<table class='tableDocuments'> -->
								<c:if test="${karticeStanje=='kartice'}">
									<tr>
										<td style="width: 5%;">${stavka.id}</td>
										<td style="width: 10%;">${stavka.datum}</td>
										<td style="width: 5%;">${stavka.idDokument.typesOfDocuments.name}</td>
										<td style="width: 5%;">${stavka.idDokument.brojDokumenta}</td>
										<td style="width: 10%;" class='text-right'>${stavka.ulaz}</td>
										<td style="width: 10%;" class='text-right'>${stavka.izlaz}</td>
										<td style="width: 10%;" class='text-right'>${totalKol}</td>
										<td style="width: 10%;" class='text-right'>${stavka.cena}</td>
										<td style="width: 10%;" class='text-right'>${stavka.duguje}</td>
										<td style="width: 10%;" class='text-right'>${stavka.potrazuje}</td>
										<td style="width: 10%;" class='text-right'>${totalVred}</td>
									</tr>
								</c:if>
								<c:set value="${false}" var="firstTime"></c:set>

								</c:forEach>

								<!-- ************************* UKUPNO ZA ARTIKAL ********************************  -->

							</tbody>
						</table>

						<table class='tableDocuments'>
							<thead id="table-head-first-row">
								<!-- 								<th style="width: 5%;"></th> -->
								<th style="width: 5%;">Artikal</th>
								<th style="width: 22.5%;">${aktivniArtikalName}</th>
								<th style="width: 10%;" class='text-right'>${totalUlaz}</th>
								<th style="width: 10%;" class='text-right'>${totalIzlaz}</th>
								<th style="width: 10%;" class='text-right'>${totalKol}</th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'>${totalDuguje}</th>
								<th style="width: 10%;" class='text-right'>${totalPotrazuje}</th>
								<th style="width: 10%;" class='text-right'>${totalVred}</th>
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
								<!-- 								<th style="width: 5%;"></th> -->
								<th style="width: 5%;">Mag:</th>
								<th style="width: 22.5%;">${aktivniMagacinName}</th>
								<th style="width: 10%;" class='text-right'>${totalUlazm}</th>
								<th style="width: 10%;" class='text-right'>${totalIzlazm}</th>
								<th style="width: 10%;" class='text-right'>${totalKolm}</th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'>${totalDugujem}</th>
								<th style="width: 10%;" class='text-right'>${totalPotrazujem}</th>
								<th style="width: 10%;" class='text-right'>${totalVredm}</th>
							</thead>

						</table>

						<c:set var="totalKolm" value="0" />
						<c:set var="totalVredm" value="0" />
						<c:set var="totalUlazm" value="0" />
						<c:set var="totalIzlazm" value="0" />
						<c:set var="totalDugujem" value="0" />
						<c:set var="totalPotrazujem" value="0" />

						<!-- 						<br /> -->
						<!-- ************************* UKUPNO ZA PARTNERA ********************************  -->

						</table>
						<table class='tableDocuments'>
							<thead id="table-head-first-row">
								<!-- 								<th style="width: 5%;"></th> -->
								<th style="width: 5%;">Part:</th>
								<th style="width: 22.5%;" colspan="3";">${aktivniPartnerName}</th>
								<th style="width: 10%;" class='text-right'>${totalUlazp}</th>
								<th style="width: 10%;" class='text-right'>${totalIzlazp}</th>
								<th style="width: 10%;" class='text-right'>${totalKolp}</th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'>${totalDugujep}</th>
								<th style="width: 10%;" class='text-right'>${totalPotrazujep}</th>
								<th style="width: 10%;" class='text-right'>${totalVredp}</th>
							</thead>
						</table>
						<c:set var="totalKolp" value="0" />
						<c:set var="totalVredp" value="0" />
						<c:set var="totalUlazp" value="0" />
						<c:set var="totalIzlazp" value="0" />
						<c:set var="totalDugujep" value="0" />
						<c:set var="totalPotrazujep" value="0" />
						<!-- ************************* KRAJ UKUPNO ZA PARTNERA ********************************  -->
						<br />
						<!-- ************************* UKUPNO SVEGA ********************************  -->
						</table>
						<table class='tableDocuments'>
							<thead id="table-head-first-row">
								<!-- 								<th style="width: 5%;"></th> -->
								<!-- 								<th style="width: 10%;">SVEGA:</th> -->
								<!-- 								<th style="width: 10%;"></th> -->
								<th style="width: 5%;"></th>
								<th style="width: 22.5%;">SVEGA:</th>
								<th style="width: 10%;" class='text-right'>${totalUlazs}</th>
								<th style="width: 10%;" class='text-right'>${totalIzlazs}</th>
								<th style="width: 10%;" class='text-right'>${totalKols}</th>
								<th style="width: 10%;" class='text-right'></th>
								<th style="width: 10%;" class='text-right'>${totalDugujes}</th>
								<th style="width: 10%;" class='text-right'>${totalPotrazujes}</th>
								<th style="width: 10%;" class='text-right'>${totalVreds}</th>
							</thead>
						</table>
						<c:set var="totalKolp" value="0" />
						<c:set var="totalVredp" value="0" />
						<c:set var="totalUlazp" value="0" />
						<c:set var="totalIzlazp" value="0" />
						<c:set var="totalDugujep" value="0" />
						<c:set var="totalPotrazujep" value="0" />
						<!-- ************************* KRAJ SVEGA ********************************  -->
						<br />
						<%
							for (SpecifikacijaKartica sk : theArray) {
								System.out.println(" ovo je ispis " + sk.getIdArtikal() + " " + sk.getIdMagacin());
								// do your work
							}
						%>

						<table>
							<th></th>
							<th></th>
							<c:forEach items="${theArray}" var="current">
								<tr>
									<td><c:out value="${current.ulaz}" />
									<td><c:out value="${current.idMagacin}" />
								</tr>
							</c:forEach>
						</table>
			</div>
		</div>
	</div>
	</page>
</body>
</html>