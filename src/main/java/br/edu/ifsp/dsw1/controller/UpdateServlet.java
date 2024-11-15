package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private FlightDataCollection collection;
	
	public UpdateServlet() {
		this.collection = new FlightDataCollection();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FlightData> flights = collection.getAllFligthts();
		request.setAttribute("flights", flights);
		request.getRequestDispatcher("atualizarState.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long number = Long.parseLong(request.getParameter("numeroDeVoo"));
		collection.updateFlight(number);
		response.sendRedirect("update.do");
	}
}
