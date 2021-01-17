<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/17/2021
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

        #main {
            margin-left: 300px;
            margin-top: 150px;
            padding: 10px;

        }
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

<h1>Edit show!</h1>
<form action="/shows/${tvShow.id}/update" method="POST">
    <label for="title">Title: </label>
    <input type="text" name="title" value="${tvShow.title}" id="title" required><br><br>
    <label for="network">Network: </label>
    <input type="text" name="network" value="${tvShow.network}" id="network" required><br><br>
    <input style="margin-top: 10px" type="submit" value="Update"/>
</form>

<br>
<form action="/shows/${tvShow.id}/delete" method="POST">
    <input class="but" type="submit" value="Delete"/>
</form>

</body>
</html>
