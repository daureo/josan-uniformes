/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.model;

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
import javax.validation.constraints.NotNull;

/**
 *
 * @author daureo
 */
@Entity
@Table(name = "Encomenda")
@NamedQueries({
    @NamedQuery(name = "Encomenda.findAll", query = "SELECT e FROM Encomenda e"),
    @NamedQuery(name = "Encomenda.findByNumero", query = "SELECT e FROM Encomenda e WHERE e.numero = :numero"),
    @NamedQuery(name = "Encomenda.findByDataEncomenda", query = "SELECT e FROM Encomenda e WHERE e.dataEncomenda = :dataEncomenda"),
    @NamedQuery(name = "Encomenda.findByDataEntrega", query = "SELECT e FROM Encomenda e WHERE e.dataEntrega = :dataEntrega")})
public class Encomenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "dataEncomenda")
    @Temporal(TemporalType.DATE)
    private Date dataEncomenda;
    @Column(name = "dataEntrega")
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;
    @JoinColumn(name = "cliente_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Cliente clienteCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encomenda")
    private List<ProdutoEncomenda> produtoEncomendaList;

    public Encomenda() {
    }

    public Encomenda(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getDataEncomenda() {
        return dataEncomenda;
    }

    public void setDataEncomenda(Date dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Cliente getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(Cliente clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public List<ProdutoEncomenda> getProdutoEncomendaList() {
        return produtoEncomendaList;
    }

    public void setProdutoEncomendaList(List<ProdutoEncomenda> produtoEncomendaList) {
        this.produtoEncomendaList = produtoEncomendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encomenda)) {
            return false;
        }
        Encomenda other = (Encomenda) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josan.model.Encomenda[ numero=" + numero + " ]";
    }
    
}
