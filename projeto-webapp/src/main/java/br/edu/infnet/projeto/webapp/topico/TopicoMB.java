package br.edu.infnet.projeto.webapp.topico;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.edu.infnet.projeto.ejb.topico.Topico;
import br.edu.infnet.projeto.ejb.topico.TopicoBean;

@ManagedBean
@ViewScoped
public class TopicoMB {
	@EJB
    private TopicoBean topicoBean;
    
    private Topico topico;
    private List<Topico> listaTopicos;
    
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
	
	private void atualizaView(){
		topico = new Topico();
		listaTopicos = topicoBean.listar();
	}
    
    public List<Topico> getListaTopicos() {
		return listaTopicos;
	}

	public void salvar() {
		if (topico.getId() == null)
			topicoBean.adicionar(topico);
		else
			topicoBean.atualizar(topico.getId(), topico);
		atualizaView();
    }
	
	public void remover() {
		topicoBean.remover(topico.getId());
		atualizaView();
    }
}
