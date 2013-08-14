/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.model;

/**
 *
 * @author daureo
 */
public class ProdutoContado {

    private Produto produto;
    private Integer quantidade;

    public ProdutoContado(Produto produto) {
        this.produto = produto;
        this.quantidade = 1;
    }

    public void adicionar() {
        this.setQuantidade((Integer) (this.getQuantidade() + 1));
    }

    public void remove() {
        this.setQuantidade((Integer) (this.getQuantidade() - 1));
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        if (this.produto.equals(produto)) {
            this.quantidade++;
        } else {
            this.produto = produto;
        }
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
