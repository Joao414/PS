package br.com.fiap.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	@Produces
	public EntityManager getGerenciadorEntidade(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jkcontrol-persistence-unit");
		EntityManager gerenciador = fabrica.createEntityManager();
		return gerenciador;
	}
}