<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\16 0016
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>
        function addFile() {
            var name=$("#userName").val();
            //提取文件标签中的二进数据，只有dom对象才能进行这种操作
            var files=$("input[type='file']")[0].files[0];
            var d=new FormData();
            d.append("user",name);
            d.append("f",files);
            $.ajax({
                url:"${pageContext.request.contextPath}/day2/upload/up.do",
                data:d,
                dataType:"json",
                type:'post',
                processData:false,
                contentType:false,
                success:function (data) {
                    console.log(data.info);
                }
            });
        }
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/day2/upload/up.do" >
        <input type="file" name="f"><br>
        <input name="user" id="userName"><br>
        <input type="submit" value="上传">
    </form>
    <button onclick="addFile();">ajax</button>
</body>
</html>
