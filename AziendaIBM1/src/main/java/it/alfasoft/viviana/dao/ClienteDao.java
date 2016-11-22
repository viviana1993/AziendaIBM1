package it.alfasoft.viviana.dao;



import hibernateUtil.HibernateUtil;
import it.alfasoft.viviana.bean.ClienteBean;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;






public class ClienteDao {
	//1-Create
			public boolean creaCliente(ClienteBean c) {
				boolean bool=false;

				Session session =HibernateUtil.openSession();
				Transaction tx=null;

				try{
					tx=session.getTransaction();
					tx.begin();
					
					session.persist(c);
					bool=true;
					
					tx.commit();
				}catch(Exception ex){
					tx.rollback();
				}finally{
					session.close();
				}
				
				return bool;
			}

			
			
			
			//2-Trova cliente per username
			public ClienteBean trovaCliente(String username)
			{
				ClienteBean c=null;
				Session session =HibernateUtil.openSession();
				Transaction tx=null;

				try{
					tx=session.getTransaction();
					tx.begin();


					Query query= session.createQuery("from ClienteBean where username=:user");
					query.setString("user", username);
					c=(ClienteBean) query.uniqueResult();
					
					tx.commit();
				}catch(Exception ex){
					tx.rollback();
				}finally{
					session.close();
				}
				return c;
			}

			
			
			//2-Trova cliente per id
			public ClienteBean trovaClientePerId(Long id_c)
			{
				ClienteBean c=null;
				Session session =HibernateUtil.openSession();
				Transaction tx=null;

				try{
					tx=session.getTransaction();
					tx.begin();


					Query query= session.createQuery("from ClienteBean where id_utente=:id");
					query.setLong("id", id_c);
					c=(ClienteBean) query.uniqueResult();
					
					tx.commit();
				}catch(Exception ex){
					tx.rollback();
				}finally{
					session.close();
				}
				return c;
			}

			
			
			//3-Read tutti i clienti
			
			@SuppressWarnings("unchecked")
			public List<ClienteBean> getAllClient() {
				
				List<ClienteBean> listaClienti= new ArrayList<ClienteBean>();
				Session session =HibernateUtil.openSession();
				Transaction tx=null;
				
				try{
				tx=session.getTransaction();
				tx.begin();

				Query query= session.createQuery("from ClienteBean");
				
				listaClienti=query.list();
				
				 tx.commit();
				}catch(Exception ex){
					tx.rollback();
				}finally{
					session.close();
				}
			return listaClienti;
			}
			
			
			
			//4-Update cliente
			public boolean aggiornaCliente(ClienteBean cBean) {
				boolean res=false;
				
				Session session =HibernateUtil.openSession();
				Transaction tx=null;
				ClienteBean cV=null;
				
				try{
					tx=session.getTransaction();
					tx.begin(); 
					//session.update(Long.toString(cV.getId_utente()),cBean);
					
					cV=trovaClientePerId(cBean.getId_utente());
					cV.setNome(cBean.getNome());
					cV.setCognome(cBean.getCognome());
					cV.setUsername(cBean.getUsername());
					cV.setPassword(cBean.getPassword());
					cV.setRagioneSociale(cBean.getRagioneSociale());
					cV.setP_iva(cBean.getP_iva());
					
					session.update(cV);
					
					res=true;
					tx.commit();
				}catch(Exception ex){
					tx.rollback();
				}finally{
					session.close();
				}
				
				
				return res;

			}
			
			
			
//			//5-Delete
//			public boolean rimuoviCliente(ClienteBean c) {
//				boolean bool=false;
//
//				Session session =HibernateUtil.openSession();
//				Transaction tx=null;
//
//				try{
//					tx=session.getTransaction();
//					tx.begin();
//					
//					session.delete(c);
//					bool=true;
//					
//					tx.commit();
//				}catch(Exception ex){
//					tx.rollback();
//				}finally{
//					session.close();
//				}
//				
//				return bool;
//			}
}
