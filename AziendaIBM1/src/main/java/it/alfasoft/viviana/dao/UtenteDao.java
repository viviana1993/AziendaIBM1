package it.alfasoft.viviana.dao;




import hibernateUtil.HibernateUtil;
import it.alfasoft.viviana.bean.UtenteBean;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;






public class UtenteDao {

	//1-Create
	public boolean creaUtente(UtenteBean u) {
		boolean bool=false;

		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();

			session.persist(u);
			bool=true;

			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}

		return bool;
	}




	//2-Trova utente per id
	public UtenteBean trovaUtenteId(Long id_u)
	{
		UtenteBean u=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();


			Query query= session.createQuery("from UtenteBean where id_utente=:id");
			query.setLong("id", id_u);
			u=(UtenteBean) query.uniqueResult();

			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return u;
	}

	//2-Trova utente per user
		public UtenteBean trovaUtente(String user)
		{
			UtenteBean u=null;
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();


				Query query= session.createQuery("from UtenteBean where username=:user");
				query.setString("user", user);
				u=(UtenteBean) query.uniqueResult();

				tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			return u;
		}
//	//3-Read tutti gli utenti
//	@SuppressWarnings("unchecked")
//	public List<UtenteBean> getAllUtenti() {
//
//		List<UtenteBean> utenti= new ArrayList<UtenteBean>();
//		Session session =HibernateUtil.openSession();
//		Transaction tx=null;
//
//		try{
//			tx=session.getTransaction();
//			tx.begin();
//
//			Query query= session.createQuery("from UtenteBean");
//			utenti=query.list();
//
//			tx.commit();
//		}catch(Exception ex){
//			tx.rollback();
//		}finally{
//			session.close();
//		}
//		return utenti;
//	}

	
	
	
	//5-Delete
	public boolean rimuoviUtente(UtenteBean u) {
		boolean bool=false;

		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
			tx=session.getTransaction();
			tx.begin();

			session.delete(u);
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
