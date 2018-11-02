/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seconci.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "normaitem")
@NamedQueries({
    @NamedQuery(name = "Normaitem.findAll", query = "SELECT n FROM Normaitem n")})
public class Normaitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnormaitem")
    private Integer idnormaitem;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "itemnorma")
    private String itemnorma;
    @JoinColumn(name = "normatitulo_idnormatitulo", referencedColumnName = "idnormatitulo")
    @ManyToOne(optional = false)
    private Normatitulo normatitulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "normaitem")
    private List<Normacomentario> normacomentarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "normaitem")
    private List<Normacomentariofoto> normacomentariofotoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "normaitem")
    private List<Normadescricao> normadescricaoList;

    public Normaitem() {
    }

    public Normaitem(Integer idnormaitem) {
        this.idnormaitem = idnormaitem;
    }

    public Integer getIdnormaitem() {
        return idnormaitem;
    }

    public void setIdnormaitem(Integer idnormaitem) {
        this.idnormaitem = idnormaitem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getItemnorma() {
        return itemnorma;
    }

    public void setItemnorma(String itemnorma) {
        this.itemnorma = itemnorma;
    }

    public Normatitulo getNormatitulo() {
        return normatitulo;
    }

    public void setNormatitulo(Normatitulo normatitulo) {
        this.normatitulo = normatitulo;
    }

    public List<Normacomentario> getNormacomentarioList() {
        return normacomentarioList;
    }

    public void setNormacomentarioList(List<Normacomentario> normacomentarioList) {
        this.normacomentarioList = normacomentarioList;
    }

    public List<Normacomentariofoto> getNormacomentariofotoList() {
        return normacomentariofotoList;
    }

    public void setNormacomentariofotoList(List<Normacomentariofoto> normacomentariofotoList) {
        this.normacomentariofotoList = normacomentariofotoList;
    }

    public List<Normadescricao> getNormadescricaoList() {
        return normadescricaoList;
    }

    public void setNormadescricaoList(List<Normadescricao> normadescricaoList) {
        this.normadescricaoList = normadescricaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnormaitem != null ? idnormaitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Normaitem)) {
            return false;
        }
        Normaitem other = (Normaitem) object;
        if ((this.idnormaitem == null && other.idnormaitem != null) || (this.idnormaitem != null && !this.idnormaitem.equals(other.idnormaitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Normaitem[ idnormaitem=" + idnormaitem + " ]";
    }
    
}
