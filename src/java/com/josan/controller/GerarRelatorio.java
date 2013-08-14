/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josan.controller;

import com.josan.util.ConnectionFactory;
import com.josan.util.FacesUtil;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author daureo
 */

public class GerarRelatorio {

    public String deMaterialEmFalta() throws JRException, SQLException {

        GestaoProdutos gestaoProdutos = new GestaoProdutos();
        
        if (gestaoProdutos.emFalta().isEmpty()) {                 
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Não existe material em falta no momento!");
        } else {

            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.responseComplete();
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();


            JasperReport pathjrxml = JasperCompileManager.compileReport(
                    scontext.getRealPath("/relatorios/relatorioMaterialEmFalta.jrxml"));
            
            

            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null,
                    ConnectionFactory.getSakilaConnection());

            JasperExportManager.exportReportToPdfFile(printReport,
                    (String) scontext.getRealPath("/relatorios/") + "/relatorioMaterialEmFalta.pdf");

            ConnectionFactory.getSakilaConnection().close();
            return "relatorios/relatorioMaterialEmFalta.pdf";
        }
        return "index.xhtml";
    }
    
    public String deMaterialDisponivel() throws JRException, SQLException {

        GestaoProdutos gestaoProdutos = new GestaoProdutos();
        
        if (gestaoProdutos.emEstoque().isEmpty()) {                 
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Não existe material em estoque!");
        } else {

            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.responseComplete();
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();


            JasperReport pathjrxml = JasperCompileManager.compileReport(
                    scontext.getRealPath("/relatorios/relatorioMaterialDisponivel.jrxml"));
            
            

            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null,
                    ConnectionFactory.getSakilaConnection());

            JasperExportManager.exportReportToPdfFile(printReport,
                    (String) scontext.getRealPath("/relatorios/") + "/relatorioMaterialDisponivel.pdf");

            ConnectionFactory.getSakilaConnection().close();
            return "relatorios/relatorioMaterialDisponivel.pdf";
        }
        return "index.xhtml";
    }
    
    public String deEncomendas() throws JRException, SQLException {

        GestaoEncomendas gestaoEncomendas = new GestaoEncomendas();
        
        if (gestaoEncomendas.todas().isEmpty()) {                 
            FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_FATAL, "Não existem encomendas!");
        } else {

            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.responseComplete();
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();


            JasperReport pathjrxml = JasperCompileManager.compileReport(
                    scontext.getRealPath("/relatorios/relatorioEncomendas.jrxml"));
            
            

            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null,
                    ConnectionFactory.getSakilaConnection());

            JasperExportManager.exportReportToPdfFile(printReport,
                    (String) scontext.getRealPath("/relatorios/") + "/relatorioEncomendas.pdf");

            ConnectionFactory.getSakilaConnection().close();
            return "relatorios/relatorioEncomendas.pdf";
        }
        return "index.xhtml";
    }
}
