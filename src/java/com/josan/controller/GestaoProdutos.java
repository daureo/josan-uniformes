package com.josan.controller;

import com.josan.model.Produto;
import com.josan.repository.ProdutoRepository;
import com.josan.util.FacesUtil;
import com.josan.util.Repositorios;
import java.util.List;
import javax.faces.application.FacesMessage;

public class GestaoProdutos {

    
    private Repositorios repositorio = new Repositorios();
    private ProdutoRepository produtoRepo = this.repositorio.deProduto();

    private Integer ultimoCodigo() {
        return this.produtoRepo.ultimoCodigo() == null ? 0 : this.produtoRepo.ultimoCodigo();
    }

    public Produto salvar(Produto produto) {
        if (produtoRepo.mesmosDados(produto) == null) {
            produto.setCodReferencia(this.ultimoCodigo() + 1);
            produto.setQuantidade(0);
            return this.produtoRepo.salvar(produto);
        } else 
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_WARN, "Produto já cadastrado!");
            
        return null;
            

    }

    public List<Produto> listaTodos() {

        return this.produtoRepo.todos();

    }

    public List<Produto> emFalta(){
        return this.produtoRepo.emFalta();
    }
    
    public List<Produto> emEstoque(){
        return this.produtoRepo.emEstoque();
    }
    
    public Produto porCodigo(Integer codigo) {
        Produto prod = this.produtoRepo.porCodigo(codigo);

        if (prod == null) {
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_WARN, "Produto não encontrado!");
        }

        return prod;

    }
}
