package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Role;

@Repository
@Transactional
public class RoleDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Role> listar() {
		return manager.createQuery("select r from Role r", Role.class).getResultList();
	}
	
	public void gravar(Role role) {
		manager.persist(role);
		System.out.println("gravando role");
	}
}
