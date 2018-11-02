/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.seconci.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author julioizidoro
 */
@Entity
@Table(name = "relatorio")
@NamedQueries({
    @NamedQuery(name = "Relatorio.findAll", query = "SELECT r FROM Relatorio r")})
public class Relatorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelatorio")
    private Integer idrelatorio;
    @Size(max = 100)
    @Column(name = "empresa")
    private String empresa;
    @Size(max = 100)
    @Column(name = "canteiroobras")
    private String canteiroobras;
    @Size(max = 50)
    @Column(name = "fase")
    private String fase;
    @Size(max = 100)
    @Column(name = "numerotrabalhadores")
    private String numerotrabalhadores;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 100)
    @Column(name = "empresaacopanhante")
    private String empresaacopanhante;
    @Size(max = 100)
    @Column(name = "acompanhante")
    private String acompanhante;
    @Size(max = 100)
    @Column(name = "funcao")
    private String funcao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relatorio")
    private List<Relatorioitem> relatorioitemList;
    @JoinColumn(name = "relatoriotipo_idrelatoriotipo", referencedColumnName = "idrelatoriotipo")
    @ManyToOne(optional = false)
    private Relatoriotipo relatoriotipo;
    @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Relatorio() {
    }

    public Relatorio(Integer idrelatorio) {
        this.idrelatorio = idrelatorio;
    }

    public Integer getIdrelatorio() {
        return idrelatorio;
    }

    public void setIdrelatorio(Integer idrelatorio) {
        this.idrelatorio = idrelatorio;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCanteiroobras() {
        return canteiroobras;
    }

    public void setCanteiroobras(String canteiroobras) {
        this.canteiroobras = canteiroobras;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getNumerotrabalhadores() {
        return numerotrabalhadores;
    }

    public void setNumerotrabalhadores(String numerotrabalhadores) {
        this.numerotrabalhadores = numerotrabalhadores;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEmpresaacopanhante() {
        return empresaacopanhante;
    }

    public void setEmpresaacopanhante(String empresaacopanhante) {
        this.empresaacopanhante = empresaacopanhante;
    }

    public String getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(String acompanhante) {
        this.acompanhante = acompanhante;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public List<Relatorioitem> getRelatorioitemList() {
        return relatorioitemList;
    }

    public void setRelatorioitemList(List<Relatorioitem> relatorioitemList) {
        this.relatorioitemList = relatorioitemList;
    }

    public Relatoriotipo getRelatoriotipo() {
        return relatoriotipo;
    }

    public void setRelatoriotipo(Relatoriotipo relatoriotipo) {
        this.relatoriotipo = relatoriotipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelatorio != null ? idrelatorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Relatorio)) {
            return false;
        }
        Relatorio other = (Relatorio) object;
        if ((this.idrelatorio == null && other.idrelatorio != null) || (this.idrelatorio != null && !this.idrelatorio.equals(other.idrelatorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.seconci.model.Relatorio[ idrelatorio=" + idrelatorio + " ]";
    }
    
}
