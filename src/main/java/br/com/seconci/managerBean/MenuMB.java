package br.com.seconci.managerBean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named
@ViewScoped
public class MenuMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public String consultaRelatorios() {
		return "consultaRelatorios";
	}
	
	public String sair() {
		return "index";
	}

}
