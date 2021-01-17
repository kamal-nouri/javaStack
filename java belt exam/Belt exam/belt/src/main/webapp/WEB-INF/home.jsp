<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
<h1>Welcome, <c:out value="${user.name}" /></h1>
<a class="but" href="/logout">Logout</a>
<h3>TV Shows</h3>
<div class="main">
<table>
    <thead>
    <tr>
        <th>Show</th>
        <th>Network</th>
        <th>Avg Rating</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach  items="${tvShows}" var="show">
        <tr>
            <td>
                <a href="/shows/${show.id}"><c:out value="${show.title}"/></a>
            </td>
            <td><c:out value="${show.network}"/></td>
            <td><c:out value="${show.averageRating}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="butt" href="/shows/new">Add a Show!</a>
</div>
</body>
</html>