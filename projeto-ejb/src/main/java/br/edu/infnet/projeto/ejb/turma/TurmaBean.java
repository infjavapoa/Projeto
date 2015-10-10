package br.edu.infnet.projeto.ejb.turma;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TurmaBean{
	@PersistenceContext
    private EntityManager em;
	
    public void adicionar(Turma turma) {
        em.persist(turma);
    }
    
    public void remover(Long idTurma) {
    	Turma turma = obter(idTurma);
        em.remove(turma);
    }
    
    public Turma obter(Long idTurma) {
    	return em.find(Turma.class, idTurma);
    }
    
    public List<Turma> listar() {
        Query query = em.createQuery("SELECT t FROM Turma t");
        return (List<Turma>) query.getResultList();
    }
}
