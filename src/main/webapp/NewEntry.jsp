<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>New Entry</title>
<link rel="stylesheet" type="text/css" href="NewEntry.css"/>
<link rel="icon" href="images/vtulogo.png"/>
</head>
<body>
  <div class="entry-container">
    <h2>New Book Entry</h2>
    <form action="NewEntry" method="post">
      <div class="form-group">
        <label for="student-name">Student Name</label>
        <input type="text" id="student-name" name="student-name" required>
      </div>
      <div class="form-group">
        <label for="usn">Student USN</label>
        <input type="text" id="usn" name="usn" required>
      </div>
      <div class="form-group">
        <label for="book-id">Book ID</label>
        <input type="text" id="book-id" name="book-id" required>
      </div>
      <div class="form-group">
        <label for="book-name">Book Name</label>
        <input type="text" id="book-name" name="book-name" required>
      </div>
      <div class="form-group">
        <label for="issue-date">Issue Date</label>
        <input type="date" id="issue-date" name="issue-date" required>
      </div>
      <button type="submit" class="submit-btn">Submit</button>
    </form>
  </div>
</body>
</html>