package br.edu.infnet.projeto.ejb.core;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class Repositorio {
	@PersistenceContext
    private EntityManager em;
    
    public <T> void adicionar(T t) {
        em.persist(t);
    }
    
    public <T> void remover(Class<T> type, Number id) {
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
    
    public <T> T obter(Class<T> type, Number id) {
        return em.find(type, id);
    }
    
    public <T> List<T> listar(Class<T> c){
    	TypedQuery<T> query = em.createQuery("SELECT t FROM "+c.getName()+" t", c);
        return query.getResultList();
    }
    
    public <T> List<T> listarWithNamedQuery(Class<T> c, String namedQueryName, Map<String, Object> parameters){
    	TypedQuery<T> query = em.createNamedQuery(namedQueryName, c);
    	
    	//parâmetros
		Iterator<Entry<String,Object>> it = parameters.entrySet().iterator();
		while (it.hasNext()) {
		    Entry<String,Object> entry = it.next();
		    query.setParameter(entry.getKey().toString(), entry.getValue());
		}
		
        return query.getResultList();
    }
 
}
