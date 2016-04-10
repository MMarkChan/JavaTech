<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
ng-model 指令 绑定 HTML 元素 到应用程序数据。ng-model 指令可以将输入域的值与 AngularJS 创建的变量绑定。
ng-model 指令也可以：
    为应用程序数据提供类型验证（number、email、required）。
    为应用程序数据提供状态（invalid、dirty、touched、error）。
    为 HTML 元素提供 CSS 类。
    绑定 HTML 元素到 HTML 表单。
--%>
<body ng-app="app">
    <%--将输入域的值与 AngularJS 创建的变量绑定。
    双向绑定，在修改输入域的值时， AngularJS 属性的值也将修改--%>
    <div ng-controller="controller1">
        名字: <input ng-model="name">
        <h1>你输入了: {{name}}</h1>
    </div>

    <form name="myForm">
        <%--验证用户输入，提示信息会在 ng-show 属性返回 true 的情况下显示。--%>
        Email1:
        <input type="email" name="myAddress1" ng-model="text">
        <span ng-show="myForm.myAddress1.$error.email">不是一个合法的邮箱地址</span>

        <br/>

        <%--应用状态，ng-model 指令可以为应用数据提供状态值(invalid, dirty, touched, error)--%>
        Email2:
        <input type="email" name="myAddress2" ng-model="myText" required></p>
        <h1>状态</h1>
        {{myForm.myAddress2.$valid}}
        {{myForm.myAddress2.$dirty}}
        {{myForm.myAddress2.$touched}}


        <br/>

        <%--
            CSS 类，ng-model 指令基于它们的状态为 HTML 元素提供了 CSS 类
            ng-model 指令根据表单域的状态添加/移除以下类：
                ng-empty
                ng-not-empty
                ng-touched
                ng-untouched
                ng-valid
                ng-invalid
                ng-dirty
                ng-pending
                ng-pristine
        --%>
        <style>
            input.ng-invalid {
                background-color: lightblue;
            }
        </style>
        输入你的邮箱:
        <input type="email" name="myAddress3" ng-model="text3" required>
    </form>

    <script>
       /*如果整个网页只有一个应用，则Angularjs自动启动第一个应用时会默认把ng-app指令的值作为相应module的名称
       * */
        var app = angular.module('app', []);
        app.controller('controller1', function($scope) {
            $scope.name = "John Doe";
        });
    </script>
</body>
</html>
