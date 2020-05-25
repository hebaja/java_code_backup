package br.com.caelum.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPage {
	
	private WebDriver driver;
	
	public UsuariosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
		driver.get(new URLDaAplicacao().getUrlBase() + "/usuarios");
	}
	
	public NovoUsuarioPage novo() {
		driver.findElement(By.linkText("Novo Usuário")).click();
		return new NovoUsuarioPage(driver);
	}
	
	public AlteraUsuarioPage altera(int posicao) {
		driver.findElement(By.linkText("editar")).click();
		return new AlteraUsuarioPage(driver);
	}
	
	public boolean existeNaListagem(String nome, String email) {
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(email);
	}
	
	public boolean alertaNomeObrigatorio() {
		return driver.getPageSource().contains("Nome obrigatorio!");
	}
	
	public boolean alerteNomeEEmailObrigatorio() {
		return driver.getPageSource().contains("Nome obrigatorio!") && driver.getPageSource().contains("E-mail obrigatorio!");
	}
}

