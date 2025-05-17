<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Entries</title>
<link rel="stylesheet" type="text/css" href="AllEntry.css">
<link rel="icon" href="images/vtulogo.png"/>
</head>
<body>
	<%
	try {

		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/server", "root", "root");
		PreparedStatement stmt = con.prepareStatement("select * from entries order by issuedate asc");
		ResultSet rs = stmt.executeQuery();
		if (rs.next() == false) {
			out.println("No Records in the table");
		} else {
	%>

	<table border="1">
		<tr>
			<th>Student Name</th>
			<th>Student USN</th>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Issue Date</th>
		</tr>
		<%
		do {
		%>

		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
		</tr>

		<%
		} while (rs.next());
		}

		} catch (Exception e) {
		System.out.println(e.getMessage());
		e.getStackTrace();
		}
		%>
	</table>
</body>
</html>
