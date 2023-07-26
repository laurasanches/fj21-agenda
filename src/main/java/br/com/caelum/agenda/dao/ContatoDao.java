package br.com.caelum.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.agenda.model.Contato;

public class ContatoDao {
	
	public void adiciona(Contato contato) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos2");
	    EntityManager manager = factory.createEntityManager();
	    
		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		
		System.out.println("ID do contato: " + contato.getId());
		
        manager.close();
        factory.close();
	}
	
	public Contato pesquisa(long id) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos2");
	    EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select c from Contato as c where c.nome = :paramNome");
		Contato encontrado = manager.find(Contato.class, id);
		System.out.println(encontrado.getNome());
		
		return encontrado;
	}
	
	public void altera(Contato contato) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos2");
	    EntityManager manager = factory.createEntityManager();
	
		manager.getTransaction().begin();
		Contato contatoAtualizado = manager.find(Contato.class, contato.getId());
		contatoAtualizado.setNome(contato.getNome());
		contatoAtualizado.setEmail(contato.getEmail());
		contatoAtualizado.setEndereco(contato.getEndereco());
		contatoAtualizado.setDataNascimento(contato.getDataNascimento());
		manager.getTransaction().commit();
		
        manager.close();
        factory.close();
		
	}

	public void exclui(Contato contato) {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos2");
	    EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("delete from Contato where id = :id");
		
		manager.getTransaction().begin();
		contato = manager.merge(contato);
		manager.remove(contato);
		manager.getTransaction().commit();
		
        manager.close();
        factory.close();
		
	}
	
	public List<Contato> getLista() {
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos2");
	    EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select c from Contato c");
		
		List<Contato> contatos = query.getResultList();
		
		for (Contato c : contatos) {
			System.out.println(c.getNome());
		}
		
		return contatos;
	}
	
}

