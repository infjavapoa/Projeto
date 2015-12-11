package br.edu.infnet.projeto.webapp.avaliacao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import org.primefaces.event.SelectEvent;

import br.edu.infnet.projeto.ejb.avaliacao.Avaliacao;
import br.edu.infnet.projeto.ejb.avaliacao.AvaliacaoInvalidaException;
import br.edu.infnet.projeto.ejb.avaliacao.ValidaAvaliacao;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.infnet.Turma;
import br.edu.infnet.projeto.ejb.questionario.Questionario;

@ManagedBean
@ViewScoped
public class AvaliacaoMB {

	@EJB
	private Repositorio repositorio;
	@EJB
	ValidaAvaliacao validaAval;

	private Avaliacao aval;
	private List<Avaliacao> listaAvals;
	private List<Avaliacao> filtroAvals;

	// turma
	private Turma turma;
	private Turma selTurma;
	private List<Turma> selTurmas;
	private List<Turma> filtroTurmas;

	// questionario
	private Questionario questionario;
	private Questionario selQuestionario;
	private List<Questionario> selQuestionarios;
	private List<Questionario> filtroQuestionarios;

	@PostConstruct
	public void init() {
		atualizaView();
	}

	// Avaliacao
	public Avaliacao getAval() {
		return aval;
	}

	public void setAval(Avaliacao aval) {
		this.aval = aval;
	}

	public List<Avaliacao> getListaAvals() {
		return listaAvals;
	}

	public void setListaAvals(List<Avaliacao> listaAvals) {
		this.listaAvals = listaAvals;
	}

	// INICIO TURMA
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getListaTurmas() {
		return repositorio.listar(Turma.class);
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
	}

	public Turma getSelTurma() {
		return selTurma;
	}

	public void setSelTurma(Turma selectedTurma) {
		if (selectedTurma != null) {
			System.out.println("SEL TURMA" + aval);
			System.out.println("Turma:" + aval.getTurma());
			System.out.println("TurmaSel:" + this.getSelTurma());
			this.selTurma = selectedTurma;
			this.aval.setTurma(selectedTurma);
		}
	}

	public List<Turma> getSelectedTurmas() {
		return selTurmas;
	}

	public List<Turma> getFiltroTurmas() {
		return filtroTurmas;
	}

	public void setFiltroTurmas(List<Turma> filtroTurmas) {
		this.filtroTurmas = filtroTurmas;
	}

	public void setSelectedTurmas(List<Turma> selectedTurmas) {
		this.selTurmas = selectedTurmas;
		atualizaView();
	}

	public void onRowTurSelect(SelectEvent event) {
		// FacesMessage msg = new FacesMessage("Turma selecionada", ((Turma)
		// event.getObject()).getId().toString() );
		// FacesContext.getCurrentInstance().addMessage(null, msg);
		// this.setListaTurmas(this.getListaTurmas());
	}

	// FINAL TURMA

	// INICIO QUESTIONARIO
	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public List<Questionario> getListaQuestionarios() {
		return repositorio.listar(Questionario.class);
	}

	public void setListaQuestionarios(List<Questionario> listaQuestionarios) {
	}

	public Questionario getSelQuestionario() {
		return selQuestionario;
	}

	public void setSelQuestionario(Questionario selectedQuestionario) {
		if (selectedQuestionario != null) {
			this.selQuestionario = selectedQuestionario;
			this.aval.setQuestionario(selectedQuestionario);
		}
	}

	public List<Questionario> getSelectedQuestionario() {
		return selQuestionarios;
	}

	public List<Questionario> getFiltroQuestionarios() {
		return filtroQuestionarios;
	}

	public void setFiltroQuestionarios(List<Questionario> filtroQuestionarios) {
		this.filtroQuestionarios = filtroQuestionarios;
	}

	public void setSelectedQuestionarios(
			List<Questionario> selectedQuestionarios) {
		this.selQuestionarios = selectedQuestionarios;
		atualizaView();
	}

	public void onRowQuestSelect(SelectEvent event) {
		// FacesMessage msg = new FacesMessage("Turma selecionada", ((Turma)
		// event.getObject()).getId().toString() );
		// FacesContext.getCurrentInstance().addMessage(null, msg);
		// this.setListaTurmas(this.getListaTurmas());
	}

	// FINAL QUESTIONARIO

	public void atualizaView() {
		aval = new Avaliacao();
		listaAvals = repositorio.listar(Avaliacao.class);

		// turma
		this.selTurmas = this.getListaTurmas();
		this.filtroTurmas = this.selTurmas;

		// questionario
		this.selQuestionarios = this.getListaQuestionarios();
		this.filtroQuestionarios = this.selQuestionarios;

		this.filtroAvals = this.getListaAvals();
		this.selTurma = (null); // o método não vai gravar se for null
		this.selQuestionario = (null); // o método não vai gravar se for null
		this.aval.setTurma(null);
		this.aval.setQuestionario(null);
	}

	public List<Avaliacao> getFiltroAvals() {
		return filtroAvals;
	}

	public void setFiltroAvals(List<Avaliacao> filtroAvals) {
		this.filtroAvals = filtroAvals;
	}

	// Persistir
	public void salvar() {
		System.out.println("SALVAR" + aval);
		System.out.println("Turma:" + aval.getTurma());
		System.out.println("Quest:" + aval.getQuestionario());
		System.out.println("TurmaSel:" + this.getSelTurma());
		System.out.println("QuestSel:" + this.getSelQuestionario());

		try {
			aval.setSituacao("F");
			validaAval.setAval(aval);
			System.out
					.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX Antes XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			if (aval.getId() == null) {
				validaAval.valida(true);
				repositorio.adicionar(aval);
			} else {
				validaAval.valida(false);
				repositorio.atualizar(aval);
			}
			System.out
					.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX Depois XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			atualizaView();
		} catch (AvaliacaoInvalidaException exAval) {
			System.out.println("Excdfdd: " + exAval.toString());
			listaAvals = repositorio.listar(Avaliacao.class);
			validaAval.validaExceptionAval(exAval);
		} catch (Exception ex) {
			validaAval.validaException(ex);
		}

	}

	public void remover(Avaliacao aval) {
		try {
			validaAval.setAval(aval);
			validaAval.valida();
			repositorio.remover(aval);
			atualizaView();
		} catch (AvaliacaoInvalidaException exAval) {
			System.out.println("Excdfdd: " + exAval.toString());
			validaAval.validaExceptionAval(exAval);
		} catch (PersistenceException perex) {
			validaAval.validaException(perex);
		} catch (Exception ex) {
			validaAval.validaException(ex);
		}

	}

	public void editar() {
		System.out.println("Turma:" + aval.getTurma());
		System.out.println("Quest:" + aval.getQuestionario());
		this.setSelTurma(aval.getTurma());
		this.setSelQuestionario(aval.getQuestionario());
	}

}
