package it.alfasoft.viviana.servizi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import it.alfasoft.viviana.bean.FatturaBean;
import it.alfasoft.viviana.dao.FatturaDao;

public class Servizio {
	FatturaDao fDao=new FatturaDao();
	
	
	//metodo per trovare fattura con id
	public FatturaBean cercaFatturaId(long id){
		return fDao.trovaFatturaId(id);
	}
	
	//metodo per trovare fattura con id
		public FatturaBean cercaFatturaCodice(String codice){
			return fDao.trovaFatturaCodice(codice);
		}
	
	//metodo per leggere lista fatture
	public List<FatturaBean> leggiFatture(){
		return fDao.getTutteLeFatture();
	}
	
	//metodo per  aggiornare Fattura
		public boolean aggiornaFattura(FatturaBean f){
			
			FatturaBean fV=fDao.trovaFatturaCodice(f.getcodiceFattura());
			fV.setcodiceFattura(f.getcodiceFattura());
			fV.setDataEmissione(f.getDataEmissione());
			fV.setImporto(f.getImporto());
			
			
			return fDao.aggiornaFattura(fV);
		}
		
		//metodo per rimuovere fattura
		public boolean rimuoviFattura(FatturaBean f){
			return fDao.rimuoviFattura(f);
		}
		
	//metodo per creare il pdf della fattura
		
		
		public String creaPDF(FatturaBean f){
			String nomeFile="FatturaBean"+f.getcodiceFattura()+".pdf";
			
			 String percorso  = "C:\\Users\\Viviana\\Desktop\\fatture\\";
			 
			 String fileFinale=percorso+nomeFile;
			 
			 
			try {

	          Map<String, Object> parameters = new HashMap<String, Object>();
	          FatturaBean fBean=cercaFatturaCodice(f.getcodiceFattura());
	          
	          parameters.put("importo", fBean.getImporto());

	          parameters.put("dataEmissione", fBean.getDataEmissione());

	          parameters.put("codiceFattura", fBean.getcodiceFattura());
	          try {
				String current = new java.io.File( "." ).getCanonicalPath();
				System.out.println(current);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          
	          //  file compilato di jasper (.jasper) di Jasper Report per creare  PDF 
	          JasperPrint jasperPrint = JasperFillManager.fillReport("C:\\Users\\Viviana\\git\\AziendaIBM1\\AziendaIBM1\\src\\main\\webapp\\jasper\\Fattura.jasper", parameters, new JREmptyDataSource());

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
			
		return fileFinale;	

	}
		
		
		//metodo per creare fattura
		public boolean aggiungiFattura(FatturaBean f){
			boolean b=fDao.creaFattura(f);
			return b;
		}
		
		//metodo per prendere fatture con mese e anno
		
		public List<FatturaBean> leggiFattureMeseAnno(int mese,int anno){
			List<FatturaBean> fatture=leggiFatture();
			List <FatturaBean> fattureMeseAnno=new ArrayList<FatturaBean>();
			Calendar cal=new GregorianCalendar();
			for(FatturaBean fb:fatture){
				
				cal.setTimeInMillis(fb.getDataEmissione().getTime());
			
				int m=cal.get(Calendar.MONTH)+1;
				int a=cal.get(Calendar.YEAR);
				
				
				if(m==mese && a==anno){
					fattureMeseAnno.add(fb);
				
				}
			}
			
			
			
			
			return fattureMeseAnno;
		}
		
		
		
		}
	
	

