<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%--引入jstl--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" +
            request.getServerPort() +
            request.getContextPath() + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<center>
    <form action="login" method="post">
        <%--input[type=hidden][name=method][value=login]--%>
        用户名：<input type="text" name="username"><br>
        密　码：<input type="password" name="password"><br>
        <input type="submit" value="登录">
        <input type="button" value="注册" onclick="window.location.href='regist.jsp'">
    </form>
    <font size="3" color="red">${sessionScope.msg}</font>
    <c:remove var="msg" scope="session"/>
</center>
</body>
</html>
