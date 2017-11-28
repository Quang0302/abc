package business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HourlyEmployee
 */
@WebServlet("/HourlyEmployee")
public class HourlyEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int employeeID;
	private String firstName;
	private String lastName;
	private double hourlyRate;
	
    public HourlyEmployee() {
        super();
    }
    
    public HourlyEmployee(int employeeID, String firstName, String lastName, double hourlyRate) {
    	this.employeeID = employeeID;
    	this.firstName =  firstName;
    	this.lastName = lastName;
    	this.hourlyRate = hourlyRate;
    }
    
    public int getEmployeeID() {
    return employeeID;
    }
    
    public void setEmployeeID(int employeeID) {
    	this.employeeID = employeeID;
    }

    public String getFirstName() {
    	return firstName;
    }
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName= lastName;
    }
    
    public double getHourlyRate() {
    	return hourlyRate;
    }
    
    public void setHourlyRate(double hourlyRate) {
    this.hourlyRate = hourlyRate;
    }
    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
