<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
   ng-repeat 指令可以完美的显示表格。
   使用 angular 显示表格是非常简单的
--%>
<body>
    <style>
        table, th , td {
            border: 1px solid grey;
            border-collapse: collapse;
            padding: 5px;
        }
        table tr:nth-child(odd) {
            background-color: #f1f1f1;
        }
        table tr:nth-child(even) {
            background-color: #ffffff;
        }
    </style>
    <div ng-app="app" ng-controller="customersCtrl">
        <table>
            <tr ng-repeat="x in names">
                <td>{{ x.Name }}</td>
                <td>{{ x.Country }}</td>
            </tr>
        </table>
        <br/>

        <%--使用 orderBy 过滤器--%>
        <table>
            <tr ng-repeat="x in names | orderBy : 'Country'">
                <td>{{ x.Name }}</td>
                <td>{{ x.Country }}</td>
            </tr>
        </table>
        <br/>

        <%--使用 uppercase 过滤器--%>
        <table>
            <tr ng-repeat="x in names">
                <td>{{ x.Name }}</td>
                <td>{{ x.Country | uppercase }}</td>
            </tr>
        </table>
        <br/>

        <%--
        显示序号 ($index)
        表格显示序号可以在 <td> 中添加 $index
        --%>
        <table>
            <tr ng-repeat="x in names">
                <td>{{ $index + 1 }}</td>
                <td>{{ x.Name }}</td>
                <td>{{ x.Country }}</td>
            </tr>
        </table>
        <br/>

        <%--使用 $even 和 $odd--%>
        <table>
            <tr ng-repeat="x in names">
                <td ng-if="$odd" style="background-color:#f1f1f1">{{ x.Name }}</td>
                <td ng-if="$even">{{ x.Name }}</td>
                <td ng-if="$odd" style="background-color:#f1e66f">{{ x.Country }}</td>
                <td ng-if="$even">{{ x.Country }}</td>
            </tr>
        </table>
    </div>
    <script>
        var app = angular.module('app', []);
        app.controller('customersCtrl', function($scope, $http) {
            $http.get("data.json")
                .success(function (response) {
                    $scope.names = response.records;
                });
        });
    </script>
</body>
</html>
