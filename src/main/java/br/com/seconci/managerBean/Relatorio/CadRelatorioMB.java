package br.com.seconci.managerBean.Relatorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;

import br.com.seconci.dao.NormaItemDao;
import br.com.seconci.dao.NormaTituloDao;
import br.com.seconci.dao.RelatorioDao;
import br.com.seconci.dao.RelatorioTipoDao;
import br.com.seconci.model.Normaitem;
import br.com.seconci.model.Normatitulo;
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
	private NormaItemDao normaItemDao;
	@Inject
	private NormaTituloDao normaTituloDao;
	@Inject
	private RelatorioTipoDao relatorioTipoDao;
	private Relatorio relatorio;
	private List<Relatoriotipo> listaTipo;
	private Relatoriotipo relatorioTipo;
	
	
	private List<Normaitem> listaNormaItem;
	private List<Normatitulo> listaNormaTitulo;


	
	
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
		listarNormaItem();
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
	
	
	
	public List<Normaitem> getListaNormaItem() {
		return listaNormaItem;
	}


	public void setListaNormaItem(List<Normaitem> listaNormaItem) {
		this.listaNormaItem = listaNormaItem;
	}

	public List<Normatitulo> getListaNormaTitulo() {
		return listaNormaTitulo;
	}


	public void setListaNormaTitulo(List<Normatitulo> listaNormaTitulo) {
		this.listaNormaTitulo = listaNormaTitulo;
	}
	
	public String cadRelatorioItemNorma(Normaitem normaItem) {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("normaItem", normaItem);
		session.setAttribute("relatorio", relatorio);
		return "cadRelatorioItemNorma";
	}
	
	public String listarNormaItem() {
		String sql = "SELECT n FROM Normaitem n order by n.nome";
    	listaNormaItem = normaItemDao.listar(sql);
        if (listaNormaItem == null) {
        	listaNormaItem = new ArrayList<Normaitem>();
        }
        sql = "SELECT n FROM Normatitulo n order by n.titulo";
        listaNormaTitulo = normaTituloDao.listar(sql);
        if (listaNormaTitulo == null) {
        	listaNormaTitulo  = new ArrayList<Normatitulo>();
        }
        return null;
	}
	
	

}
