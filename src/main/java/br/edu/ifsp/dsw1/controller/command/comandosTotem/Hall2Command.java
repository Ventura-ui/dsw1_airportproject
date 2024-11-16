package br.edu.ifsp.dsw1.controller.command.comandosTotem;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Hall2Command implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FlightDataCollection collection = FlightDataSingleton.getInstance();
		
		List<FlightData> lista = collection.getAllFligthts().stream()
				.filter(f -> f.getState() instanceof TakingOff)
				.collect(Collectors.toList());
		
		request.setAttribute("lista_hall2", lista);
		
		return "hall2.jsp";
	}

	
	
}
