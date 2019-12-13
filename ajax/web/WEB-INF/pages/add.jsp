<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\12 0012
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>
        $(function () {
            $("#key").blur(function () {
                //查询key的值在数据库中是否重复
                //方法一
                /*$.get(
                    "${pageContext.request.contextPath}/checkKey.do",
                    {"key":$("#key").val()},
                    function (data) {
                        $("#err").html(data);
                        if(data.indexOf("key 已存在")!=-1){
                            //key已存在，不能提交
                            $("#sb").prop("disabled",true);
                        }else{
                            $("#sb").prop("disabled",false);
                        }
                    }
                );*/
                $.post(
                    "${pageContext.request.contextPath}/checkKeyJson.do",
                    {"key":$("#key").val()},
                    function (data) {
                        $("#err").html(data.info);
                        if(data.info.indexOf("key 已存在")!=-1){
                            //key已存在，不能提交
                            $("#sb").prop("disabled",true);
                        }else{
                            $("#sb").prop("disabled",false);
                        }
                    },
                    "json"
                );
            });
        });
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/addInfo.do">
        <input name="key" id="key" placeholder="关键字"><br>
        <input name="msg" id="msg"><br>
        <input type="submit" id="sb" value="添加" disabled>
    </form>
    <span id="err"></span>
</body>
</html>
