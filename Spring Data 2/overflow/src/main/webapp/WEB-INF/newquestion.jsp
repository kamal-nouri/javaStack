<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/10/2021
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Question</title>
</head>
<body>
<h1>New Question</h1>
<form:form action="/addquestions" method="post" modelAttribute="questions">
    <p>
        <form:label path="question">Question</form:label>
        <form:errors path="question"/>
        <form:textarea path="question"/>
    </p>
<form:form action="/addquestions" method="post" modelAttribute="tag">
    <p>
        <form:label path="subject">Tags</form:label>
        <form:errors path="subject"/>
        <form:input path="subject"/>
    </p>

    <input type="submit" value="Submit"/>
</form:form>
</form:form>

</body>
</html>