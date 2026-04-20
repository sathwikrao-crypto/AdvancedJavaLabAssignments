<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie Manager - Add</title>
</head>
<body>
    <h2>Add a New Cookie</h2>
    <form action="manageCookies.jsp" method="POST">
        <label>Cookie Name:</label><br>
        <input type="text" name="cookieName" required><br><br>
        
        <label>Domain:</label><br>
        <input type="text" name="cookieDomain" placeholder="e.g. localhost" required><br><br>
        
        <label>Max Expiry Age (seconds):</label><br>
        <input type="number" name="cookieAge" required><br><br>
        
        <button type="submit" name="action" value="add">Add Cookie</button>
    </form>
    <br>
    <a href="manageCookies.jsp">Go to the active cookie list</a>
</body>
</html>