package com.josan.view;

import com.josan.controller.GestaoClientes;
import com.josan.controller.GestaoEncomendas;
import com.josan.model.Cliente;
import com.josan.model.Encomenda;
import com.josan.model.Produto;
import com.josan.model.ProdutoContado;
import com.josan.model.ProdutoEncomenda;
import com.josan.model.ProdutoEncomendaPK;
import com.josan.util.FacesUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author daureo
 */
@ManagedBean
@ViewScoped
public class NovaEncomendaBean {

    private GestaoEncomendas gestaoEncomendas = new GestaoEncomendas();
    private GestaoClientes gestaoClientes = new GestaoClientes();
    private List<Produto> produtosSelecionados = new ArrayList<Produto>();
    private List<ProdutoContado> produtosContados = new ArrayList<ProdutoContado>();
    private List<Cliente> listaClientes = gestaoClientes.todos();
    private Produto produtoSelecionado;
    private Integer quantidadeSelecionada;
    private Integer quantidade;
    private ProdutoContado produtoContado;
    private Cliente cliente;

    public void salvarEncomenda() {

        Encomenda encomenda = new Encomenda();
        encomenda.setClienteCodigo(cliente);
        encomenda.setDataEncomenda(new Date());


        Encomenda encomendaSalva = this.gestaoEncomendas.salvarEncomenda(encomenda);

        for (int i = 0; i < this.produtosContados.size(); i++) {


            ProdutoEncomenda produtoEncomenda = new ProdutoEncomenda();
            ProdutoEncomendaPK produtoEncomendaPK = new ProdutoEncomendaPK();

            produtoEncomendaPK.setEncomendaNumero(encomendaSalva.getNumero());

            produtoEncomenda.setEncomenda(encomendaSalva);

            produtoEncomenda.setProdutoEncomendaPK(produtoEncomendaPK);

            produtoEncomendaPK.setProdutocodReferencia(this.produtosContados.get(i).getProduto().getCodReferencia());
            produtoEncomenda.setProduto(this.produtosContados.get(i).getProduto());
            produtoEncomenda.setQuantidade(this.produtosContados.get(i).getQuantidade());
            produtoEncomenda.setValor(this.produtosContados.get(i).getProduto().getValorVenda().multiply(new BigDecimal(this.produtosContados.get(i).getQuantidade())));
           
            this.gestaoEncomendas.salvarProdutosLista(produtoEncomenda);

        }

        
        FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Número da Encomenda: " + encomendaSalva.getNumero());
        
        this.produtosContados.clear();
        this.produtosSelecionados.clear();
        this.cliente = new Cliente();


    }
    
    public void adicionarProduto() {
        if (this.produtosSelecionados.contains(this.produtoSelecionado)) {
            ProdutoContado produtoASerAdicionado = this.porObjetoAdd(produtoSelecionado);
            this.produtosContados.get(this.produtosContados.indexOf(produtoASerAdicionado)).adicionar();

        } else {
            this.produtoContado = new ProdutoContado(this.produtoSelecionado);
            this.produtosContados.add(this.produtoContado);
        }

        this.getProdutosSelecionados().add(this.produtoSelecionado);
    }

    private ProdutoContado porObjetoAdd(Produto produto) {

        ProdutoContado pC = null;

        for (int i = 0; i < this.produtosContados.size(); i++) {
            if (this.produtosContados.get(i).getProduto().equals(produto)) {
                pC = this.produtosContados.get(i);
            }

        }

        return pC;
    }

    private ProdutoContado porObjeto(Produto produto) {

        ProdutoContado pC = null;

        for (int i = 0; i < this.produtosContados.size(); i++) {
            if (this.produtosContados.get(i).getProduto().getCodReferencia() == produto.getCodReferencia()) {
                pC = this.produtosContados.get(i);
            }

        }

        return pC;
    }

    public void removerProduto() {

        ProdutoContado produtoASerRemovido = this.porObjeto(this.produtoSelecionado);

        if (null != produtoASerRemovido) {

            if (this.produtosContados.get(this.produtosContados.indexOf(produtoASerRemovido)).getQuantidade() == 1) {
                this.produtosContados.remove(this.produtosContados.get(this.produtosContados.indexOf(produtoASerRemovido)));
            } else {
                this.produtosContados.get(this.produtosContados.indexOf(this.produtoContado)).remove();
            }
        }

        this.getProdutosSelecionados().remove(this.produtoSelecionado);
    }

    public List<Produto> getProdutosSelecionados() {
        return produtosSelecionados;
    }

    public void setProdutosSelecionados(List<Produto> produtosSelecionados) {
        this.produtosSelecionados = produtosSelecionados;
    }

    public Integer getQuantidadeSelecionada() {
        return quantidadeSelecionada;
    }

    public void setQuantidadeSelecionada(Integer quantidade) {
        this.quantidadeSelecionada = quantidade;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
