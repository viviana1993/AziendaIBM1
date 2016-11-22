package it.alfasoft.viviana.bean;

import javax.persistence.Entity;


@Entity
public class AdminBean extends UtenteBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String livelloDiAccesso;

	
	
	public AdminBean() {
		super();
		this.livelloDiAccesso = "";
	}
	
	
	
	public AdminBean(String nome,String cognome,String username,String password,char ruolo,String livelloDiAccesso) {
		super(nome,cognome,username,password,ruolo);
		this.livelloDiAccesso = livelloDiAccesso;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public String getLivelloDiAccesso() {
		return livelloDiAccesso;
	}



	public void setLivelloDiAccesso(String livelloDiAccesso) {
		this.livelloDiAccesso = livelloDiAccesso;
	}
	
	public boolean isValid() {
		boolean result=false;
		
		if(!nome.isEmpty() && nome!=null && 
				!cognome.isEmpty() && cognome!=null &&
				!username.isEmpty() && username!=null &&
				!password.isEmpty() && password!=null &&
				ruolo=='A' &&
				!livelloDiAccesso.isEmpty() && livelloDiAccesso!=null) {
			result=true;
		}
		
		return result;
	}
}
