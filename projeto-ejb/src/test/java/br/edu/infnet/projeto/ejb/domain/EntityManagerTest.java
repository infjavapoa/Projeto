package br.edu.infnet.projeto.ejb.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.edu.infnet.projeto.ejb.turma.Turma;


public class EntityManagerTest {
	EntityManagerFactory emf;
	EntityManager em;
	
	@BeforeClass
	public void setup() {
		System.out.println("EntityManagerTest setup...");
        emf = Persistence.createEntityManagerFactory("infbloco");
        assert emf != null;
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("EntityManagerTest tearDown...");
        assert emf != null;
        emf.close();
	}
	  
	@Test
	public void testTurma() {
		EntityManager em = emf.createEntityManager();
		Turma t1 = new Turma();
		t1.setNome("Java");
		
		try{
			em.getTransaction().begin();
			em.persist(t1);
			em.getTransaction().commit();
		}
		finally{
			em.close();
		}
	}
}
