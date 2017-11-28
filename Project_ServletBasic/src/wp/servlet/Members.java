package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Members")
public class Members extends HttpServlet {
            	private static final long serialVersionUID = 1L;
   	
  
	public Members() {
    	super();
    	// TODO Auto-generated constructor stub
	}
 
            	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String user = (String) request.getSession().getAttribute("user"); 
                            	
                            	
                            	if(user!=null)
                            	{
                                            	PrintWriter out = response.getWriter();
                                            	response.setContentType("text/html");
                                            	out.println("<html><head><title>Members</title></head><body>");
                                            	out.println("<h2>This is members-only area!</h2>");
                                            	out.println("<p>Welcome  "+user+"</p>");
                                            	out.println("<a href='Logout'> Logout </a>");
                                            	out.println("</body></html>");
                            	}
                            	else
                            	{
                                            	response.sendRedirect("Login");
                            	}
            	}
 
            	
            	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            	}
}
