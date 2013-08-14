/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.josan.view;

import com.josan.model.Produto;
import com.josan.repository.ProdutoRepository;
import com.josan.util.Repositorios;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class EstoqueBean {
    private Repositorios repositorio = new Repositorios();
    private ProdutoRepository produtoRepo = this.repositorio.deProduto();
    private List<Produto> listaProdutos;
    private List<Produto> listaProdutosFiltrados;
   
    
    @PostConstruct
    public void init(){
        this.setListaProdutos(this.produtoRepo.todos());
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public List<Produto> getListaProdutosFiltrados() {
        return listaProdutosFiltrados;
    }

    public void setListaProdutosFiltrados(List<Produto> listaProdutosFiltrados) {
        this.listaProdutosFiltrados = listaProdutosFiltrados;
    }
    
    public BigDecimal calcularLucro(Produto produto){
        BigDecimal venda = produto.getValorVenda();
        BigDecimal compra = produto.getValorCompra();
        
        return new BigDecimal(10);//(BigDecimal)venda.divide(compra).multiply(new BigDecimal(100)).subtract(new BigDecimal(100));
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    
    
    
}
