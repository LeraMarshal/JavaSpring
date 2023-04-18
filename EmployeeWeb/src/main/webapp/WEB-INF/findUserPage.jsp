<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users Search</title>

    <link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>

</head>
<body>

<div class="container">

    <c:choose>
        <c:when test="${userToFind != null}">
            <h2>User</h2>
            <table class="table table-hover">
                <tbody>
                <tr>
                    <th>Username</th><th>Role</th><th>Id</th><th>Email</th>
                </tr>
                <tr>
                    <td>${userToFind.username}</td>
                    <td>${userToFind.role}</td>
                    <td>${userToFind.id}</td>
                    <td>${userToFind.email}</td>
                </tr>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>${notPresentMessage}</p>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
