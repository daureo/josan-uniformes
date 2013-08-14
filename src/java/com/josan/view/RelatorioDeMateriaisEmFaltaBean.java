/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.view;

import com.josan.controller.GerarRelatorio;
import java.io.IOException;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author daureo
 */
@ManagedBean
public class RelatorioDeMateriaisEmFaltaBean {
    
    private GerarRelatorio gerarRelatorio = new GerarRelatorio();
    
    public void gerar() throws JRException, SQLException, IOException{        
        FacesContext.getCurrentInstance().getExternalContext().redirect(this.gerarRelatorio.deMaterialEmFalta());        
    }
}
