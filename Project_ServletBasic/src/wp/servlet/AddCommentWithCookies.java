package wp.servlet;
import wp.model.GuestBookEntry;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCommentWithCookies")
public class AddCommentWithCookies extends HttpServlet {
           	private static final long serialVersionUID = 1L;
	int idSeed=3;  
 
	public AddCommentWithCookies() {
   	super();
  	
	}

	private String getUsernameFromCookie(HttpServletRequest request){
	       	Cookie [] cookies =request.getCookies();
	       	if(cookies!=null)
	                       	for(Cookie cookie: cookies)
	                                       
	                                       	if(cookie.getName().equals("name"))
	                                                       	return cookie.getValue();

	       	return null;
	                                       	
	}
           	
           	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                           	
                           	PrintWriter out = response.getWriter();
                           	response.setContentType("text/html");
                           	
                           	out.println("<html><head><title>Add Comment</title><head><body>");
                           	out.println("<form action='AddCommentWithCookies' method='Post'>");
                           	
                           	String name= getUsernameFromCookie(request);
                           
                           	if(name!=null)
                                           	out.println("Name: "+name +"<br/>");

                           	else
                                           	out.println("Name: <input type=' text' name='name'/><br/>");
                           	
                           	out.println("Message:<textarea name='message' rows='5' cols='60'></textarea>");
                           	out.println("<input type='submit' name='add' value='Add'/>");
                           	
                           	out.println("</form>");
                           	out.println("</body></html>");
           	}
           	
           	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           	

                           	String name=getUsernameFromCookie(request);
                           	if(name==null)
                           	{
                                           	name=request.getParameter("name");
                                           	Cookie cookie=new Cookie("name",name);
                                           	response.addCookie(cookie);//dùng response để xét cookies

                           	String message = request.getParameter("message");
                           
                           	GuestBookEntry entry=new GuestBookEntry(name,message);
                          
                           	List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
                           	entries.add(entry);
 
                           	response.sendRedirect("GuestBook");
           	}
}}
