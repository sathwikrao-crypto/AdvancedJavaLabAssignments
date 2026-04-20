<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Session Setup</title>
</head>
<body>
    <h2>Session Management Setup</h2>
    <form action="sessionHandler.jsp" method="POST">
        <label>Enter Your Name:</label><br>
        <input type="text" name="userName" required><br><br>
        
        <label>Session Expiry Time (in seconds):</label><br>
        <input type="number" name="expiryTime" required><br><br>
        
        <button type="submit">Start Session</button>
    </form>
</body>
</html>