package br.edu.infnet.projeto.ejb.questao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.edu.infnet.projeto.ejb.questao.Questao;

@Stateless
public class QuestaoBean {
	@PersistenceContext
    private EntityManager em;
	
    public void adicionar(Questao questao) {
        em.persist(questao);
    }
    
    public void remover(Long idQuestao) {
    	Questao questao = obter(idQuestao);
        em.remove(questao);
    }
    
    public void atualizar(Long idQuestao, Questao novaQuestao) {
    	Questao questao = obter(idQuestao);
    	questao.setTexto(novaQuestao.getTexto());
        em.merge(questao);
    }
    
    public Questao obter(Long idQuestao) {
    	return em.find(Questao.class, idQuestao);
    }
    
    public List<Questao> listar() {
    	TypedQuery<Questao> query = em.createQuery("SELECT t FROM Questao t", Questao.class);
        return query.getResultList();
    }
}
