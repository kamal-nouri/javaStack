<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/11/2021
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<h1>Questions Dashboard</h1>
<table>
    <tr>
        <th>Questions</th>
        <th>Tags</th>


    </tr>
    <c:forEach items="${questions}" var="question">
        <tr>
            <td> <a href="questions/${question.id}"><c:out value="${question.question}"/></a></td>
            <c:forEach items="${question.tags}" var="tag">
                <td><c:out value="${tag.subject}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
