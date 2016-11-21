package it.alfasoft.viviana.servizi;

import java.util.List;

import it.alfasoft.viviana.bean.FatturaBean;
import it.alfasoft.viviana.dao.FatturaDao;

public class Servizio {
	FatturaDao fDao=new FatturaDao();
	
	//metodo per creare fattura
	public boolean aggiungiFattura(FatturaBean f){
		return fDao.creaFattura(f);
	}
	
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
		
	
	
	
}
