function ctrlRead($scope, $filter, $http ) {
    // init
	
    $http.get('http://localhost:8080/states'). // getAllStates
    success(function(data) {

        $scope.items =  data;
        $scope.rr= 14;

    });
        
    $scope.sortingOrder = sortingOrder;
    $scope.reverse = false;
    $scope.filteredItems = [];
    $scope.groupedItems = [];
    $scope.itemsPerPage = 5;
    $scope.pagedItems = [];
    $scope.currentPage = 0;
    $scope.rr = 0;
 
    $scope.items = [];

    $scope.items2 = [
        {"id":"1","name":"name 1","code":"code 1","remark":"remark 1","akcija":"akcija 1","video":"video 1"}, 
        {"id":"2","name":"name 2","code":"code 1","remark":"remark 2","akcija":"akcija 2","video":"video 2"}, 
        {"id":"3","name":"name 3","code":"code 1","remark":"remark 3","akcija":"akcija 3","video":"video 3"}, 
        {"id":"4","name":"name 4","code":"code 1","remark":"remark 4","akcija":"akcija 4","video":"video 4"}, 
        {"id":"5","name":"name 5","code":"code 1","remark":"remark 5","akcija":"akcija 5","video":"video 5"}, 
        {"id":"6","name":"name 6","code":"code 1","remark":"remark 6","akcija":"akcija 6","video":"video 6"}, 
        {"id":"7","name":"name 7","code":"code 1","remark":"remark 7","akcija":"akcija 7","video":"video 7"}, 
        {"id":"8","name":"name 8","code":"code 1","remark":"remark 8","akcija":"akcija 8","video":"video 8"}, 
        {"id":"9","name":"name 9","code":"code 1","remark":"remark 9","akcija":"akcija 9","video":"video 9"}, 
        {"id":"10","name":"name 10","code":"code 1","remark":"remark 10","akcija":"akcija 10","video":"video 10"}, 
        {"id":"11","name":"name 11","code":"code 1","remark":"remark 11","akcija":"akcija 11","video":"video 11"}, 
        {"id":"12","name":"name 12","code":"code 1","remark":"remark 12","akcija":"akcija 12","video":"video 12"}, 
        {"id":"13","name":"name 13","code":"code 1","remark":"remark 13","akcija":"akcija 13","video":"video 13"}, 
        {"id":"14","name":"name 14","code":"code 1","remark":"remark 14","akcija":"akcija 14","video":"video 14"}, 
        {"id":"15","name":"name 15","code":"code 1","remark":"remark 15","akcija":"akcija 15","video":"video 15"}, 
        {"id":"16","name":"name 16","code":"code 1","remark":"remark 16","akcija":"akcija 16","video":"video 16"}, 
        {"id":"17","name":"name 17","code":"code 1","remark":"remark 17","akcija":"akcija 17","video":"video 17"}, 
        {"id":"18","name":"name 18","code":"code 1","remark":"remark 18","akcija":"akcija 18","video":"video 18"}, 
        {"id":"19","name":"name 19","code":"code 1","remark":"remark 19","akcija":"akcija 19","video":"video 19"}, 
        {"id":"20","name":"name 20","code":"code 1","remark":"remark 20","akcija":"akcija 20","video":"video 20"}
    ];

    $scope.items2 = [
        {"id":"1","name":"name 1", "zvuk":"zvuk 1","code":"code 1","remark":"remark 1","akcija":"akcija 1","video":"video 1"}, 
        {"id":"2","name":"name 2", "zvuk":"zvuk 1","code":"code 1","remark":"remark 2","akcija":"akcija 2","video":"video 2"}, 
        {"id":"3","name":"name 3", "zvuk":"zvuk 1","code":"code 1","remark":"remark 3","akcija":"akcija 3","video":"video 3"}, 
        {"id":"4","name":"name 4", "zvuk":"zvuk 1","code":"code 1","remark":"remark 4","akcija":"akcija 4","video":"video 4"}, 
        {"id":"5","name":"name 5", "zvuk":"zvuk 1","code":"code 1","remark":"remark 5","akcija":"akcija 5","video":"video 5"}, 
        {"id":"6","name":"name 6", "zvuk":"zvuk 1","code":"code 1","remark":"remark 6","akcija":"akcija 6","video":"video 6"}, 
        {"id":"7","name":"name 7", "zvuk":"zvuk 1","code":"code 1","remark":"remark 7","akcija":"akcija 7","video":"video 7"}, 
        {"id":"8","name":"name 8", "zvuk":"zvuk 1","code":"code 1","remark":"remark 8","akcija":"akcija 8","video":"video 8"}, 
        {"id":"9","name":"name 9", "zvuk":"zvuk 1","code":"code 1","remark":"remark 9","akcija":"akcija 9","video":"video 9"}, 
        {"id":"10","name":"name 10", "zvuk":"zvuk 1","code":"code 1","remark":"remark 10","akcija":"akcija 10","video":"video 10"}, 
        {"id":"11","name":"name 11", "zvuk":"zvuk 1","code":"code 1","remark":"remark 11","akcija":"akcija 11","video":"video 11"}, 
        {"id":"12","name":"name 12", "zvuk":"zvuk 1","code":"code 1","remark":"remark 12","akcija":"akcija 12","video":"video 12"}, 
        {"id":"13","name":"name 13", "zvuk":"zvuk 1","code":"code 1","remark":"remark 13","akcija":"akcija 13","video":"video 13"}, 
        {"id":"14","name":"name 14", "zvuk":"zvuk 1","code":"code 1","remark":"remark 14","akcija":"akcija 14","video":"video 14"}, 
        {"id":"15","name":"name 15", "zvuk":"zvuk 1","code":"code 1","remark":"remark 15","akcija":"akcija 15","video":"video 15"}, 
        {"id":"16","name":"name 16", "zvuk":"zvuk 1","code":"code 1","remark":"remark 16","akcija":"akcija 16","video":"video 16"}, 
        {"id":"17","name":"name 17", "zvuk":"zvuk 1","code":"code 1","remark":"remark 17","akcija":"akcija 17","video":"video 17"}, 
        {"id":"18","name":"name 18", "zvuk":"zvuk 1","code":"code 1","remark":"remark 18","akcija":"akcija 18","video":"video 18"}, 
        {"id":"19","name":"name 19", "zvuk":"zvuk 1","code":"code 1","remark":"remark 19","akcija":"akcija 19","video":"video 19"}, 
        {"id":"20","name":"name 20", "zvuk":"zvuk 1","code":"code 1","remark":"remark 20","akcija":"akcija 20","video":"video 20"}
    ];
//    $scope.items =
//    [{"id":3,"name":"-","code":"0","remark":"***","akcija":null,"timestamp":1513254527000,"aktivan":true,"video":null,"zvuk":null,"slike":null},{"id":7,"name":"Finska","code":"4","remark":"","akcija":null,"timestamp":1514220557000,"aktivan":true,"video":null,"zvuk":null,"slike":null},{"id":8,"name":"1lll1","code":"0","remark":null,"akcija":null,"timestamp":1514223378000,"aktivan":false,"video":null,"zvuk":null,"slike":null},{"id":9,"name":"00","code":"0","remark":"","akcija":null,"timestamp":1514223432000,"aktivan":false,"video":null,"zvuk":null,"slike":null},{"id":10,"name":"5111","code":"8","remark":"","akcija":null,"timestamp":1514224493000,"aktivan":false,"video":null,"zvuk":null,"slike":null},{"id":11,"name":"ouoiuuupppp","code":"00111","remark":"","akcija":null,"timestamp":1514224282000,"aktivan":false,"video":null,"zvuk":null,"slike":null},{"id":12,"name":"Mongolija","code":"10","remark":"","akcija":null,"timestamp":1514743409000,"aktivan":true,"video":null,"zvuk":null,"slike":null},{"id":13,"name":"UAE","code":"15","remark":"","akcija":null,"timestamp":1514743424000,"aktivan":true,"video":null,"zvuk":null,"slike":null},{"id":14,"name":"mAXI","code":"16","remark":"","akcija":null,"timestamp":1514743440000,"aktivan":true,"video":null,"zvuk":null,"slike":null},{"id":15,"name":"belgija","code":"18","remark":"","akcija":null,"timestamp":1514743462000,"aktivan":true,"video":null,"zvuk":null,"slike":null},{"id":16,"name":"Holandija","code":"19","remark":"","akcija":null,"timestamp":1514743477000,"aktivan":true,"video":null,"zvuk":null,"slike":null},{"id":17,"name":"Bulgarija","code":"20","remark":"","akcija":null,"timestamp":1514743492000,"aktivan":true,"video":null,"zvuk":null,"slike":null}]
    
//    $scope.items = function () {
//    	$scope.items = [];
    $http.get('http://localhost:8080/states'). // getAllStates
    success(function(data) {

        $scope.items =  data;
        $scope.rr= 14;

    });
    
    $scope.items =  data;
//    }
    
 //   $scope.search();
//    function _refreshStateData() {
//        $http({
//            method : 'GET',
//            url : 'http://localhost:8080/states'
//        }).then(function successCallback(response) {
//           $scope.items = response // .data
//        }, function errorCallback(response) {
//            console.log(response.statusText);
//        });
//    	
//
//    }  
//    
//    $scope._refreshStateData();
    
    var searchMatch = function (haystack, needle) {
        if (!needle) {
            return true;
        }
        return haystack.toLowerCase().indexOf(needle.toLowerCase()) !== -1;
    };

    // init the filtered items
    $scope.search = function () {
        $scope.filteredItems = $filter('filter')($scope.items, function (item) {
            for(var attr in item) {
                if (searchMatch(item[attr], $scope.query))
                    return true;
            }
            return false;
        });
        // take care of the sorting order
        if ($scope.sortingOrder !== '') {
            $scope.filteredItems = $filter('orderBy')($scope.filteredItems, $scope.sortingOrder, $scope.reverse);
        }
        $scope.currentPage = 0;
        // now group by pages
        $scope.groupToPages();
    };
    
    // calculate page in place
    $scope.groupToPages = function () {
        $scope.pagedItems = [];
        
        for (var i = 0; i < $scope.filteredItems.length; i++) {
            if (i % $scope.itemsPerPage === 0) {
                $scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
            } else {
                $scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
            }
        }
    };
    
    $scope.range = function (start, end) {
        var ret = [];
        if (!end) {
            end = start;
            start = 0;
        }
        for (var i = start; i < end; i++) {
            ret.push(i);
        }
        return ret;
    };
    
    $scope.prevPage = function () {
        if ($scope.currentPage > 0) {
            $scope.currentPage--;
        }
    };
    
    $scope.nextPage = function () {
        if ($scope.currentPage < $scope.pagedItems.length - 1) {
            $scope.currentPage++;
        }
    };
    
    $scope.setPage = function () {
        $scope.currentPage = this.n;
    };

    // functions have been describe process the data for display
    $scope.search();

    // change sorting order
    $scope.sort_by = function(newSortingOrder) {
        if ($scope.sortingOrder == newSortingOrder)
            $scope.reverse = !$scope.reverse;

        $scope.sortingOrder = newSortingOrder;

        // icon setup
        $('th i').each(function(){
            // icon reset
            $(this).removeClass().addClass('icon-sort');
        });
        if ($scope.reverse)
            $('th.'+new_sorting_order+' i').removeClass().addClass('icon-chevron-up');
        else
            $('th.'+new_sorting_order+' i').removeClass().addClass('icon-chevron-down');
    };
    

    
};



ctrlRead.$inject = ['$scope', '$filter', '$http'];
