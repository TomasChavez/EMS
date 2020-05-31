<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="./header.html"></jsp:include>
	<table class="table table-hover table-striped table-hover ">
		<thead class="thead-dark" >
			<tr>
				<td>Employee ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Department</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${employees}">
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