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

<sql:query var="items" sql="select * from guestbook"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Message</th><th>Operation</th></tr>
<c:forEach items="${entries}" var="entry">
<tr>
<td>${entry.id} </td>
<td>${entry.name} </td>
<td><c:out value="${entry.message }" escapeXml = "true" /></td>
<td><a href="editcomment.jsp?id=${entry.id }">Edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>