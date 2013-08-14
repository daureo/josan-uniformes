/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.repository;

import com.josan.model.Produto;
import java.util.List;

public interface ProdutoRepository {

    public List<Produto> todos();

    public Produto porCodigo(Integer codigo);

    public Produto salvar(Produto produto);

    public void excluir(Produto produto);

    public Produto mesmosDados(Produto produto);

    public Integer ultimoCodigo();

    public List<Produto> emFalta();

    public List<Produto> emEstoque();
}
