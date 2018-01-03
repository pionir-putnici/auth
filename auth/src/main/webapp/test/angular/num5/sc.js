var myevents = angular.module('myeventsApp', []);

myevents.controller("EventsController", function ($scope, $http) {
    $http.get('http://localhost:8080/states')
        .success(function (data) {
            $scope.events = data;
        });
});