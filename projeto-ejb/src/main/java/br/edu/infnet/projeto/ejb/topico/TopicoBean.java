package br.edu.infnet.projeto.ejb.topico;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class TopicoBean {
	@PersistenceContext
    private EntityManager em;
	
    public void adicionar(Topico topico) {
        em.persist(topico);
    }
    
    public void remover(Long idTopico) {
    	Topico topico = obter(idTopico);
        em.remove(topico);
    }
    
    public void atualizar(Long idTopico, Topico novoTopico) {
    	Topico topico = obter(idTopico);
    	topico.setTexto(novoTopico.getTexto());
        em.merge(topico);
    }
    
    public Topico obter(Long idTopico) {
    	return em.find(Topico.class, idTopico);
    }
    
    public List<Topico> listar() {
    	TypedQuery<Topico> query = em.createQuery("SELECT t FROM Topico t", Topico.class);
        return query.getResultList();
    }
}
