/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author daureo
 */
@Embeddable
public class ProdutoEncomendaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "produto_codReferencia")
    private int produtocodReferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "encomenda_numero")
    private int encomendaNumero;

    public ProdutoEncomendaPK() {
    }

    public ProdutoEncomendaPK(int produtocodReferencia, int encomendaNumero) {
        this.produtocodReferencia = produtocodReferencia;
        this.encomendaNumero = encomendaNumero;
    }

    public int getProdutocodReferencia() {
        return produtocodReferencia;
    }

    public void setProdutocodReferencia(int produtocodReferencia) {
        this.produtocodReferencia = produtocodReferencia;
    }

    public int getEncomendaNumero() {
        return encomendaNumero;
    }

    public void setEncomendaNumero(int encomendaNumero) {
        this.encomendaNumero = encomendaNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) produtocodReferencia;
        hash += (int) encomendaNumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdutoEncomendaPK)) {
            return false;
        }
        ProdutoEncomendaPK other = (ProdutoEncomendaPK) object;
        if (this.produtocodReferencia != other.produtocodReferencia) {
            return false;
        }
        if (this.encomendaNumero != other.encomendaNumero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josan.model.ProdutoEncomendaPK[ produtocodReferencia=" + produtocodReferencia + ", encomendaNumero=" + encomendaNumero + " ]";
    }
    
}
