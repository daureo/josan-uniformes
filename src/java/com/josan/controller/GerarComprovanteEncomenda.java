package com.josan.controller;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Daureo
 */
public class GerarComprovanteEncomenda {

    private Document doc = null;
    private OutputStream os = null;
    private String encomenda = "001";

    public void gerar() throws DocumentException, FileNotFoundException, IOException {

        try {
            this.doc = new Document(PageSize.A4, 72, 72, 72, 72);
            String arquivo = "Encomenda_" + this.encomenda + ".pdf";

            this.os = new FileOutputStream(arquivo);

            PdfWriter.getInstance(this.doc, this.os);
            
            this.doc.open();
            
            Paragraph p1 = new Paragraph("Comprovante Encomenda  - " + this.encomenda);
            
            this.doc.add(p1);           
          

        } finally {
            if(this.doc!=null)
                this.doc.close();
            if(this.os!=null)
                this.os.close();
        }
    }
}
