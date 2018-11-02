package br.com.seconci.managerBean.Relatorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.seconci.dao.RelatorioDao;
import br.com.seconci.dao.RelatorioTipoDao;
import br.com.seconci.model.Relatorio;
import br.com.seconci.model.Relatoriotipo;

@Named
@ViewScoped
public class CadRelatorioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RelatorioDao relatorioDao;
	@Inject
	private RelatorioTipoDao relatorioTipoDao;
	private Relatorio relatorio;
	private List<Relatoriotipo> listaTipo;
	private Relatoriotipo relatorioTipo;
	
	
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		relatorio = (Relatorio) session.getAttribute("relatorio");
		if (relatorio==null) {
			relatorio = new Relatorio();
			
		}
		listaTipo = relatorioTipoDao.listar();
		if (listaTipo==null) {
			listaTipo = new ArrayList<Relatoriotipo>();
		}
	}


	public Relatorio getRelatorio() {
		return relatorio;
	}


	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}


	public List<Relatoriotipo> getListaTipo() {
		return listaTipo;
	}


	public void setListaTipo(List<Relatoriotipo> listaTipo) {
		this.listaTipo = listaTipo;
	}


	public Relatoriotipo getRelatorioTipo() {
		return relatorioTipo;
	}


	public void setRelatorioTipo(Relatoriotipo relatorioTipo) {
		this.relatorioTipo = relatorioTipo;
	}
	
	public String cadRelatorioItemNorma() {
		//return "cadRelatorioItemNorma"; 
		return "cadRelatorioItemNorma";
	}


	

}
