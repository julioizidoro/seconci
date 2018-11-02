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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "normadescricao")
@NamedQueries({
    @NamedQuery(name = "Normadescricao.findAll", query = "SELECT n FROM Normadescricao n")})
public class Normadescricao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnormadescricao")
    private Integer idnormadescricao;
    @Lob
    @Size(max = 16777215)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "normaitem_idnormaitem", referencedColumnName = "idnormaitem")
    @ManyToOne(optional = false)
    private Normaitem normaitem;

    public Normadescricao() {
    }

    public Normadescricao(Integer idnormadescricao) {
        this.idnormadescricao = idnormadescricao;
    }

    public Integer getIdnormadescricao() {
        return idnormadescricao;
    }

    public void setIdnormadescricao(Integer idnormadescricao) {
        this.idnormadescricao = idnormadescricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Normaitem getNormaitem() {
        return normaitem;
    }

    public void setNormaitem(Normaitem normaitem) {
        this.normaitem = normaitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnormadescricao != null ? idnormadescricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Normadescricao)) {
            return false;
        }
        Normadescricao other = (Normadescricao) object;
        if ((this.idnormadescricao == null && other.idnormadescricao != null) || (this.idnormadescricao != null && !this.idnormadescricao.equals(other.idnormadescricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Normadescricao[ idnormadescricao=" + idnormadescricao + " ]";
    }
    
}
