package wp.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import wp.model.GuestBookEntry;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wp.model.GuestBookEntry;

@WebServlet("/AddCommentWithSession")
public class AddCommentWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddCommentWithSession() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<form action='AddCommentWithSession' method='Post'>");
		//if we already have name in a cookie, then just display the name
		String name = (String) request.getSession().getAttribute("name");
		if(name!=null) 
			out.println("Name: " + name +"<br/>");
		else 
			out.println("Name: <input type='text' name='name' /> <br/>" );
		out.println("Message: <textarea name='message' rows='5' cols='60'></textarea>");
		out.println("<input type='submit' name='add' value='add'/>");
		out.println("</form>");
		out.println("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//first try to get name from cookie
		String name = (String) request.getSession().getAttribute("name");
		
		if(name==null) {
		//get the user input
			name = request.getParameter("name");
			request.getSession().setAttribute("name", name);
		}
		
		String message = request.getParameter("message");
		
		//create a guestbook entry
		GuestBookEntry entry = new GuestBookEntry(name,message);
		//add the new entry to the guestbook
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		entries.add(entry);
		//send user back to guestbook
		response.sendRedirect("GuestBook");
	}
}
