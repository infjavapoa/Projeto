package br.edu.infnet.projeto.webapp.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.usuario.Usuario;

@ManagedBean
@ViewScoped
public class LoginMB {
	@EJB
    private Repositorio repositorio;
    private String nomeUsuario;
    private String senha;
    private Usuario usuario;
    
    @PostConstruct
    public void init() {
    	if (FacesContext.getCurrentInstance().getExternalContext().getRemoteUser() != null) {
	    	Map<String, Object> param = new HashMap<String, Object>();
			param.put("email", FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
	    	usuario = repositorio.obterWithNamedQuery(Usuario.class, "Usuario.pesquisarPorEmail", param);
    	}
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String login(){	
        try {
        	HttpServletRequest request = (HttpServletRequest) FacesContext.
                getCurrentInstance().getExternalContext().getRequest();
            request.login(this.nomeUsuario, this.senha);
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            ec.redirect(ec.getRequestContextPath());
        } catch (ServletException e) {
        	FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Autenticação falhou. Tente novamente."));
        } catch (IOException e) {
			e.printStackTrace();
		}

        return null;
	}

	public String logOut(){	
		HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
		if (session != null) {
			session.invalidate();  
		} 
		return "/login.xhtml?faces-redirect=true";
	}
	
	public String getMenuPadrao(){
		return "/templateAdmin.xhtml";
	}
}
