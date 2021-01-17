<%--
  Created by IntelliJ IDEA.
  User: Gr0tto
  Date: 1/14/2021
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>Welcome</h1>
<main>
    <fieldset>
        <legend> Registration </legend>
    <div class="registration">
        <p><form:errors path="user.*"/></p>

        <form:form method="POST" action="/registration" modelAttribute="user">
            <p>
                <form:label path="firstName">First Name:</form:label>
                <form:input  path="firstName"/>
            </p>
            <p>
                <form:label path="lastName">Last Name:</form:label>
                <form:input  path="lastName"/>
            </p>
            <p>
                <form:label path="email">Email:</form:label>
                <form:input type="email" path="email"/>
            </p>
            <p>
                <form:label path="location">Location:</form:label>
                <form:input  path="location"/>

                <form:select path="state">
                    <form:option value="WB">WB</form:option>
                    <form:option value="CA">CA</form:option>
                    <form:option value="AD">AD</form:option>
                    <form:option value="BD">BD</form:option>
                </form:select>
            </p>

            <p>
                <form:label path="password">Password:</form:label>
                <form:password path="password"/>
            </p>
            <p>
                <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                <form:password path="passwordConfirmation"/>
            </p>
            <input type="submit" value="Register!"/>
        </form:form>

    </div>
    </fieldset>
    <fieldset>
    <legend> Login </legend>
    <div class="login">
        <p><c:out value="${loginError}" /></p>
        <form method="post" action="/login">
            <p>
                <label for="email">Email</label>
                <input type="text" id="email" name="email"/>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
            </p>
            <input type="submit" value="Login!"/>
        </form>
    </div>
    </fieldset>
</main>
</body>
</html>
