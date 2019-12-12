<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\11 0011
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>login.jsp</h1>
    <form action="${pageContext.request.contextPath}/loginHandle.do">
        <input name="username" placeholder="用户名"><br>
        <input type="password" name="password" placeholder="密码"><br>
        <input type="submit" value="登录">
    </form>
    <span style="color:red;">${msg}</span>
</body>
</html>
