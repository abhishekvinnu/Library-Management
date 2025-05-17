package in.miniproject;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/DashboardServlet")
public class NewEntry extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if ("new".equals(action)) {           
            response.sendRedirect(request.getContextPath() + "/NewEntry.jsp");
        }
        else if ("delete".equals(action)) {
            response.sendRedirect(request.getContextPath() + "/DeleteEntry.jsp");
        }
        else if ("view".equals(action)) {            
            response.sendRedirect(request.getContextPath() + "/AllEntries.jsp");
        }
        else {         
            response.sendRedirect(request.getContextPath() + "/Dash.jsp");
        }
	}

    
}
