<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
    <script src="angular/angular.min.js"></script>
</head>
<%--
  AngularJS 表单是输入控件的集合。
  以下 HTML input 元素被称为 HTML 控件:
    input 元素
    select 元素
    button 元素
    textarea 元素
    HTML 表单通常与 HTML 控件同时存在。
--%>
<body>
    <div ng-app="myApp" ng-controller="formCtrl"> <%--ng-app 指令定义了 AngularJS 应用。ng-controller 指令定义了应用控制器。--%>
        <%--novalidate 属性在应用中不是必须的，但是你需要在 AngularJS 表单中使用，用于重写标准的 HTML5 验证。--%>
        <form novalidate>
            <%--ng-model 指令绑定了两个 input 元素到模型的 user 对象。--%>
            First Name:<br>
            <input type="text" ng-model="user.firstName"><br>
            Last Name:<br>
            <input type="text" ng-model="user.lastName">
            <br><br>
            <button ng-click="reset()">RESET</button><%--ng-click 指令调用了 reset() 方法，且在点击按钮时调用。--%>
        </form>
        <p>form = {{user}}</p>
        <p>master = {{master}}</p>
    </div>

    <script>
        var app = angular.module('myApp', []);
        /*formCtrl 函数设置了 master 对象的初始值，并定义了 reset() 方法。*/
        app.controller('formCtrl', function($scope) {
            $scope.master = {firstName: "John", lastName: "Doe"}; // 保存初始值
            /*reset() 方法设置了 user 对象等于 master 对象。 */
            $scope.reset = function() {
                $scope.user = angular.copy($scope.master); // 点击重置按钮把表单所有的字段重新赋值为master里面的值
            };
            $scope.reset();
        });
    </script>
</body>
</html>
