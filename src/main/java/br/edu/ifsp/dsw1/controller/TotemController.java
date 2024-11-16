package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.comandosTotem.DesembarqueCommand;
import br.edu.ifsp.dsw1.controller.command.comandosTotem.EmbarqueCommand;
import br.edu.ifsp.dsw1.controller.command.comandosTotem.Hall1Command;
import br.edu.ifsp.dsw1.controller.command.comandosTotem.Hall2Command;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/totem.do")
public class TotemController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Command command;
		
		if ("hall1".equals(action)) {
			command = new Hall1Command();
		} else if ("hall2".equals(action)) {
			command = new Hall2Command();
		} else if ("desembarque".equals(action)) {
			command = new DesembarqueCommand();
		} else if ("embarque".equals(action)) {
			command = new EmbarqueCommand();
		} else {
			command = new ErrorCommand();
		}
		
		String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
