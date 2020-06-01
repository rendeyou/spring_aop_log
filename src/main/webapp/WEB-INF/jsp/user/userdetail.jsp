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
    <style type="text/css">
        table {
            width: 50%;
            border-collapse: collapse;
        }

        td {
            border: 1px solid grey;
        }
    </style>
</head>
<body>
<center>
    <h1>用户详情</h1>
    <hr>
    <form action="addAddress" method="post">
        <input type="hidden" name="uid" value="${user.id}">
        <table>
            <tr>
                <td>用户ID：</td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td>注册日期：</td>
                <td><fmt:formatDate value="${user.registTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
            </tr>
            <tr>
                <td>收获地址：</td>
                <td colspan="10" style="padding: 5px">
                    <table style="width: 100%">
                        <tr>
                            <td>省</td>
                            <td>市</td>
                            <td>区</td>
                            <td>操作</td>
                        </tr>
                        <c:forEach items="${user.addressList}" var="address">
                            <tr>
                                <td>${address.province}</td>
                                <td>${address.city}</td>
                                <td>${address.district}</td>
                                <td><a href="#">修改</a>|<a href="#">删除</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr>
                <td>省：</td>
                <td><input type="text" name="province"></td>
            </tr>
            <tr>
                <td>市：</td>
                <td><input type="text" name="city"></td>
            </tr>
            <tr>
                <td>区：</td>
                <td><input type="text" name="district"></td>
            </tr>
            <tr>
                <td colspan="10" align="center">
                    <input type="submit" value="添加收获地址">
                    <input type="button" value="返回" onclick="location.href='userList'">
                </td>
            </tr>
        </table>
    </form>
    <span style="color: #ff0000">${msg}</span>
</center>
</body>
</html>
