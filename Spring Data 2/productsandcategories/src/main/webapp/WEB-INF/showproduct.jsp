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
    <title>Product Page</title>
</head>
<body>
<h1>${product.name}</h1>
<h3>Categories</h3>
<ul>
    <c:forEach items="${product.categories}" var="category">
        <li>${category.name}</li>
    </c:forEach>
</ul>
<h3>Add Category</h3>
<form action="/addcategory/${product.id}" method="post">
    <select name="category">
    <c:forEach items="${unlisted}" var="cat">
        <option value="${cat.id}">${cat.name}</option>
    </c:forEach>
    </select>
    <input type="submit" value="add"/>
</form>
<a href="/">Back</a>
</body>
</html>
