<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\12 0012
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>
        $(function () {
            $("#key").blur(function () {
                //查询key的值在数据库中是否重复
                //方法一
                $.get(
                    "${pageContext.request.contextPath}/checkKey.do",
                    {"key":$("#key").val()},
                    function (data) {
                        $("#err").html(data);
                        if(data.indexOf("key 已存在")!=-1){
                            //key已存在，不能提交
                            $("#sb").attr("disabled",true);
                        }else{
                            $("#sb").attr("disabled",false);
                        }
                    }
                );
            });
        });
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/addInfo.do">
        <input name="key" id="key" placeholder="关键字"><br>
        <input name="msg" id="msg"><br>
        <input type="submit" id="sb" value="添加" disabled="false">
    </form>
    <span id="err">${success}</span>
</body>
</html>
