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
@Table(name = "normacomentariofoto")
@NamedQueries({
    @NamedQuery(name = "Normacomentariofoto.findAll", query = "SELECT n FROM Normacomentariofoto n")})
public class Normacomentariofoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnormacomentariofoto")
    private Integer idnormacomentariofoto;
    @Size(max = 200)
    @Column(name = "nomearquivo")
    private String nomearquivo;
    @JoinColumn(name = "normaitem_idnormaitem", referencedColumnName = "idnormaitem")
    @ManyToOne(optional = false)
    private Normaitem normaitem;

    public Normacomentariofoto() {
    }

    public Normacomentariofoto(Integer idnormacomentariofoto) {
        this.idnormacomentariofoto = idnormacomentariofoto;
    }

    public Integer getIdnormacomentariofoto() {
        return idnormacomentariofoto;
    }

    public void setIdnormacomentariofoto(Integer idnormacomentariofoto) {
        this.idnormacomentariofoto = idnormacomentariofoto;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
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
        hash += (idnormacomentariofoto != null ? idnormacomentariofoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Normacomentariofoto)) {
            return false;
        }
        Normacomentariofoto other = (Normacomentariofoto) object;
        if ((this.idnormacomentariofoto == null && other.idnormacomentariofoto != null) || (this.idnormacomentariofoto != null && !this.idnormacomentariofoto.equals(other.idnormacomentariofoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Normacomentariofoto[ idnormacomentariofoto=" + idnormacomentariofoto + " ]";
    }
    
}
