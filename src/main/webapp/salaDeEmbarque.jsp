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
</head>
<body>
	<h1>Sala de Embarque:</h1>
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
			List<FlightData> lista = (List<FlightData>) request.getAttribute("embarcados");
			if(lista != null && !lista.isEmpty()){
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
			<td colspan="4">Nenhum voo em embarque!</td>
			<%} %>
		</tbody>
	</table>
	
	<br>
	<hr>
	<br>
	<p><a href="index.jsp">Voltar</a></p>
</body>
</html>