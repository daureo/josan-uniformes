/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.view;

import com.josan.controller.GestaoEncomendas;
import com.josan.model.Encomenda;
import com.josan.util.FacesUtil;
import java.math.BigDecimal;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author daureo
 */
@ManagedBean
public class FinalizarEncomendaBean {

    private GestaoEncomendas gestaoEncomendas = new GestaoEncomendas();
    private Integer numero;
    private Encomenda encomenda;
    private BigDecimal total;

    public void finalizar() {

        try {
            this.gestaoEncomendas.porNumero(numero).setDataEntrega(new Date());
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Encomenda finalizada!");
        } catch (NullPointerException e) {
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Encomenda não pode ser finalizada! " + e.getMessage());
        }

        this.numero = null;
    }

    public void localizar() {
        
        this.encomenda = this.gestaoEncomendas.porNumero(this.numero);
        if (this.encomenda == null) {
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Nenhuma encomenda encontrada!");
        } else {
            this.total = calcularTotal();
        }
    }

    private BigDecimal calcularTotal() {
        BigDecimal total = new BigDecimal(0);
        for (int i = 0; i < this.encomenda.getProdutoEncomendaList().size(); i++) {
            total = total.add(this.encomenda.getProdutoEncomendaList().get(i).getValor());
        }
        return total;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
