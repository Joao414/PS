package br.com.fiap.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Usuario;

public class UsuarioDao {

	@Inject
	private EntityManager gerenciador;

	public void criar(Usuario usuario) {
		gerenciador.getTransaction().begin();
		gerenciador.persist(usuario);
		gerenciador.getTransaction().commit();
		gerenciador.clear();
	}
	
	public List<Usuario> listar() {
		TypedQuery<Usuario> consulta = gerenciador.createQuery("select u from Usuario u", Usuario.class);
		return consulta.getResultList();
	}

}
