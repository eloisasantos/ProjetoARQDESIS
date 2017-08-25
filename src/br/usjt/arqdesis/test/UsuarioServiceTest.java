package br.usjt.arqdesis.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import br.usjt.arqdesis.model.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.usjt.arqdesis.service.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioServiceTest {
	static Usuario usuario;
	static UsuarioService cs;

	
	@BeforeClass
	public static void setUp() throws Exception {
		cs = new UsuarioService();
		usuario = new Usuario();
		usuario.setNome("Ana");
		usuario.setCpf("12345678912");
		usuario.setLogin("ana01");
		usuario.setSenha("123456");
		usuario.setTipo("Funcionario");
		usuario.setId(-1);
	}
	
	@Test
	public void test00Carregar() {
		
		Usuario fixture = new Usuario();
		fixture.setId(1);
		fixture.setNome("Carlos");
		fixture.setCpf("24687123345");
		fixture.setLogin("carlos");
		fixture.setSenha("abcde");
		fixture.setTipo("sindico");
		Usuario novo = new Usuario();
		novo.setId(1);
		try {
			novo = cs.carregar(fixture.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		Usuario copia = null;
		try {
			usuario.setId(cs.criar(usuario));
			copia = cs.carregar(usuario.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("testa criacao", usuario, copia);
	}

	@Test
	public void test02Atualizar() {
		Usuario copia = null;
		usuario.setLogin("anapaula");
			
		try {
			copia = cs.carregar(usuario.getId());
			cs.atualizar(usuario);
			copia.setLogin("anapaula");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("testa inclusao", usuario, copia);
	}

	@Test
	public void test03Excluir() {
		usuario.setNome(null);
		usuario.setCpf(null);
		usuario.setLogin(null);
		usuario.setSenha(null);
		usuario.setTipo(null);
		Usuario copia = null;
		try {
			cs.excluir(usuario.getId());
			copia = cs.carregar(usuario.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("testa exclusao", usuario, copia);
	}
}