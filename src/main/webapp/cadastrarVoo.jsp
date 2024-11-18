<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Voo</title>
</head>
<body>
	<%
    HttpSession sessao = request.getSession(false);
    if (sessao == null || sessao.getAttribute("user") == null) {
    	request.setAttribute("errorMessage", "Não é possível acessar a página de cadastrar voo sem estar logado.");
    	request.getRequestDispatcher("login.jsp").forward(request, response);
        return;  
    }
	%>

	<h1>Fazer cadastro de um novo voo:</h1>
	<br>
	<hr>
	<form action="admin.do?action=cadastro" method="post">
		<label for="number">Número de voo:</label>
		<input type="number" id="number" name="number" required><br><br>
		
		<label for="company">Companhia Aérea:</label>
		<input type="text" id="company" name="company" required><br><br>
		
		<label for="time">Horário:</label>
		<input type="text" id="time" name="time" required><br><br>
		
		<button type="submit">Enviar</button>
	</form>
	<br>
	<hr>
	<p><a href="homeAdmin.jsp">Voltar</a></p>
</body>
</html>