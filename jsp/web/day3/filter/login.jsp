<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\5 0005
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%String path=request.getContextPath();%>
    <form action="<%=path%>/day3/filter/one">
        <input name="name" placeholder="用户名"><br>
        <input type="submit">
    </form>
</body>
</html>
