<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\16 0016
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/day2/upload/up" method="post" enctype="multipart/form-data">
        <input type="file" name="f"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
