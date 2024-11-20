package br.edu.ifsp.dsw1.controller.command.comandosAdmin;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SendUpdateCommand implements Command{
	// doPost do atualizar state
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDataCollection collection = FlightDataSingleton.getInstance(); // pega a lista de voos cadastrados
		Long number = Long.parseLong(request.getParameter("numeroDeVoo")); // recupera o numero de voo através do hidden
		
		FlightData flight = collection.getAllFligthts().stream() // verifica se tem algum voo com esse numero
	            .filter(f -> f.getFlightNumber().equals(number))  
	            .findFirst()
	            .orElse(null);
		
		collection.updateFlight(flight.getFlightNumber()); // atuaiza o estado
		return "admin.do?action=update"; // retorna pro doGet do atualizar state
	}

}
