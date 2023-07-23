<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
</head>
<body>
	<h1>Clientes</h1>
	<table border="1">
		
		<thead>
			<tr>
				<td>ID</td>
				<td>USER</td>
				<td>PASS</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cliente" items="${clientes}" varStatus="status">
				
				<tr>
					<td>${cliente.id_cliente}</td>
					<td>${cliente.username}</td>
					<td>${cliente.pass}</td>
	
				</tr>
	
			</c:forEach>
		</tbody>

	</table>
</body>
</html>