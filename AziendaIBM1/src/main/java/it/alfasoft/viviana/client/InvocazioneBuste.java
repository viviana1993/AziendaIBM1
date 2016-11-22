package it.alfasoft.viviana.client;

import javax.ws.rs.client.Invocation;

public class InvocazioneBuste extends Invocazione{
	
	public InvocazioneBuste()  {
		
	}

	
	public Invocation richiestaBustePaga() {
		
		return baseTarget.request().buildGet();
	}

}
