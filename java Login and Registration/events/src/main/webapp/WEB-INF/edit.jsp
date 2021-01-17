<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Abood
  Date: 1/16/2021
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<fieldset>
    <legend>Edit  ${event.name}</legend>
<div>
    <p><form:errors path="event.*"/></p>

    <form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name" />
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
        <input type="submit" value="Edit Event!"/>
    </form:form>
        <a href="/events">Back</a>
</div>
</fieldset>
</body>
</html>