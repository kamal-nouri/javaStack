<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/10/2021
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <link rel="stylesheet" type="text/css" href="css/show.css">
</head>
<body>
<a class="left" href="/songs">All Songs</a>
<form action="/search" method="post">
    <input class="form" type="submit" value="Search Artists">
    <input class="form" type="search" name="artist" placeholder="Artist">
</form>
<a href="/songs/top">top Songs</a>
<div>
<h3>Title  :<c:out value="${song.title}"/></h3>
<h3>Artist  :<c:out value="${song.artist}"/></h3>
<h3>Rating(1 - 10)  :<c:out value="${song.rating}"/></h3>
<br><br>
<a href="/songs/${song.id}/delete">Delete</a>
</div>

</body>
</html>
