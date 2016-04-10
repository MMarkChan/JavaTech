<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">

</head>
<%--
   模块定义了一个应用程序。
   模块是应用程序中不同部分的容器。
   模块是应用控制器的容器。
   控制器通常属于一个模块。
--%>
<body>

    <%--
        创建模块
        通过 AngularJS 的 angular.module 函数来创建模块
        可以在 AngularJS 应用中添加控制器，指令，过滤器等。
    --%>
    <div ng-app="app">
        <%--
            添加控制器
            你可以使用 ng-controller 指令来添加应用的控制器
        --%>
        <div ng-controller="ctrl">
            {{ firstName + " " + lastName }}
        </div>


        <%--
            添加指令
            AngularJS 提供了很多内置的指令，你可以使用它们来为你的应用添加功能。
            完整的指令内容可以参阅 AngularJS 参考手册。
            此外，你可以使用模块来为你应用添加自己的指令
        --%>
        <div my-directive></div>
    </div>
    <script src="angular/angular.min.js"></script>
    <script>
        /*"app" 参数对应执行应用的 HTML 元素。*/

        var app = angular.module("app", []);
        app.controller("ctrl", function($scope) {
            $scope.firstName = "John";
            $scope.lastName = "Doe";
        });
        app.directive("myDirective", function() {
            return {
                template : "我在指令构造器中创建!"
            };
        });
    </script>

    <%--
        手动启用应用
    --%>
    <div id="app2">
        名: <input type="text" ng-model="firstName"><br>
        姓: <input type="text" ng-model="lastName"><br>
        姓名: {{firstName + " " + lastName}}
        <div ng-controller="ctrl1">
            {{firstName}}
        </div>
    </div>

    <script>
        var app2 = angular.module('app22',[]); // 先创建一个名称为‘app2'的模块
        app2.controller('ctrl1',function($scope){ // 在名称为‘app2’的模块定义名称为‘ctrl1’的控制器
        $scope.firstName = 'cdm';
        });
        angular.bootstrap(document.getElementById("app2"), ['app22']); // 让HTML中ID为‘app2’的元素与名称为‘app2’的模块进行绑定
    </script>

    <%--
        模块和控制器包含在 JS 文件中
        通常 AngularJS 应用程序将模块和控制器包含在 JavaScript 文件中。
        在以下实例中， "myApp.js" 包含了应用模块的定义程序， "myCtrl.js" 文件包含了控制器
    --%>
    <div id="myApp" ng-controller="myCtrl">
        myApp : {{ firstName + " " + lastName }}
    </div>

    <script src="myApp.js"></script>
    <script src="myCtrl.js"></script>

</body>
</html>
