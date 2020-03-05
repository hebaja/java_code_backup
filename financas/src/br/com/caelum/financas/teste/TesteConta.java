package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(3);
		
//		conta.setAgencia("123");
//		conta.setNumero("456789");
//		conta.setBanco("Banco Biruleibe");
//		conta.setTitular("hebaja");
		

		EntityManager em = new JPAUtil().getEntityManager();
		            
		em.getTransaction().begin();
		
		conta = em.find(Conta.class, 3);
		
//		em.persist(conta);
		em.remove(conta);
		
		em.getTransaction().commit();
				
		em.close();
		
		
				
	}


}


