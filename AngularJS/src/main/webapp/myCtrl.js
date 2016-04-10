myApp.controller("myCtrl", function($scope) {
    $scope.firstName = "John";
    $scope.lastName= "Doe";
});
angular.bootstrap(document.getElementById('myApp'),['myApp']);