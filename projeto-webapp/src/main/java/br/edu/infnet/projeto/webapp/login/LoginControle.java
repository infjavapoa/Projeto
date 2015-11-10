package br.edu.infnet.projeto.webapp.login;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.edu.infnet.projeto.ejb.core.Repositorio;
import br.edu.infnet.projeto.ejb.login.Login;
import br.edu.infnet.projeto.ejb.usuario.Usuario;
//import br.com.licker.kyron.negocio.LoginNegocio;

@ManagedBean(name="loginControle")
@ViewScoped
public class LoginControle {
	
	private Login login;
	//private LoginNegocio negocio;
	@EJB
	private Repositorio repositorio;
	private List<Usuario> listaUsuario;
			
	public LoginControle() {
		super();
		login = new Login();
		usuarioLogado();
		//negocio = new LoginNegocio();
	}
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public boolean validaUsuario(Login login){
		
		listaUsuario = repositorio.listar(Usuario.class); 
		
		Iterator<Usuario> uIt = listaUsuario.iterator(); 
		while (uIt.hasNext()){ 
			Usuario usu = uIt.next();
			System.out.println("Dai..: " + usu.getEmail() + "-" + usu.getSenha()+ "-" + login.getSenha() );
			if (login.getCodigo().equals(usu.getEmail()) && login.getSenha().equals(usu.getSenha())){
				System.out.println("Usuário Autenticado...");
	    		HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
				session.setAttribute( "usuarLog", usu ); 
				return true;
			}
		} 

		return false;
		
	}
	
	public String validaAcesso(){
		
		if (validaUsuario(login)){
	        HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
			Usuario usuario = (Usuario) session.getAttribute("usuarLog");
			if (usuario != null){
				return "/index.xhtml?faces-redirect=true";
								
				//return "/publico/skeleton.xhtml?faces-redirect=true";
			}
			else{
				FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Usuário ou Senha Inválidos"));
				return "";
			}
			
		}
		else{
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Usuário ou Senha Inválidos"));
			return "";
		}
		
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
		
		try {
			HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
			Usuario usuario = (Usuario) session.getAttribute("usuarLog");
			if (usuario != null){
				this.login = new Login(usuario.getEmail(), usuario.getSenha(), usuario.getNome());
			}
		}
		catch (Exception e) {
				e.printStackTrace();
		}
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
		
		HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
		if (session != null) {
			session.invalidate();  
		} 
		return "/login.xhtml?faces-redirect=true";
		
	}

}
