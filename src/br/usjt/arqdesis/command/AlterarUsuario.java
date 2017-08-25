package br.usjt.arqdesis.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;

public class AlterarUsuario implements Command {

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
		HttpSession session = request.getSession();

		cs.atualizar(usuario);
		@SuppressWarnings("unchecked")
		ArrayList<Usuario> lista = (ArrayList<Usuario>) session
				.getAttribute("lista");
		int pos = busca(usuario, lista);
		lista.remove(pos);
		lista.add(pos, usuario);
		session.setAttribute("lista", lista);
		request.setAttribute("usuario", usuario);
		view = request.getRequestDispatcher("VisualizarUsuario.jsp");

		view.forward(request, response);

	}

	public int busca(Usuario usuario, ArrayList<Usuario> lista) {
		Usuario to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == usuario.getId()) {
				return i;
			}
		}
		return -1;
	}

}
