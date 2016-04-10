<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <script src="angular/angular.min.js"></script>
</head>
<%--
    过滤器可以使用一个管道字符（|）添加到 <表达式> 和 <指令> 中。
    AngularJS 过滤器可用于转换数据：
        currency 	格式化数字为货币格式。
        filter 	从数组项中选择一个子集。
        lowercase 	格式化字符串为小写。
        orderBy 	根据某个表达式排列数组。
        uppercase 	格式化字符串为大写。


--%>
<body ng-app="app">
    <%--
       表达式中添加过滤器
        过滤器可以通过一个管道字符（|）和一个过滤器添加到表达式中。.
        (（下面的两个实例，我们将使用前面章节中提到的 person 控制器）)
        uppercase 过滤器将字符串格式化为大写
    --%>
    <div ng-controller="personCtrl">
        名: <input type="text" ng-model="firstName"><br>
        姓: <input type="text" ng-model="lastName"><br>
        <br>
        姓名: {{fullName()|uppercase}}<br/>
        姓名: {{fullName()|lowercase}}
    </div>
    <div ng-controller="costCtrl">
        <input type="number" ng-model="quantity">
        <input type="number" ng-model="price">
        <p>总价 = {{ (quantity * price) | currency }}</p>
    </div>
    <script>
        var app = angular.module('app',[]);
        app.controller('personCtrl', function($scope) {
            $scope.firstName = "John";
            $scope.lastName = "Doe";
            $scope.fullName = function() {
                return $scope.firstName + " " + $scope.lastName;
            }
        }).controller('costCtrl',function($scope){
//            $scope.firstName;
//            $scope.lastName;
        });
    </script>



    <div ng-controller="namesCtrl">
        <%--
            向指令添加过滤器
            过滤器可以通过一个管道字符（|）和一个过滤器添加到指令中。
            orderBy 过滤器根据表达式排列数组：
        --%>
        <ul>
            <li ng-repeat="x in names | orderBy:'country'">
                {{ x.name + ', ' + x.country }}
            </li>
        </ul>


        <%--
            过滤输入
            输入过滤器可以通过一个管道字符（|）和一个过滤器添加到指令中，该过滤器后跟一个冒号和一个<模型名称>。
            模型就是当前视图中可用的数据，而scope 是所有模型数据的聚集地
            filter 过滤器从数组中选择一个子集
        --%>
        <p><input type="text" ng-model="keyword"></p>
        <ul>
            <li ng-repeat="x in names | filter:keyword | orderBy:'country'">
                {{ (x.name | uppercase) + ', ' + x.country }}
            </li>
        </ul>
    </div>
    <script>
        app.controller('namesCtrl', function($scope) {
            $scope.names = [
                {name:'Jani',country:'Norway'},
                {name:'Hege',country:'Sweden'},
                {name:'Kai',country:'Denmark'}
            ];
        });
    </script>


</body>
</html>
