<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Expression Language Demo - Output</h1>
	<hr/>
	<h2>Using the Employee Bean</h2>
	EmployeeID: ${employee.employeeID} <br/>
	Employee Name:${sessionScope.employee.firstName} ${sessionScope.employee.lastName} <br/>
	Hourly Rate: ${employee["hourlyRate"]}<br/>
	<hr/>
	<h2>Using the Map</h2>
	Table of Tax Rates:
	<table border = 1>
	<tr>
	<td>
	Georgia
	</td>
	<td>${taxRates.Georgia}</td>
	</tr>
	<tr>
	<td>
	Vermont
	</td>
	<td>${taxRates.Vermont}</td>
	</tr><tr>
	<td>
	Tennessee
	</td>
	<td>${taxRates.Tennessee}</td>
	</tr>
	</table>
	<hr/>
	<h2>Using the EL operations</h2>
	<h3>A temperature calculation:</h3>
	<p>3C=${(9.0/5.0)*3.0+32.0} F</p>
	<h3>An expression language if-statment:</h3>
	10 is an ${10 mod 2 == 0 ? "even" : "odd" } number
	<hr/>
	<h3>Check to see if the hoursWorked field is empty:</h3>
	${empty param.hoursWorked}
	<h3>Check combined with EL if statement:</h3>
	${empty param.hoursWorked ? "Please enter hours worked.":"Thanks for  entering hours worked." }
	<h3>Using param and math opearation:</h3>
	Employee Compensation: ${employee.hourlyRate * param.hoursWorked }
	<h3>Using header to get host information:</h3>
	${header["host"] }
	<hr/>
</body>
</html>