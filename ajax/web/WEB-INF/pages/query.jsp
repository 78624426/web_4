<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\13 0013
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <style>
        #d{
            width:200px;
            height: 100px;
            background-color: pink;
            border: 1px solid blue;
            overflow: auto;
        }
    </style>
    <script>
        function getinfo() {
            $("#d").show();
            //方法三
            $("#d").load("${pageContext.request.contextPath}/getInfo.do");
        }
        function queryOne() {
            var key=$("#one").val();
            var d=$("#d");
            if(""==key){
                //d.hide();
                d.css("display","none");
                return;
            }
            $.getJSON("${pageContext.request.contextPath}/findOne2.do",
                {"key":key},
                function (data) {
                    if(data.msg==null){
                        d.hide();
                        return;
                    }
                    d.show();
                    d.html("<li>"+data.msg+"</li>");
                }
            )
        }

        function queryMore() {
            var key=$("#more").val();
            var d=$("#d");
            if(""==key){
                //d.hide();
                d.css("display","none");
                return;
            }
            d.html("");
            $.ajax({
                url:"${pageContext.request.contextPath}/findMore.do",
                data:{"key":key},
                dataType:"json",
                success:function (data) {
                    if(data.length==0){//m查到数据，隐藏div
                        d.hide();
                        return;
                    }
                    d.show();
                    for(var i=0;i<data.length;i++){
                        var c=d.html();
                        d.html(c+"<li>"+data[i].msg+"</li>");
                    }
                }
            });
        }
    </script>
</head>
<body>
    <button onclick="getinfo();">功能介绍</button><br>
    精确查询<input id="one" style="width:210px;" onkeyup="queryOne();"><br>
    模糊查询<input id="more" style="width:210px;" onkeyup="queryMore();"><br>
    <div id="d">

    </div>
</body>
</html>
