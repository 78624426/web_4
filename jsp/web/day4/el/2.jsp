<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\6 0006
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:if test="${a >=10}">
        <h1>已成年</h1>
    </c:if>

    <c:if test="${a <10}">
        <h1>未成年</h1>
    </c:if>

    <hr><br>

    <c:choose>
        <c:when test="${a<3}">
            <h1>幼儿</h1>
        </c:when>
        <c:when test="${a<6}">
            <h1>幼儿</h1>
        </c:when>
        <c:otherwise>
            <h1>少年</h1>
        </c:otherwise>
    </c:choose>

    <hr><br>


</body>
</html>
