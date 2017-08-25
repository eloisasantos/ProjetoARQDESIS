package br.usjt.arqdesis.service;

import br.usjt.arqdesis.dao.UsuarioDAO;
import br.usjt.arqdesis.model.Usuario;


public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();
	
	public int criar(Usuario usuario) {
		return dao.criar(usuario);
	}
	
	public void atualizar(Usuario usuario){
		dao.atualizar(usuario);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Usuario carregar(int id){
		return dao.carregar(id);
	}

}
