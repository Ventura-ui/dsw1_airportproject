package br.edu.ifsp.dsw1.controller.command.comandosAdmin;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CadastroCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDataCollection collection = FlightDataSingleton.getInstance();
		Long number = Long.parseLong(request.getParameter("number"));		
		String company = request.getParameter("company");
		String time = request.getParameter("time");
		
		boolean flightExists = collection.getAllFligthts().stream()
                .anyMatch(f -> f.getFlightNumber().equals(number));
		
		if (flightExists) {
            request.setAttribute("errorMessageCadastro", "Já existe um voo com este número.");
            return "cadastrarVoo.jsp"; 
        }
		
		FlightData flight = new FlightData(number, company, time);
		flight.setState(Arriving.getIntance());
		collection.insertFlight(flight);
		request.setAttribute("sucessCadastro", "Voo cadastrado com sucesso.");
		
		return "cadastrarVoo.jsp";
	}
}
