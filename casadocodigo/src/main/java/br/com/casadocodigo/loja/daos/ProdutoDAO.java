package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Repository
@Transactional
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Produto produto) {
		manager.persist(produto);
	}
	
	@DateTimeFormat
	private Calendar data = Calendar.getInstance();

	public List<Produto> listar() {
		return manager.createQuery("select distinct(p) from Produto p join fetch p.precos", Produto.class).getResultList();
	}
	
	public List<Produto> listarJson(Calendar data) {
		TypedQuery<Produto> query = manager.createQuery("select distinct(p) from Produto p join fetch p.precos preco "
				+ "where p.dataLancamento > :data", Produto.class);
		
		return query.setParameter("data", data).getResultList();
	}

	public Produto find(Integer id) {
		return manager.createQuery("select distinct(p) from Produto p join fetch p.precos preco where p.id = :id",Produto.class).setParameter("id", id).getSingleResult();
	}

	public BigDecimal somaPrecosPorTipo(TipoPreco tipoPreco){
	    TypedQuery<BigDecimal> query = manager.createQuery("select sum(preco.valor) from Produto p join p.precos preco where preco.tipo = :tipoPreco", BigDecimal.class);
	    query.setParameter("tipoPreco", tipoPreco);
	    return query.getSingleResult();
	}

	public Long findQuant(Calendar data) {
		Query query = manager.createQuery("select count(p) from Produto p where p.dataLancamento > :data", Long.class);
		return (Long) query.setParameter("data", data).getSingleResult();
				
	}
	
	public Long findQuantList() {
		Query query = manager.createQuery("select count(p) from Produto p", Long.class);
		return (Long) query.getSingleResult();
	}
}
