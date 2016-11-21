package it.alfasoft.viviana.filtri;

import javax.ws.rs.QueryParam;

public class FiltriFatturaAnno {
	private @QueryParam("anno") int anno;
	

	
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
}
