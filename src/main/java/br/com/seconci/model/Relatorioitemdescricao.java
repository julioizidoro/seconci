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
@Table(name = "relatorioitemdescricao")
public class Relatorioitemdescricao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelatorioitemdescricao")
    private Integer idrelatorioitemdescricao;
    @Lob
    @Size(max = 16777215)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "selecionado")
    private boolean selecionado;
    @JoinColumn(name = "relatorioitem_idrelatorioitem", referencedColumnName = "idrelatorioitem")
    @ManyToOne(optional = false)
    private Relatorioitem relatorioitem;

    public Relatorioitemdescricao() {
    }

    public Relatorioitemdescricao(Integer idrelatorioitemdescricao) {
        this.idrelatorioitemdescricao = idrelatorioitemdescricao;
    }

    public Integer getIdrelatorioitemdescricao() {
        return idrelatorioitemdescricao;
    }

    public void setIdrelatorioitemdescricao(Integer idrelatorioitemdescricao) {
        this.idrelatorioitemdescricao = idrelatorioitemdescricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    

    public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
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
        hash += (idrelatorioitemdescricao != null ? idrelatorioitemdescricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Relatorioitemdescricao)) {
            return false;
        }
        Relatorioitemdescricao other = (Relatorioitemdescricao) object;
        if ((this.idrelatorioitemdescricao == null && other.idrelatorioitemdescricao != null) || (this.idrelatorioitemdescricao != null && !this.idrelatorioitemdescricao.equals(other.idrelatorioitemdescricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Relatorioitemdescricao[ idrelatorioitemdescricao=" + idrelatorioitemdescricao + " ]";
    }
    
}
