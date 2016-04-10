<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
    <script src="angular/angular.min.js"></script>
</head>
<%--
    AngularJS 表单和控件可以提供验证功能，并对用户输入的非法数据进行警告。
    注意：客户端的验证不能确保用户输入数据的安全，所以服务端的数据验证也是必须的。

    $dirty 	表单有填写记录
    $valid 	字段内容合法的
    $invalid 	字段内容是非法的
    $pristine 	表单没有填写记录
--%>
<body>
    <%--HTML 表单属性 novalidate 用于禁用浏览器默认的验证。--%>
    <form  ng-app="myApp" ng-controller="validateCtrl" name="myForm" novalidate>
        <%--AngularJS ng-model 指令用于绑定输入元素到模型中。
        模型对象有两个属性： user 和 email。--%>
        <p>用户名:<br>
          <input type="text" name="user" ng-model="user" required>
          <span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
            <span ng-show="myForm.user.$error.required">用户名是必须的。</span>
          </span>
        </p>
        <p>邮箱:<br>
            <input type="email" name="email" ng-model="email" required>
            <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
                <span ng-show="myForm.email.$error.required">邮箱是必须的。</span>
                <span ng-show="myForm.email.$error.email">非法的邮箱。</span>
            </span>
        </p>
        <p>
            <input type="submit" ng-disabled="myForm.user.$dirty && myForm.user.$invalid ||
                                                myForm.email.$dirty && myForm.email.$invalid">
        </p>
    </form>
    <script>
        var app = angular.module('myApp', []);
        app.controller('validateCtrl', function($scope) {
            $scope.user = 'John Doe';
            $scope.email = 'john.doe@gmail.com';
        });
    </script>
</body>
</html>
