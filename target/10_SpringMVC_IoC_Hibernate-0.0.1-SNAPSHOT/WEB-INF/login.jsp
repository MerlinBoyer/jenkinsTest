<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>

	<h1>Login page</h1>
	
	<form:form action="login" method="POST" modelAttribute="log">
		Username: 	<form:input path="mail"/>	<br/>
		Password: 	<form:input path="mdp"/>	<br/>
		<form:button>Submit</form:button>
	</form:form>

</body>
</html>