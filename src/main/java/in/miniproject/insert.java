package in.miniproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/NewEntry")
public class insert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String mystudname = req.getParameter("student-name");
		String mystudusn = req.getParameter("usn");
		String mybookid= req.getParameter("book-id");
		String mybookname = req.getParameter("book-name");
		String myissuedate = req.getParameter("issue-date");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","root");
			PreparedStatement ps = con.prepareStatement("insert into entries values(?,?,?,?,?)");
			ps.setString(1, mystudname);
			ps.setString(2, mystudusn);
			ps.setString(3, mybookid);
			ps.setString(4, mybookname);
			ps.setString(5, myissuedate);
			int count=ps.executeUpdate();
			if (count>0) {
				resp.setContentType("text/html");
				out.print("<div style='text-align:center;'><h3 style='color:green;'>Entry Successful</h3></div>");
				RequestDispatcher rd=req.getRequestDispatcher("/Dash.jsp");
				rd.include(req, resp);
			} else {
				resp.setContentType("text/html");
				out.print("<div style='text-align:center;'><h3 style='color:red;'>Entry Unsuccessful</h3></div>");
				RequestDispatcher rd=req.getRequestDispatcher("/NewEntry.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<div style='text-align:center;'><h3 style='color:red;'>Error occurred"+e.getMessage()+"</h3></div>");
			RequestDispatcher rd=req.getRequestDispatcher("/NewEntry.jsp");
			rd.include(req, resp);
		}
	}

}
