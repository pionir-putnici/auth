<!DOCTYPE html>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html ng-app="myApp" ng-app lang="en">
<head>
    <meta charset="utf-8">
    <link href="bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    ul>li, a{cursor: pointer;}
    </style>
    <title>Simple Datagrid with search, sort and paging using AngularJS, PHP, MySQL</title>
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
									<a href="${new_item}">
										<button
											class='btn btn-lg btn-success button-novi border-radius-0'>
											<span class='glyphicon glyphicon-file'></span> New
										</button>
									</a> <a href="${print_item}" target="_blank">
										<button
											class='btn btn-lg btn-success button-novi border-radius-0 margin-left-10'>
											<span class='fa fa-print'></span> Print
										</button>
									</a>
								</div>
							</div>



<div class="navbar navbar-default" id="navbar">
    <div class="container" id="navbar-container">
    <div class="navbar-header">
        <a href="http://angularcode.com" class="navbar-brand">
            <small>
                <i class="glyphicon glyphicon-log-out"></i>
                AngularCode / AngularJS Demos 
            </small>
        </a><!-- /.brand -->
        
    </div><!-- /.navbar-header -->
    <div class="navbar-header pull-right" role="navigation">
        <a href="http://angularcode.com/angularjs-datagrid-paging-sorting-filter-using-php-and-mysql/" class="btn btn-sm btn-danger nav-button-margin"> <i class="glyphicon glyphicon-book"></i>&nbsp;Tutorial Link</a>
        <a href="http://angularcode.com/download-link/?url=https://app.box.com/s/kyomkfyeb42irie6rxcl" class="btn btn-sm btn-warning nav-button-margin"> <i class="glyphicon glyphicon-download"></i>&nbsp;Download Project</a>
    </div>
    </div>
</div>


<div ng-controller="customersCrtl">
<div class="container">
<br/>
<blockquote><h4><a href="http://angularcode.com/angularjs-datagrid-paging-sorting-filter-using-php-and-mysql/">Simple Datagrid with search, sort and paging using AngularJS + PHP + MySQL</a></h4></blockquote>
<br/>
    <div class="row">
        <div class="col-md-2">PageSize:
            <select ng-model="entryLimit" class="form-control">
                <option>5</option>
                <option>3</option>
                <option>20</option>
                <option>50</option>
                <option>100</option>
            </select>
        </div>
        <div class="col-md-3">Filter:
            <input type="text" ng-model="search" ng-change="filter()" placeholder="Filter" class="form-control" />
        </div>
        <div class="col-md-4">
            <h5>Filtered {{ filtered.length }} of {{ totalItems}} total customers</h5>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-md-12" ng-show="filteredItems > 0">
            <table class="table table-striped table-bordered">
            <thead>
            <th>Customer Name&nbsp;<a ng-click="sort_by('code');"><i class="glyphicon glyphicon-sort"></i></a></th>
            <th>Address&nbsp;<a ng-click="sort_by('name');"><i class="glyphicon glyphicon-sort"></i></a></th>
            <th>City&nbsp;<a ng-click="sort_by('remark');"><i class="glyphicon glyphicon-sort"></i></a></th>
            <th>State&nbsp;<a ng-click="sort_by('akcija');"><i class="glyphicon glyphicon-sort"></i></a></th>
<!--             <th>Postal Code&nbsp;<a ng-click="sort_by('video');"><i class="glyphicon glyphicon-sort"></i></a></th> -->
<!--             <th>Country&nbsp;<a ng-click="sort_by('zvuk');"><i class="glyphicon glyphicon-sort"></i></a></th> -->
<!--             <th>Credit Limit&nbsp;<a ng-click="sort_by('slika');"><i class="glyphicon glyphicon-sort"></i></a></th> -->
            </thead>
            <tbody>
                <tr ng-repeat="data in filtered = (list | filter:search | orderBy : predicate :reverse) | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit">
                    <td>{{data.code}}</td>
                    <td>{{data.name}}</td>
                    <td>{{data.remark}}</td>
                    <td>{{data.akcija}}</td>
<!--                     <td>{{data.video}}</td> -->
<!--                     <td>{{data.zvuk}}</td> -->
<!--                     <td>{{data.slika}}</td> -->
                </tr>
            </tbody>
            </table>
        </div>
        <div class="col-md-12" ng-show="filteredItems == 0">
            <div class="col-md-12">
                <h4>No customers found</h4>
            </div>
        </div>
        <div class="col-md-12" ng-show="filteredItems > 0">    
            <div pagination="" page="currentPage" on-select-page="setPage(page)" boundary-links="true" total-items="filteredItems" items-per-page="entryLimit" class="pagination-small" previous-text="&laquo;" next-text="&raquo;"></div>
            
            
        </div>
    </div>
</div>
</div>

</div></div></div></div></div></div>


<script src="https://code.angularjs.org/1.2.32/angular.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/2.5.0/ui-bootstrap-tpls.js"></script> -->
<!-- <script src="angular.min.js"></script> -->
<script src="ui-bootstrap-tpls-0.10.0.min.js"></script>
<script src="partner.js"></script>         
    </body>
</html>