<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
除了 AngularJS 内置的指令外，我们还可以创建自定义指令。
你可以使用 .directive 函数来添加自定义的指令。
要调用自定义指令，HTMl 元素上需要添加自定义指令名。
使用驼峰法来命名一个指令， myDirective, 但在使用它时需要以 - 分割, my-directive

你可以通过以下方式来调用指令：
    元素名
        <my-directive></my-directive>
    属性
        <div my-directive></div>
    类名
        <div class="my-directive"></div>
    注释
        <!-- 指令: my-directive -->
元素名


--%>

<body ng-app="myApp">
  <div class="my-directive"></div>
  <script>
      var app = angular.module("myApp", []);
      app.directive("myDirective", function() {
          return {
              restrict:"C", // 注意： 你必须设置 restrict 的值为 "C" 才能通过类名来调用指令。
              template : "<h1>自定义指令!</h1>"
          };
      });
  </script>
</body>

</html>
