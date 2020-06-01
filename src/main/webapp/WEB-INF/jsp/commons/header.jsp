<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>XXX管理系统</h3>
<strong style="color: chartreuse">${sessionScope.user.username}</strong>欢迎您！
<a href="${pageContext.request.contextPath}/logout" target="_top">退出登录</a>
</body>
</html>
