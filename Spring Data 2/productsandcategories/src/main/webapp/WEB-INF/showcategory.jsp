<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/10/2021
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category Page</title>
</head>
<body>
<h1>${category.name}</h1>
<h3>Products</h3>
<ul>
    <c:forEach items="${category.products}" var="pro">
        <li>${pro.name}</li>
    </c:forEach>
</ul>
<h3>Add Category</h3>
<form action="/addproduct/${category.id}" method="post">
    <select name="product">
        <c:forEach items="${unlisted}" var="pro">
            <option value="${pro.id}">${pro.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="add"/>
</form>
<a href="/">Back</a>
</body>
</html>
