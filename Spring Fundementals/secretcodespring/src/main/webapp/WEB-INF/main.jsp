<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/5/2021
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>secret code</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div>

    <h4>What is the Code?</h4>
    <p><c:out value="${error}"/></p>
    <form method="post" action="/code">
        <input type="text" name="code">
        <input type="submit" value="Try Code">
    </form>
</div>

</body>
</html>
