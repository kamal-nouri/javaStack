<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/10/2021
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New License</title>
</head>
<body>
<h1>New Product</h1>
<form:form action="/product" method="post" modelAttribute="product">
<%--    <p>--%>
<%--        <form:label path="dojo">Dojo: </form:label>--%>
<%--        <form:select  path="dojo">--%>
<%--            <c:forEach items="${dojos}" var="dojo">--%>
<%--                <form:option value="${dojo.id}">${dojo.name}</form:option>--%>
<%--            </c:forEach>--%>
<%--        </form:select>--%>
<%--    </p>--%>
    <p>
        <form:label path="name">Name: </form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="description">Description: </form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="price">Price: </form:label>
        <form:errors path="price"/>
        <form:input path="price"/>

    </p>
    <input type="submit" value="Create"/>
</form:form>
<a href="/">Back</a>
</body>
</html>