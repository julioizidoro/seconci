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
@Table(name = "normatitulo")
@NamedQueries({
    @NamedQuery(name = "Normatitulo.findAll", query = "SELECT n FROM Normatitulo n")})
public class Normatitulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnormatitulo")
    private Integer idnormatitulo;
    @Size(max = 50)
    @Column(name = "titulo")
    private String titulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "normatitulo")
    private List<Normaitem> normaitemList;

    public Normatitulo() {
    }

    public Normatitulo(Integer idnormatitulo) {
        this.idnormatitulo = idnormatitulo;
    }

    public Integer getIdnormatitulo() {
        return idnormatitulo;
    }

    public void setIdnormatitulo(Integer idnormatitulo) {
        this.idnormatitulo = idnormatitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Normaitem> getNormaitemList() {
        return normaitemList;
    }

    public void setNormaitemList(List<Normaitem> normaitemList) {
        this.normaitemList = normaitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnormatitulo != null ? idnormatitulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Normatitulo)) {
            return false;
        }
        Normatitulo other = (Normatitulo) object;
        if ((this.idnormatitulo == null && other.idnormatitulo != null) || (this.idnormatitulo != null && !this.idnormatitulo.equals(other.idnormatitulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getTitulo();
    }
    
}
