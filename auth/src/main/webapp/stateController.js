var app = angular.module("StatesManagement", []);
 
//             myAngularApp.config ["$httpProvider", ($httpProvider) ->
//             csrfToken = $('meta[name=csrf-token]').attr('content')
//             $httpProvider.defaults.headers.post['X-CSRF-Token'] = csrfToken
//             $httpProvider.defaults.headers.put['X-CSRF-Token'] = csrfToken
//             $httpProvider.defaults.headers.patch['X-CSRF-Token'] = csrfToken
//             $httpProvider.defaults.headers.delete['X-CSRF-Token'] = csrfToken
//             ]
            //Controller Part

            app.controller("StatesAngularJSController", function($scope, $http) {

            	   $scope.filteredTodos = [];
            	   $scope.currentPage = 1;
            	   $scope.numPerPage = 2;
            	   $scope.maxSize = 5;          
            	   $scope.test = "aklasjldfkasj";
            	
                $scope.states = [];
                $scope.stateForm = {
                    id : -1,
                    code : "",
                    name : "",
                    remark : ""
                };
         
                /* Private Methods */
                //HTTP GET- get all customers collection
                function _refreshStateData() {
                    $http({
                        method : 'GET',
                        url : 'http://localhost:8080/states'
                    }).then(function successCallback(response) {
                        $scope.states = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }                
                //Now load the data from server
                _refreshStateData();
         
                // numPages();
//                $scope.makeTodos(); 
//                $scope.states
                
                $scope.numPages = function () {
                  return Math.ceil($scope.states.length / $scope.numPerPage);
                  // return 3;
                };
                
                $scope.$watch('currentPage + numPerPage', function() {
                  var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                  , end = begin + $scope.numPerPage;
                  
                  $scope.filteredTodos = $scope.states.slice(begin, end);
                });                
                
                //HTTP POST/PUT methods for add/edit customer 
                // with the help of id, we are going to find out whether it is put or post operation
                
                $scope.submitState = function() {
         
                    var method = "";
                    var url = "";
                    if ($scope.stateForm.id == -1) {
                        //Id is absent in form data, it is create new customer operation
                        method = "POST";
                        url = '/addState';
                    } else {
                        //Id is present in form data, it is edit customer operation
                        method = "POST"; // was PUT
                        url = '/addState';
                    }
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.stateForm),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
                    }).then( _success, _error );
                };
         
                //HTTP DELETE- delete customer by Id
                $scope.deleteState = function(state) {
                    $http({
                        method : 'GET', // was DELETE
                        url : '/deleteState/' + state.id
                    }).then(_success, _error);
                };
 
             // In case of edit, populate form fields and assign form.id with customer id
                $scope.editState = function(state) {
                    $scope.stateForm.code = state.code;
                    $scope.stateForm.name = state.name;
                    $scope.stateForm.remark = state.remark;
                    $scope.stateForm.id = state.id;
                };
         
//                /* Private Methods */
//                //HTTP GET- get all customers collection
//                function _refreshStateData() {
//                    $http({
//                        method : 'GET',
//                        url : 'http://localhost:8080/states'
//                    }).then(function successCallback(response) {
//                        $scope.states = response.data;
//                    }, function errorCallback(response) {
//                        console.log(response.statusText);
//                    });
//                }
         
                function _success(response) {
                    _refreshStateData();
                    _clearFormData()
                }
         
                function _error(response) {
                    console.log(response.statusText);
                }
         
                //Clear the form
                function _clearFormData() {
                    $scope.stateForm.id = -1;
                    $scope.stateForm.name = "";
                    $scope.stateForm.code = "";
                    $scope.stateForm.remark = "";               
                };
            });
            
            