/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seconci.managerBean.Relatorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.seconci.dao.RelatorioDao;

import br.com.seconci.model.Relatorio;

/**
 *
 * @author julioizidoro
 */

@Named
@ViewScoped
public class ConsultaRelatorioMB implements  Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RelatorioDao relatorioDao;
	//@Inject
   // private UsuarioLogadoMB usuarioLogadoMB;
    private List<Relatorio> listaRelatorio;
    private String empresa;
    
    @PostConstruct
    public void init(){
    	String sql = "SELECT r FROM Relatorio r order by r.empresa";
        listaRelatorio = relatorioDao.listar(sql);
        if (listaRelatorio == null) {
        	listaRelatorio = new ArrayList<Relatorio>();
        }
    }

   
    public List<Relatorio> getListaRelatorio() {
        return listaRelatorio;
    }

    public void setListaRelatorio(List<Relatorio> listaRelatorio) {
        this.listaRelatorio = listaRelatorio;
    }
    
    public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String pesquisar(){
        return null;
    }
    
    public String limpar(){
        return null;
    }
    
    public String editar(Relatorio relatorio){
        return null;
    }
    
    public String novo() {
    	return "cadastroRelatorio";
    }
    
  
    
    
    
    
    
}
