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
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Welcome, <c:out value="${user.firstName}"/></h1>
<a href="/logout">Logout</a>
<h3>Here are some of the events in your state</h3>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Location</th>
        <th>Host</th>
        <th>Action/Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${eventwithstate}" var="event">
        <tr>
            <td><a href="/events/${event.id}">${event.name}</a></td>
            <td>${event.date}</td>
            <td>${event.location}</td>
            <td>${event.planner.firstName}</td>
            <c:choose>
                <c:when test="${event.planner.id==user.id}">
                    <td><a href="/events/${event.id}/edit">Edit</a><a href="/events/${event.id}/delete">Delete</a></td>
                </c:when>
                <c:when test="${event.joinedUsers.contains(user)}">
                    <td>Joining<a href="events/${event.id}/cancel">Cancel</a></td>
                </c:when>
                <c:when test="${not(event.joinedUsers.contains(user))}">
                    <td><a href="events/${event.id}/join">Join</a></td>
                </c:when>
            </c:choose>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3>Here are some of the events in other state</h3>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Location</th>
        <th>State</th>
        <th>Host</th>
        <th>Action/Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${eventwithoutstate}" var="event">
        <tr>
            <td><a href="/events/${event.id}">${event.name}</a></td>
            <td>${event.date}</td>
            <td>${event.location}</td>
            <td>${event.state}</td>
            <td>${event.planner.firstName}</td>
            <c:choose>
                <c:when test="${event.planner.id==user.id}">
                    <td><a href="/events/${event.id}/edit">Edit</a><a href="/events/${event.id}/delete">Delete</a></td>
                </c:when>
                <c:when test="${event.joinedUsers.contains(user)}">
                    <td>Joining<a href="events/${event.id}/cancel">Cancel</a></td>
                </c:when>
                <c:when test="${not(event.joinedUsers.contains(user))}">
                    <td><a href="events/${event.id}/join">Join</a></td>
                </c:when>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <p><form:errors path="event.*"/></p>

    <form:form method="POST" action="/events" modelAttribute="event">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date"/>
        </p>
        <p>
            <form:label path="location">Location:</form:label>
            <form:input path="location"/>

            <form:select path="state">
                <form:option value="WB">WB</form:option>
                <form:option value="CA">CA</form:option>
                <form:option value="AD">AD</form:option>
                <form:option value="BD">BD</form:option>
            </form:select>
        </p>
        <input type="submit" value="Create Event!"/>
    </form:form>
</div>
</body>
</html>