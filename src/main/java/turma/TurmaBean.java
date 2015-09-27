package turma;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TurmaBean implements Serializable {
	private static final long serialVersionUID = 9183981999682329722L;
	
	@PersistenceContext
    private EntityManager em;
	
    public void create(Turma turma) {
    	//Valida��es...
    	
    	em.getTransaction().begin();
        em.persist(turma);
        em.getTransaction().commit();
    }
}
