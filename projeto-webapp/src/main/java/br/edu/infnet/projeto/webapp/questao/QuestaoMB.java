package br.edu.infnet.projeto.webapp.questao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.questao.Questao;
import br.edu.infnet.projeto.ejb.questao.QuestaoObjetiva;
import br.edu.infnet.projeto.ejb.topico.Topico;

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
	
	private void atualizaView(){
		questao = new QuestaoObjetiva();
		listaQuestoes = new ArrayList<Questao>();
		listaQuestoes.addAll(repositorio.listar(new QuestaoObjetiva()));
	}

	public void salvar() {
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
