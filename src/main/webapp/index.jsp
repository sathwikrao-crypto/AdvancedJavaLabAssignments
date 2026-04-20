<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<body>
    <h2>User Data Form</h2>
    <form action="processUser" method="POST">
        Username: <input type="text" name="username"><br>
        Email: <input type="email" name="email"><br>
        Designation: <input type="text" name="designation"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>