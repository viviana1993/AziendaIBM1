package it.alfasoft.viviana.dao;



import hibernateUtil.HibernateUtil;
import it.alfasoft.viviana.bean.AdminBean;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;






public class AdminDao {
	
	
	//1-Create
		public boolean creaAdmin(AdminBean a) {
			boolean bool=false;

			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();
				
				session.persist(a);
				bool=true;
				
				tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			
			return bool;
		}

		
		
		
		//2-Trova admin per username
		public AdminBean trovaAdmin(String username)
		{
			AdminBean a=null;
			Session session =HibernateUtil.openSession();
			Transaction tx=null;

			try{
				tx=session.getTransaction();
				tx.begin();


				Query query= session.createQuery("from AdminBean where username=:user");
				query.setString("user", username);
				a=(AdminBean) query.uniqueResult();
				
				tx.commit();
			}catch(Exception ex){
				tx.rollback();
			}finally{
				session.close();
			}
			return a;
		}

		
//		//3-Read tutti gli admin
//		@SuppressWarnings("unchecked")
//		public List<AdminBean> getAllAdmin() {
//			
//			List<AdminBean> listaAdmin= new ArrayList<AdminBean>();
//			Session session =HibernateUtil.openSession();
//			Transaction tx=null;
//			
//			try{
//			tx=session.getTransaction();
//			tx.begin();
//
//			Query query= session.createQuery("from ADMINBEAN");
//			
//			listaAdmin=query.list();
//			
//			 tx.commit();
//			}catch(Exception ex){
//				tx.rollback();
//			}finally{
//				session.close();
//			}
//		return listaAdmin;
//		}
//		
//		
//		
//		//4-Update admin
//		public boolean aggiornaAdmin(long ,AdminBean aNuovo) {
//			boolean res=false;
//			Session session =HibernateUtil.openSession();
//			Transaction tx=null;
//			AdminBean aV=null;
//			
//			try{
//				tx=session.getTransaction();
//				tx.begin();
//				
//				Query query= session.createQuery("from AdminBean where id=:id_vecchio");
//				query.setString("user", aVecchio.getUsername());
//				aV=(AdminBean) query.uniqueResult();
//				session.update(aV);
//
//				res=true;
//				tx.commit();
//			}catch(Exception ex){
//				tx.rollback();
//			}finally{
//				session.close();
//			}
//			return res;
//
//		}
//		
//		
//		
//		//5-Delete
//		public boolean rimuoviAdmin(AdminBean a) {
//			boolean bool=false;
//
//			Session session =HibernateUtil.openSession();
//			Transaction tx=null;
//
//			try{
//				tx=session.getTransaction();
//				tx.begin();
//				
//				session.delete(a);
//				bool=true;
//				
//				tx.commit();
//			}catch(Exception ex){
//				tx.rollback();
//			}finally{
//				session.close();
//			}
//			
//			return bool;
//		}
//		
//		
}
