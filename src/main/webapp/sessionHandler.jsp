<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Session Status</title>
</head>
<body>
    <%
        String name = request.getParameter("userName");
        String expiryStr = request.getParameter("expiryTime");

        if (name != null) {
            // Store name in session
            session.setAttribute("user", name);
            
            // Set session timeout (setMaxInactiveInterval takes seconds)
            int expiry = Integer.parseInt(expiryStr);
            session.setMaxInactiveInterval(expiry);
        }

        // Check if session is still valid
        String currentUser = (String) session.getAttribute("user");

        if (currentUser != null) {
    %>
            <h2>Hello, <%= currentUser %>!</h2>
            <p style="color: green;">Your session is currently <b>Active</b>.</p>
            <p>Session Timeout set to: <b><%= session.getMaxInactiveInterval() %> seconds</b>.</p>
            <hr>
            <p>Try refreshing this page or clicking the link below before the time runs out.</p>
            <a href="sessionHandler.jsp">Check session status again</a>
    <%
        } else {
    %>
            <h2 style="color: red;">Session Expired!</h2>
            <p>The session has timed out or was never created.</p>
            <a href="index.jsp">Back to Login</a>
    <%
        }
    %>
</body>
</html>