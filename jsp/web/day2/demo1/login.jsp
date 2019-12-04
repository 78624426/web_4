<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\4 0004
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/day2/demo1/login" method="post">
        <input name="user" placeholder="用户名"><br>
        <input type="submit">
    </form>
</body>
</html>
