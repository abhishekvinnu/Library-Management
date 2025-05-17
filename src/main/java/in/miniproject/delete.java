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
@WebServlet("/DeleteEntry")
public class delete extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		String mystudusn = req.getParameter("usn");	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/server","root","root");
			PreparedStatement pss = con.prepareStatement("select bookid,bookname from entries where studusn=?");
			pss.setString(1, mystudusn);
			ResultSet rs=pss.executeQuery();
			if(rs.next())
			{
				HttpSession session=req.getSession();
				session.setAttribute("book_id", rs.getString("bookid"));
                session.setAttribute("book_name", rs.getString("bookname"));
			}
			PreparedStatement ps = con.prepareStatement("delete from entries where studusn=?");
			ps.setString(1, mystudusn);
			int count=ps.executeUpdate();
			if (count>0) {
				out.print(
						  "<div style=\"position:fixed; top:0; left:0; width:100%; text-align:center; padding:10px; background:rgba(255,255,255,0.8);\">"
						+   "<h3 style=\"color:red; margin:0;\">Delete Successful</h3>"
						+ "</div>"
						);

				RequestDispatcher rd=req.getRequestDispatcher("/DeleteEntry.jsp");
				rd.include(req, resp);
			} else {
				out.print(
						  "<div style=\"position:fixed; top:2px; left:0; width:100%; text-align:center; padding:10px; background:rgba(255,255,255,0.8);\">"
						+   "<h3 style=\"color:red; margin:0;\">Delete Unsuccessful</h3>"
						+ "</div>"
						);
				RequestDispatcher rd=req.getRequestDispatcher("/DeleteEntry.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("<div style='text-align:center;'><h3 style='color:red;'>Error occurred: "+e.getMessage()+"</h3></div>");
			RequestDispatcher rd=req.getRequestDispatcher("/Dash.jsp");
			rd.include(req, resp);
		}
	}

}
