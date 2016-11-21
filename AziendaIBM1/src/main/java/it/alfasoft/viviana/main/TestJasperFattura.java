package it.alfasoft.viviana.main;

import it.alfasoft.viviana.bean.FatturaBean;
import it.alfasoft.viviana.servizi.Servizio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class TestJasperFattura {

	public static void main(String[] args) {
		
		Servizio s=new Servizio();
		String nomeFile="FatturaBean.pdf";
		
		 String percorso  = "C:\\Users\\Viviana\\Desktop\\";
		 
		 String fileFinale=percorso+nomeFile;
		 
		 
		try {

          //  una mappa per mandare i parametri a Jasper 
          Map<String, Object> parameters = new HashMap<String, Object>();
          FatturaBean fBean=s.cercaFatturaCodice("bbb");
          
          parameters.put("importo", fBean.getImporto());

          parameters.put("dataEmissione", fBean.getDataEmissione());

          parameters.put("codiceFattura", fBean.getcodiceFattura());

          //  file compilato di jasper (.jasper) di Jasper Report per creare  PDF 
          JasperPrint jasperPrint = JasperFillManager.fillReport("Fattura.jasper", parameters, new JREmptyDataSource());

          //outputStream per creare PDF 
          OutputStream outputStream = new FileOutputStream(new File(fileFinale));
         
          
          // scrivo in un  file PDF  
        
          JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

          System.out.println("File e' stato creato");
        
          
          
      } catch (JRException ex) {
          ex.printStackTrace();
      } catch (FileNotFoundException ex) {
          ex.printStackTrace();
      }
		
		

}
		

	}


