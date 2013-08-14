/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.controller;

import com.josan.model.Encomenda;
import com.josan.model.ProdutoEncomenda;
import com.josan.repository.EncomendaRepository;
import com.josan.repository.ProdutoRepository;
import com.josan.util.Repositorios;
import java.util.List;

/**
 *
 * @author daureo
 */
public class GestaoEncomendas {
    private Repositorios repositorio = new Repositorios();
    private ProdutoRepository produtoRepo = this.repositorio.deProduto();
    private EncomendaRepository encomendaRepo = this.repositorio.deEncomenda();
    
    
    public List<Encomenda> todas(){
        return this.encomendaRepo.todas();
    }
    
    public Encomenda salvarEncomenda(Encomenda o){
        return (Encomenda) this.encomendaRepo.salvarEncomenda(o);
    }
    
    public void salvarProdutosLista(ProdutoEncomenda produtoEncomenda){
        this.encomendaRepo.salvarProdutosEncomenda(produtoEncomenda);
    }
    
    public Encomenda porNumero(Integer numero){
        return this.encomendaRepo.porNumero(numero);
    }
}
