package br.edu.infnet.projeto.ejb.core;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class Repositorio {
	@PersistenceContext
    private EntityManager em;
    
    public <T> void adicionar(T t) {
        em.persist(t);
    }
    
    public void remover(Class<BaseEntity<? extends Number>> type, Number id) {
        Object ref = em.getReference(type, id);
        em.remove(ref);
    }
    
    public <T> void remover(T t) {
        t = em.merge(t);
        em.remove(t);
    }
    
    public <T> void atualizar(T t) {
        em.merge(t);
    }
    
    public BaseEntity<? extends Number> obter(Class<BaseEntity<? extends Number>> type, Number id) {
        return em.find(type, id);
    }
    
    public <T> List<T> listar(Class<T> c){
    	Query query = em.createQuery("SELECT t FROM "+c.getName()+" t", c);
        return query.getResultList();
    }
 
}
