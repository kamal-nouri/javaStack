<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/10/2021
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Lookify</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="cen">
<form action="/search" method="post">
    <input class="form" type="submit" value="Search Artists">
    <input class="form" type="search" name="artist" placeholder="Artist">
</form>
<a href="/songs/new">Add New Song</a>
<a href="/songs/top">top Songs</a>
</div>
<div class="main">
<table>
    <tr>
        <th>Names</th>
        <th>Rating</th>
        <th>actions</th>
    </tr>
    <c:forEach items="${songs}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/songs/${song.id}/delete">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
