package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesSystemTest {

	private WebDriver driver;
	private LeiloesPage leiloes;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);
		
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Jaguatirica Santos", "jagua@tirica.com");
	}
	
	@After
	public void encerra() {
		driver.close();
	}
	
	@Test
	public void deveCadastrarUmLeilao() {
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Geladeira", 123, "Jaguatirica Santos", true);
		
		assertTrue(leiloes.existe("Geladeira", 123, "Jaguatirica Santos", true));
		
	}
	
	@Test
	public void naoDeveCadastrarUmLeilaoSemNome() {
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("", 123, "Jaguatirica Santos", true);
		
		assertTrue(leiloes.alertaNomeOuValorInicialObrigatorio());
		
	}
	
	@Test
	public void naoDeveCadastrarUmLeilaoSemValorInicial() {
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Xbox", 0, "Jaguatirica Santos", true);
		
		assertTrue(leiloes.alertaNomeOuValorInicialObrigatorio());
		
	}
}
