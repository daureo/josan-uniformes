/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.view;

import com.josan.model.CliFisico;
import com.josan.model.CliFisicoPK;
import com.josan.model.Cliente;
import com.josan.repository.ClientesRepository;
import com.josan.util.Repositorios;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author daureo
 */
@ManagedBean
public class NovoClienteFisicoBean {

    private Repositorios repositorios = new Repositorios();
    private ClientesRepository clienteRepo = this.repositorios.deCliente();
    private Cliente cliente = new Cliente();
    private CliFisico cliFisico = new CliFisico();
    private CliFisicoPK cliFisicoPK = new CliFisicoPK();

    public void salvar() {
        this.cliFisicoPK.setClienteCodigo(((Cliente) this.clienteRepo.salvar(this.cliente)).getCodigo());
        this.cliFisico.setCliFisicoPK(cliFisicoPK);
        this.cliFisico.setCliente(cliente);
        this.clienteRepo.salvar(this.cliFisico);


        cliente = new Cliente();
        cliFisico = new CliFisico();
        cliFisicoPK = new CliFisicoPK();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CliFisico getCliFisico() {
        return cliFisico;
    }

    public void setCliFisico(CliFisico cliFisico) {
        this.cliFisico = cliFisico;
    }

    public CliFisicoPK getCliFisicoPK() {
        return cliFisicoPK;
    }

    public void setCliFisicoPK(CliFisicoPK cliFisicoPK) {
        this.cliFisicoPK = cliFisicoPK;
    }
}
