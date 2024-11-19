package br.edu.ifsp.dsw1.controller.command.comandosTotem;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmbarqueCommand implements Command, FlightDataObserver{
	
	private boolean isRegistered = false;
	private boolean podeUnregister = false;
    private FlightDataCollection collection = FlightDataSingleton.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isRegistered) {
            collection.register(this);
            isRegistered = true;
        }

		List<FlightData> lista = collection.getAllFligthts().stream()
				.filter(f -> f.getState() instanceof Boarding)
				.collect(Collectors.toList());
		
		request.setAttribute("embarcados", lista);
		
		if (podeUnregister && isRegistered) {
            collection.unregister(this);
            isRegistered = false;
            podeUnregister = false;
        }

		return "salaDeEmbarque.jsp";
	}

	@Override
	public void update(FlightData flight) {
		if(flight.getState() instanceof Boarding) {
			System.out.println("Voo atualizado: " + flight.getFlightNumber() + " para o estado: " + flight.getState().getClass().getSimpleName());
			podeUnregister = true;	
		}
	}
}
