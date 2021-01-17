<%--
  Created by IntelliJ IDEA.
  User: Gr0tto
  Date: 1/14/2021
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        .comments{
            width: 400px;
            height: 110px;
            overflow: auto;
            border: 1px solid gray;
        }
    </style>
    <meta charset="UTF-8">
    <title>${event.name}</title>
</head>
<body>
<h1>${event.name}</h1>
<p>Host: ${event.planner.firstName} ${event.planner.lastName}</p>
<p>Date: ${event.date}</p>
<p>Location: ${event.location}, ${event.state}</p>
<p>People Who are attending this event are: ${eventnumber}</p>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Location</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${event.joinedUsers}" var="user">
        <tr>
            <td>${user.firstName} ${user.lastName}</td>
            <td>${user.location}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="comments"><c:forEach items="${event.messages}" var="message">
    <span>${message.user.firstName} says: ${message.comment}</span><br>
    <hr>
</c:forEach></div>
<div>
    <p><form:errors path="message.*"/></p>

    <form:form method="POST" action="/events/${event.id}" modelAttribute="message">
        <p>
            <form:label path="comment">Add Comment:</form:label>
            <form:textarea path="comment"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
    <a href="/events">Back</a>
</div>
</body>
</html>