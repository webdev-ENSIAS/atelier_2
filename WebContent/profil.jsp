<%@page import="atelier_2.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>profil</title>
</head>
<body>
	<h3>profil</h3>
	<%
		User user = (User)session.getAttribute("user");
	%>
	<h4>hello Mr <%=user.getUsername() %></h4>
	
	
	<a href="Logout">deconnexion</a>
</body>
</html>