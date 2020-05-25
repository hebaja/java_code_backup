package br.com.caelum.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {

	private WebDriver driver;
	private UsuariosPage usuarios;

	@Before
	public void antes() {
		driver = new ChromeDriver();
		usuarios = new UsuariosPage(driver);

	}
	
	@After
	public void depois() {
		driver.get("http://localhost:8080/apenas-teste/limpa");
		driver.close();
	}
	
	@Test
	public void deveAdicionarUmUsuario() {
		
		usuarios.visita();
		usuarios.novo().cadastra("Jacaré da Silva", "jacare@silva.com.br");
		assertTrue(usuarios.existeNaListagem("Jacaré da Silva", "jacare@silva.com.br"));
		
//		driver.get("http://localhost:8080/usuarios/new");
//		
//		WebElement nome = driver.findElement(By.name("usuario.nome"));
//		WebElement email = driver.findElement(By.name("usuario.email"));
//		
//		nome.sendKeys("Ronaldo José Pereira");
//		email.sendKeys("ronaldao@bol.com.br");
//		
//		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
//		botaoSalvar.click();
//		
//		boolean achouNome = driver.getPageSource().contains("Ronaldo José Pereira");
//		boolean achouEmail = driver.getPageSource().contains("ronaldao@bol.com.br");
//		
//		assertTrue(achouNome);		
//		assertTrue(achouEmail);

	}
	
	@Test
	public void naoDeveAdicionarUsuarioSemNome() {
		
		usuarios.visita();
		usuarios.novo().cadastra("", "jacare@silva.com.br");
		
		assertTrue(usuarios.alertaNomeObrigatorio());
		
	}
	
	@Test
	public void naoDeveAdicionarUsuarioSemNomeNemEmail() {

		usuarios.visita();
		usuarios.novo().cadastra("", "");
		
		assertTrue(usuarios.alerteNomeEEmailObrigatorio());
		
	}
	
	@Test
	public void linkNovoUsuarioDeveFuncionar() {
		driver.get("http://localhost:8080/usuarios");
		driver.findElement(By.linkText("Novo Usuário")).click();
	}
	
	public void deveAleterarUmUsuario() {
		
		usuarios.novo().cadastra("Macaquin Armando", "maca@armando.com");
		usuarios.altera(1).para("Macaquin Armando Sá", "macaquin@armando.com");
		
		assertFalse(usuarios.existeNaListagem("Macaquin Armando", "maca@armando.com"));
		assertTrue(usuarios.existeNaListagem("Macaquin Armando Sá", "macaquin@armando.com"));
	}
	
	
	
}
