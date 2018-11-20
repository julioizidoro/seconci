package br.com.seconci.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.seconci.conexao.Transactional;
import br.com.seconci.model.Relatorioitem;

public class RelatorioItemDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	@Transactional
	public Relatorioitem salvar(Relatorioitem relatorioItem) {
		relatorioItem = manager.merge(relatorioItem);
		return relatorioItem;
	}

}
