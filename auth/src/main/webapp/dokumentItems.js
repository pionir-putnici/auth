var app = angular.module('dokumentItems', ['ui.bootstrap']);

app.filter('startFrom', function() {
    return function(input, start) {
        if(input) {
            start = +start; //parse to int
            return input.slice(start);
        }
        return [];
    }
});


app.controller('ctrl', function ($scope, $http, $timeout, $routeParams) {
	
	$http({
		method: 'Get',
		params:{id: "id"},
		url: 'http://10.11.124.46:8080/view_dokumentStavke.html'})
		.then(function(response)
		{
			$scope.names = response.data;
	        $scope.list = data;
	        $scope.currentPage = 1; //current page
	        $scope.entryLimit = 5; //max no of items to display in a page
	        $scope.filteredItems = $scope.list.length; //Initially for no filter  
	        $scope.totalItems = $scope.list.length;
		})
//	});

//    $http.get('http://localhost:8080/view_dokumentStavke.html', {
//        params: { id: "test" })
//        .success(function(data){
////        $http.get('http://localhost:8080/dokumentstavke?itemid=2}').success(function(data){
//        $scope.list = data;
//        $scope.currentPage = 1; //current page
//        $scope.entryLimit = 5; //max no of items to display in a page
//        $scope.filteredItems = $scope.list.length; //Initially for no filter  
//        $scope.totalItems = $scope.list.length;
//        $scope.kata = "verrr";
//    })
//    , (function error(response) {
//		$scope.postResultMessage = "Error with status: " +  response.statusText;
//	}
//    });
//    
    $scope.setPage = function(pageNo) {
        $scope.currentPage = pageNo;
    };
    $scope.filter = function() {
        $timeout(function() { 
            $scope.filteredItems = $scope.filtered.length;
        }, 10);
    };
    
});