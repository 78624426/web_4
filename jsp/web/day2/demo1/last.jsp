<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\4 0004
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%="request域对象的传值:"+request.getAttribute("u")%>
    <hr>
    <%="session域对象的传值:"+session.getAttribute("u")%>
</body>
</html>
