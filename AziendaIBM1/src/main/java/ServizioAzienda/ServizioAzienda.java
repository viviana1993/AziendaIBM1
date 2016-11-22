package ServizioAzienda;

import it.alfasoft.viviana.bean.AdminBean;
import it.alfasoft.viviana.bean.BustaPaga;
import it.alfasoft.viviana.bean.ClienteBean;
import it.alfasoft.viviana.bean.DipendenteBean;
import it.alfasoft.viviana.bean.UtenteBean;
import it.alfasoft.viviana.client.InvocazioneBuste;
import it.alfasoft.viviana.dao.AdminDao;
import it.alfasoft.viviana.dao.ClienteDao;
import it.alfasoft.viviana.dao.DipendenteDao;
import it.alfasoft.viviana.dao.RubricaDao;
import it.alfasoft.viviana.dao.UtenteDao;
import it.alfasoft.viviana.dao.VoceDao;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import model.Rubrica;
import model.Voce;
import utility.CodificationOfPassword;




public class ServizioAzienda {
	UtenteDao uDao=new UtenteDao();
	ClienteDao cDao=new ClienteDao();
	DipendenteDao dDao=new DipendenteDao();
	AdminDao adao= new AdminDao();
	VoceDao vdao=new VoceDao();
	RubricaDao rDao=new RubricaDao();


	//	//metodo per registrare  utente
	//		public boolean registraUtente(UtenteBean u) {
	//			boolean result=false;
	//			result=uDao.creaUtente(u);
	//
	//			return result;
	//		}
	//metodo per registrare cliente

	public boolean registraCliente(ClienteBean c){

		return cDao.creaCliente(c);

	}


	//metodo per registrare dipendente
	public boolean registraDipendente(DipendenteBean d){

		return dDao.creaDipendente(d);

	}

	//metodo per aggiornare cliente

	public boolean aggiornaCliente(ClienteBean cNuovo){

		return cDao.aggiornaCliente(cNuovo);

	}
	//metodo per aggiornare dipendente

	public boolean aggiornaDip(DipendenteBean dNuovo){

		return dDao.aggiornaDipendente(dNuovo);

	}

	//metodo per registrare rubrica di un utente

	public boolean creazioneRubrica(String nome){
		Rubrica r=new Rubrica(nome);
		return rDao.creaRubrica(r);
	}

	//metodo per controllare se l'username è già presente

	public UtenteBean trovaUser(String username){
		UtenteBean u=uDao.trovaUtente(username);
		return u;
	}

	//metodo per convertire la password

	public String conversionePass(String pass){
		return CodificationOfPassword.codificatePass(pass);
	}

	//metodo per trovare utente tramite id

	public UtenteBean trovaUtenteConId(Long id){
		UtenteBean uBean=uDao.trovaUtenteId(id);
		return uBean;
	}

	//metodo per trovare cliente tramite id

	public ClienteBean trovaCliente(Long id){
		ClienteBean cBean=cDao.trovaClientePerId(id);
		return cBean;
	}
	//metodo per leggere elenco clienti

	public List<ClienteBean> getTuttiClienti(){
		List <ClienteBean> listaClient=cDao.getAllClient();
		return listaClient;
	}

	//metodo per leggere elenco dipendenti

	public List<DipendenteBean> getTuttiDipendenti(){
		List <DipendenteBean> listaDipendenti=dDao.getAllDipendenti();
		return listaDipendenti;
	}


	public AdminBean leggiAdmin(String username) {
		AdminBean a =adao.trovaAdmin(username);
		return a;
	}

	public DipendenteBean trovaDipendente(long id) {
		DipendenteBean d =dDao.getDipendente(id);
		return d;
	}



	//metodo per cancellare
	public boolean eliminaUtenteESuaRubrica(UtenteBean uBean) {
		boolean bool=false;
		if(uBean.getRuolo()=='A')
		{
			return bool;
		}
		else if(uBean.getRuolo()=='C' || uBean.getRuolo()=='D'){
			Rubrica r=rDao.leggiRubricaConNome(uBean.getUsername());
			if(r!=null) {
				bool=rDao.rimuoviRubrica(r);
			}
			return bool=uDao.rimuoviUtente(uBean);
		}
		return bool;
	}


	//metodo per aggiungere una voce in rubrica
	public boolean registraVoce(Rubrica r,Voce v) {
		boolean result= false;
		v.setRubrica(r);
		r.aggiungiVoce(v);
		boolean b=vdao.creaVoce(v);
		rDao.aggiornaRubrica(r);

		if(b==true)
		{
			result =true;
		}

		return result;

	}

	//Metodo per trovare la rubrica di un utente tramite username
	public Rubrica trovaRubrica(String username) {

		Rubrica r= rDao.leggiRubricaConNome(username);

		return r;
	}

	//metodo per prendere tutte le voci di rubrica
	public List<Voce> getAllVoci(Rubrica r) {
		List<Voce> voci = vdao.getVociRubrica(r);

		return voci;
	}


	//		//metodo per eliminare una voce
	//		public boolean eliminaVoce(Rubrica r, String nome, String cognome)
	//		{
	//			
	//			return vdao.rimuoviVoce(nome, cognome, r.getId_Rubrica());
	//			
	//		}

	//metodo per prendere lista buste

	public List<BustaPaga> getAllBuste(){
		InvocazioneBuste invocazione=new InvocazioneBuste();

		Response response= invocazione.richiestaBustePaga().invoke();
		List<BustaPaga> Buste = response.readEntity(new GenericType<List<BustaPaga>>(){});


		return Buste;


	}




}
