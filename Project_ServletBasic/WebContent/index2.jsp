<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>JSP Expression Language Demo - Input</h1>
<form name="employeeForm" action="EmployeeServlet" method="get">
<p>Please enter the following information<p>
<label>Employee ID:</label>
<input type="text" name="employeeID"/> <br/>
<label>First Name:</label>
<input type="text" name="firstName"/> <br/>
<label>Last Name:</label>
<input type="text" name="lastName"/> <br/>
<label>Hourly Rate:</label>
<input type="text" name="hourlyRate"/> <br/>
<label>Hours Worked:</label>
<input type="text" name="hoursWorked"/> <br/>
<input type="submit" name="submit" value="Go!">

</form>

</body>
</html>