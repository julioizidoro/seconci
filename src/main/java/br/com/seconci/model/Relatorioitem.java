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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;



/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "relatorioitem")
public class Relatorioitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelatorioitem")
    private Integer idrelatorioitem;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "itemnorma")
    private String itemnorma;
    @JoinColumn(name = "relatorio_idrelatorio", referencedColumnName = "idrelatorio")
    @ManyToOne(optional = false)
    private Relatorio relatorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relatorioitem")
    private List<Relatorioitemcomentariofoto> relatorioitemcomentariofotoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relatorioitem")
    private List<Relatorioitemcomentario> relatorioitemcomentarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relatorioitem")
    private List<Relatorioitemdescricao> relatorioitemdescricaoList;

    public Relatorioitem() {
    }

    public Relatorioitem(Integer idrelatorioitem) {
        this.idrelatorioitem = idrelatorioitem;
    }

    public Integer getIdrelatorioitem() {
        return idrelatorioitem;
    }

    public void setIdrelatorioitem(Integer idrelatorioitem) {
        this.idrelatorioitem = idrelatorioitem;
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

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public List<Relatorioitemcomentariofoto> getRelatorioitemcomentariofotoList() {
        return relatorioitemcomentariofotoList;
    }

    public void setRelatorioitemcomentariofotoList(List<Relatorioitemcomentariofoto> relatorioitemcomentariofotoList) {
        this.relatorioitemcomentariofotoList = relatorioitemcomentariofotoList;
    }

    public List<Relatorioitemcomentario> getRelatorioitemcomentarioList() {
        return relatorioitemcomentarioList;
    }

    public void setRelatorioitemcomentarioList(List<Relatorioitemcomentario> relatorioitemcomentarioList) {
        this.relatorioitemcomentarioList = relatorioitemcomentarioList;
    }

    public List<Relatorioitemdescricao> getRelatorioitemdescricaoList() {
        return relatorioitemdescricaoList;
    }

    public void setRelatorioitemdescricaoList(List<Relatorioitemdescricao> relatorioitemdescricaoList) {
        this.relatorioitemdescricaoList = relatorioitemdescricaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelatorioitem != null ? idrelatorioitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Relatorioitem)) {
            return false;
        }
        Relatorioitem other = (Relatorioitem) object;
        if ((this.idrelatorioitem == null && other.idrelatorioitem != null) || (this.idrelatorioitem != null && !this.idrelatorioitem.equals(other.idrelatorioitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Relatorioitem[ idrelatorioitem=" + idrelatorioitem + " ]";
    }
    
}
