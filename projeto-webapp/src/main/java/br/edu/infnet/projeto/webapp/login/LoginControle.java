package br.edu.infnet.projeto.webapp.login;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

//import br.com.licker.kyron.entidade.Login;
//import br.com.licker.kyron.entidade.Usuario;
//import br.com.licker.kyron.negocio.LoginNegocio;

@ManagedBean(name="loginControle")
@ViewScoped
public class LoginControle {
	
	//private Login login;
	private boolean login;
	//private LoginNegocio negocio;
	
	public LoginControle() {
		//super();
		//login = new Login();
		//usuarioLogado();
		//negocio = new LoginNegocio();
	}
	
	public boolean getLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}
	
	public String validaAcesso(){
		/*if (negocio.validarAcesso(login)){
	        HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
			Usuario usuario = (Usuario) session.getAttribute("usuarLog");
			if (usuario != null){
								if (usuario.getAdmin() == true || usuario.getDesenv() == true ){
					return "/protegido/adm/kyronadm.xhtml?faces-redirect=true";
				} else {
					return "/protegido/kyronfono.xhtml?faces-redirect=true";
				}
				
				return "/protegido/kyronAbout.xhtml?faces-redirect=true";
								
				//return "/publico/skeleton.xhtml?faces-redirect=true";
			}
			else{
				FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Usu�rio ou Senha Inv�lido"));
				return "";
			}
			
		}
		else{
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Usu�rio ou Senha Inv�lido"));
			return "";
		}*/
		return "";
	}
	
	public String pesquisa(){
		/*HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
		Usuario usuario = (Usuario) session.getAttribute("usuarLog");
		
		if (usuario != null && (usuario.getAvalia() == null || usuario.getAvalia() != true)){ 
			return "/publico/avalia.xhtml?faces-redirect=true";		
		} else {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Voc� j� respondeu a Pesquisa! Obrigado."));
			return "";
		}*/
		return "";
	}
	
	public void usuarioLogado(){
		/*
		try {
			HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
			Usuario usuario = (Usuario) session.getAttribute("usuarLog");
			if (usuario != null){
				this.login = new Login(usuario.getCodigo(), usuario.getSenha(), usuario.getNome());
			}
		}
		catch (Exception e) {
				e.printStackTrace();
		}*/
	}
	
	@SuppressWarnings("unused")
	public String getMenuPadrao(){
		/*
		HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
		Usuario usuario = (Usuario) session.getAttribute("usuarLog");
		
		if (session != null) {
			if (usuario.getAdmin() == true || usuario.getDesenv() == true){
				return "/protegido/adm/templatemenuadm.xhtml";
			} else {
				return "/protegido/templatemenufono.xhtml";
			}  
		} else {				
			session.invalidate();
			return "/publico/kyron.xhtml?faces-redirect=true";
		}*/
		return "/templateAdmin.xhtml";
	}
	
	public String montaSkeleton(Integer pJan){
		/*
		HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
		Usuario usuario = (Usuario) session.getAttribute("usuarLog");
		if (session != null) {
			//session.invalidate();  
		} 
		switch (pJan){
			case 1: 	
				if (usuario.getAdmin() == true || usuario.getDesenv() == true) 
					 {return "/protegido/adm/templatemenuadm.xhtml";} 
				else {return "/protegido/templatemenufono.xhtml?faces-redirect=true";}
			case 2: 	
				if (usuario.getAdmin() == true || usuario.getDesenv() == true) 
					 {return "/protegido/adm/templatemenuadm.xhtml?faces-redirect=true";} 
				else {return "/protegido/templatemenufono.xhtml?faces-redirect=true";}
			case 3: 	return "/publico/kyron.xhtml?faces-redirect=true"; 
			case 4: 	
				if (usuario.getAdmin() == true || usuario.getDesenv() == true) 
					 {return "/protegido/adm/templatemenuadm.xhtml";} 
				else {return "/protegido/templatemenufono.xhtml";}
			default: 	return "/publico/kyron.xhtml?faces-redirect=true";
				 
		}
		*/
		return "";
	}
	
	public String logOut(){
		/*
		HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
		if (session != null) {
			session.invalidate();  
		} 
		return "/publico/kyron.xhtml?faces-redirect=true";*/
		return "";
	}

}
