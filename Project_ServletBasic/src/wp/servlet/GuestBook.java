package wp.servlet;
import wp.model.GuestBookEntry;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/GuestBook", loadOnStartup=1)
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GuestBook() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("john","hello"));
		entries.add(new GuestBookEntry("jeo","nice site"));
		getServletContext().setAttribute("entries", entries);

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		// response.getWriter().print("Hello World!");
		
		out.println("<html><head><title>GuestBook</title></head><body>");
		out.println("<h2>GuestBook</h2>");
		out.println("<table border='1'>");
		out.println("<tr><th>Name</th><th>Message</th></tr>");
		for(GuestBookEntry entry : entries)
			out.println("<tr><td>"+entry.getName()+"says: </td><td>"+entry.getMessage()+"</td></tr>");
		out.println("</table");
		out.println("<p><a href='AddComment'>Leave a comment<a></p>");
		out.println("<p><a href='AddCommentWithCookies'>Leave a comment (with cookie) <a></p>");
		out.println("<p><a href='AddCommentWithSession'>Leave a comment (with session) <a></p>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
