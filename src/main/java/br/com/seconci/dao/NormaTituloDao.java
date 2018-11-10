package br.com.seconci.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.seconci.model.Normatitulo;

public class NormaTituloDao implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Normatitulo> listar(String sql){
		Query q = manager.createQuery(sql); 
        List<Normatitulo> lista = null;
        if (q.getResultList().size() > 0) {
        		lista  =   q.getResultList();
        } 
        return lista;
	}

}
