package br.edu.infnet.projeto.webapp.topico;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.infnet.projeto.ejb.topico.Topico;
import br.edu.infnet.projeto.ejb.topico.TopicoBean;

@RequestScoped 
@ManagedBean 
public class TopicoMB {
    @EJB
    private TopicoBean topicoBean;
    private Topico topico = new Topico();
    
    public Topico getTopico() {
		return topico;
	}
    
	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public String adicionarTopico() {
		topicoBean.adicionar(topico);
		return "";
    }
}
