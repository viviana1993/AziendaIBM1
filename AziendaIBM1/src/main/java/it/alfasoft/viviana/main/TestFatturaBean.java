package it.alfasoft.viviana.main;
import it.alfasoft.viviana.bean.FatturaBean;

import it.alfasoft.viviana.servizi.Servizio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TestFatturaBean {

	public static void main(String[] args) {
		
		Servizio s=new Servizio();
		Date data=new Date();
//		FatturaBean f1=new FatturaBean("aaa",10.90,data);
//		FatturaBean f2=new FatturaBean("bbb",10.90,data);
//		FatturaBean f3=new FatturaBean("ccc",10.90,data);
//		FatturaBean f4=new FatturaBean("ddd",10.90,data);
//		
//		
//		s.aggiungiFattura(f1);
//		s.aggiungiFattura(f2);
//		s.aggiungiFattura(f3);
//		s.aggiungiFattura(f4);
//		
		
		FatturaBean fT=s.cercaFatturaCodice("bbb");
		System.out.println(fT.getId_fattura()+" "+fT.getcodiceFattura()+" "+fT.getImporto());
		
		List<FatturaBean> lista=s.leggiFatture();
		for(FatturaBean fx:lista){
			System.out.println(fx.getId_fattura()+" "+fx.getcodiceFattura()+" "+fx.getImporto());
		}
		FatturaBean fr=new FatturaBean("ddd",100,data);
		s.aggiornaFattura(fr);
		FatturaBean fx=s.cercaFatturaCodice("ddd");
		System.out.println(fx.getId_fattura()+" "+fx.getcodiceFattura()+" "+fx.getImporto());
		
		


	}}


