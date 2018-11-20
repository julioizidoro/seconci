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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "funcao")
public class Funcao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncao")
    private Integer idfuncao;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcao")
    private List<Usuario> usuarioList;

    public Funcao() {
    }

    public Funcao(Integer idfuncao) {
        this.idfuncao = idfuncao;
    }

    public Integer getIdfuncao() {
        return idfuncao;
    }

    public void setIdfuncao(Integer idfuncao) {
        this.idfuncao = idfuncao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncao != null ? idfuncao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
        if ((this.idfuncao == null && other.idfuncao != null) || (this.idfuncao != null && !this.idfuncao.equals(other.idfuncao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Funcao[ idfuncao=" + idfuncao + " ]";
    }
    
}
