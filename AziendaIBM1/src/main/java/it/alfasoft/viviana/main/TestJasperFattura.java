package it.alfasoft.viviana.main;

import it.alfasoft.viviana.bean.FatturaBean;
import it.alfasoft.viviana.servizi.Servizio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class TestJasperFattura {

	public static void main(String[] args) {
		
		Servizio s=new Servizio();
		String nomeFile="FatturaBean.pdf";
		
		 String percorso  = "C:\\Users\\Viviana\\Desktop\\";
		 
		 String fileFinale=percorso+nomeFile;
		 
		 
		
		try {
            

          //la mia lista che mantiene i dati
            List<FatturaBean> fatture = s.leggiFatture();
            

          // Converto la  lista to JRBeanCollectionDataSource 
          JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(fatture,false);

          //  una mappa per mandare i parametri a Jasper 
          Map<String, Object> parameters = new HashMap<String, Object>();
        
          parameters.put("DatasetFatturaBean", itemsJRBean);

          //  file compilato di jasper (.jasper) di Jasper Report per creare  PDF 
          JasperPrint jasperPrint = JasperFillManager.fillReport("ElencoFatture.jasper", parameters, new JREmptyDataSource());

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


