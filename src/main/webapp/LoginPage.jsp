<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="LoginPage.css"/>
<link rel="icon" href="images/vtulogo.png"/>
</head>
<body>
 <div class="login-container">
    <h2>VTU Library</h2>
    <form action="LoginPage" method="post">
      <div class="input-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Enter your username" required>
        <br> </br>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>
      </div>
      <button type="submit" class="submit-btn">Login</button>
    </form>
  </div>
</body>
</html>