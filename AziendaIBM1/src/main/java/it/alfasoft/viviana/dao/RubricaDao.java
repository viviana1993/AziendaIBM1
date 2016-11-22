package it.alfasoft.viviana.dao;

import model.Rubrica;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateUtil.HibernateUtil;

public class RubricaDao {
	// 1- Create 

		public boolean creaRubrica(Rubrica r){
			boolean res=false;
			Session session=HibernateUtil.openSession();

			Transaction tx=null;

			try{

				tx=session.getTransaction();

				tx.begin();

				session.persist(r); 


				tx.commit(); 
				res=true;
			}catch(Exception ex){

				tx.rollback();


			}finally{
				session.close();
			}



			return res;

		}



		// 2- Read ( con Id)

		public Rubrica leggiRubricaConId(long r_id){

			Rubrica r=null;
			Session session=HibernateUtil.openSession();

			Transaction tx=null;

			try{

				tx=session.getTransaction();

				tx.begin();


				r=session.get(Rubrica.class, r_id); 

				tx.commit(); 

			}catch(Exception ex){

				tx.rollback();


			}finally{
				session.close();
			}



			return r;

		}


		// 2- Read ( con nome )

		public Rubrica leggiRubricaConNome(String nome) {
			Rubrica r = null;

			Session session = HibernateUtil.openSession();
			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				Query query = session
						.createQuery("from Rubrica where nome=:nomeInserito ");

				query.setString("nomeInserito", nome);

				r = (Rubrica) query.uniqueResult();

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {
				session.close();
			}

			return r;

		}

		// 1- Update 

		public boolean aggiornaRubrica(Rubrica r){
			boolean res=false;


			Session session=HibernateUtil.openSession();
			Rubrica rV=null;
			Transaction tx=null;

			try{

				tx=session.getTransaction();

				tx.begin();
				rV=leggiRubricaConId(r.getId_Rubrica());
				rV.setNome(r.getNome());
				rV.setVoci(r.getVoci());
				session.update(rV); 


				tx.commit(); 
				res=true;
			}catch(Exception ex){

				tx.rollback();


			}finally{
				session.close();
			}



			return res;

		}
		//delete
		public boolean rimuoviRubrica(Rubrica r){
			boolean res=false;

			Session session=HibernateUtil.openSession();

			Transaction tx=null;
			
			try{

				tx=session.getTransaction();

				tx.begin();
				
				session.delete(r);


				tx.commit(); 
				res=true;
			}catch(Exception ex){

				tx.rollback();


			}finally{
				session.close();
			}



			return res;

		}

}
