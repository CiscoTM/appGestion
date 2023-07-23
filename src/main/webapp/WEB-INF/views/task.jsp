<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		
		<thead>
			<tr>
				<td>USER</td>
				<td>PASS</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tasks" items="${tasks}" varStatus="status">
				
				<tr>
					<td>${tasks.task_name}</td>
					<td>${tasks.section_id}</td>
	
				</tr>
	
			</c:forEach>
		</tbody>

	</table>

</body>
</html>