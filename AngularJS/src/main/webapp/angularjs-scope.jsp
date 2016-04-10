<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
Scope(作用域) 是应用在 HTML (视图) 和 JavaScript (控制器)之间的纽带。
Scope 是一个对象，有可用的方法和属性。
Scope 可应用在视图和控制器上。

--%>
<body ng-app="app">
    <%--
    如何使用 Scope
    --%>
    <div ng-controller="ctrl0">
        <%--
        第二步、当在控制器中添加 $scope 对象时，视图 (HTML) 可以获取了这些属性。
        视图中，你不需要添加 $scope 前缀, 只需要添加属性名即可，如： {{carname}}。
        --%>
        <h1>{{carname}}</h1>
    </div>
    <script>
        var app = angular.module('app', []);
        /*第一步、在 AngularJS 创建控制器时，你可以将 $scope 对象当作一个参数传递*/
        app.controller('ctrl0', function($scope) {
            $scope.carname = "Volvo";
        });
    </script>


    <%--
    根作用域
        所有的应用都有一个 $rootScope，它可以作用在 ng-app 指令包含的所有 HTML 元素中。
        $rootScope 可作用于整个应用中。是各个 controller 中 scope 的桥梁。
        用 rootscope 定义的值，可以在各个 controller 中使用。
    --%>
    <div ng-controller="ctrl2">
        <h1>{{lastname}} 家族成员:</h1>
        <ul>
            <li ng-repeat="x in names">{{x}} {{lastname}}
        </ul>
    </div>
    <script>
        /*创建控制器时，将 $rootScope 作为参数传递，可在应用中使用*/
        app.controller('ctrl2', function($scope, $rootScope) {
        $scope.names = ["Emil", "Tobias", "Linus"];
        $rootScope.lastname = "Refsnes";
        });
    </script>

    <%--
        Scope 概述
        AngularJS 应用组成如下：
            View(视图), 即 HTML。
            model(模型), 当前视图中可用的数据。
            Controller(控制器), 即 JavaScript 函数，可以添加或修改属性。
        scope 是模型。
        scope 是一个 JavaScript 对象，带有属性和方法，这些属性和方法可以在视图和控制器中使用。
        如果你修改了视图，模型和控制器也会相应更新
     --%>
    <div ng-controller="ctrl1">
        <input ng-model="name">
        <h1>我的名字是 {{name}} {{lastname}}</h1>
    </div>
    <script>
        app.controller('ctrl1', function($scope) {
            $scope.name = "John Dow";
        });
    </script>


</body>
</html>
