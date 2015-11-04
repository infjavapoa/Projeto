package br.edu.infnet.projeto.webapp.questionario;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.questionario.Topico;

@ManagedBean
@ViewScoped
public class TopicoMB {
	@EJB
    private Repositorio repositorio;
    
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
	
	public void atualizaView(){
		topico = new Topico();
		listaTopicos = repositorio.listar(Topico.class);
	}
    
    public List<Topico> getListaTopicos() {
		return listaTopicos;
	}

	public void salvar() {
		if (topico.getId() == null)
			repositorio.adicionar(topico);
		else
			repositorio.atualizar(topico);
		atualizaView();
    }
	
	public void remover() {
		repositorio.remover(topico);
		atualizaView();
    }
}
