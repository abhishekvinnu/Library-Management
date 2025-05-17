<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Dashboard</title>
  <link rel="stylesheet"  href="Dash.css"/>
  <link rel="icon" href="images/vtulogo.png"/>
</head>
<body>
  <div class="header">
    <div class="welcome">Welcome, ${session_name}</div>
    <div class="logout"><a href="LogoutServlet" style="text-decoration: none; color: white;">Logout</a></div>
  </div>

  <div class="main-container">
    <form action="DashboardServlet" method="post">
      <div class="button-container">
        <button class="btn" name="action" value="new">New Entry</button>
        <button class="btn" name="action" value="delete">Delete Entry</button>
        <button class="btn" name="action" value="view">View Entry</button>
      </div>
    </form>
  </div>
</body>
</html>
