<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hall 1</title>
</head>
<body>
	<body>
	<h1>Hall 1:</h1>
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
			</tr>
		</thead>
		<tbody>
			<%
			List<FlightData> lista = (List<FlightData>) request.getAttribute("lista_hall1");
			if(lista != null){
				for(FlightData f : lista){	
			%>
			<tr>
				<td><%= f.getFlightNumber()%></td>
				<td><%= f.getCompany()%></td>
				<td><%= f.getTime()%></td>
				<td><%= f.getState().getClass().getSimpleName()%></td>
			</tr>
			<%
				}
			}else{
			%>
			<td colspan="5">Nenhum voo no Hall 1!</td>
			<%} %>
		</tbody>
	</table>
	
	<br>
	<hr>
	<br>
	<p><a href="index.jsp">Voltar</a></p>
</body>
</html>