<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\5 0005
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%String path=request.getContextPath();%>
    <script src="<%=path%>/day3/login/jquery.js"></script>
    <script src="<%=path%>/day3/login/jquery.cookie.js"></script>
    <script>
        $(function () {
            var name=$.cookie("name");
            var pass=$.cookie("pass");
            if(name&&pass){
                $("input[name=name]").val(name);
                $("input[name=pass]").val(pass);
                $("form").submit();
            }
        });
    </script>

</head>
<body>
    <form action="<%=path%>/day3/login/login">
        <input name="name"><br>
        <input name="pass"><br>
        <input type="submit">
        <input type="checkbox" name="rm">七天免登录<br>
        <span style="color: red;"><%String msg=(String)request.getAttribute("msg");%>
            <%=msg==null? "":msg%></span>
    </form>
</body>
</html>
