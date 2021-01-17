<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/11/2021
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Ninjas</th>
    </tr>
    <c:forEach items="${dojos}" var="dojo">
        <tr>
            <td><c:out value="${dojo.name}"/></td>
            <c:forEach items="${dojo.ninjas}" var="dojo1">
                <td><c:out value="${dojo1.firstName}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
