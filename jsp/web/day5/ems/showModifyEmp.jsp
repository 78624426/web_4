<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019\12\9 0009
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>
<h1>修改员工信息</h1>
<hr>
<form action="${pageContext.request.contextPath}/modify.emp" method="post">
    <input name="id" value="${emp.id}" readonly>
    <input name="name" value="${emp.name}"><br>
    <input name="salary" type="number" value="${emp.salary}"><br>
    <input name="gender" type="radio" value="男" <c:if test="${emp.gender=='男'}">checked</c:if> >男
    <input name="gender" type="radio" value="女" <c:if test="${emp.gender=='女'}">checked</c:if> >女<br>
    <select name="edu">
        <option value="未知">--请选择--</option>
        <option value="大专"  <c:if test="${emp.edu=='大专'}">selected </c:if>   >大专</option>
        <option value="本科"  <c:if test="${emp.edu=='本科'}">selected </c:if>   >本科</option>
    </select> <br>
    兴趣:<input type="checkbox" name="hobbies" value="运动" <c:if test="${f:contains(emp.hobbies_str,'运动')}">checked</c:if>   >运动
    <input type="checkbox" name="hobbies" value="旅游" <c:if test="${f:contains(emp.hobbies_str,'旅游')}">checked</c:if> >旅游
    <input type="checkbox" name="hobbies" value="电影" <c:if test="${f:contains(emp.hobbies_str,'电影')}">checked</c:if> >电影
    <br>
    <input type="submit" value="提交"><input type="reset" value="重置"><br>
</form>
</body>
</html>
