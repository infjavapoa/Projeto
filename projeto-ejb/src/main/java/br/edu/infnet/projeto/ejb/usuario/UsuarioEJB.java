package br.edu.infnet.projeto.ejb.usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;






import br.edu.infnet.projeto.ejb.core.InfnetException;
import br.edu.infnet.projeto.ejb.core.Repositorio;

@Stateless
public class UsuarioEJB {
	
	@EJB
	Repositorio repositorio;

	public void salvarUsuario(Usuario usuario) throws InfnetException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("email", usuario.getEmail());
		List<Usuario> usuarios = repositorio.listarWithNamedQuery(Usuario.class, "Usuario.pesquisarPorEmail", param);
		if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) 
			throw new InfnetException("Favor, informar um Login para o Usuário!");
		else {
			
			if ((usuario.getNome() == null || usuario.getNome().isEmpty()) ||
				(usuario.getSenha() == null || usuario.getSenha().isEmpty()	))
			{
				System.out.println("lista:" + usuarios.size() + " dfd: " + usuario.getEmail());
				throw new InfnetException("Você precisa informar todos os campos para cadastrar um Usuário!");
			}			
			
			
			if (usuarios.size() > 0 && usuarios.get(0).getEmail().equals(usuario.getEmail())){
				
				throw new InfnetException("Código de login não disponível!");
			}
			else {
				try{
					usuario.setPapel("administrador");
					if (!(usuarios.size() > 0))
						repositorio.adicionar(usuario);
					else
						repositorio.atualizar(usuario);
				} catch (PersistenceException perex){			
					throw new InfnetException("Favor, informar um Login para o Usuário!");
				} catch (Exception ex) {
					throw new InfnetException(ex.getMessage());			
				}
				
				
			}
		}
	}
	
	public void alterarSenhaUsuario(Usuario usuario) throws InfnetException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("email", usuario.getEmail());
		List<Usuario> usuarios = repositorio.listarWithNamedQuery(Usuario.class, "Usuario.pesquisarPorEmail", param);		
			
			if (usuarios.size() > 0 && usuarios.get(0).getEmail().equals(usuario.getEmail())){				
				try{					
					repositorio.atualizar(usuario);
					System.out.println("Gravado:" + usuario.getSenha());
				} catch (PersistenceException perex){			
					throw new InfnetException("Erro na atualização da senha!");
				} catch (Exception ex) {
					throw new InfnetException(ex.getMessage());			
				}
			} else {
				throw new InfnetException("Não foi possivel identificar o usuário no banco de dados!");
			}
			
		
	}
	
	public void removerUsuario(Usuario usuario) throws InfnetException {		
		try{
			;
			if (FacesContext.getCurrentInstance().getExternalContext().getRemoteUser() != null &&
				!FacesContext.getCurrentInstance().getExternalContext().getRemoteUser().isEmpty()) {
				if (!usuario.getEmail().equals(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser()))
					repositorio.remover(usuario);
				else 
					throw new InfnetException("Não é possivel excluir o usuário logado!");
			} else {
				throw new InfnetException("Não foi possivel identificar o usuário logado!");
			}
			
		} catch (PersistenceException perex){			
			throw new InfnetException("Favor, informar um Login para o Usuário!");			
		} catch (Exception ex) {
			throw new InfnetException(ex.getMessage());			
		}		
	}
	
	
}
