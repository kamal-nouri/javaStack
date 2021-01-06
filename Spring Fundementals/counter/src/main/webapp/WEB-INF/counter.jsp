<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/4/2021
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>counter Project</title>
</head>
<body>
<h1>You have visited <c:out value="${ count }"/> Times</h1>
<a href="/"> 

    Another visit?</a>
</body>
</html>
