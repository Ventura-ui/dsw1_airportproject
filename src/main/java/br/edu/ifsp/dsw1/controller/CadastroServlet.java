package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/novoVoo.do")
public class CadastroServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private FlightDataCollection collection;
	
	public CadastroServlet() {
		this.collection = new FlightDataCollection();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long number = Long.parseLong(request.getParameter("number"));
		String company = request.getParameter("company");
		String time = request.getParameter("time");
		
		FlightData flight = new FlightData(number, company, time);
		flight.setState(Arriving.getIntance());
		collection.insertFlight(flight);
		
		response.sendRedirect("homeAdmin.jsp");
	}
}
