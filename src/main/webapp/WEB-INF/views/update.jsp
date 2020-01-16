<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="add" method="POST" modelAttribute="etudiant" class="input-group" >
		Nom: 	<form:input path="nom"/>	<br/>
		Prenom: <form:input path="prenom"/>	<br/>
		Date: 	<form:input path="dn" type="date"/>	<br/>
		<form:button>Submit</form:button>
	</form:form>
	
</body>
</html>