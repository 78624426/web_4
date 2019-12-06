<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\6 0006
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--遍历数组--%>
    <c:forEach items="${arr}" var ="t">
        ${t}<br>
    </c:forEach>

<%--集合遍历--%>
    <c:forEach items="${users}" var ="t">
        用户名：${t.name}<br>
        密码:${t.pass}<br>
    </c:forEach>

<%--map遍历--%>
    <c:forEach items="${map}" var="e">
        ${e.key}---${e.value.name}
    </c:forEach>


</body>
</html>
