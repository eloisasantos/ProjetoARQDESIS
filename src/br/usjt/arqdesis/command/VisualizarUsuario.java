package br.usjt.arqdesis.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;

public class VisualizarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pCpf = request.getParameter("cpf");
		String pLogin = request.getParameter("login");
		String pSenha = request.getParameter("senha");
		String pTipo = request.getParameter("tipo");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(pNome);
		usuario.setCpf(pCpf);
		usuario.setLogin(pLogin);
		usuario.setSenha(pSenha);
		usuario.setTipo(pTipo);
		UsuarioService cs = new UsuarioService();
		
		RequestDispatcher view = null;

		usuario = cs.carregar(usuario.getId());
		request.setAttribute("usuario", usuario);
		view = request.getRequestDispatcher("VisualizarUsuario.jsp");

		view.forward(request, response);

	}

}
