package wp.servlet;
import wp.model.GuestBookEntry;
import wp.model.GuestBookEntry1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


@WebServlet(urlPatterns="/GuestBook1", loadOnStartup=1)
public class GuestBook1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GuestBook1() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			throw new ServletException(e);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		List<GuestBookEntry1> entries = (List<GuestBookEntry1>)getServletContext().getAttribute("entries");
		java.sql.Connection c=null;
		try {
			String url = "jdbc:mysql://localhost/DESKTOP-IU5DU7J\\SQLEXPRESS";
			String username="root";
			String password="root";
			c=DriverManager.getConnection(url,username,password);
			java.sql.Statement stmt=c.createStatement();
			ResultSet rs= stmt.executeQuery("select * from guestbook");
			while(rs.next())
			{
				GuestBookEntry1 entry = new GuestBookEntry1(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("message") );
						
				entries.add(entry);
			}
		}
		catch(SQLException e) {
			throw new ServletException(e);
		}
		finally {
			try {
				if(c!=null) c.close();
			}
			catch(SQLException e) {
				throw new ServletException (e);
			}
		}
		request.setAttribute("entries",entries);
		request.getRequestDispatcher("/WEB-INF/GuestBook1.jsp").forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
