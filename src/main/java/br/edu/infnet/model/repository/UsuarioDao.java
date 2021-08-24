package br.edu.infnet.model.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.model.domain.Usuario;

public class UsuarioDao {
	
	private static List<Usuario> usuarios = new ArrayList<Usuario>();	
	
	public static void incluir(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public static List<Usuario> obterLista(){
		return usuarios;
	}
	
	public static Usuario validar(String email, String senha) {
		
		if(email.equals(senha)) {
						
			return new Usuario("Joao", email);
		}
		
		return null;	
	}
}
