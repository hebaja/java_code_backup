package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import junit.framework.Assert;

public class TesteDoAvaliador {
	
	private Avaliador leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	
	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		joao = new Usuario("João");
		jose = new Usuario("Jose");
		maria = new Usuario("Maria");
	}
	
//	@After
//	public void finaliza() {
//		System.out.println("Fim");
//	}
	
	@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLance() {
			Leilao leilao = new CriadorDeLeilao().para("Play One").constroi();
		
			leiloeiro.avalia(leilao);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void deveEntenderLanceEmOrdemCrescente() {
		//Parte 1 Cenário
		Leilao leilao = new CriadorDeLeilao().para("Playstation 4 novinho")
				.lance(joao, 250.0)
				.lance(jose, 300.0)
				.lance(maria, 400.0)
				.constroi();
		
		
		//Parte 2 Ação
		leiloeiro.avalia(leilao);

		// Parte 3 Validação
		assertThat(leiloeiro.getMaiorLance(), equalTo(400.0));
		assertThat(leiloeiro.getMenorLance(), equalTo(250.0));
		
	}
	
	@Test
	public void deveEntenderUnicoLance() {
		Leilao leilao = new CriadorDeLeilao().para("Xiaomi mi 9")
				.lance(joao, 1000)
				.constroi();
		
		leilao.propoe(new Lance(joao, 1000));
		
		leiloeiro.avalia(leilao);
		
		assertEquals(1000, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(1000, leiloeiro.getMenorLance(), 0.00001);
		
	} 	
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Leilao leilao = new CriadorDeLeilao().para("Monitor 29 polegadas")
				.lance(joao, 100.0)
				.lance(maria, 200.0)
				.lance(joao, 300.0)
				.lance(maria, 400.0)
				.constroi();
		
		
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(3, maiores.size());
//		assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
//		assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
//		assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
		
		assertThat(maiores, hasItems(
				new Lance(maria, 400),
				new Lance(joao, 300),
				new Lance(maria, 200)
				));
	}
	
	@Test
	public void deveEntenderOrdemEmLancesRandomicos() {
		Leilao leilao = new CriadorDeLeilao().para("Monitor 29 polegadas")
			.lance(joao, 200.0)
			.lance(maria, 450.0)
			.lance(jose, 120.0)
			.lance(joao, 700.0)
			.lance(maria, 630.0)
			.lance(jose, 230.0)
			.constroi();
		
		leiloeiro.avalia(leilao);
		
		assertEquals(120, leiloeiro.getMenorLance(), 0.00001);
		assertEquals(700, leiloeiro.getMaiorLance(), 0.00001);
	}

	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
				.lance(joao, 400.0)
				.lance(maria, 300.0)
				.lance(jose, 200.0)
				.lance(joao, 100.0)
				.constroi();
		
		leiloeiro.avalia(leilao);
		
		assertEquals(400, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(300, leilao.getLances().get(1).getValor(), 0.00001);
		assertEquals(200, leilao.getLances().get(2).getValor(), 0.00001);
		assertEquals(100, leilao.getLances().get(3).getValor(), 0.00001);
	}
	
	@Test
	public void deveDevolverListaDeLanceVazia() {
		Leilao leilao = new Leilao("Mouse gamer");
 		
		assertEquals(0, leilao.getLances().size());
	}
	
	@Test
	public void DeveRetornarValorMedio() {
		//Parte 1 Cenário
		Leilao leilao = new CriadorDeLeilao().para("Monitor 29 polegadas")
				.lance(joao, 250.0)
				.lance(jose, 300.0)
				.lance(maria, 400.0)
				.constroi();
		
		//Parte 2 Ação
		leiloeiro.media(leilao);

		// Parte 3 Validação
		double mediaEsperada = 316.666666667;
		
		Assert.assertEquals(mediaEsperada, leiloeiro.getMedia(), 0.00001);
			
	}
	
}
