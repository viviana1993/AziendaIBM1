package it.alfasoft.viviana.dao;

import hibernateUtil.HibernateUtil;
import it.alfasoft.viviana.bean.DipendenteBean;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




public class DipendenteDao {
	
	//1-Create
	public boolean creaDipendente(DipendenteBean d) {
		boolean bool=false;

		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.persist(d);
			bool=true;
			
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return bool;
	}

	
	
	
	//2-Trova dipendente per username
	public DipendenteBean getDipendente(long id)
	{
		DipendenteBean d=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();


			Query query= session.createQuery("from DipendenteBean where id_utente=:id");
			query.setLong("id", id);
			d=(DipendenteBean) query.uniqueResult();
			
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return d;
	}

	
	//3-Read tutti i dipendenti
	@SuppressWarnings("unchecked")
	public List<DipendenteBean> getAllDipendenti() {
		
		List<DipendenteBean> listaDipendenti= new ArrayList<DipendenteBean>();
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		
		try{
		tx=session.getTransaction();
		tx.begin();

		Query query= session.createQuery("from DipendenteBean");
		
		listaDipendenti=query.list();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
	return listaDipendenti;
	}
	
	
	
	//4-Update dipendente
	public boolean aggiornaDipendente(DipendenteBean d) {
		boolean res=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;
		DipendenteBean dV=null;
		
		try{
			tx=session.getTransaction();
			tx.begin();
			
			
			dV=getDipendente(d.getId_utente());
			dV.setNome(d.getNome());
			dV.setCognome(d.getCognome());
			dV.setUsername(d.getUsername());
			dV.setPassword(d.getPassword());
			dV.setPosizione(d.getPosizione());
			dV.setStipendio(d.getStipendio());
			session.update(dV);

			res=true;
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return res;

	}
	
	
	
	//5-Delete
	public boolean rimuoviDipendente(DipendenteBean d) {
		boolean bool=false;

		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();
			
			session.delete(d);
			bool=true;
			
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return bool;
	}
}
