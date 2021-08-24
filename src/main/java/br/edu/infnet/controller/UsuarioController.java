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
import br.edu.infnet.model.repository.UsuarioDao;

public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    
    	public UsuarioController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tela = request.getParameter("tela");
		
		if("lista".equals(tela)){
			request.getRequestDispatcher("usuario/cadastro.jsp").forward(request, response);
		}else {
			request.setAttribute("lista", UsuarioDao.obterLista());
			request.getRequestDispatcher("usuario/lista.jsp").forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario(request.getParameter("nome"), request.getParameter("email"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		System.out.println(usuario);
		
		UsuarioDao.incluir(usuario);
				
		//Passa a informação pra dentro de um atributo e a tela de confirmação jsp recebe a informação e exibe na tela.
		
		request.setAttribute("nomeDoUsuario", usuario.getNome());
		request.setAttribute("lista",UsuarioDao.obterLista());
		
		request.getRequestDispatcher("confirmacao.jsp").forward(request, response);
				
	}
	

}

//PrintWriter out = response.getWriter();
//
//out.println(
//		"<!DOCTYPE html>\r\n" +
//		"<html>\r\n " +
//		"<head>\r\n " +
//		"<meta charset=\"ISO-8859-1\">\r\n" +
//		"<title>Confirmação!</title> \r\n" +
//		"</head>\r\n" + 
//		"<body> \r\n" +
//		"	<a href='usuario'>Voltar</a>\r\n"+
//		"	<h2> O usuario " + usuario.getNome() + "foi cadastrado com sucesso!!!</h2>\r\n"+
//		"   <h3>Quantidade de usuarios existentes: " + usuarios.size() + "!!!</h3>\r\n" +
//		"    <hr>");
//
//for(Usuario user: usuarios) {
//	out.println("<h3>Usuario: " + user.getNome()+"</h3>");
//}
//
//out.println(
//		"	</div>\r\n" +
//		"</body>\r\n" +
//		"</html>");