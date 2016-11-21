package it.alfasoft.viviana.filtri;

import javax.ws.rs.QueryParam;

public class FiltriFatturaMeseAnno {

	private @QueryParam("anno") int anno;
	private @QueryParam("mese") int mese;
	
	
	
	
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	public int getMese() {
		return mese;
	}
	public void setMese(int mese) {
		this.mese = mese;
	}
	
	
	
}
