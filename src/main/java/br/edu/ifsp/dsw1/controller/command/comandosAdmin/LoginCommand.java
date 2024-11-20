package br.edu.ifsp.dsw1.controller.command.comandosAdmin;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCommand implements Command{
	// doPost do login
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); // recupera o username do form
		String password = request.getParameter("password"); // recupera o password do form
		
		if(username.equals("admin") && password.equals("admin")) { // vertifica se o userr e a senha são iguais a "admin"
			HttpSession sessao = request.getSession(); // inicia a sessão
			
			sessao.setAttribute("user", "admin");
			return "homeAdmin.jsp";
		}else {
			request.setAttribute("errorMessage", "Dados de login incorretos."); // retorna uma mensagem de erro pro login
			return "login.jsp?error=true";
		}
	}
}
