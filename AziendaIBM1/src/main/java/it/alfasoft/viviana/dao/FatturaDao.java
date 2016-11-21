package it.alfasoft.viviana.dao;

import hibernateUtil.HibernateUtil;
import it.alfasoft.viviana.bean.FatturaBean;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FatturaDao {
	
	//1-Create
		public boolean creaFattura(FatturaBean f) {
			boolean bool=false;

			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();

				session.persist(f);
				bool=true;

				tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}

			return bool;
		}




		//2-Trova fattura per id
		public FatturaBean trovaFatturaId(long id_f)
		{
			FatturaBean f=null;
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();


				Query query= session.createQuery("from FatturaBean where id_fattura=:id");
				query.setLong("id", id_f);
				f=(FatturaBean) query.uniqueResult();

				tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			return f;
		}

		
		
		//2-Trova fattura per codice
				public FatturaBean trovaFatturaCodice(String codice)
				{
					FatturaBean f=null;
					Session session =HibernateUtil.openSession();
					Transaction tx=null;

					try{
						tx=session.getTransaction();
						tx.begin();


						Query query= session.createQuery("from FatturaBean where codiceFattura=:cod");
						query.setString("cod", codice);
						f=(FatturaBean) query.uniqueResult();

						tx.commit();
					}catch(Exception ex){
						tx.rollback();
					}finally{
						session.close();
					}
					return f;
				}

		
		
		
		
		//metodo per leggere tutte le fatture
		@SuppressWarnings("unchecked")
		public List<FatturaBean> getTutteLeFatture()
		{
			List<FatturaBean> fatture= new ArrayList<FatturaBean>();
			
			
			
			Session session =HibernateUtil.openSession();
			
			Transaction tx=null;

			try{
			tx=session.getTransaction();
			tx.begin();

			Query query= session.createQuery("from FatturaBean");
			fatture=query.list();
			
			 tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			return fatture;
		}

		
		
		
		// 5- Update 

				public boolean aggiornaFattura(FatturaBean f){
					boolean res=false;
					Session session=HibernateUtil.openSession();
					Transaction tx=null;

					try{

						tx=session.getTransaction();

						tx.begin();
						session.update(f); 


						tx.commit(); 
						res=true;
					}catch(Exception ex){

						tx.rollback();


					}finally{
						session.close();
					}



					return res;

				}

		
		
		//5-Delete
		public boolean rimuoviFattura(FatturaBean f) {
			boolean bool=false;

			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();
				
				session.delete(f);
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
