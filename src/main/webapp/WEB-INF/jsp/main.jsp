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

<frameset rows="15%,*,10%" border="1px">
    <frame src="commons/header" noresize="yes" scrolling="no">
    <frameset cols="15%,*">
        <frame src="commons/left">
        <frame src="commons/center" name="center">
    </frameset>
    <frame src="commons/footer" noresize="yes">
</frameset>

</html>
