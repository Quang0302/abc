package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
            	private static final long serialVersionUID = 1L;
  
	public Login() {
    	super();
    	// TODO Auto-generated constructor stub
	}
 
            	
            	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                            	PrintWriter out = response.getWriter();
                            	response.setContentType("text/html");
                            	out.println("<html><head><title>Login</title></head><body>");
                            	out.println("<form action='Login' method='Post'>");
                            	out.println("Username : <input type='text' name='username' /> <br/><br/>");
                            	out.println("Password : <input type='text' name='password'></input><br/><br/>");
                            	out.println("<input type='submit' name='add' value='add'>");
                            	out.println("</form>");
                            	out.println("</body></html>");
            	}
 
            	
            	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                            	
                            	String username = request.getParameter("username");
                            	String password = request.getParameter("password");
                            	
                            	if(username.equals("quang") && password.equals("123"))
                            	{
                                            	request.getSession().setAttribute("user",username);
                                            	response.sendRedirect("Members");
                            	}
                            	else
                            	{
                                            	response.sendRedirect("Login");
                            	}
 
            	}
}
