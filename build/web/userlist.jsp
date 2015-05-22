<%-- 
    Document   : user_list
    Created on : Feb 15, 2015, 2:09:11 PM
    Author     : Maharjan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Welcome</h1>
        <h3>${idExists}</h3>
        <table>
            <tr>
                <th>Id</th>
                <th>Profile Id</th>
                <th>User Name</th>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Birthday</th>
                <th>Location</th>
                <th>Fb Link</th>
                <th>Ip Address</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getUserId()}</td>
                    <td>${user.getUserName()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getMiddleName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getBirthday()}</td>
                    <td>${user.getLocation()}</td>
                    <td>${user.getFbLink()}</td>
                     <td>${user.getIpAddress()}</td>
                </tr>    
            </c:forEach>
        </table>
    </body>
</html>
