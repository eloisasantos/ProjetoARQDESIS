package test;


import static org.junit.Assert.assertEquals;
import model.Usuario;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.UsuarioService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {
	Usuario usuario, copia;
	UsuarioService usuarioService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Usuario. 
	 * Certifique-se que a fixture usuario1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome("Batista Cepelos");
		usuario.setCpf("456123789");
		usuario.setLogin("batista");
		usuario.setSenha("010203");
		usuario.setTipo("Sindico");
		
		copia = new Usuario();
		copia.setId(id);
		copia.setNome("Batista Cepelos");
		copia.setCpf("456123789");
		copia.setLogin("batista");
		copia.setSenha("010203");
		copia.setTipo("Sindico");
		usuarioService = new UsuarioService();
		System.out.println(usuario);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o usuario 1 deve ter sido carregado no banco por fora
		Usuario fixture = new Usuario();
		fixture.setId(1);
		fixture.setNome("Carlos Drummond de Andrade");
		fixture.setCpf("(11) 91234-4321");
		fixture.setLogin("carlos");
		fixture.setSenha("123mudar");
		fixture.setTipo("funcionario");
		UsuarioService novoService = new UsuarioService();
		Usuario novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = usuarioService.criar(usuario);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", usuario, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		usuario.setCpf("999999");
		copia.setCpf("999999");		
		usuarioService.atualizar(usuario);
		usuario = usuarioService.carregar(usuario.getId());
		assertEquals("testa atualizacao", usuario, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setCpf(null);
		copia.setLogin(null);
		copia.setSenha(null);
		copia.setTipo(null);
		usuarioService.excluir(id);
		usuario = usuarioService.carregar(id);
		assertEquals("testa exclusao", usuario, copia);
	}
}