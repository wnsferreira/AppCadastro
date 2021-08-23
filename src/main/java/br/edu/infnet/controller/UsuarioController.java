package br.edu.infnet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;	

import br.edu.infnet.model.domain.Usuario;

public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> usuarios;
    
    	public UsuarioController() {
        super();
        usuarios = new ArrayList<Usuario>();	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("home.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario(request.getParameter("nome"), request.getParameter("email"));
		
		usuario.setSenha(request.getParameter("senha"));
		
		System.out.println(usuario);
		
		//request.getRequestDispatcher("confirmacao.html").forward(request, response);
		
		usuarios.add(usuario);
		
		PrintWriter out = response.getWriter();
		
		out.println(
				"<!DOCTYPE html>\r\n" +
				"<html>\r\n " +
				"<head>\r\n " +
				"<meta charset=\"ISO-8859-1\">\r\n" +
				"<title>Confirmação!</title> \r\n" +
				"</head>\r\n" + 
				"<body> \r\n" +
				"	<a href='usuario'>Voltar</a>\r\n"+
				"	<h2> O usuario " + usuario.getNome() + "foi cadastrado com sucesso!!!</h2>\r\n"+
				"   <h3>Quantidade de usuarios existentes: " + usuarios.size() + "!!!</h3>\r\n" +
				"    <hr>");
		
		for(Usuario user: usuarios) {
			out.println("<h3>Usuario: " + user.getNome()+"</h3>");
		}
		
		out.println(
				"	</div>\r\n" +
				"</body>\r\n" +
				"</html>");
				
	}
	

}
