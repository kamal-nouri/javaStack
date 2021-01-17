<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/17/2021
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
    <style>


        .but{
            text-decoration: none;
            border: 1px solid black;
            background-color: #8080808a;
            border-radius: 3px;
            margin-top: 28px;
            margin-right: 10px;

        }
    </style>
</head>
<body>

<h1>Create a new show!</h1>
<p><form:errors path="show.*"/></p>
<form:form action="/addshow" method="POST" modelAttribute="tvShow">
    <p>
        <form:label path="title">Title:</form:label>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="network">Network:</form:label>
        <form:input path="network"/>
    </p>

<input class="but" type="submit" value="Create!"/>
</form:form>

</body>
</html>
