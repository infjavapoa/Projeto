package br.edu.infnet.projeto.webapp.questionario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.questao.Questao;
import br.edu.infnet.projeto.ejb.questao.QuestaoObjetiva;
import br.edu.infnet.projeto.ejb.questionario.Questionario;

@ManagedBean
@ViewScoped
public class QuestionarioMB {
	@EJB
    private Repositorio repositorio;
    private Questionario questionario;
    private List<Questionario> listaQuestionarios;
    private Questao questao;    
    
    @PostConstruct
    public void init() {
    	atualizaView();
    }
    
    public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Questionario getQuestionario() {
		return questionario;
	}
    
	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	
	public void atualizaView(){
		questao = new QuestaoObjetiva();
		questionario = new Questionario();
		listaQuestionarios = repositorio.listar(Questionario.class);
	}
    
    public List<Questionario> getListaQuestionarios() {
		return listaQuestionarios;
	}

	public void salvar() {
		if (questionario.getId() == null)
			repositorio.adicionar(questionario);
		else
			repositorio.atualizar(questionario);
		atualizaView();
    }
	
	public void remover() {
		repositorio.remover(questionario);
		atualizaView();
    }
	
	public List<Questao> listarQuestoes(String texto){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("texto","%"+texto+"%");
		return repositorio.listarWithNamedQuery(Questao.class, "pesquisarPorTexto", parametros);
	}	
}
