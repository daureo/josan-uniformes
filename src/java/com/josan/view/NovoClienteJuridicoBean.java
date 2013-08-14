/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.view;

import com.josan.model.CliJuridico;
import com.josan.model.CliJuridicoPK;
import com.josan.model.Cliente;
import com.josan.repository.ClientesRepository;
import com.josan.util.Repositorios;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author daureo
 */
@ManagedBean
public class NovoClienteJuridicoBean {

    private Repositorios repositorios = new Repositorios();
    private ClientesRepository clienteRepo = this.repositorios.deCliente();
    private Cliente cliente = new Cliente();
    private CliJuridico cliJuridico = new CliJuridico();
    private CliJuridicoPK cliJuridicoPK = new CliJuridicoPK();

    public void salvar() {
        this.cliJuridicoPK.setClienteCodigo(((Cliente) this.clienteRepo.salvar(this.cliente)).getCodigo());
        this.cliJuridico.setCliJuridicoPK(cliJuridicoPK);
        this.cliJuridico.setCliente(cliente);
        this.clienteRepo.salvar(this.cliJuridico);


        cliente = new Cliente();
        cliJuridico = new CliJuridico();
        cliJuridicoPK = new CliJuridicoPK();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CliJuridico getCliJuridico() {
        return cliJuridico;
    }

    public void setCliJuridico(CliJuridico cliJuridico) {
        this.cliJuridico = cliJuridico;
    }

    public CliJuridicoPK getCliJuridicoPK() {
        return cliJuridicoPK;
    }

    public void setCliJuridicoPK(CliJuridicoPK cliJuridicoPK) {
        this.cliJuridicoPK = cliJuridicoPK;
    }
}
