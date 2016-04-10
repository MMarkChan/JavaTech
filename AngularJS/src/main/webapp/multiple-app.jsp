<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<body>

<%--一个网页可以包含多个运行在不同元素中的 AngularJS 应用程序--%>
<div ng-app="app1">
    名: <input type="text" ng-model="firstName"><br>
    姓: <input type="text" ng-model="lastName"><br>
    姓名: {{firstName + " " + lastName}}
</div>
<br>
<div id="app2">
    名: <input type="text" ng-model="firstName"><br>
    姓: <input type="text" ng-model="lastName"><br>
    姓名: {{firstName + " " + lastName}}
</div>

<script>
    /**
    * 只有第一个ng-app会被angular加载，其他的用 angular.bootstrap 手动加载
    */
    var app1 = angular.module('app1', []);
    var app2 = angular.module('app2', []);
    angular.bootstrap(document.getElementById("app2"), ['app2']);

</script>
</body>
</html>
