package br.com.seconci.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.seconci.model.Normaitem;

public class NormaItemDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	public Normaitem pesquisar(int id) {
		Query q = manager.createQuery("SELECT n FROM Normaitem n where n.idnormaitem=" + id); 
        Normaitem norma = null;
        if (q.getResultList().size() > 0) {
        		norma  =  (Normaitem) q.getResultList().get(0);
        } 
        return norma;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Normaitem> listar(String sql){
		Query q = manager.createQuery(sql); 
        List<Normaitem> lista = null;
        if (q.getResultList().size() > 0) {
        		lista  =   q.getResultList();
        } 
        return lista;
	}

}
