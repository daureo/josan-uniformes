/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.repository;

import com.josan.model.Cliente;
import java.util.List;

/**
 *
 * @author daureo
 */
public interface ClientesRepository {
    public List<Cliente> listaTodos();
    public Cliente porCodigo(Integer codigo);
    public Object salvar(Object o);
}
