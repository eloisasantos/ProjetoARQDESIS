package br.usjt.arqdesis.service;

import java.util.ArrayList;

import br.usjt.arqdesis.dao.UsuarioDAO;
import br.usjt.arqdesis.model.Usuario;

public class VendedorService {
	
	UsuarioDAO dao;
	
	public VendedorService(){
		dao = new UsuarioDAO();
	}
	public ArrayList<Usuario> listarUsuarios(){
		return dao.listarUsuarios();
	}
	public ArrayList<Usuario> listarUsuarios(String chave){
		return dao.listarUsuarios(chave);
	} 

}
