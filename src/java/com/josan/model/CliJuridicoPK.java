/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daureo
 */
@Embeddable
public class CliJuridicoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_codigo")
    private int clienteCodigo;

    public CliJuridicoPK() {
    }

    public CliJuridicoPK(String cnpj, int clienteCodigo) {
        this.cnpj = cnpj;
        this.clienteCodigo = clienteCodigo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(int clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnpj != null ? cnpj.hashCode() : 0);
        hash += (int) clienteCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CliJuridicoPK)) {
            return false;
        }
        CliJuridicoPK other = (CliJuridicoPK) object;
        if ((this.cnpj == null && other.cnpj != null) || (this.cnpj != null && !this.cnpj.equals(other.cnpj))) {
            return false;
        }
        if (this.clienteCodigo != other.clienteCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josan.model.CliJuridicoPK[ cnpj=" + cnpj + ", clienteCodigo=" + clienteCodigo + " ]";
    }
    
}
