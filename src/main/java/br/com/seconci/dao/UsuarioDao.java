package br.com.seconci.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.seconci.model.Usuario;


public class UsuarioDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	
	
	public Usuario getUsuario(String sql) {
		Query q = manager.createQuery(sql); 
        Usuario usuario = null;
        if (q.getResultList().size() > 0) {
        		usuario = (Usuario) q.getResultList().get(0);
        } 
        return usuario;
		
	}

}
