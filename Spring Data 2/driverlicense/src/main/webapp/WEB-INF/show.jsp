<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/10/2021
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Person</title>
</head>
<body>
<h1><c:out value="${person.firstName}"/>   <c:out value="${person.lastName}"/></h1>
<h4><c:out value="${license.state}"/></h4>


</body>
</html>
