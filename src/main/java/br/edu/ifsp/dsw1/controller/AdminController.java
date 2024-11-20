package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.comandosAdmin.CadastroCommand;
import br.edu.ifsp.dsw1.controller.command.comandosAdmin.LoginCommand;
import br.edu.ifsp.dsw1.controller.command.comandosAdmin.LogoutCommand;
import br.edu.ifsp.dsw1.controller.command.comandosAdmin.SendUpdateCommand;
import br.edu.ifsp.dsw1.controller.command.comandosAdmin.UpdateCommand;
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
	// implementando o padrão do front-controller
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
		
		if ("login".equals(action)) { 
			command = new LoginCommand(); // caso o link seja /admin.do?action=login o command receberá o LoginCommand
		} else if ("logout".equals(action)) {
			command = new LogoutCommand(); // caso o link seja /admin.do?action=logout o command receberá o LogoutCommand
		} else if ("cadastro".equals(action)) {
			command = new CadastroCommand(); // caso o link seja /admin.do?action=cadastro o command receberá o CadastroCommand
		} else if ("update".equals(action)) {
			command = new UpdateCommand(); // caso o link seja /admin.do?action=update o command receberá o UpdateCommand
		} else if ("sendUpdate".equals(action)) {
			command = new SendUpdateCommand(); // caso o link seja /admin.do?action=sendUpdate o command receberá o SendUpdateCommand
		} else {
			command = new ErrorCommand(); // caso não seja nenhum dos outros o command receberá o ErrorCommand
		}
		
		String view = command.execute(request, response); // irá executar o command
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response); 
	}
}
