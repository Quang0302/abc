package wp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestInfo() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		// response.getWriter().print("Hello World!");
		
		out.println("<html><head><title>Request Info</title></head><body>");
		out.println("<p>Method: "+request.getMethod()+"</p");
		out.println("<p>ContextPath: "+request.getContextPath()+"</p");
		out.println("<p>URL: "+request.getRequestURL()+"</p");
		out.println("<p>URI: "+request.getRequestURI()+"</p");
		out.println("<p>RemoteAddr: "+request.getRemoteAddr()+"</p");
		if(request.getHeader("Accept-Encoding").indexOf("gzip")>=0)
			out.println("<p>Gzip support</p>");
		else
			out.println("<p>Gzip not support</p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
