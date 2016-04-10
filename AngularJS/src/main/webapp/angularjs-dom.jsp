<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
   AngularJS 为 HTML DOM 元素的属性提供了绑定应用数据的指令。
--%>
<body>

 <div ng-app="app" ng-controller="ctrl">
     <%--
        ng-disabled 指令
        ng-disabled 指令直接绑定应用程序数据到 HTML 的 disabled 属性。
     --%>
     <div  ng-init="mySwitch=true">
         <p>
             <%--ng-disabled 指令绑定应用程序数据 "mySwitch" 到 HTML 的 disabled 属性。--%>
             <button ng-disabled="mySwitch">点我!</button>
         </p>
         <p>
             <%--ng-model 指令绑定 "mySwitch" 到 HTML input checkbox 元素的内容（value）。--%>
             <input type="checkbox" ng-model="mySwitch"/>按钮
         </p>
         <p>
             {{ mySwitch }}
         </p>


         <%--
            ng-show 指令
            ng-show 指令隐藏或显示一个 HTML 元素。
        --%>
         <p ng-show="mySwitch">我是可见的。</p>
         <p ng-show="!mySwitch">我是不可见的。</p>
         <p ng-show="hour > 11">夜已深，请休息！</p>

         <%--
            ng-hide 指令
            ng-hide 指令用于隐藏或显示 HTML 元素。
         --%>
         <p ng-hide="!mySwitch">我是不可见的。</p>
         <p ng-hide="mySwitch">我是可见的。</p>
     </div>

    <script>
        angular.module('app',[]).controller('ctrl',function($scope){
            $scope.hour = new Date().getHours();
        });
    </script>

 </div>
</body>
</html>
