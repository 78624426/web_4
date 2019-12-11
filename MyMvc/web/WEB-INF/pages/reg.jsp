<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\11 0011
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function run() {
            return true;
        }
    </script>
</head>
<body>
    <h1>hello,I'm reg.jsp</h1>
    <form id="f" method="post" action="${pageContext.request.contextPath}/regHandle.do" onsubmit="return run();">
        <input name="username" placeholder="用户名"><br>
        <input type="password" placeholder="密码"><br>
        <input name="email" placeholder="邮箱"><br>
        <input type="submit" value="注册">
    </form>
    <span style="color: red;">${requestScope.msg}</span>

</body>
</html>
