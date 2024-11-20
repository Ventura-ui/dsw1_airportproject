<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Estado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h1 class="text-primary">Atualizar Estado de Voo</h1>
            <p class="text-muted">Escolha um voo para atualizar o estado</p>
        </div>
        <hr>
		<%-- Se a sessão não tiver sido iniciada vai retornar a página de login com uma mensagem de erro  --%>
        <%
            HttpSession sessao = request.getSession(false);
            if (sessao == null || sessao.getAttribute("user") == null) {
                request.setAttribute("errorMessage", "Não é possível acessar a página de atualizar estado sem estar logado.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;  
            }
        %>
		<%-- Tabelaa de voos cadastrados--%>
        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead class="table-primary">
                    <tr>
                        <th>Número de Voo</th>
                        <th>Companhia</th>
                        <th>Horário</th>
                        <th>Estado</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <%-- Resgatando a lista de voos que foram cadastrados--%>
                <tbody>
                    <%
                        List<FlightData> lista = (List<FlightData>) request.getAttribute("flights");
                        if (lista != null && !lista.isEmpty()) { // se a lista não for nulla nem vazia será mostrada a tabela
                            for (FlightData f : lista) {
                    %>
                    <tr>
                        <td><%= f.getFlightNumber() %></td>
                        <td><%= f.getCompany() %></td>
                        <td><%= f.getTime() %></td>
                        <td><%= f.getState().getClass().getSimpleName() %></td>
                        <td>
                            <form action="admin.do?action=sendUpdate" method="post">
                                <input type="hidden" name="numeroDeVoo" value="<%= f.getFlightNumber() %>">
                                <button type="submit" class="btn btn-success btn-sm">Atualizar Estado</button>
                            </form>
                        </td>
                    </tr>
                    <%
                            }
                        } else { // linha mostrada se a lista for nula
                    %>
                    <tr>
                        <td colspan="5" class="text-center">Nenhum voo disponível</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <hr>
        <div class="text-center mt-4">
            <a href="homeAdmin.jsp" class="btn btn-link">Voltar</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>