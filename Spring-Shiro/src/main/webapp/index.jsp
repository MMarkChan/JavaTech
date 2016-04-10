<%@ taglib prefix=“shiro” uri=http://shiro.apache.org/tags %>
<html>
    <body>
        <shiro:hasPermission name=“users:manage”>
            <a href=“manageUsers.jsp”>
                Click here to manage users
            </a>
        </shiro:hasPermission>
        <shiro:lacksPermission name=“users:manage”>
            No user management for you!
        </shiro:lacksPermission>
    </body>
</html>