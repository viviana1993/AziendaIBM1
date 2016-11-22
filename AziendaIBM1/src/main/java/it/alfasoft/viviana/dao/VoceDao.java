package it.alfasoft.viviana.dao;

import java.util.ArrayList;
import java.util.List;

import model.Rubrica;
import model.Voce;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateUtil.HibernateUtil;

public class VoceDao {
	// 1- Create 

		public boolean creaVoce(Voce v){
			boolean res=false;


			Session session=HibernateUtil.openSession();

			Transaction tx=null;

			try{

				tx=session.getTransaction();

				tx.begin();

				session.persist(v); 


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

		public Voce leggiVoceConId(long v_id){

			Voce v=null;
			Session session=HibernateUtil.openSession();

			Transaction tx=null;

			try{

				tx=session.getTransaction();

				tx.begin();


				v=session.get(Voce.class, v_id); 

				tx.commit(); 

			}catch(Exception ex){

				tx.rollback();


			}finally{
				session.close();
			}



			return v;

		}


		
		//metodo per leggere tutte le voci della rubrica
		@SuppressWarnings("unchecked")
		public List<Voce> getVociRubrica(Rubrica r)
		{
			List<Voce> voci= new ArrayList<Voce>();
			
			
			
			Session session =HibernateUtil.openSession();
			
			Transaction tx=null;

			try{
			tx=session.getTransaction();
			tx.begin();

			Query query= session.createQuery("from Voce where Rubrica_Id_Rubrica=:x");
			query.setLong("x", r.getId_Rubrica());
			 voci=query.list();
			
			 tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			return voci;
		}

		
		// 5- Update 

		public boolean aggiornaVoce(Voce v){
			boolean res=false;



			Session session=HibernateUtil.openSession();
			Voce vV=null;
			Transaction tx=null;

			try{

				tx=session.getTransaction();

				tx.begin();
				vV=leggiVoceConId(v.getId_voce());
				vV.setNome(v.getNome());
				vV.setCognome(v.getCognome());
				vV.setTel(v.getTel());
				session.update(vV); 


				tx.commit(); 
				res=true;
			}catch(Exception ex){

				tx.rollback();


			}finally{
				session.close();
			}



			return res;

		}

//		//6-delete
//		
//		public boolean rimuoviVoce(String nome,String cognome,long id_r){
//			boolean res=false;
//
//
//			Session session=HibernateUtil.openSession();
//
//			Transaction tx=null;
//			Voce v=null;
//			try{
//
//				tx=session.getTransaction();
//
//				tx.begin();
//				v=leggiVoceConNomCognRubr(nome, cognome, id_r);
//				session.delete(v);
//
//
//				tx.commit(); 
//				res=true;
//			}catch(Exception ex){
//
//				tx.rollback();
//
//
//			}finally{
//				session.close();
//			}
//
//
//
//			return res;
//
//		}
//
//		//7-delete
//		
//			public boolean rimuoviVoce2(long v_id){
//				boolean res=false;
//
//				Voce v=null;
//				Session session=HibernateUtil.openSession();
//
//				Transaction tx=null;
//				
//				try{
//
//					tx=session.getTransaction();
//
//					tx.begin();
//					v=session.get(Voce.class, v_id);
//					session.delete(v);
//
//
//					tx.commit(); 
//					res=true;
//				}catch(Exception ex){
//
//					tx.rollback();
//
//
//				}finally{
//					session.close();
//				}
//
//
//
//				return res;
//
//			}
}
