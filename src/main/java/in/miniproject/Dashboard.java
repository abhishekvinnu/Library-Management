package in.miniproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/LoginPage") 
public class Dashboard extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		String myname = req.getParameter("username");
		String mypass = req.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","root");
			PreparedStatement ps = con.prepareStatement("select * from credentials where username=? and password=?");
			ps.setString(1, myname);
			ps.setString(2, mypass);
			
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				HttpSession session=req.getSession();
				session.setAttribute("session_name",rs.getString("name"));
				RequestDispatcher rd=req.getRequestDispatcher("/Dash.jsp");
				rd.include(req, resp);
			} else {
				out.print("<h3 style='color:red' >Login unsucessfull </h3>");
				RequestDispatcher rd=req.getRequestDispatcher("/LoginPage.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();

			out.print("<h3 style='color:red' >Login unsucessfull "+e.getMessage()+"</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/LoginPage.jsp");
			rd.include(req, resp);
		}
	}

}

