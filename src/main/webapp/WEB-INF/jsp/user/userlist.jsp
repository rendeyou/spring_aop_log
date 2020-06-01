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
    <%--分页查询代码域--%>
    <script type="text/javascript">
        /*最终访问路径*/
        function change(page, size) {
            var id = document.getElementById("id").value;
            var username = document.getElementById("username").value;
            location.href = "userList?page=" + page + "&size=" + size + "&id=" + id + "&username=" + username;
        }

        /*每页几条记录*/
        function changeSize(size) {
            // alert(size);
            change(1, size);
        }

        /*跳到第几页*/
        function changePage(size) {
            // alert(size);
            var page = document.getElementById("page").value;
            change(page, size);
        }
    </script>
    <%--根据用户IDS,批量删除代码域--%>
    <script type="text/javascript">
        // 加载页面
        $(function () {
            // ckAll复选框绑定单击事件
            $("#ckAll").click(function () {
                // 设置ckAll复选框状态
                var flag = this.checked;
                // 设置ck复选框状态，和ckAll复选框状态一致
                $("input[name=ck]").each(function (i, e) {
                    e.checked = flag;
                })
            });
            // 删除按钮绑定单击事件
            $("#btn-del").click(function () {
                // 准备一个空数组，存放id
                var arr = [];
                // 如果ck复选框状态为ckecked，就追加到数组
                $("input[name=ck]").each(function (i, e) {
                    if (e.checked) {
                        arr.push($(e).val());
                    }
                });
                // 数组转换成字符串
                var ids = arr.join(",");
                if (ids.length == 0) {
                    alert("请先选中再删除！");
                }
                if (confirm("再次确认删除ID为[" + ids + "]的用户吗？")) {
                    // 发送超链接请求，根据用户ID，批量删除用户
                    location.href = "delByIds?ids=" + ids;
                }
            })
        })
    </script>
    <style type="text/css">
        /*表格样式*/
        table {
            margin: 0 auto;
            width: 50%;
            border-collapse: collapse;
            text-align: center;
        }

        td {
            border: 1px solid grey;
        }

        /*导航条样式*/
        a {
            text-decoration: none;
        }

        a:hover {
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
<%--创建表单，条件查询--%>
<center>
<form action="userList" method="post" align="center">
    <input type="hidden" name="page" vaule="${p.page}">
    <input type="hidden" name="size" value="${p.size}">
    用户编号：<input type="text" name="id" value="${id}" id="id">
    用户名：<input type="text" name="username" value="${username}" id="username">
    <input type="submit" value="查询">
    <input type="button" value="重置" onclick="$(':input:text').val('')">
    <input type="button" value="批量删除选中用户" id="btn-del">
</form>
</center>
<hr>
<%--创建表格，显示数据--%>
<table>
    <tr>
        <td><input type="checkbox" name="ckAll" id="ckAll">全选</td>
        <td>用户ID</td>
        <td>用户名</td>
        <td>生日</td>
        <td>注册日期</td>
    </tr>
    <c:forEach items="${p.list}" var="user">
        <tr>
            <td><input type="checkbox" name="ck" value="${user.id}"></td>
            <td>${user.id}</td>
            <td>
                <a href="findById?id=${user.id}">${user.username}</a>
            </td>
            <td>
                <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>
            </td>
            <td>
                <fmt:formatDate value="${user.registTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="15">
            共${p.totalCount}条记录，
            每页
            <select onchange="changeSize(this.value)"><%--传递参数：每页记录数--%>
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
<br>
<%--创建导航条--%>
<center>
    <a class="a-other" href="javascript:change(${p.firstPage},size=${p.size})">首页</a>
    <a class="a-other" href="javascript:change(${p.prevPage},size=${p.size})" onclick="return ${p.hasPrev}">上一页</a>
    <c:forEach begin="${p.navStart}" end="${p.navEnd}" step="1" var="n">
        <c:if test="${n==p.page}">
            [<a href="javascript:change(${n},size=${p.size})">${n}</a>]
        </c:if>
        <c:if test="${n!=p.page}">
            <a href="javascript:change(${n},size=${p.size})">${n}</a>
        </c:if>
    </c:forEach>
    <a class="a-other" href="javascript:change(${p.nextPage},size=${p.size})" onclick="return ${p.hasNext}">下一页</a>
    <a class="a-other" href="javascript:change(${p.lastPage},size=${p.size})">末页</a>
    跳到第
    <input type="text" value="" id="page" size="1">
    页
    <input type="button" value="GO" onclick="changePage(${p.size})"><%--传递参数：跳到第几页--%>
</center>
</body>
</html>

