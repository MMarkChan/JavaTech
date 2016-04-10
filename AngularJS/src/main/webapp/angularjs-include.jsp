<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="angular/angular.min.js"></script>
</head>
<%--在 AngularJS 中，你可以在 HTML 中包含 HTML 文件。--%>
<body ng-app="myApp" ng-controller="userCtrl">
    <%--
    服务端包含
    大多服务端脚本都支持包含文件功能 (SSI： Server Side Includes)。
    使用 SSI, 你可在 HTML 中包含 HTML 文件，并发送到客户端浏览器。

    客户端包含
    通过 JavaScript 有很多种方式可以在 HTML 中包含 HTML 文件。
    通常我们使用 http 请求 (AJAX) 从服务端获取数据，返回的数据我们可以通过 使用 innerHTML 写入到 HTML 元素中。
    --%>

    <%--
    AngularJS 包含
    使用 AngularJS, 你可以使用 ng-include 指令来包含 HTML 内容
    --%>
    <div class="container">
        <div ng-include="'myUsers_List.html'"></div>
        <div ng-include="'myUsers_Form.html'"></div>
    </div>

    <script src= "myUsers.js"></script>
</body>
</html>
