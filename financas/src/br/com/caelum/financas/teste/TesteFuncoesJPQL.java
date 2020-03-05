package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);

		TypedQuery<Double> TypedQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);
		
		TypedQuery.setParameter("pConta", conta);
		TypedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = TypedQuery.getResultList();
		
//		MovimentacaoDao dao = new MovimentacaoDao(em);
//		List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		
		for (Double media : medias) {
			System.out.println("A média é: " + medias);
			
		}
				
		
//		System.out.println("A soma é: " + soma);
//		System.out.println("A média é: " + medias);
//		System.out.println("A média é: " + medias.get(0));
//		System.out.println("A média é: " + medias.get(1));
//		System.out.println("A média é: " + medias.get(2));
//		System.out.println("A média é: " + medias.get(3));
//		System.out.println("A média é: " + medias.get(4));

		
		em.getTransaction().commit();
		em.close();
		
	}

}
