app1.controller('personCtrl2', function($scope) {
    $scope.firstName = "John222",
    $scope.lastName = "Doe222",
    $scope.fullName = function() {
        return $scope.firstName + " " + $scope.lastName;
    }
});