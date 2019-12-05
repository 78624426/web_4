<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\5 0005
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%String path=request.getContextPath();%>
    <style>
        div,img{
            width:100px;
            text-align: center;
            display: inline-block;
        }
        .history{
            width:40px;
            height: 40px;
        }
    </style>
</head>
<body>
    <div>
        <img src="<%=path%>/day3/history/img/1.jpg"><br>
        <a href="<%=path%>/day3/history/servlet?id=1">手电筒</a>
    </div>
    <div>
        <img src="<%=path%>/day3/history/img/2.jpg"><br>
        <a href="<%=path%>/day3/history/servlet?id=2">手机</a>
    </div>
    <div>
        <img src="<%=path%>/day3/history/img/3.jpg"><br>
        <a href="<%=path%>/day3/history/servlet?id=3">显示器</a>
    </div>
    <div>
        <img src="<%=path%>/day3/history/img/4.jpg"><br>
        <a href="<%=path%>/day3/history/servlet?id=4">冰箱</a>
    </div>
    <div>
        <img src="<%=path%>/day3/history/img/5.jpg"><br>
        <a href="<%=path%>/day3/history/servlet?id=5">手表</a>
    </div>
    <div>
        <img src="<%=path%>/day3/history/img/6.jpg"><br>
        <a href="<%=path%>/day3/history/servlet?id=6">电脑</a>
    </div>
    <h2><a href="<%=path%>/day3/history/revove">清除记录</a></h2>
    <span style="color: red;"><%=session.getAttribute("msg")%></span>
    <hr>
    <h2>浏览历史</h2>
    <%
        Cookie[]arr=request.getCookies();
        Cookie c=null;
        if(arr!=null){
            for(Cookie t:arr){
                if(t.getName().equals("product")){
                    c=t;
                    break;
                }
            }
        }
        if(c!=null){
            //"1,3,4"
            String v=c.getValue();
            String[]ids=v.split(",");
            for(String id:ids){
    %>
            <img class="history" src="<%=path%>/day3/history/img/<%=id%>.jpg">
    <%
            }
        }
    %>
</body>
</html>
