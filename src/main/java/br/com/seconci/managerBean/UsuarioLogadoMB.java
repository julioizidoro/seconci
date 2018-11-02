package br.com.seconci.managerBean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.seconci.dao.UsuarioDao;
import br.com.seconci.model.Usuario;
import br.com.seconci.util.Criptografia;
import br.com.seconci.util.Mensagem;



/**
 *
 * @author julioizidoro
 */
@Named
@SessionScoped
public class UsuarioLogadoMB implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDao usuarioDao;
	private String senha;
    private String login;
    private Usuario usuario;
    private boolean logar;
    
    
    
    @PostConstruct
    public void init() {
    	setLogin("jizidoro");
    	setSenha("1");
    	usuario = new Usuario();
    }
    
    
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public boolean isLogar() {
		return logar;
	}


	public void setLogar(boolean logar) {
		this.logar = logar;
	}


	public boolean validarUsuario() throws SQLException { 
		usuario = new Usuario();  
		logar = false;
		if ((login == null) && (senha == null)) {
			Mensagem.lancarMensagemInfo("Atenção", "Acesso negado");
			return logar;
		} else {
			String senha = "";
			try {
				Criptografia criptografia = new Criptografia();
				senha = criptografia.encript(this.senha);
				this.senha = "";
			} catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(UsuarioLogadoMB.class.getName()).log(Level.SEVERE, null, ex);
			} 
			String sql = "SELECT u FROM Usuario u where u.login='" + login + "' and u.senha='" + senha + "'";
			usuario = usuarioDao.getUsuario(sql);
			if (usuario == null) {
				Mensagem.lancarMensagemInfo("Atenção", "Acesso negado");
				return logar;
			} else if (!usuario.isSituacao()) {
				Mensagem.lancarMensagemInfo("Atenção", "Acesso negado");
				return logar;
			} else {
					return logar = true;
				}
			}
	}
	
	public String logar() {
		if (logar) {  
			return "dashboard";
		} else
			return "";
	}
}