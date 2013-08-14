/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.repository.infra;

import com.josan.model.Encomenda;
import com.josan.repository.EncomendaRepository;
import com.josan.util.FacesUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author daureo
 */
public class EncomendaRepositoryHibernate implements EncomendaRepository {

    @Override
    public Object salvarEncomenda(Object o) {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            Object encomendaSalva = (Object) session.merge(o);
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Encomenda salva com sucesso!");
            return encomendaSalva;
        } catch (Exception hibernateException) {
            hibernateException.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Erro ao salvar Encomenda");
        }
        return null;
    }

    @Override
    public void salvarProdutosEncomenda(Object o) {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            session.persist(o);
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Encomenda salva com sucesso!");

        } catch (Exception hibernateException) {
            hibernateException.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Erro ao salvar Encomenda");
        }

    }

    @Override
    public Encomenda porNumero(Integer numero) {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            return (Encomenda) session.get(Encomenda.class, numero);
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Erro ao recuperar encomenda");
        }
        return null;
    }

    @Override
    public List<Encomenda> todas() {
         Session session =  (Session) FacesUtil.getRequestAttribute("session");
        return session.getNamedQuery("Encomenda.findAll")              
                .list();
    }
}
