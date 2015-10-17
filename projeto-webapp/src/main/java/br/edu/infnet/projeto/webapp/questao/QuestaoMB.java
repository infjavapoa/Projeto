package br.edu.infnet.projeto.webapp.questao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.edu.infnet.projeto.ejb.questao.QuestaoBean;
import br.edu.infnet.projeto.ejb.questao.Questao;
import br.edu.infnet.projeto.ejb.questao.QuestaoDissertativa;
import br.edu.infnet.projeto.ejb.questao.QuestaoObjetiva;
import br.edu.infnet.projeto.ejb.topico.Topico;
import br.edu.infnet.projeto.ejb.topico.TopicoBean;

@ManagedBean
@ViewScoped
public class QuestaoMB {
	@EJB
    private QuestaoBean questaoBean;
	@EJB
    private TopicoBean topicoBean;
	
    private Questao questao;
    private Topico topico;
    private List<Topico> listaTopicos;
    private List<Questao> listaQuestoes;
    
    @PostConstruct
    public void init() {
    	atualizaView();
    }
    
    public Topico getTopico() {
		return topico;
	}
    
	public void setTopico(Topico topico) {
		this.topico = topico;
	}
    
    public Questao getQuestao() {
		return questao;
	}
    
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
    public List<Topico> getListaTopicos() {
		return listaTopicos;
	}
    
    public List<Questao> getListaQuestoes() {
		return listaQuestoes;
	}
	
	private void atualizaView(){
		questao = new QuestaoObjetiva();
		listaQuestoes = questaoBean.listar();
		listaTopicos = topicoBean.listar();
	}

	public void salvar() {
		if (questao.getId() == null)
			questaoBean.adicionar(questao);
		else
			questaoBean.atualizar(questao.getId(), questao);
		atualizaView();
    }
	
	public void remover() {
		questaoBean.remover(questao.getId());
		atualizaView();
    }
}
