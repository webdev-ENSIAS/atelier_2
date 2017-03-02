<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body>

	<%if(request.getAttribute("errorMsg")!=null){ %>
		<h3><%=request.getAttribute("errorMsg") %></h3>
	<%} %>
	<h1>Inscription User</h1>
	<form action="Inscrption" method="post">
		<label>nom : </label> <input type="text" name="nom"><br>
		<label>email: </label> <input type="email" name="email"><br>
		<label>password : </label> <input type="password" name="password"><br>
		<input type="submit" value="sign up" name="signup">
	</form>
</body>
</html>