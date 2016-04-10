<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
    $http 是 AngularJS 中的一个核心服务，用于读取远程服务器的数据。
    $http.get(url) 是用于读取服务器数据的函数。
--%>
<body>
    <%--AngularJS 应用通过 ng-app 定义。应用在 <div> 中执行。
        ng-controller 指令设置了 controller 对象 名。
    --%>
    <div ng-app="app" ng-controller="customersCtrl">
        <ul>
            <li ng-repeat="x in names">
                {{ x.Name + ', ' + x.Country }}
            </li>
        </ul>
    </div>
    <script>
        var app = angular.module('app', []);
        /*函数 customersCtrl 是一个标准的 JavaScript 对象构造器。*/
        app.controller('customersCtrl', function($scope, $http) {
            /*控制器对象有一个属性: $scope.names。
            $http.get() 从web服务器上读取静态 JSON 数据。 */
//            $http.get("http://www.runoob.com/try/angularjs/data/Customers_JSON.php") // 会产生跨域问题
        $http.get("data.json")
                .success(function(response) {
                    $scope.names = response.records;
                });
        });
    </script>
</body>
</html>
