<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		
		<thead>
			<tr>
				<td>fecha</td>
				<td>tarea</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="horario" items="${listado}" varStatus="status">
				
				<tr>
					<td>${horario.date_at}</td>
					<td>${horario.task_name}</td>	
				</tr>
				
			</c:forEach>
		</tbody>

	</table>
	
	
	<%-- <c:forEach var="dia" items="${getDays()}" varStatus="status">
				
				<p>dia</p>
				
	</c:forEach> --%>
	

</body>
</html>