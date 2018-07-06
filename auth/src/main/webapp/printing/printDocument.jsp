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
<link rel='stylesheet' href='printing/style.css' type='text/css' />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>

<body>
    
    <page size="A4" class="print">
    
        <div class='container-fluid spacer-top-20'>
            <div class='row'>
                <div class='col-xs-7'>
                    <div class='row'>
                        <div class='col-lg-12'><img src='/printing/pionir-logo.png' /></div>
                    </div>
                </div>
                <div class='col-xs-5'>
                    <div class='row'>
                       <div class='col-xs-6'>Magacin: ${dokument.magacini.code}</div>
                        <div class='col-xs-6'>${dokument.magacini.name}</div>
                    </div>
                    <div class='row'>
                        <div class='col-xs-6'>Adresa </div>
                        <div class='col-xs-6'>${dokument.magacini.adresa}</div>
                    </div>
                    <div class='row'>
                        <div class='col-xs-6'>Telefon</div>
                        <div class='col-xs-6'>Telefon</div>
                    </div>
                </div>
            </div>
            <div class='row spacer-top-20'>
                <div class='col-xs-7'>
                    <div class='row'>
                        <div class='col-xs-12'><h4>Racun/otpremnica br. ${dokument.brojDokumenta}</h4></div>
                    </div>
                    <div class='row'>
                        <div class='col-xs-6'>Mesto prometa</div>
                        <div class='col-xs-6'>Subotica</div>
                    </div>
                    <div class='row'>
                        <div class='col-xs-6'>Datum izdavanja</div>
                        <div class='col-xs-6'>${dokument.datum}</div>
                    </div>
                    <div class='row'>
                        <div class='col-xs-6'>Datum prometa dobara</div>
                        <div class='col-xs-6'>${dokument.datum}</div>
                    </div>
                </div>
                <div class='col-xs-5 border-up'>
                    <div class='row'>
                        <div class='col-xs-12 text-center border-bottom'><h4 >${dokument.partner.name}</h4></div>
                    </div>
                    <div class='row spacer-top-5'>
                        <div class='col-xs-12 text-center'>${dokument.partner.adresa}</div>
                    </div>
                    <div class='row'>
                        <div class='col-xs-12 text-center'>${dokument.partner.name}</div>
                    </div>
                    <div class='row'>
                        <div class='col-xs-12 text-center'> Pib: ${dokument.partner.pib}</div>
                    </div>
                </div>
            </div>
            <div class='row'>
                <div class='col-xs-12 border-bottom-dotted spacer-top-30'></div>
            </div>
            <div class='row'>
                <div class='col-xs-12'>
                    <table class='tableDocuments spacer-top-30'>
                        <thead>
                            <th>RB</th>
                            <th>SIFRA</th>
                            <th>NAZIV</th>
                            <th>JM</th>
                            <th class='text-right'>KOLIČINA</th>
                            <th class='text-right'>CENA</th>
                            <th class='text-right'>IZNOS</th>
                        </thead>
                        <tbody>
				<!--             pocetak petlje -->   
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
            </div>
            
<!--             kraj petlje -->
            
            <div class='row spacer-top-30'>
                <div class='col-xs-7'>
                    
                </div>
                <div class='col-xs-5'>
                    <table class='tableDocuments'>
<!--                         <tr> -->
<!--                             <td>Osnovica</td> -->
<!--                             <td class='text-right'>1111,00</td> -->
<!--                         </tr> -->
<!--                         <tr> -->
<!--                             <td>PDV</td> -->
<!--                             <td class='text-right'>202,22</td> -->
<!--                         </tr> -->
                        <tr>
                            <td>Ukupno</td>
                            <td class='text-right'>${totalIzn}</td>
                        </tr>
                    </table>
                </div>
            </div>
            
		<div class='row spacer-top-20'>
			<div class='col-xs-12'>
				<h4 class='remark-heading'>Napomena:</h4>
			</div>
			<div class='col-xs-12'>
				<p class='remark-p text-justify'>${dokument.napomena}</p>
			</div>
		</div>

		<div class='row spacer-top-20'>
			<div class='col-xs-12'>
				<h4 class='remark-heading'>Osnov:</h4>
			</div>
			<div class='col-xs-12'>
				<p class='remark-p text-justify'>${dokument.osnov}</p>
			</div>
		</div>

		
		<div class='row spacer-top-20'>
		<div class='col-xs-10'>
			<div class='col-xs-12'>
				<h4 class='remark-heading'>Predao:</h4>
			</div>
			<div class='col-xs-12'>
				<p class='remark-p text-justify'>${dokument.predao}</p>
			</div>
		</div>
		<div class='col-xs-2'>
			<div class='col-xs-12'>
				<h4 class='remark-heading'>Primio:</h4>
			</div>
			<div class='col-xs-12'>
				<p class='remark-p text-justify'>${dokument.primio}</p>
			</div>
		</div>			
		</div>
				
	</div>
    </page>
    
    <a href="#" class="noprint btn btn-lg btn-primary btn-flat" onClick="window.print()">Print </a>
    
    <script src="../static/js/jquery-1.11.1.min.js">
		
    </script>

</body>

</html> 