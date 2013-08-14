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
public class CliFisicoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_codigo")
    private int clienteCodigo;

    public CliFisicoPK() {
    }

    public CliFisicoPK(String cpf, int clienteCodigo) {
        this.cpf = cpf;
        this.clienteCodigo = clienteCodigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        hash += (cpf != null ? cpf.hashCode() : 0);
        hash += (int) clienteCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CliFisicoPK)) {
            return false;
        }
        CliFisicoPK other = (CliFisicoPK) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        if (this.clienteCodigo != other.clienteCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josan.model.CliFisicoPK[ cpf=" + cpf + ", clienteCodigo=" + clienteCodigo + " ]";
    }
    
}
