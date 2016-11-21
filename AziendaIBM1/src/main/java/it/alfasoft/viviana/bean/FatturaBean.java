package it.alfasoft.viviana.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class FatturaBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_fattura;
	
	private String codiceFattura;
	private double importo;
	private Date dataEmissione;
	
	
	

	public FatturaBean(String codiceFattura, double importo,
			Date dataEmissione) {
	
		this.codiceFattura = codiceFattura;
		this.importo = importo;
		this.dataEmissione = dataEmissione;
	}


	public FatturaBean() {
		
	}

	
	public long getId_fattura() {
		return id_fattura;
	}


	public void setId_fattura(long id_fattura) {
		this.id_fattura = id_fattura;
	}


	public String getcodiceFattura() {
		return codiceFattura;
	}


	public void setcodiceFattura(String codiceFattura) {
		this.codiceFattura = codiceFattura;
	}


	public double getImporto() {
		return importo;
	}


	public void setImporto(double importo) {
		this.importo = importo;
	}


	public Date getDataEmissione() {
		return dataEmissione;
	}


	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}
	
	
}
