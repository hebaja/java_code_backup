package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Usuario usuario) {
		System.out.println("gravando usuario");
		manager.persist(usuario);
		System.out.println(usuario);
	}
	
	public void update(Usuario usuario) {
		System.out.println("atualizando usuario");
		manager.merge(usuario);
	}
	
	public List<Usuario> listar() {
		return manager.createQuery("select u from Usuario u", Usuario.class).getResultList();
	}

	public Usuario find(String email) {
		return manager.createQuery("select distinct(u) from Usuario u where u.email = :email", Usuario.class).setParameter("email", email).getSingleResult();
	}
	
	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
		.setParameter("email", email)
		.getResultList();
		
		if(usuarios.isEmpty()) {
			throw new UsernameNotFoundException ("Usuário " + email + " não foi encontrado");
		}
		return usuarios.get(0);
	}

}