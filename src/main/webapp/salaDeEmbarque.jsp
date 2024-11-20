<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="2">
    <title>Sala de Embarque</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h1 class="text-primary">Sala de Embarque</h1>
            <p class="text-muted">Lista de voos em embarque</p>
        </div>
        <hr>

        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead class="table-primary">
                    <tr>
                        <th>Número de Voo</th>
                        <th>Companhia</th>
                        <th>Horário</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <%-- Resgatando a lista de voos que foram cadastrados com o estado Boarding--%>
                <tbody>
                    <%
                    List<FlightData> lista = (List<FlightData>) request.getAttribute("embarcados");
                    if (lista != null && !lista.isEmpty()) {
                        for (FlightData f : lista) {
                    %>
                    <tr>
                        <td><%= f.getFlightNumber() %></td>
                        <td><%= f.getCompany() %></td>
                        <td><%= f.getTime() %></td>
                        <td><%= f.getState().getClass().getSimpleName() %></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="4" class="text-center">Nenhum voo em embarque!</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <hr>
        <div class="text-center mt-4">
            <a href="index.jsp" class="btn btn-link">Voltar</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
