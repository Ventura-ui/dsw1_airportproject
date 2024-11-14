<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login de administrador</h1>
	<br>
	<hr>
	
	<form action="loginservlet.do" method="post">
		<label for="username">Username:</label>
		<input type="text" id="username" name="username" required><br><br>
		
		<label for="password">Senha:</label>
		<input type="password" id="password" name="password" required><br><br>
		
		<button type="submit">Enviar</button>
	</form>
	
	<br>
	<hr>
	
	<p><a href="index.jsp">Retornar ao menu</a></p>
</body>
</html>