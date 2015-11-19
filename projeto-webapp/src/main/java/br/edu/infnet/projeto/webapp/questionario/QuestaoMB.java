package br.edu.infnet.projeto.webapp.questionario;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.questionario.Questao;
import br.edu.infnet.projeto.ejb.questionario.QuestaoDissertativa;
import br.edu.infnet.projeto.ejb.questionario.QuestaoObjetiva;

@ManagedBean
@ViewScoped
public class QuestaoMB {
	@EJB
    private Repositorio repositorio;
	
    private Questao questao;
    private List<Questao> listaQuestoes;
    
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
    
    public List<Questao> getListaQuestoes() {
		return listaQuestoes;
	}
	
	public void atualizaView(){
		questao = new QuestaoObjetiva();
		listaQuestoes = new ArrayList<Questao>();
		listaQuestoes.addAll(repositorio.listar(Questao.class));
	}

	public void salvar() {
		//Atualiza o tipo da questão
		if (questao.getTipoQuestao().equals("O"))
			this.questao = new QuestaoObjetiva(questao.getId(), questao.getTexto());
		else
			this.questao = new QuestaoDissertativa(questao.getId(), questao.getTexto());
		
		if (questao.getId() == null) 
			repositorio.adicionar(questao);
		else
			repositorio.atualizar(questao);
		atualizaView();
    }
	
	public void remover() {
		repositorio.remover(questao);
		atualizaView();
    }
}
