var todos = angular.module('todos', ['ui.bootstrap']);

todos.controller('TodoController', function($scope) {
   $scope.filteredTodos = []
  ,$scope.states = []
  ,$scope.currentPage = 1
  ,$scope.numPerPage = 10
  ,$scope.maxSize = 5;
  
  $scope.makeTodos = function() {
    $scope.todos = [];
    
    for (i=1;i<=1000;i++) {
      $scope.todos.push({ text:'todo '+i, done:false});
    }
    
    $http({
        method : 'GET',
        url : 'http://localhost:8080/states'
    }).then(function successCallback(response) {
        $scope.todos = response.data;
    }, function errorCallback(response) {
        console.log(response.statusText);
    });    
    
  };
  
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
  
//  _refreshStateData();
  $scope.makeTodos(); 
 // _refreshStateData();
  
  $scope.numPages = function () {
    return Math.ceil($scope.todos.length / $scope.numPerPage);
  };
  
  function _success(response) {
      _refreshStateData();
      _clearFormData()
  }

  function _error(response) {
      console.log(response.statusText);
  }
  
  $scope.$watch('currentPage + numPerPage', function() {
    var begin = (($scope.currentPage - 1) * $scope.numPerPage)
    , end = begin + $scope.numPerPage;
    
    $scope.filteredTodos = $scope.todos.slice(begin, end);
  });
  
});
