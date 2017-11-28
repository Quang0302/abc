package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.HourlyEmployee;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employeeID = Integer.parseInt(request.getParameter("employeeID"));
		String firstName  = request.getParameter("firstName");
		String lastName  = request.getParameter("lastName");
		double hourlyRate = Double.parseDouble(request.getParameter("hourlyRate"));
		
		HourlyEmployee employee=new HourlyEmployee(employeeID,firstName,lastName,hourlyRate);
		Map<String,String> taxRates=new HashMap<String,String>();
		taxRates.put("Georgia", "6.00");
		taxRates.put("Vermont", "8.90");
		taxRates.put("Tennessee", "0.00");
		
		HttpSession session=request.getSession();
		session.setAttribute("employee", employee);
		session.setAttribute("taxRates", taxRates);
		String url="/ELDemo.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
