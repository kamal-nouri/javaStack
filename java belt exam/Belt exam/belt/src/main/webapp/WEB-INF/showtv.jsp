<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/17/2021
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/show.css">
    <style>
        div.main{
            margin-left: 300px;
            margin-top: 150px;

        }
        table ,td , th{
            border: 1px solid black;
            width: 700px;
            text-align: center;
        }
        .butt{
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
<h1><c:out value="${tvShow.title}"/></h1>
<h3><c:out value="${tvShow.network}"/></h3><hr>
<div class="main">
<h1>Users who rated this show</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Rating</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tvShow.ratings}" var="rating">
        <tr>
            <td><c:out value="${rating.user.name}"/></td>
            <td><c:out value="${rating.rate}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table><br>
<a class="butt"  href="/shows/${tvShow.id}/edit">Edit!</a><br>
<h3>Leave a rating!</h3>
<form action="/shows/${tvShow.id}/rate" method="POST">
    <input  type="number" name="rate" value="1.0">
    <input type="submit" value="Rate!">
</form>
    </div>
</body>
</html>
