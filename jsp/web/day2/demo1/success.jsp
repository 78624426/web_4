
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%="request域对象的传值:"+request.getAttribute("u")%>
    <hr>
    <%="session域对象的传值:"+session.getAttribute("u")%>

    <a href="<%=request.getContextPath()%>/day2/demo1/last.jsp">to last.jsp</a>
</body>
</html>
