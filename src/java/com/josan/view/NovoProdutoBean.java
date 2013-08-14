/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.josan.view;

import com.josan.controller.GestaoProdutos;
import com.josan.model.Produto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class NovoProdutoBean {
    private GestaoProdutos gestaoProdutos = new GestaoProdutos();
   
    private Produto produto = new Produto();
    
   
    public void salvar(){
        this.gestaoProdutos.salvar(this.produto);
        
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
}
