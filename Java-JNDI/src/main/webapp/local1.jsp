<%@ page import="local.LocalConfig1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    LocalConfig1 local = new LocalConfig1();
  %>
  <%=local.test()%>
  </body>
</html>
