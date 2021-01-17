<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/10/2021
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Store app</title>
</head>
<body>
<h1>Welcome to our Store App</h1>
<a href="/products/new">Add Product</a>
<a href="/categories/new">Add Category</a>
<%--<table>--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>Dojo ID</th>--%>
<%--        <th>Dojo Name</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach items="${dojos}" var="dojo">--%>
<%--        <tr>--%>
<%--        <td>${dojo.id}</td>--%>
<%--        <td><a href="/dojos/${dojo.id}">${dojo.name}</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
</table>
</body>
</html>
