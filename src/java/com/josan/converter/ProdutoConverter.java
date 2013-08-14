
package com.josan.converter;

import com.josan.controller.GestaoProdutos;
import com.josan.model.Produto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author daureo
 */
@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter{
 private GestaoProdutos gestaoProdutos = new GestaoProdutos();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (!value.equals("")) {
            return (Produto) this.gestaoProdutos.porCodigo(new Integer(value));
        }

        return null;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Integer codigo = ((Produto) value).getCodReferencia();
            return codigo == null ? "" : codigo.toString();
        }

        return null;
    }
    
}
