package br.edu.ifsp.dsw1.controller.command.comandosAdmin;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command{
	// doGet do atualizar state
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDataCollection collection = FlightDataSingleton.getInstance(); // pega a lista de voos cadastrados
	    List<FlightData> flights = collection.getAllFligthts();
	    request.setAttribute("flights", flights); // determina um atributo flights que seria a lista de voos que vai ser usado no atualizarState.jsp
	    return "atualizarState.jsp"; // retorna pro atualizar state
	}
	

}
