package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.entity.FlightDataSingleton;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin.do")
public class AdminController extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if ("login".equals(action)) {
			handleLogin(request, response);
		} else if ("logout".equals(action)) {
			handleLogout(request, response);
		} else if ("cadastro".equals(action)) {
			handleCadastro(request, response);
		} else if ("update".equals(action)) {
			handleUpdate(request, response);
		} else if ("sendUpdate".equals(action)) {
			handleSendUpdate(request, response);
		}
	}
	
	private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("admin") && password.equals("admin")) {
			HttpSession sessao = request.getSession();
			
			sessao.setAttribute("user", "admin");
			response.sendRedirect("homeAdmin.jsp");
		}else {
			response.sendRedirect("login.jsp?error=true");
		}
	}
	
	private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		
		if(sessao != null) {
			sessao.invalidate();
		}
		
		response.sendRedirect("login.jsp");
	}
	
	private void handleCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long number = Long.parseLong(request.getParameter("number"));
		String company = request.getParameter("company");
		String time = request.getParameter("time");
		
		FlightData flight = new FlightData(number, company, time);
		flight.setState(Arriving.getIntance());
		
		FlightDataCollection collection = FlightDataSingleton.getInstance();
		collection.insertFlight(flight);
		
		response.sendRedirect("homeAdmin.jsp");
	}
	
	private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDataCollection collection = FlightDataSingleton.getInstance();
	    List<FlightData> flights = collection.getAllFligthts();
	    request.setAttribute("flights", flights);
	    request.getRequestDispatcher("atualizarState.jsp").forward(request, response);
	}
	
	private void handleSendUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDataCollection collection = FlightDataSingleton.getInstance();
		Long number = Long.parseLong(request.getParameter("numeroDeVoo"));
		collection.updateFlight(number);
		response.sendRedirect("admin.do?action=update");
	}
	
}
