/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.repository.infra;

import com.josan.model.Cliente;
import com.josan.repository.ClientesRepository;
import com.josan.util.FacesUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author daureo
 */
public class ClientesRepositoryHibernate implements ClientesRepository {

    @Override
    public List<Cliente> listaTodos() {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            return (List<Cliente>) session.createCriteria(Cliente.class)
                    .list();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Erro ao recuperar lista de Clientes");
        }
        return null;
    }

    @Override
    public Cliente porCodigo(Integer codigo) {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        return (Cliente) session.get(Cliente.class, codigo);
    }

    @Override
    public Object salvar(Object o) {
        Session session = (Session) FacesUtil.getRequestAttribute("session");
        try {
            session.persist(o);
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cliente Salvo!");
            return o;
        } catch (Exception e) {
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_WARN, "Erro ao salvar Cliente! " + e.getMessage());
        }
        
        return null;
    }
}

