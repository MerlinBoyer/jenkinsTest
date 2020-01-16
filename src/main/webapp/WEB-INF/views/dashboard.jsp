<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dashboard</title>
<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css"/>"/>
</head>
<body>

	<h2>Dashboard</h2>
	
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Date</th>
		</tr>
		
		<c:forEach var="e" items="${etudiants}">
			<tr>
				<th>${e.id}</th>
				<th>${e.nom}</th>
				<th>${e.prenom}</th>
				<th>${e.dn}</th>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>