<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<body>
    <h2>Results</h2>
    <p style="color: green;"><%= request.getAttribute("message") %></p>
    
    <p><b>Username:</b> <%= request.getAttribute("username") %></p>
    <p><b>Email:</b> <%= request.getAttribute("email") %></p>
    <p><b>Designation:</b> <%= request.getAttribute("designation") %></p>
    
    <a href="index.jsp">Go Back</a>
</body>
</html>