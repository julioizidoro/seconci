package br.com.seconci.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.seconci.conexao.Transactional;
import br.com.seconci.model.Relatorio;

public class RelatorioDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Relatorio> listar(String sql) {
		Query q = manager.createQuery(sql); 
       List<Relatorio> lista = null;
        if (q.getResultList().size() > 0) {
        		lista =  q.getResultList();
        } 
        return lista;
		
	}
	
	@Transactional
	public Relatorio salvar(Relatorio relatorio) {
		relatorio = manager.merge(relatorio); 
        return relatorio;
		
	}

}
