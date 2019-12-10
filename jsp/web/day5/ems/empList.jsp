<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\9 0009
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
    <h1>员工列表</h1>
    <a href="${pageContext.request.contextPath}/day5/ems/addEmp.jsp">添加员工</a>
    <hr>
    <table border="1">
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>工资</th>
            <th>性别</th>
            <th>学历</th>
            <th>爱好</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${emps}" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.name}</td>
                <td>${e.salary}</td>
                <td>${e.gender}</td>
                <td>${e.edu}</td>
                <td>${e.hobbies}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/day5/showModify.emp?id=${e.id}">修改</a>
                    <a href="${pageContext.request.contextPath}/day5/delete.emp?id=${e.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
