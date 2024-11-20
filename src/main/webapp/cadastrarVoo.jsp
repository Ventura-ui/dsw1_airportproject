<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Voo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h1 class="text-primary">Cadastrar Novo Voo</h1>
            <p class="text-muted">Preencha as informações do voo</p>
        </div>
        <hr>

        <%
            HttpSession sessao = request.getSession(false);
            if (sessao == null || sessao.getAttribute("user") == null) {
                request.setAttribute("errorMessage", "Não é possível acessar a página de cadastrar voo sem estar logado.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;  
            }
        %>

        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <form action="admin.do?action=cadastro" method="post" class="border rounded p-4 bg-white shadow-sm">
                    <div class="mb-3">
                        <label for="number" class="form-label">Número de Voo</label>
                        <input type="number" id="number" name="number" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="company" class="form-label">Companhia Aérea</label>
                        <input type="text" id="company" name="company" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="time" class="form-label">Horário</label>
                        <input type="time" id="time" name="time" class="form-control" required>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">Cadastrar Voo</button>
                    </div>
                </form>
            </div>
        </div>

        <%
            String error = (String) request.getAttribute("errorMessageCadastro");
            String sucess = (String) request.getAttribute("sucessCadastro");
            if (error != null) {
        %>
            <div class="row justify-content-center mt-4">
                <div class="col-md-6 col-lg-4">
                    <div class="alert alert-danger text-center">
                        <h5><%= error %></h5>
                    </div>
                </div>
            </div>
        <% 
            request.removeAttribute("errorMessageCadastro");
            } else if (sucess != null) {
        %>
            <div class="row justify-content-center mt-4">
                <div class="col-md-6 col-lg-4">
                    <div class="alert alert-success text-center">
                        <h5><%= sucess %></h5>
                    </div>
                </div>
            </div>
        <% 
            request.removeAttribute("sucessCadastro");
            }
        %>

        <div class="text-center mt-4">
            <a href="homeAdmin.jsp" class="btn btn-link">Voltar</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
