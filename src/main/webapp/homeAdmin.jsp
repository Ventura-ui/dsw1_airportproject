<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
	<%-- Se a sessão não tiver sido iniciada vai retornar a página de login com uma mensagem de erro  --%>
    <%
    HttpSession sessao = request.getSession(false);
    if (sessao == null || sessao.getAttribute("user") == null) {
        request.setAttribute("errorMessage", "Não é possível acessar a página de home admin sem estar logado.");
        request.getRequestDispatcher("login.jsp").forward(request, response);
        return;  
    }
    %>

    <div class="container mt-5">
        <div class="text-center mb-4">
            <h1 class="text-primary">Administração dos Voos</h1>
            <p class="text-muted">Bem-vindo(a) ao painel administrativo</p>
        </div>
        <hr>
        
        <nav class="nav flex-column text-center">
            <a href="cadastrarVoo.jsp" class="nav-link btn btn-outline-primary mb-2">Cadastrar Voo</a>
            <a href="admin.do?action=update" class="nav-link btn btn-outline-success mb-2">Atualizar Estado</a>
            <a href="admin.do?action=logout" class="nav-link btn btn-outline-danger">Logout</a>
        </nav>

        <hr>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
