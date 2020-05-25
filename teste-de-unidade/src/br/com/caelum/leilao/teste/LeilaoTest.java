package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {
	
	private Usuario steveJobs;
	private Usuario steveWozniac;
	private Usuario billGates;

	@Before
	public void criaUsuarios() {
		steveJobs = new Usuario("Steve Jobs");
		steveWozniac = new Usuario("Steve Wozniac");
		billGates = new Usuario("Bill Gates");
	}
	
	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15").constroi();
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(steveJobs, 2000));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
				.lance(steveJobs, 2000)
				.lance(steveWozniac, 3000)
				.constroi();
		
		assertEquals(2, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000.0, leilao.getLances().get(1).getValor(), 0.00001);

	}
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
				.lance(steveJobs, 2000.0)
				.lance(steveJobs, 3000.0)
				.constroi();
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
		.lance(steveJobs, 2000.0)
		.lance(billGates, 3000.0)
		.lance(steveJobs, 4000.0)
		.lance(billGates, 5000.0)
		.lance(steveJobs, 6000.0)
		.lance(billGates, 7000.0)
		.lance(steveJobs, 8000.0)
		.lance(billGates, 9000.0)
		.lance(steveJobs, 10000.0)
		.lance(billGates, 11000.0)
		.constroi();
		
		//deve ser ignorado
		leilao.propoe(new Lance(steveJobs, 12000.0));

		assertEquals(10, leilao.getLances().size());
		assertEquals(11000.0, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
		
	}
	
	@Test
	public void deveDobrarUltimoLanceEncontrado() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
		.lance(steveJobs, 2000.0)
		.lance(billGates, 3000.0)
		.lance(steveJobs, 4000.0)
		.lance(billGates, 5000.0)
		.constroi();
				
		leilao.dobraLance(steveJobs);
				
		assertEquals(8000.0, leilao.getLances().get(leilao.getLances().size()-1).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15").constroi();

        leilao.dobraLance(steveJobs);

        assertEquals(0, leilao.getLances().size());
	}
}
