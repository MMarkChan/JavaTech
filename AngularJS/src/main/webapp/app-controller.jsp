<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<body ng-app="app">

<div data-ng-init="firstName='John'">

  <p>姓名为 <span data-ng-bind="firstName"></span></p>

</div>

<%--ng-app指令告诉AngularJS: 这个div元素里面的所有元素归myApp这个应用所有，
并且myApp应用通过ng-controller指定的myCtrl来控制--%>
<div ng-controller="controller1">
    <%--ng-model属性把页面中(input, select, textarea)的值绑定到应用"app"控制器controller1里面的变量中--%>
    名: <input type="text" ng-model="firstName"><br>
    姓: <input type="text" ng-model="lastName"><br>
    <br>
    <%--{{}}表达式把应用“myApp”中的变量值绑定到页面上--%>
    姓名: {{firstName + " " + lastName}}
</div>


<script>
    var app = angular.module('app', []);
    //一个应用可以有很多控制器
    app.controller('controller1', function($scope) {
        $scope.firstName= "John";
        $scope.lastName= "Doe";
        $scope.cdm='Mark.Chan';
    });
</script>
</body>
</html>
