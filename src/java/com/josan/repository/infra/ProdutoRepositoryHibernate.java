/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.josan.repository.infra;

import com.josan.model.Produto;
import com.josan.repository.ProdutoRepository;
import com.josan.util.FacesUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class ProdutoRepositoryHibernate implements ProdutoRepository{

    @Override
    public List<Produto> todos() {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            return (List<Produto>) session.createCriteria(Produto.class)
                    .list();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Erro ao recuperar lista de Produtos");
        }
        return null;
    }

    @Override
    public Produto porCodigo(Integer codigo) {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            return (Produto) session.get(Produto.class, codigo);
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Erro ao recuperar produto");
        }
        return null;
    }

    @Override
    public Produto salvar(Produto produto) {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            Produto produtoSalvo = (Produto) session.merge(produto);
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Produto salvo com sucesso!");
            return produtoSalvo;
        } catch (Exception hibernateException) {
            hibernateException.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Erro ao salvar produto");
        }
        return null;
        
    }

    @Override
    public void excluir(Produto produto) {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            session.delete(produto);
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Erro ao excluir produto");
        }
        
    }

    @Override
    public Produto mesmosDados(Produto produto) {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        return (Produto) session.createCriteria(Produto.class)
                .add(Restrictions.eq("nome", produto.getNome()))
                .add(Restrictions.eq("descricao", produto.getDescricao()))
                .add(Restrictions.eq("tamanho", produto.getTamanho()))
                .uniqueResult();
    }

    @Override
    public Integer ultimoCodigo() {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            String SQL_String = "Select max(codReferencia) from Produto ";
            Query query = session.createQuery(SQL_String);
            
            List list = query.list();
            
            return list == null ? null : (Integer)list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar no banco!");
        }
        
        
        return null;
        
    }

    @Override
    public List<Produto> emFalta() {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            String SQL_String = "Select p from Produto p where p.quantidade <= p.quantidadeMin";
            Query query = session.createQuery(SQL_String);
            
            List list = query.list();
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar no banco!");
        }
        
        
        return null;
    }

    @Override
    public List<Produto> emEstoque() {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            String SQL_String = "Select p from Produto p where p.quantidade > p.quantidadeMin";
            Query query = session.createQuery(SQL_String);
            
            List list = query.list();
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao pesquisar no banco!");
        }
        
        
        return null;
    }

}
