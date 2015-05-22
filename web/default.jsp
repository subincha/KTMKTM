<%-- 
    Document   : default
    Created on : Feb 17, 2015, 11:36:47 AM
    Author     : Maharjan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="http://127.0.0.1:8080/api/userlocation" method="POST">
            User Id: <input type="text" name="profileId"></br>
            First Name: <input type="text" name="userName"> </br>
             First Name: <input type="text" name="latitude"> </br>
              First Name: <input type="text" name="longitude"> </br>
               First Name: <input type="text" name="nameOfPlace"> </br>
               
            <input type="submit">
        </form>
    </body>
</html>
