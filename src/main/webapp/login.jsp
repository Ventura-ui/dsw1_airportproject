<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h1 class="text-primary">Login de Administrador</h1>
            <p class="text-muted">Acesse o painel administrativo</p>
        </div>
        <hr>

        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <form action="admin.do?action=login" method="post" class="border rounded p-4 bg-white shadow-sm">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="Digite seu username" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Senha</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Digite sua senha" required>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </div>
                </form>
            </div>
        </div>

        <%
            String error = (String) request.getAttribute("errorMessage");
            if (error != null) {
        %>
        <div class="row justify-content-center mt-4">
            <div class="col-md-6 col-lg-4">
                <div class="alert alert-danger text-center">
                    <%= error %>
                </div>
            </div>
        </div>
        <% 
            request.removeAttribute("errorMessage");
            }
        %>

        <div class="text-center mt-4">
            <a href="index.jsp" class="btn btn-link">Retornar ao menu</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
