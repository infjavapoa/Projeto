package br.edu.infnet.projeto.webapp.turma;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean; 
import javax.faces.bean.RequestScoped; 

import br.edu.infnet.projeto.ejb.turma.Turma;
import br.edu.infnet.projeto.ejb.turma.TurmaBean;

@RequestScoped 
@ManagedBean 
public class TurmaMB { 

    @EJB
    private TurmaBean turmaBean;
    private Turma turma = new Turma();
    
    public Turma getTurma() {
		return turma;
	}
    
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String adicionarTurma() throws Exception {
		turmaBean.create(turma);
        return "infdsafdex.xhtml";
    }
}
