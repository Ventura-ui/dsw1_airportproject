<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Admin</title>
</head>
<body>
	<%
    HttpSession sessao = request.getSession(false);
    if (sessao == null || sessao.getAttribute("user") == null) {
    	request.setAttribute("errorMessage", "Não é possível acessar a página de home admin sem estar logado.");
    	request.getRequestDispatcher("login.jsp").forward(request, response);
        return;  
    }
	%>

	<h1>Administração dos Voos</h1>
	<hr>
	<nav>
		<ul>
			<li><a href="cadastrarVoo.jsp">Cadastrar Voo</a></li>
			<li><a href="admin.do?action=update">Atualizar estado</a></li>
			<li><a href="admin.do?action=logout">Logout</a></li>
		</ul>
	</nav>
	<hr>
</body>
</html>