/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author daureo
 */
@Entity
@Table(name = "Produto_Encomenda")
@NamedQueries({
    @NamedQuery(name = "ProdutoEncomenda.findAll", query = "SELECT p FROM ProdutoEncomenda p"),
    @NamedQuery(name = "ProdutoEncomenda.findByProdutocodReferencia", query = "SELECT p FROM ProdutoEncomenda p WHERE p.produtoEncomendaPK.produtocodReferencia = :produtocodReferencia"),
    @NamedQuery(name = "ProdutoEncomenda.findByEncomendaNumero", query = "SELECT p FROM ProdutoEncomenda p WHERE p.produtoEncomendaPK.encomendaNumero = :encomendaNumero"),
    @NamedQuery(name = "ProdutoEncomenda.findByQuantidade", query = "SELECT p FROM ProdutoEncomenda p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "ProdutoEncomenda.findByValor", query = "SELECT p FROM ProdutoEncomenda p WHERE p.valor = :valor")})
public class ProdutoEncomenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProdutoEncomendaPK produtoEncomendaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Min(value=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @JoinColumn(name = "produto_codReferencia", referencedColumnName = "codReferencia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "encomenda_numero", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Encomenda encomenda;

    public ProdutoEncomenda() {
    }

    public ProdutoEncomenda(ProdutoEncomendaPK produtoEncomendaPK) {
        this.produtoEncomendaPK = produtoEncomendaPK;
    }

    public ProdutoEncomenda(ProdutoEncomendaPK produtoEncomendaPK, int quantidade, BigDecimal valor) {
        this.produtoEncomendaPK = produtoEncomendaPK;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public ProdutoEncomenda(int produtocodReferencia, int encomendaNumero) {
        this.produtoEncomendaPK = new ProdutoEncomendaPK(produtocodReferencia, encomendaNumero);
    }

    public ProdutoEncomendaPK getProdutoEncomendaPK() {
        return produtoEncomendaPK;
    }

    public void setProdutoEncomendaPK(ProdutoEncomendaPK produtoEncomendaPK) {
        this.produtoEncomendaPK = produtoEncomendaPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoEncomendaPK != null ? produtoEncomendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoEncomenda)) {
            return false;
        }
        ProdutoEncomenda other = (ProdutoEncomenda) object;
        if ((this.produtoEncomendaPK == null && other.produtoEncomendaPK != null) || (this.produtoEncomendaPK != null && !this.produtoEncomendaPK.equals(other.produtoEncomendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josan.model.ProdutoEncomenda[ produtoEncomendaPK=" + produtoEncomendaPK + " ]";
    }
    
}
