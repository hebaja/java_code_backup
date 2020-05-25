package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSystemTest {
	
	private WebDriver driver;
	private LeiloesPage leiloes;
	private DetalhesDoLeilaoPage lances;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);
		
//		UsuariosPage usuarios = new UsuariosPage(driver);
//		usuarios.visita();
//		usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
//		usuarios.novo().cadastra("José Eduardo", "jose@eduardo.com");
//		
//		LeiloesPage leiloes = new LeiloesPage(driver);
//		leiloes.visita();
//		leiloes.novo().preenche("Geladeira", 100, "Paulo Henrique", false);
				
		lances = new DetalhesDoLeilaoPage(driver);
		
		new CriadorDeCenarios(driver)
			.umUsuario("Paulo Henrique", "paulo@henrique.com")
			.umUsuario("José Alberto", "jose@alberto.com")
			.umLeilao("Paulo Henrique", "Geladeira", 100, false);
	
	}
		
	@Test
	public void deveFazerUmLance() {
		
		leiloes.detalhes(1);
		
		lances.lance("José Eduardo", 150);
		
		assertTrue(lances.existeLance("José Eduardo", 150));
	}
	
}
