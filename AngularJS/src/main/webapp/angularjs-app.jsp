<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html ng-app="myNoteApp"> <%--<html> 元素是 AngularJS 应用: ng-app="myNoteApp" 的容器--%>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
   创建一个真正的 AngularJS 单页 Web 应用（single page web application，SPA）

   AngularJS 应用架构
        以下实例是一个完整的 AngularJS 单页Web应用（single page web application，SPA）。
        <html> 元素包含了 AngularJS 应用 (ng-app=)。
        <div> 元素定义了 AngularJS 控制器的作用域 (ng-controller=)。
        在一个应用可以由很多控制器。
        应用文件(my...App.js) 定义了应用模型代码。
        一个或多个控制器文件 (my...Ctrl.js) 定义了控制器代码。

    总结 - 它是如何工作的呢？
        ng-app 指令位于应用的根元素下。
        对于单页Web应用（single page web application，SPA），应用的根通常为 <html> 元素。
        一个或多个 ng-controller 指令定义了应用的控制器。每个控制器有他自己的作用域：: 定义的 HTML 元素。
        AngularJS 在 HTML DOMContentLoaded 事件中自动开始。如果找到 ng-app 指令 ， AngularJS 载入指令中的模块，并将 ng-app 作为应用的根进行编译。
        应用的根可以是整个页面，或者页面的一小部分，如果是一小部分会更快编译和执行。
--%>
<body>
    <div ng-controller="myNoteCtrl"> <%--<div> 是 HTML 页面中控制器: ng-controller="myNoteCtrl" 的作用域--%>
        <h2>我的笔记</h2>
        <%--ng-model 指令绑定了 <textarea> 到控制器变量 message--%>
        <p><textarea ng-model="message" cols="40" rows="10"></textarea></p>
        <p>
            <%--两个 ng-click 事件调用了控制器函数 clear() 和 save()--%>
            <button ng-click="save()">保存</button>
            <button ng-click="clear()">清除</button>
        </p>
        <%--ng-bind 指令绑定控制器函数 left() 到<span> ，用于显示剩余字符--%>
        <p>Number of characters left: <span ng-bind="left()"></span></p>
    </div>
    <%--应用库文件需要在 AngularJs 加载后才能执行--%>
    <script src="myNoteApp.js"></script>
    <script src="myNoteCtrl.js"></script>
</body>
</html>
