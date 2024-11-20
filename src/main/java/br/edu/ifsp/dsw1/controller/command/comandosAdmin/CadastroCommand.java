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
	// doPost do cadastro
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDataCollection collection = FlightDataSingleton.getInstance(); // pega a lista de voos cadastrados
		Long number = Long.parseLong(request.getParameter("number")); // recupera o numero de voo do form		
		String company = request.getParameter("company"); // recupera o companhia do form	
		String time = request.getParameter("time"); // recupera o horario do voo do form	
		
		boolean flightExists = collection.getAllFligthts().stream()
                .anyMatch(f -> f.getFlightNumber().equals(number)); // verifica se tem algum voo com o mesmo numero
		
		if (flightExists) { // se tiver manda uma mensagem de erro pra página de cadastro
            request.setAttribute("errorMessageCadastro", "Já existe um voo com este número.");
            return "cadastrarVoo.jsp"; // retorna sem cadastrar
        }
		
		FlightData flight = new FlightData(number, company, time);
		flight.setState(Arriving.getIntance()); // arriving é o estado inicial de todo voo
		collection.insertFlight(flight);
		request.setAttribute("sucessCadastro", "Voo cadastrado com sucesso."); // mensagem de sucesso
		
		return "cadastrarVoo.jsp"; // retorna com o voo cadastrado
	}
}
