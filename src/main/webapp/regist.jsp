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
    <title>Title</title>
</head>
<body>
<center>
    <form action="regist" method="post">
        <%--input[type=hidden][name=method][value=regist]--%>
        　用户名：<input type="text" name="username"><br>
        　密　码：<input type="password" name="password"><br>
        确认密码：<input type="password" name="confirm"><br>
        　生　日：<input type="text" name="birthday"><br>
        <input type="submit" value="注册">
        <input type="button" value="登录" onclick="location.href='index.jsp'">
    </form>
    <span style="color: #ff0000;">${msg}</span>
</center>
</body>
</html>
