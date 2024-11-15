<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sala de Embarque</title>
</head>
<body>
	<h1>Sala de Embarque:</h1>
	
	<%
	List<FlightData> lista = (List<FlightData>) request.getAttribute("embarcados");
	if(lista != null || lista.isEmpty()){
	%>
	
    <ul>
        <%    
        for (FlightData f : lista) {
        %>
            <li><%= f.getFlightNumber() %> - <%= f.getCompany() %> - <%= f.getTime() %></li>
        <% 
        }
        %>   	
    </ul>
    <%}else{ %>
    <h2>Não existem voos em embarque!</h2>
    <%} %>
</body>
</html>