<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Page</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>Employee ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Department</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var ="emp" items="${employees}">
				<tr>
					<td><c:out value="${emp.employeeId}" /></td>
					<td><c:out value="${emp.firstName}" /></td>
					<td><c:out value="${emp.lastName}" /></td>
					<td><c:out value="${emp.departmentName}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>