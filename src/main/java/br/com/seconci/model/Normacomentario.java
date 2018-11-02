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
@Table(name = "normacomentario")
@NamedQueries({
    @NamedQuery(name = "Normacomentario.findAll", query = "SELECT n FROM Normacomentario n")})
public class Normacomentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnormacomentario")
    private Integer idnormacomentario;
    @Lob
    @Size(max = 16777215)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "normaitem_idnormaitem", referencedColumnName = "idnormaitem")
    @ManyToOne(optional = false)
    private Normaitem normaitem;

    public Normacomentario() {
    }

    public Normacomentario(Integer idnormacomentario) {
        this.idnormacomentario = idnormacomentario;
    }

    public Integer getIdnormacomentario() {
        return idnormacomentario;
    }

    public void setIdnormacomentario(Integer idnormacomentario) {
        this.idnormacomentario = idnormacomentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
        hash += (idnormacomentario != null ? idnormacomentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Normacomentario)) {
            return false;
        }
        Normacomentario other = (Normacomentario) object;
        if ((this.idnormacomentario == null && other.idnormacomentario != null) || (this.idnormacomentario != null && !this.idnormacomentario.equals(other.idnormacomentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Normacomentario[ idnormacomentario=" + idnormacomentario + " ]";
    }
    
}
