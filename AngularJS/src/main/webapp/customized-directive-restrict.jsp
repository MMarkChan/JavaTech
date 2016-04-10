<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
你可以限制你的指令只能通过特定的方式来调用。
通过添加 restrict 属性,并设置只值为 "A", 来设置指令只能通过属性的方式来调用
restrict 值可以是以下几种:

    E 只限元素名使用
    A 只限属性使用
    C 只限类名使用
    M 只限注释使用

restrict 默认值为 EA, 即可以通过元素名和属性名来调用指令。

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
