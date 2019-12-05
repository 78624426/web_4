<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\4 0004
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=response.encodeURL(request.getContextPath()+"/day2/demo2/url")%>">
        <input name="name"><br>
        <input type="submit">

    </form>
</body>
</html>
