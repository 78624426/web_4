<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\6 0006
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=request.getAttribute("xmq")%><br>
    ${applicationScope.xmq}<br>
    ${user.name}----${user.pass}
    <hr><br>
    数组：${arr[0]}
    <hr><br>
    list:${list[1]}
    <hr><br>
    map:${map.a1}或${map["a2"]}
</body>
</html>
