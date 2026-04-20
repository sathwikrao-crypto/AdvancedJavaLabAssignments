<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Result</title>
    <style>
        .pass { color: green; font-weight: bold; }
        .fail { color: red; font-weight: bold; }
    </style>
</head>
<body>
    <h2>Examination Result</h2>
    <table border="1" cellpadding="10">
        <tr><td>Roll No:</td><td><%= request.getAttribute("rollNo") %></td></tr>
        <tr><td>Student Name:</td><td><%= request.getAttribute("sName") %></td></tr>
        <tr>
            <td>Marks Obtained:</td>
            <td>
                <% 
                    int[] marks = (int[]) request.getAttribute("marks");
                    for(int m : marks) { out.print(m + " "); }
                %>
            </td>
        </tr>
        <tr><td>Average Marks:</td><td><%= request.getAttribute("avg") %></td></tr>
        <tr>
            <td>Final Status:</td>
            <td class="<%= request.getAttribute("status").toString().toLowerCase() %>">
                <%= request.getAttribute("status") %>
            </td>
        </tr>
    </table>
    <br>
    <a href="index.jsp">Back to Data Entry (Client Side)</a>
</body>
</html>