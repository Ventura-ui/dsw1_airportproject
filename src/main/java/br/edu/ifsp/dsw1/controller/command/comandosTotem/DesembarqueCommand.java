package br.edu.ifsp.dsw1.controller.command.comandosTotem;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DesembarqueCommand implements Command, FlightDataObserver{
	
	private boolean isRegistered = false;
	private boolean podeUnregister = false;
    private FlightDataCollection collection = FlightDataSingleton.getInstance(); // pega a lista de voos cadastrados
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isRegistered) { // verifica se este totem ja esta registrado como um observer
            collection.register(this); // registra como observer
            isRegistered = true;
        }
		
		List<FlightData> lista = collection.getAllFligthts().stream()
				.filter(f -> f.getState() instanceof Arriving)
				.collect(Collectors.toList());
		
		request.setAttribute("desembarcados", lista);
		
		if (podeUnregister && isRegistered) { //verifica se ja tiver registrado e puder ser unregister
            collection.unregister(this); // da um unregister desse totem como observer
            isRegistered = false;
            podeUnregister = false;
        }
		
		return "salaDeDesembarque.jsp"; // retorna pra pagina do totem
	}

	@Override
	public void update(FlightData flight) {
		if(flight.getState() instanceof Arriving) {
			System.out.println("Voo atualizado: " + flight.getFlightNumber() + " para o estado: " + flight.getState().getClass().getSimpleName()); // exibe uma mensagem no console dizendo que tal voo foi atualizado pra tal estado
			podeUnregister = true; // fala que ja pode dar unregister
		}
	}
	
}
