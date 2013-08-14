/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author daureo
 */
@Entity
@Table(name = "CliJuridico")
@NamedQueries({
    @NamedQuery(name = "CliJuridico.findAll", query = "SELECT c FROM CliJuridico c"),
    @NamedQuery(name = "CliJuridico.findByCnpj", query = "SELECT c FROM CliJuridico c WHERE c.cliJuridicoPK.cnpj = :cnpj"),
    @NamedQuery(name = "CliJuridico.findByClienteCodigo", query = "SELECT c FROM CliJuridico c WHERE c.cliJuridicoPK.clienteCodigo = :clienteCodigo"),
    @NamedQuery(name = "CliJuridico.findByRazaoSocial", query = "SELECT c FROM CliJuridico c WHERE c.razaoSocial = :razaoSocial")})
public class CliJuridico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CliJuridicoPK cliJuridicoPK;
    @Size(max = 50)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @JoinColumn(name = "cliente_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public CliJuridico() {
    }

    public CliJuridico(CliJuridicoPK cliJuridicoPK) {
        this.cliJuridicoPK = cliJuridicoPK;
    }

    public CliJuridico(String cnpj, int clienteCodigo) {
        this.cliJuridicoPK = new CliJuridicoPK(cnpj, clienteCodigo);
    }

    public CliJuridicoPK getCliJuridicoPK() {
        return cliJuridicoPK;
    }

    public void setCliJuridicoPK(CliJuridicoPK cliJuridicoPK) {
        this.cliJuridicoPK = cliJuridicoPK;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliJuridicoPK != null ? cliJuridicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CliJuridico)) {
            return false;
        }
        CliJuridico other = (CliJuridico) object;
        if ((this.cliJuridicoPK == null && other.cliJuridicoPK != null) || (this.cliJuridicoPK != null && !this.cliJuridicoPK.equals(other.cliJuridicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josan.model.CliJuridico[ cliJuridicoPK=" + cliJuridicoPK + " ]";
    }
    
}
