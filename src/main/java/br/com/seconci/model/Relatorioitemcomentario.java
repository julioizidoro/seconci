/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seconci.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "relatorioitemcomentario")
public class Relatorioitemcomentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelatorioitemcomentario")
    private Integer idrelatorioitemcomentario;
    @Lob
    @Size(max = 16777215)
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "selecionado")
    private boolean selecionado;
    @Column(name = "novo")
    private boolean novo;
    @JoinColumn(name = "relatorioitem_idrelatorioitem", referencedColumnName = "idrelatorioitem")
    @ManyToOne(optional = false)
    private Relatorioitem relatorioitem;
    

    public Relatorioitemcomentario() {
    }

    public Relatorioitemcomentario(Integer idrelatorioitemcomentario) {
        this.idrelatorioitemcomentario = idrelatorioitemcomentario;
    }

    public Integer getIdrelatorioitemcomentario() {
        return idrelatorioitemcomentario;
    }

    public void setIdrelatorioitemcomentario(Integer idrelatorioitemcomentario) {
        this.idrelatorioitemcomentario = idrelatorioitemcomentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

   

    public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public Relatorioitem getRelatorioitem() {
        return relatorioitem;
    }

    public void setRelatorioitem(Relatorioitem relatorioitem) {
        this.relatorioitem = relatorioitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelatorioitemcomentario != null ? idrelatorioitemcomentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Relatorioitemcomentario)) {
            return false;
        }
        Relatorioitemcomentario other = (Relatorioitemcomentario) object;
        if ((this.idrelatorioitemcomentario == null && other.idrelatorioitemcomentario != null) || (this.idrelatorioitemcomentario != null && !this.idrelatorioitemcomentario.equals(other.idrelatorioitemcomentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Relatorioitemcomentario[ idrelatorioitemcomentario=" + idrelatorioitemcomentario + " ]";
    }
    
}
