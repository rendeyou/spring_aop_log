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
    <h1>批量导入用户</h1>
    <form action="addUserBatch" method="post" enctype="multipart/form-data">
        <input type="file" name="userFile">
        <input type="submit" value="导入">
    </form>
    <h3>${msg}</h3>
</center>
</body>
</html>
