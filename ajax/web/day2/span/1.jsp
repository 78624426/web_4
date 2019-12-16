<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\16 0016
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:'http://192.168.3.145/ajax/p',
                    type:"post",
                    dataType:"json",
                    success:function (data) {
                        $("#text").val(data.info);
                    }
                });
            });
        })
    </script>
</head>
<body>
    <textarea id="text" style="width:400px; height:100px;"></textarea><br>
    <input id="btn" type="button" value="跨域获取数据">

</body>
</html>
