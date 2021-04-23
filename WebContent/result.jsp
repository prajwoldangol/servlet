<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;300;500;600;700;900&display=swap"
	rel="stylesheet">
<link href="style.css" rel="stylesheet" >
<title>Student List</title>
</head>
<body>

	<section class="results">
	<div class="tables">
	<header>
		<h1> List Of Registered Students </h1>
	</header>
		<table>
			<tr>
				<th>Student Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Middle Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Date OF Birth</th>
				<th>Address 1</th>
				<th>Address 2</th>
				<th>State</th>
				<th>City</th>
				<th>Zip / Postal code</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="std" items="${students}">
				<tr>
					<td><c:out value="${std.id}" /></td>
					<td><c:out value="${std.fname}" /></td>
					<td><c:out value="${std.lname}" /></td>
					<td><c:out value="${std.mname}" /></td>
					<td><c:out value="${std.phone}" /></td>
					<td><c:out value="${std.email}" /></td>
					<td><c:out value="${std.gender}" /></td>
					<td><c:out value="${std.dob}" /></td>
					<td><c:out value="${std.adddress1}" /></td>
					<td><c:out value="${std.address2}" /></td>
					<td><c:out value="${std.state}" /></td>
					<td><c:out value="${std.city}" /></td>
					<td><c:out value="${std.zip}" /></td>
					<td>
						<a href="<c:out value="${url}" />/edit?sid=<c:out value="${std.id}" />"> Edit </a>
						<a href="<c:out value="${url}" />/Delete?sid=<c:out value="${std.id}" />" onclick="return confirm('Are You Sure to delete it ?');"> Delete </a>
					</td>

				</tr>
				</c:forEach>
		</table>
		<div class="submitbtn">
		<a href="<c:out value="${url}" />/InsertData"> Register New Student</a>
		</div>
		</div>
	</section>

</body>
</html>
