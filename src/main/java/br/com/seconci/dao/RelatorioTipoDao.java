package br.com.seconci.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.seconci.model.Relatoriotipo;

public class RelatorioTipoDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Relatoriotipo> listar() {
		String sql = "SELECT t FROM Relatoriotipo t order by t.titulo";
		Query q = manager.createQuery(sql); 
       List<Relatoriotipo> lista = null;
        if (q.getResultList().size() > 0) {
        		lista =  q.getResultList();
        } 
        return lista;
		
	}
	
	

}
