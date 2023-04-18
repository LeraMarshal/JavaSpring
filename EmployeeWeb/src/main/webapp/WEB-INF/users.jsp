<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users Info</title>

    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>

</head>
<body>

<spring:url value="/users/delete" var="delUrl"/>


<div class="container">

    <h2>Users</h2>
    <table class="table table-hover">
        <tbody>
        <tr>
            <th>UserName</th><th>Role</th><th>Id</th><th>Email</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.role}</td>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>
                    <form:form action="${delUrl}" method="POST">
                        <input type="hidden" value="${user.id}" name="userId">
                        <input type="submit" value="delete"/>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>Add new User:</h2>

    <spring:url value="/users" var="formUrl"/>
    <form:form action="${formUrl}" method="POST" modelAttribute="userToAdd">

        <div class="row">

            <div class="form-group">
                <label for="userToAdd-username">UserName</label>
                <form:input path="username" cssClass="form-control" id="userToAdd-username"/>
            </div>

            <div class="form-group">
                <label for="userToAdd-role">Role</label>
                <form:input path="role" cssClass="form-control" id="userToAdd-role"/>
            </div>

            <div class="form-group">
                <label for="userToAdd-password">Password</label>
                <form:input type="password" path="password" cssClass="form-control" id="userToAdd-password"/>
            </div>

            <div class="form-group">
                <label for="userToAdd-id">ID</label>
                <form:input path="id" cssClass="form-control" id="userToAdd-id"/>
            </div>

            <div class="form-group">
                <label for="userToAdd-email">Email</label>
                <form:input path="email" cssClass="form-control" id="userToAdd-email"/>
            </div>

            <button type="submit" class="btn btn-default">Submit</button>

        </div>

    </form:form>

    <c:if test="${deleted != null}">
        <div>
            <p>User with id=${deleted} successfully deleted</p>
        </div>
    </c:if>
    <c:if test="${added != null}">
        <div>
            <p>User with id=${added} successfully added</p>
        </div>
    </c:if>

</div>
</body>
</html>
