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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "relatoriotipo")
public class Relatoriotipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelatoriotipo")
    private Integer idrelatoriotipo;
    @Size(max = 200)
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Size(max = 16777215)
    @Column(name = "textoinicial")
    private String textoinicial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relatoriotipo")
    private List<Relatorio> relatorioList;

    public Relatoriotipo() {
    }

    public Relatoriotipo(Integer idrelatoriotipo) {
        this.idrelatoriotipo = idrelatoriotipo;
    }

    public Integer getIdrelatoriotipo() {
        return idrelatoriotipo;
    }

    public void setIdrelatoriotipo(Integer idrelatoriotipo) {
        this.idrelatoriotipo = idrelatoriotipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTextoinicial() {
        return textoinicial;
    }

    public void setTextoinicial(String textoinicial) {
        this.textoinicial = textoinicial;
    }

    public List<Relatorio> getRelatorioList() {
        return relatorioList;
    }

    public void setRelatorioList(List<Relatorio> relatorioList) {
        this.relatorioList = relatorioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelatoriotipo != null ? idrelatoriotipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Relatoriotipo)) {
            return false;
        }
        Relatoriotipo other = (Relatoriotipo) object;
        if ((this.idrelatoriotipo == null && other.idrelatoriotipo != null) || (this.idrelatoriotipo != null && !this.idrelatoriotipo.equals(other.idrelatoriotipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Relatoriotipo[ idrelatoriotipo=" + idrelatoriotipo + " ]";
    }
    
}
