package br.edu.infnet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.model.domain.Usuario;
import br.edu.infnet.model.repository.UsuarioDao;
	

public class AcessoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public AcessoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
				
		Usuario usuario = UsuarioDao.validar(email, senha);
		
		if(usuario != null) {
			System.out.println("Usuário autenticado: " + usuario.getNome());
			
			request.setAttribute("lista", UsuarioDao.obterLista());
			
			request.getRequestDispatcher("usuario/lista.jsp").forward(request, response);
		}else {
									
			request.setAttribute("mensagem","Autenticacao invalida para o usuario " + email + "!");
			
			doGet(request, response);
		}
	}


}
