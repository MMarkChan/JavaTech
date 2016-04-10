<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
    <script src="angular/angular.min.js"></script>
</head>
<%--
     AngularJS 全局 API 用于执行常见任务的 JavaScript 函数集合，如：
        比较对象
        迭代对象
        转换对象

     全局 API 函数使用 angular 对象进行访问。
     以下列出了一些通用的 API 函数：
         angular.lowercase() 	转换字符串为小写
        angular.uppercase() 	转换字符串为大写
        angular.isString() 	判断给定的对象是否为字符串，如果是返回 true。
        angular.isNumber() 	判断给定的对象是否为数字，如果是返回 true。
--%>
<body ng-app="myApp">
    angular.lowercase()
    <div ng-controller="ctrl0">
        <p>{{ x1 }}</p>
        <p>{{ x2 }}</p>
    </div>
    angular.uppercase()
    <div ng-controller="ctrl1">
        <p>{{ x1 }}</p>
        <p>{{ x2 }}</p>
    </div>
    angular.isString()
    <div ng-controller="ctrl2">
        <p>{{ x1 }}</p>
        <p>{{ x2 }}</p>
    </div>
    angular.isNumber()
    <div ng-controller="ctrl3">
        <p>{{ x1 }}</p>
        <p>{{ x2 }}</p>
    </div>
    <script>
        var app = angular.module('myApp', []);
        app.controller('ctrl0', function($scope) {
            $scope.x1 = "JOHN";
            $scope.x2 = angular.lowercase($scope.x1);
        }).controller('ctrl1', function($scope) {
            $scope.x1 = "John";
            $scope.x2 = angular.uppercase($scope.x1);
        }).controller('ctrl2', function($scope) {
            $scope.x1 = "JOHN";
            $scope.x2 = angular.isString($scope.x1);
        }).controller('ctrl3', function($scope) {
            $scope.x1 = "JOHN";
            $scope.x2 = angular.isNumber($scope.x1);
        });
    </script>
</body>
</html>
