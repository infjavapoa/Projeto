package br.edu.infnet.projeto.ejb.turma;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Stateless
public class TurmaBean{
	
	@PersistenceContext
    private EntityManager em;
	
    public void create(Turma turma) throws Exception {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("infbloco");
    	EntityManager em2 = emf.createEntityManager();
        em2.persist(turma);
    }
}
