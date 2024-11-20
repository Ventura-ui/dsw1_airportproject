package br.edu.ifsp.dsw1.controller.command.comandosAdmin;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutCommand implements Command{
	// doGet do logout
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false); // pega a sessao 
		
		if (sessao == null || sessao.getAttribute("user") == null) { // se a sessao for nula retorna pra pagina de login com uma mensagem de erro
	        request.setAttribute("errorMessage", "Não é possível acessar a página de logout sem estar logado.");
	    }
		
		if(sessao != null) {
			sessao.invalidate(); // invalida a sessao 
		}
		
		return "login.jsp"; // retorna pra pagina de login
	}

}
