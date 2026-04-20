<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Active Cookie List</title>
</head>
<body>
    <%
        // 1. Process the "Add Cookie" logic
        String name = request.getParameter("cookieName");
        String domain = request.getParameter("cookieDomain");
        String ageStr = request.getParameter("cookieAge");

        if (name != null && !name.isEmpty()) {
            // Create the cookie with a default value
            Cookie newCookie = new Cookie(name, "Value_" + name); 
            
            try {
                int age = Integer.parseInt(ageStr);
                newCookie.setMaxAge(age);
                
                // Only set domain if it's not empty to avoid browser rejection
                if (domain != null && !domain.trim().isEmpty()) {
                    newCookie.setDomain(domain);
                }
                
                newCookie.setPath("/"); 
                response.addCookie(newCookie);
                
                out.print("<p style='color:green;'><b>Successfully added cookie: " + name + "</b></p>");
            } catch (Exception e) {
                out.print("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            }
        } // End of if block
    %>

    <hr>
    <h3>Active Cookie List</h3>
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Cookie Name</th>
                <th>Value</th>
            </tr>
        </thead>
        <tbody>
            <%
                Cookie[] cookies = request.getCookies();
                if (cookies != null && cookies.length > 0) {
                    for (Cookie c : cookies) {
            %>
                        <tr>
                            <td><%= c.getName() %></td>
                            <td><%= c.getValue() %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="2">No active cookies found.</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <br>
    <a href="index.jsp">Add Another Cookie</a>
</body>
</html>