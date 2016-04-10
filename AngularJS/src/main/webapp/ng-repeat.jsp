<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
ng-repeat 指令对于集合中（数组中）的每个项会 克隆一次 HTML 元素。
--%>
<body ng-app="">
    <%--使用 ng-repeat 来循环数组--%>
    <div ng-init="names=['Jani','Hege','Kai']">
        <p>使用 ng-repeat 来循环数组</p>
        <ul>
            <li ng-repeat="x in names">
                {{ x }}
            </li>
        </ul>
    </div>

    <%--
    ng-repeat 指令用在一个对象数组上
    AngularJS 完美支持数据库的 CRUD（增加Create、读取Read、更新Update、删除Delete）应用程序。
    把实例中的对象想象成数据库中的记录。
    --%>
    <div ng-init="names2=[
        {name:'Jani',country:'Norway'},
        {name:'Hege',country:'Sweden'},
        {name:'Kai',country:'Denmark'}]">
        <p>循环对象数组：</p>
        <ul>
            <li ng-repeat="x in names2">
                {{ x.name + ', ' + x.country }}
            </li>
        </ul>
    </div>
</body>
</html>
