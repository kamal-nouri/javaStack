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
<h2>
    Tags :
<c:forEach items="${question.tags}" var="tag">
     <c:out value="${tag.subject}"/>
</c:forEach>
</h2>
<table>
    <tr>
        <th>Answers</th>
    </tr>
    <c:forEach items="${question.answers}" var="answer">
        <tr>
            <td> <c:out value="${answer.answer}"/></td>
        </tr>
    </c:forEach>
</table>
<h1>New Question</h1>
<form:form action="/questions/${question.id}" method="post" modelAttribute="answers">
    <p>
    <form:label path="answer">Answer</form:label>
    <form:errors path="answer"/>
    <form:textarea path="answer"/>
    </p>
        <input type="submit" value="Submit"/>
    </form:form>

</body>
</html>
