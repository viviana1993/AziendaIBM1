package it.alfasoft.viviana.bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class BustaPaga implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date data;
	private long importo;
	private String codiceBusta;
	
	public BustaPaga() {
	}

	public BustaPaga(Date data, long importo, String codiceBusta) {
		this.data = data;
		this.importo = importo;
		this.codiceBusta = codiceBusta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public long getImporto() {
		return importo;
	}

	public void setImporto(long importo) {
		this.importo = importo;
	}

	public String getCodiceBusta() {
		return codiceBusta;
	}

	public void setCodiceBusta(String codiceBusta) {
		this.codiceBusta = codiceBusta;
	}

	

}
