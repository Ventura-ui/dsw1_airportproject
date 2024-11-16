package br.edu.ifsp.dsw1.controller.command.comandosTotem;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DesembarqueCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FlightDataCollection collection = FlightDataSingleton.getInstance();
		
		List<FlightData> lista = collection.getAllFligthts().stream()
				.filter(f -> f.getState() instanceof Arriving)
				.collect(Collectors.toList());
		
		request.setAttribute("desembarcados", lista);
		
		return "salaDeDesembarque.jsp";
	}
	
}
