<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
   AngularJS 有自己的 HTML 事件指令。
--%>
<body ng-app="app">

 <div ng-controller="ctrl0">
     <%--
        ng-click 指令
        ng-click 指令定义了 AngularJS 点击事件。
     --%>
     <button ng-click="count = count>0?count-1:count">—</button>
     {{ count }}
     <button ng-click="count = count!=10?count+1:10">+</button>
    <script>
        var app = angular.module('app',[]).controller('ctrl0',function($scope){
            $scope.hour = new Date().getHours();
            $scope.count=0;
        });
    </script>
    </div>

    <div ng-controller="personCtrl">
        <button ng-click="toggle()">隐藏/显示</button>

        <%--
        隐藏 HTML 元素
         ng-hide 指令用于设置应用部分是否可见。
         ng-hide="true" 设置 HTML 元素不可见。
         ng-hide="false" 设置 HTML 元素可见。
        --%>
        <p ng-hide="myVar"> <%--ng-hide 指令设置 <p>元素及两个输入域是否可见， 根据 myVar 的值 (true 或 false) 来设置是否可见。 --%>
            名: <input type="text" ng-model="firstName"><br>
            姓: <input type="text" ng-model="lastName"><br>
            <br>
            姓名: {{firstName + " " + lastName}}
        </p>


        <%--
            显示 HTML 元素
            ng-show 指令可用于设置应用中的一部分是否可见 。
            ng-show="false" 可以设置 HTML 元素 不可见。
            ng-show="true" 可以以设置 HTML 元素可见。
        --%>
        <p ng-show="myVar">
            名2: <input type="text" ng-model="firstName"><br>
            姓2: <input type="text" ng-model="lastName"><br>
            <br>
            姓名2: {{firstName + " " + lastName}}
        </p>
    </div>
    <script>
         app.controller('personCtrl', function($scope) {
             $scope.firstName = "John",
             $scope.lastName = "Doe"
             $scope.myVar = false; //应用有一个默认属性: $scope.myVar = false;
             $scope.toggle = function() { //toggle() 函数用于切换 myVar 变量的值（true 和 false）。
                $scope.myVar = !$scope.myVar;
             };
         });
    </script>



</body>
</html>
