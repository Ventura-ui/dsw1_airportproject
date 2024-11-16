package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
		
		if ("hall1".equals(action)) {
			handleHall1(request, response);
		} else if ("hall2".equals(action)) {
			handleHall2(request, response);
		} else if ("desembarque".equals(action)) {
			handleDesembarque(request, response);
		} else if ("embarque".equals(action)) {
			handleEmbarque(request, response);
		}
	}
	
	private void handleHall1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDataCollection collection = FlightDataSingleton.getInstance();
		
		List<FlightData> lista = collection.getAllFligthts().stream()
				.filter(f -> f.getState() instanceof TakingOff)
				.collect(Collectors.toList());
		
		request.setAttribute("lista_hall1", lista);
		request.getRequestDispatcher("hall1.jsp").forward(request, response);
	}
	
	private void handleHall2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDataCollection collection = FlightDataSingleton.getInstance();
		
		List<FlightData> lista = collection.getAllFligthts().stream()
				.filter(f -> f.getState() instanceof TakingOff)
				.collect(Collectors.toList());
		
		request.setAttribute("lista_hall2", lista);
		request.getRequestDispatcher("hall2.jsp").forward(request, response);
	}
	
	private void handleDesembarque(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDataCollection collection = FlightDataSingleton.getInstance();
		
		List<FlightData> lista = collection.getAllFligthts().stream()
				.filter(f -> f.getState() instanceof Arriving)
				.collect(Collectors.toList());
		
		request.setAttribute("desembarcados", lista);
		request.getRequestDispatcher("salaDeDesembarque.jsp").forward(request, response);
	}
	
	private void handleEmbarque(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDataCollection collection = FlightDataSingleton.getInstance();
		
		List<FlightData> lista = collection.getAllFligthts().stream()
				.filter(f -> f.getState() instanceof Boarding)
				.collect(Collectors.toList());
		
		request.setAttribute("embarcados", lista);
		request.getRequestDispatcher("salaDeEmbarque.jsp").forward(request, response);
	}
}
