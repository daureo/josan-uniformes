/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.converter;

import com.josan.controller.GestaoClientes;
import com.josan.model.Cliente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author daureo
 */
@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

    private GestaoClientes gestaoClientes = new GestaoClientes();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (!value.equals("")) {
            return (Cliente) this.gestaoClientes.porCodigo(new Integer(value));
        }

        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Integer codigo = ((Cliente) value).getCodigo();
            return codigo == null ? "" : codigo.toString();
        }

        return null;
    }
}
