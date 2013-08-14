/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.controller;

import com.josan.model.Cliente;
import com.josan.repository.ClientesRepository;
import com.josan.util.Repositorios;
import java.util.List;

/**
 *
 * @author daureo
 */
public class GestaoClientes {

    private Repositorios repositorios = new Repositorios();
    private ClientesRepository clientesRepo = this.repositorios.deCliente();    

   public List<Cliente> todos(){
       return this.clientesRepo.listaTodos();
   }
    
   public Cliente porCodigo(Integer codigo){
       return this.clientesRepo.porCodigo(codigo);
   }
            
            
}
