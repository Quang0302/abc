<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource
 	driver="com.mysql.jdbc.Driver"
 	url="jdbc:mysql://localhost/DESKTOP-IU5DU7J\SQLEXPRESS"	
 	user="root"
 	password="root"
/>

<sql:query var="items" sql="select * from Items"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach items="${items.row }" var="row">
<c:forEach items="${row }" var="col">
<tr>
<td>${col.key }</td><td>${col.value }</td>
</tr>
</c:forEach>
</c:forEach>
</table>
</body>
</html>