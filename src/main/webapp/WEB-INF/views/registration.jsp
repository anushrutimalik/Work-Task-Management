<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div id="main">
        <form id = "loginForm">
            <input type="text" id="fullname" name="fullname" placeholder="Enter your Name" required>
            <input type="email" id="email" name="email" placeholder="Enter your Email" required>
            <input type="date" id="dob" name="dob" placeholder="Date of Birth: " required>
            <input type="password" id="password" name="password" placeholder="Enter your Password" required>
            <button type="submit">Login</button>
        </form>
    </div>
    <script src = "js/script.js"></script>
</body>
</html>