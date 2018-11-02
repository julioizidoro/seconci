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
@Table(name = "relatorioitemcomentariofoto")
@NamedQueries({
    @NamedQuery(name = "Relatorioitemcomentariofoto.findAll", query = "SELECT r FROM Relatorioitemcomentariofoto r")})
public class Relatorioitemcomentariofoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelatorioitemcomentariofoto")
    private Integer idrelatorioitemcomentariofoto;
    @Size(max = 200)
    @Column(name = "nomrarquivo")
    private String nomrarquivo;
    @Column(name = "selecionado")
    private boolean selecionado;
    @JoinColumn(name = "relatorioitem_idrelatorioitem", referencedColumnName = "idrelatorioitem")
    @ManyToOne(optional = false)
    private Relatorioitem relatorioitem;

    public Relatorioitemcomentariofoto() {
    }

    public Relatorioitemcomentariofoto(Integer idrelatorioitemcomentariofoto) {
        this.idrelatorioitemcomentariofoto = idrelatorioitemcomentariofoto;
    }

    public Integer getIdrelatorioitemcomentariofoto() {
        return idrelatorioitemcomentariofoto;
    }

    public void setIdrelatorioitemcomentariofoto(Integer idrelatorioitemcomentariofoto) {
        this.idrelatorioitemcomentariofoto = idrelatorioitemcomentariofoto;
    }

    public String getNomrarquivo() {
        return nomrarquivo;
    }

    public void setNomrarquivo(String nomrarquivo) {
        this.nomrarquivo = nomrarquivo;
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
        hash += (idrelatorioitemcomentariofoto != null ? idrelatorioitemcomentariofoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Relatorioitemcomentariofoto)) {
            return false;
        }
        Relatorioitemcomentariofoto other = (Relatorioitemcomentariofoto) object;
        if ((this.idrelatorioitemcomentariofoto == null && other.idrelatorioitemcomentariofoto != null) || (this.idrelatorioitemcomentariofoto != null && !this.idrelatorioitemcomentariofoto.equals(other.idrelatorioitemcomentariofoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Relatorioitemcomentariofoto[ idrelatorioitemcomentariofoto=" + idrelatorioitemcomentariofoto + " ]";
    }
    
}
