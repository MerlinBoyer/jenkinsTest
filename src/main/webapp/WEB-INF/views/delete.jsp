<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	
	<h2>Delete etudiant</h2>
	
	<form:form action="delete" method="POST" modelAttribute="etudiant" class="input-group" >
		ID: 	<form:input path="id"/>	<br/>
		<form:button>Delete</form:button>
	</form:form>
	
</body>
</html>