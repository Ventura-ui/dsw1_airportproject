<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar estado</title>
</head>
<body>
	<h1>Atualizar estado de voo:</h1>
	<br>
	<hr>
	<br>
	
	<table border="1">
		<thead>
			<tr>
				<th>Número de voo</th>
				<th>Companhia</th>
				<th>Horário</th>
				<th>Estado</th>
				<th>Ação</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<FlightData> lista = (List<FlightData>) request.getAttribute("flights");
			if(lista != null){
				for(FlightData f : lista){	
			%>
			<tr>
				<td><%= f.getFlightNumber()%></td>
				<td><%= f.getCompany()%></td>
				<td><%= f.getTime()%></td>
				<td><%= f.getState().getClass().getSimpleName()%></td>
				<td>
					<form action="update.do" method="post">
						<input type="hidden" name="numeroDeVoo" value="<%= f.getFlightNumber()%>">
						<button type="submit">Atualizar estado</button>
					</form>
				</td>
			</tr>
			<%
				}
			}else{
			%>
			<td colspan="5">Nenhum voo disponível</td>
			<%} %>
		</tbody>
	</table>
	
	<br>
	<hr>
	<br>
	<p><a href="homeAdmin.jsp">Voltar</a></p>
</body>
</html>