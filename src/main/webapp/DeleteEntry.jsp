<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Entry</title>
<link rel="stylesheet" type="text/css" href="DeleteEntry.css"/>
<link rel="icon" href="images/vtulogo.png"/>
</head>
<body>
  <div class="delete-container">
    <h2>Delete Book Entry</h2>
    <form action="DeleteEntry" method="post">
      <div class="form-group">
        <label for="usn">Student USN</label>
        <input type="text" id="usn" name="usn" placeholder="Enter student USN" required>
      </div>
      <div class="form-output">
        <strong>Issued Book ID:   ${sessionScope.book_id}</strong> <br>
        <strong>Book Name:    ${sessionScope.book_name}</strong> 
      </div>
      <button type="submit" class="delete-btn">Submit</button>
    </form>
  </div>
</body>
</html>