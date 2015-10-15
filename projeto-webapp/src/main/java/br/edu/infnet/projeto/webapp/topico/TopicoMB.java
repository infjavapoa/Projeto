package br.edu.infnet.projeto.webapp.topico;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import br.edu.infnet.projeto.ejb.topico.Topico;
import br.edu.infnet.projeto.ejb.topico.TopicoBean;

@ManagedBean
@ViewScoped
public class TopicoMB {
    @EJB
    private TopicoBean topicoBean;
    
    private Topico novoTopico;
    private Topico topicoSelecionado;
    private List<Topico> listaTopicos;
    
    @PostConstruct
    public void init() {
    	atualizaView();
    }
    
    public Topico getNovoTopico() {
		return novoTopico;
	}
    
	public void setNovoTopico(Topico novoTopico) {
		this.novoTopico = novoTopico;
	}
	
    public Topico getTopicoSelecionado() {
		return topicoSelecionado;
	}
    
	public void setTopicoSelecionado(Topico topicoSelecionado) {
		this.topicoSelecionado = topicoSelecionado;
	}
	
	private void atualizaView(){
		novoTopico = new Topico();
		listaTopicos = topicoBean.listar();
	}
	
	public void onRowEdit(RowEditEvent event) {
        Topico novoTopico = ((Topico) event.getObject());
        //topicoBean.remover(novoTopico.getId());
        topicoBean.atualizar(novoTopico.getId(), novoTopico);
    }
     
    
    public List<Topico> getListaTopicos() {
		return listaTopicos;
	}

	public void adicionar() {
		topicoBean.adicionar(novoTopico);
		atualizaView();
    }
	
	public void remover() {
		topicoBean.remover(topicoSelecionado.getId());
		atualizaView();
    }
}
