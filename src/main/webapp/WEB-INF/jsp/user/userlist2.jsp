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
    <%--引入jQuery--%>
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript">
        /*每页几条记录*/
        function changeSize(size) {
            alert(size);
            location.href="servlet/UserServlet?method=userList&page=1&size="+size;
        }
        /*跳到第几页*/
        function changePage(size) {
            alert(size);
            var page = document.getElementById("page").value;
            location.href="servlet/UserServlet?method=userList&page="+page+"&size="+size;
        }
    </script>
    <style type="text/css">
        /*表格样式*/
        table{
            margin:0 auto;
            width:50%;
            border-collapse: collapse;
            text-align: center;
        }
        td{
            border: 1px solid grey;
        }
        /*导航条样式*/
        a{
            text-decoration: none;
        }
        a:hover{
            background: green;
        }
/*        .a-other{
            display: inline-block;!*块级元素*!
            border: 1px solid grey;
            width: 60px;
            height: 20px;
            line-height: 20px;!*行高和高相同，垂直居中*!
        }*/
    </style>
</head>
<body>
    <%--创建表格，显示数据--%>
    <table>
        <tr>
            <td>用户ID</td>
            <td>用户名</td>
            <td>生日</td>
            <td>注册日期</td>
        </tr>
        <c:forEach items="${p.list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>
                    <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </td>
                <td>
                    <fmt:formatDate value="${user.regdate}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="15">
                共${p.totalCount}条记录，
                每页
                <select onchange="changeSize(this.value)"><%--传递参数/每页显示的记录数--%>
                    <c:forEach begin="3" end="9" step="3" var="n">
                        <c:if test="${n==p.size}">
                            <option value="${n}" selected>${n}</option>
                        </c:if>
                        <c:if test="${n!=p.size}">
                            <option value="${n}">${n}</option>
                        </c:if>

                    </c:forEach>
                </select>
                条记录，
                共${p.totalPage}页
            </td>
        </tr>
    </table>
    <br><%--换行--%>
    <%--创建导航条--%>
    <center>
        <a class="a-other" href="servlet/UserServlet?method=userList&page=${p.firstPage}&size=${p.size}">首页</a>
        <a class="a-other" href="servlet/UserServlet?method=userList&page=${p.prevPage}&size=${p.size}" onclick="return ${p.hasPrev}">上一页</a>
        <c:forEach begin="${p.navStart}" end="${p.navEnd}" step="1" var="n">
            <c:if test="${p.page==n}">
                [<a href="servlet/UserServlet?method=userList&page=${n}&size=${p.size}">${n}</a>]
            </c:if>
            <c:if test="${p.page!=n}">
                <a href="servlet/UserServlet?method=userList&page=${n}&size=${p.size}">${n}</a>
            </c:if>
        </c:forEach>
        <a class="a-other" href="servlet/UserServlet?method=userList&page=${p.nextPage}&size=${p.size}" onclick="return ${p.hasNext}">下一页</a>
        <a class="a-other" href="servlet/UserServlet?method=userList&page=${p.lastPage}&size=${p.size}">末页</a>
        跳到第
        <input type="text" value="" id="page" size="1">
        页
        <input type="button" value="GO" onclick="changePage(${p.size})"><%--传递参数/每页显示的记录数--%>
    </center>
</body>
</html>

