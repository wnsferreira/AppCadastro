package br.edu.infnet.model.repository;

import br.edu.infnet.model.domain.Usuario;

public class UsuarioDao {
	
	public static Usuario validar(String email, String senha) {
		
		if(email.equals(senha)) {
						
			return new Usuario("Joao", email);
		}
		
		return null;	
	}
}
