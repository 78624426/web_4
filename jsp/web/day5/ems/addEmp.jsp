<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\9 0009
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加员工信息</h1><hr>

<form action="${pageContext.request.contextPath}/add.emp" method="post">
    <input name="name" placeholder="员工姓名"><br>
    <input name="salary" type="number" placeholder="员工工资"><br>
    <input name="gender" type="radio" value="男">男
    <input name="gender" type="radio" value="女">女<br>
    <select name="edu">
        <option value="未知">--请选择--</option>
        <option value="大专">大专</option>
        <option value="本科">本科</option>
    </select> <br>
    兴趣:<input type="checkbox" name="hobbies" value="运动">运动
    <input type="checkbox" name="hobbies" value="旅游">旅游
    <input type="checkbox" name="hobbies" value="电影">电影
    <br>
    <input type="submit" value="提交"><input type="reset" value="重置"><br>
</form>
</body>
</html>
