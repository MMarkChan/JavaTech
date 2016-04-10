<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
AngularJS 控制器 控制 AngularJS 应用程序的数据。
AngularJS 控制器是常规的 JavaScript 对象。
--%>
<body>
    <%--AngularJS 应用程序由 ng-app 定义。应用程序在 <body> 内运行。--%>
    <div ng-app="app1">
        <%--
                        AngularJS 控制器
                        AngularJS 应用程序被控制器控制。
                        ng-controller 指令定义了应用程序控制器。
                        控制器是 JavaScript 对象，由标准的 JavaScript 对象的构造函数 创建。
                    --%>
            <div ng-controller="ctrl0"> <%--ng-controller="ctrl0" 属性是一个 AngularJS 指令。用于定义一个控制器。--%>
                <%--ng-model 指令绑定输入域到控制器的属性（firstName 和 lastName）。--%>
                名: <input type="text" ng-model="firstName"><br>
                姓: <input type="text" ng-model="lastName"><br>
                <br>
                姓名: {{firstName + " " + lastName}}
            </div>
            <script>
                var app1 = angular.module('app1', []);
                app1.controller('ctrl0', function($scope) { /*ctrl0 函数是一个 JavaScript 函数。*/
                    /*AngularJS 使用$scope 对象来调用控制器。
                    在 AngularJS 中， $scope 是一个应用对象(属于应用变量和函数)。
                    控制器的 $scope （相当于作用域、控制范围）用来保存AngularJS model(模型,包括使用ng-model定义的对象)的对象。
                    控制器在作用域中创建了两个属性 (firstName 和 lastName)。*/
                    $scope.firstName = "John";
                    $scope.lastName = "Doe";
                });
            </script>


            <%--
                控制器方法
                控制器也可以有方法（变量和函数）
            --%>
            <div ng-controller="personCtrl">
                名: <input type="text" ng-model="firstName"><br>
                姓: <input type="text" ng-model="lastName"><br>
                <br>
                姓名: {{fullName()}}
            </div>
            <script>
                app1.controller('personCtrl', function($scope) {
                    $scope.firstName = "John";
                    $scope.lastName = "Doe";
                    $scope.fullName = function() {
                    return $scope.firstName + " " + $scope.lastName;
                }
                });
            </script>


            <%--
                外部文件中的控制器
                在大型的应用程序中，通常是把控制器存储在外部文件中。
                只需要把 <script> 标签中的代码复制到名为 personController.js 的外部文件中即可
            --%>
            <div ng-controller="personCtrl2">
                First Name: <input type="text" ng-model="firstName"><br>
                Last Name: <input type="text" ng-model="lastName"><br>
                <br>
                Full Name: {{firstName + " " + lastName}}
            </div>
            <script src="personController2.js"></script>
    </div>

    <%--同一网页的第二个应用--%>
    <div id="app2" ng-controller="namesCtrl">
        <ul>
            <li ng-repeat="x in names">
                {{ x.name + ', ' + x.country }}
            </li>
        </ul>
    </div>
    <script src="namesController.js"></script>

</body>
</html>
