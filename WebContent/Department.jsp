<%@page import="com.ems.model.Department"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Page</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>Department ID</td>
				<td>Department Name</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var ="dep" items="${departments}">
				<tr>
					<td><c:out value="${dep.departmentId}" /></td>
					<td><c:out value="${dep.departmentName}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>