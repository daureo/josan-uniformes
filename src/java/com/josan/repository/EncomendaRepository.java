/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.repository;

import com.josan.model.Encomenda;
import java.util.List;

/**
 *
 * @author daureo
 */
public interface EncomendaRepository {
    public Object salvarEncomenda(Object o);
    public void salvarProdutosEncomenda(Object o);
    public Encomenda porNumero(Integer numero);
    public List<Encomenda> todas();
}
