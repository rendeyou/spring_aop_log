<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" +
            request.getServerPort() +
            request.getContextPath() + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li><a href="userList" target="center">用户列表</a></li>
    <li><a href="user/addUserBatch" target="center">批量导入用户</a></li>
</ul>
</body>
</html>
