/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author daureo
 */
@Entity
@Table(name = "CliFisico")
@NamedQueries({
    @NamedQuery(name = "CliFisico.findAll", query = "SELECT c FROM CliFisico c"),
    @NamedQuery(name = "CliFisico.findByCpf", query = "SELECT c FROM CliFisico c WHERE c.cliFisicoPK.cpf = :cpf"),
    @NamedQuery(name = "CliFisico.findByClienteCodigo", query = "SELECT c FROM CliFisico c WHERE c.cliFisicoPK.clienteCodigo = :clienteCodigo")})
public class CliFisico implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CliFisicoPK cliFisicoPK;
    @JoinColumn(name = "cliente_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public CliFisico() {
    }

    public CliFisico(CliFisicoPK cliFisicoPK) {
        this.cliFisicoPK = cliFisicoPK;
    }

    public CliFisico(String cpf, int clienteCodigo) {
        this.cliFisicoPK = new CliFisicoPK(cpf, clienteCodigo);
    }

    public CliFisicoPK getCliFisicoPK() {
        return cliFisicoPK;
    }

    public void setCliFisicoPK(CliFisicoPK cliFisicoPK) {
        this.cliFisicoPK = cliFisicoPK;
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
        hash += (cliFisicoPK != null ? cliFisicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CliFisico)) {
            return false;
        }
        CliFisico other = (CliFisico) object;
        if ((this.cliFisicoPK == null && other.cliFisicoPK != null) || (this.cliFisicoPK != null && !this.cliFisicoPK.equals(other.cliFisicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josan.model.CliFisico[ cliFisicoPK=" + cliFisicoPK + " ]";
    }
    
}
