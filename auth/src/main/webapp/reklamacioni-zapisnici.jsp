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

<title>Reklamacioni zapisnici</title>

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
</head>
<body>
<div id="wrapper">


		<%@ include file="../horizontal-navigation.html"%> 
  		<%@ include file="../vertical-menu.jsp"%> 

		<div id="page-wrapper">
			<div class='row'>

				<div class='col-lg-12 '>
					<div class='panel panel-default margin-top-10 border-radius-0'>

						<div class='panel-heading'>${title}</div>

						<div class='panel-body'>
							<div class='row spacer-bottom'>
								<div class='col-lg-12'>
									<c:url value="/" var="displayURL">
<%-- 										<c:param name="brDokumenta" value="${param.id}" /> --%>
<%-- 										<c:param name="page" value="${param.page}" /> --%>
									</c:url>
									
									<a href='<c:out value="${displayURL}" />'>
										<button
											class='btn btn-lg btn-success button-novi border-radius-0'>
											<span class='glyphicon glyphicon-arrow-left'></span> Back
										</button>										
									</a> 
								
								
									<a href="${zapisnici_unos}">
										<button
											class='btn btn-lg btn-success button-novi border-radius-0'>
											<span class='glyphicon glyphicon-file'></span> New
										</button>
									</a> 
									<a href="${print_item}" target="_blank">
										<button
											class='btn btn-lg btn-success button-novi border-radius-0 margin-left-10'>
											<span class='fa fa-print'></span> Print
										</button>
										            <div class="col-md-12">
                										<h4>{{error}}</h4>             		
            										</div>
									</a>
								</div>
							</div>

<div class='row'>
<div class='col-lg-12' ng-controller="zapisniciCtrl">
<!-- <br/> -->
<!-- <blockquote><h4><a href="http://angularcode.com/angularjs-datagrid-paging-sorting-filter-using-php-and-mysql/">Simple Datagrid with search, sort and paging using AngularJS + PHP + MySQL</a></h4></blockquote> -->
<!-- <br/> -->

    <div class="row">
        <div class="col-md-2">PageSize:
            <select ng-model="entryLimit" class="form-control">
                <option>5</option>
                <option>10</option>
                <option>20</option>
                <option>50</option>
                <option>100</option>
            </select>
        </div>
        <div class="col-md-3">Filter:
            <input type="text" ng-model="search" ng-change="filter()" placeholder="Filter" class="form-control" />
        </div>
        <div class="col-md-4">
            <h5>Filtered {{ filtered.length }} of {{ totalItems}} total documents</h5>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-12" ng-show="filteredItems > 0">
            <table class="display table table-striped table-bordered table-hover border-radius-0">
            <thead>
            <th style="width: 7%;">ID&nbsp;<a ng-click="sort_by('id');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a></th>
            <th style="width: 10%;">VD&nbsp;<a ng-click="sort_by('code');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a></th>
            <th style="width: 15%;">Broj dokumenta&nbsp;<a ng-click="sort_by('name');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a></th>
            <th style="width: 19%;">Magacin&nbsp;<a ng-click="sort_by('code');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a></th>
            <th style="width: 11%;">Partner&nbsp;<a ng-click="sort_by('code');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a></th>
            <th style="width: 14%;">Datum&nbsp;<a ng-click="sort_by('remark');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a></th>
            <th style="width: 10%;">Iznos&nbsp;<a ng-click="sort_by('akcija');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a> </th>
            <th style="width: 14%;">AKCIJA&nbsp;<a ng-click="sort_by('akcija');"><i class="glyphicon glyphicon-sort sort-arrows"></i></a></th>
<!--             <th>Country&nbsp;<a ng-click="sort_by('zvuk');"><i class="glyphicon glyphicon-sort"></i></a></th> -->
<!--             <th>Credit Limit&nbsp;<a ng-click="sort_by('slika');"><i class="glyphicon glyphicon-sort"></i></a></th> -->
            </thead>
            <tbody>
                <tr ng-repeat="data in filtered = (list | filter:search | orderBy : predicate :reverse) | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit">
                    <td ng-init="init({{data.id}}">{{data.id}} </td>
                    <td>{{data.id}}</td>
                    <td>{{data.code}}</td>
                    
                    <td>{{data.dokument.name}}</td>
                    <td>{{data.partner.name}}</td>
                    <td>{{data.datum | date:"dd.MM.yyyy"}}</td>
                    <td>{{data.iznos | number:2}}</td>
<!--                     <td>{{data.aktivan}}</td> -->

<!-- radi                    <td> <a href="dokumentstavkefinal.html?page=0&id={{data.id}}"><i class="fa fa-clone edit-delete-icon"></i></a>   <a href="/printing/index.html?id={{data.id}}" target="_blank"> <i class="fa fa-print edit-delete-icon"></i></a> <a href="update_dokument.html?id={{data.id}}"><i class="fa fa-pencil-square-o edit-delete-icon"></i></a> <a href="delete_dokument.html?id={{data.id}}" onClick="return ConfirmDelete();"><i class="fa fa-trash-o edit-delete-icon"></i></a></td> -->
                    
                    <td> <a href="dokumentstavkefinal.html?page=0&id={{data.id}}"><i class="fa fa-clone edit-delete-icon"></i></a>
                         <a href="printDocument.html?id={{data.id}}" target="_blank"> <i class="fa fa-print edit-delete-icon"></i></a> 
                         <a href="update_dokument.html?id={{data.id}}"><i class="fa fa-pencil-square-o edit-delete-icon"></i></a> 
                         <a href="delete_dokument.html?id={{data.id}}" onClick="return ConfirmDelete();"><i class="fa fa-trash-o edit-delete-icon"></i></a>
                     </td>
                    
<!--                     <td> <a href="view_dokumentStavke.html?id={{data.id}}"><i class="fa fa-clone edit-delete-icon"></i></a>   <a href="/printing/index.html?id={{data.id}}" target="_blank"> <i class="fa fa-print edit-delete-icon"></i></a> <a href="update_dokument.html?id={{data.id}}"><i class="fa fa-pencil-square-o edit-delete-icon"></i></a> <a href="delete_dokument.html?id={{data.id}}" onClick="return ConfirmDelete();"><i class="fa fa-trash-o edit-delete-icon"></i></a></td> -->
<!--                     <td>{{data.video}}</td> -->
<!--                     <td>{{data.zvuk}}</td> -->
<!--                     <td>{{data.slika}}</td> -->
<!-- ng-init="init({{data.id}})" -->
                </tr>
            </tbody>
            </table>
        </div>
        <div class="col-md-12" ng-show="filteredItems == 0">
            <div class="col-md-12">
                <h4>No document found</h4>             		
            </div>

        </div>
        <div class="col-md-12" ng-show="filteredItems > 0">    
            <div pagination="" page="currentPage" on-select-page="setPage(page)" boundary-links="true" total-items="filteredItems" items-per-page="entryLimit" class="pagination-small" previous-text="&laquo;" next-text="&raquo;"></div>
            
            
        </div>
    </div>
</div>
</div>   
<!-- controller -->


<!-- second controller  -->

  
<!-- second controller -->


</div></div></div></div></div></div>

<%@ include file="scripts.jsp"%>
<script src="https://code.angularjs.org/1.2.32/angular.js"></script>
<script src="ui-bootstrap-tpls-0.10.0.min.js"></script>
<script src="reklamacioni-zapisnici.js"></script>


<script>
		function ConfirmDelete() {
			var x = confirm("Are you sure you want to delete?");
			if (x)
				return true;
			else
				return false;
		}
	</script>         
    </body>
</html>