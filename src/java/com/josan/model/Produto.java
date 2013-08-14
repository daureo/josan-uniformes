/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daureo
 */
@Entity
@Table(name = "Produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCodReferencia", query = "SELECT p FROM Produto p WHERE p.codReferencia = :codReferencia"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByTamanho", query = "SELECT p FROM Produto p WHERE p.tamanho = :tamanho"),
    @NamedQuery(name = "Produto.findByValorCompra", query = "SELECT p FROM Produto p WHERE p.valorCompra = :valorCompra"),
    @NamedQuery(name = "Produto.findByValorVenda", query = "SELECT p FROM Produto p WHERE p.valorVenda = :valorVenda"),
    @NamedQuery(name = "Produto.findByQuantidadeMin", query = "SELECT p FROM Produto p WHERE p.quantidadeMin = :quantidadeMin"),
    @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codReferencia")
    private Integer codReferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 50)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 10)
    @Column(name = "tamanho")
    private String tamanho;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorCompra")
    private BigDecimal valorCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorVenda")
    private BigDecimal valorVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidadeMin")
    private int quantidadeMin;
    @Column(name = "quantidade")
    private Integer quantidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<ProdutoEncomenda> produtoEncomendaList;

    public Produto() {
    }

    public Produto(Integer codReferencia) {
        this.codReferencia = codReferencia;
    }

    public Produto(Integer codReferencia, String nome, BigDecimal valorVenda, int quantidadeMin) {
        this.codReferencia = codReferencia;
        this.nome = nome;
        this.valorVenda = valorVenda;
        this.quantidadeMin = quantidadeMin;
    }

    public Integer getCodReferencia() {
        return codReferencia;
    }

    public void setCodReferencia(Integer codReferencia) {
        this.codReferencia = codReferencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public void setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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
        hash += (codReferencia != null ? codReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codReferencia == null && other.codReferencia != null) || (this.codReferencia != null && !this.codReferencia.equals(other.codReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josan.model.Produto[ codReferencia=" + codReferencia + " ]";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
