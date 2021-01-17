<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/9/2021
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show Language</title>
</head>
<body>
<h1><c:out value="${language.name}"/></h1>
<p>creator: <c:out value="${language.creator}"/></p>
<p>currentVersion: <c:out value="${language.currentVersion}"/></p>
<a href="/languages/edit/${language.id}">Edit Book</a>
<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>
