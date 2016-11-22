package it.alfasoft.viviana.bean;

import javax.persistence.Entity;

import utility.IsValid;


@Entity
public class ClienteBean extends UtenteBean implements IsValid{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ragioneSociale;
	private String p_iva;
	
	
	public ClienteBean() {
		super();
		this.ragioneSociale = "";
		this.p_iva = "";
	}
	
	
	public ClienteBean(String nome,String cognome,String username,String password,char ruolo,String ragioneSociale, String p_iva) {
		super(nome,cognome,username,password,ruolo);
		this.ragioneSociale = ragioneSociale;
		this.p_iva = p_iva;
	}


	public String getRagioneSociale() {
		return ragioneSociale;
	}


	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}


	public String getP_iva() {
		return p_iva;
	}


	public void setP_iva(String p_iva) {
		this.p_iva = p_iva;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public boolean isValid() {

		boolean res=false;
		
		if(!nome.isEmpty() && nome!=null && 
				!cognome.isEmpty() && cognome!=null &&
				!username.isEmpty() && username!=null &&
				!password.isEmpty() && password!=null &&
				ruolo=='C' &&
				!ragioneSociale.isEmpty() && ragioneSociale!=null &&
				!p_iva.isEmpty() && p_iva!=null) {
			res=true;
		}
		
		return res;
	}
	

}
