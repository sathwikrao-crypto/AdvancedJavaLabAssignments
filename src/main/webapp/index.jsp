<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Mark Entry</title>
    <script>
        function validateMarks() {
            let inputs = document.querySelectorAll('input[type="number"]');
            for (let input of inputs) {
                if (input.value < 0 || input.value > 100) {
                    alert("Marks must be between 0 and 100");
                    return false;
                }
            }
            return true;
        }
    </script>
</head>
<body>
    <h2>Student Mark Management System</h2>
    <form action="ResultServlet" method="POST" onsubmit="return validateMarks()">
        Roll No: <input type="text" name="rollNo" required><br><br>
        Name: <input type="text" name="sName" required><br><br>
        
        Sub 1: <input type="number" name="m1" required><br><br>
        Sub 2: <input type="number" name="m2" required><br><br>
        Sub 3: <input type="number" name="m3" required><br><br>
        Sub 4: <input type="number" name="m4" required><br><br>
        Sub 5: <input type="number" name="m5" required><br><br>
        
        <input type="submit" value="Calculate Result">
    </form>
</body>
</html>