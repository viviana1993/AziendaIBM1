<%@page import="it.alfasoft.viviana.bean.DipendenteBean"%>

<%@page import="ServizioAzienda.ServizioAzienda"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="ServizioAzienda.ServizioAzienda"%>

<%@page import="java.lang.NumberFormatException"%>
<%@page import="javax.servlet.ServletException"%>

<jsp:useBean id="dipendente" class="it.alfasoft.viviana.bean.DipendenteBean" scope="request"></jsp:useBean>


<jsp:useBean id="utente" class="it.alfasoft.viviana.bean.UtenteBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="utente" />

<%
	ServizioAzienda sA= new ServizioAzienda();
	
    String stipendio= request.getParameter("stipendio");
    double stipendio2=0;
    boolean error = false;
   
   	try
    {
    	stipendio2=Double.parseDouble(stipendio);
    	dipendente.setNome(request.getParameter("nome"));
	   	dipendente.setCognome(request.getParameter("cognome"));
	   	dipendente.setPassword(request.getParameter("password"));
	   	dipendente.setRuolo('D');
	   	dipendente.setPosizione(request.getParameter("posizione"));
	   	dipendente.setStipendio(stipendio2);
	   	dipendente.setUsername(request.getParameter("username"));
    }
    catch (NumberFormatException e)
    {	
    	System.out.println("Lo stipendio inserito non è nel formato corretto ");
    	String message = "Lo stipendio inserito non è nel formato corretto";
        request.getSession().setAttribute("message", message);
        response.sendRedirect("./AziendaConGrafica/registraDipendenteGrafica.jsp");
  		error = true;
    }
    	
    if(error == false)
    {
	   	
	   	    
	    if(dipendente.isValid() && sA.trovaUser(dipendente.getUsername())==null) {
	    	String password=sA.conversionePass(dipendente.getPassword());
	    	
	    	
	        sA.registraDipendente(dipendente);
	        sA.creazioneRubrica(dipendente.getUsername());
	    	
	    	
	    	String message = "Registrazione effettuata con successo";
	        request.getSession().setAttribute("message", message);
	        response.sendRedirect("./AziendaConGrafica/HomePageAdmin.jsp");
	  
	    }
	    else{
	    	
	    	
	    	String message = "Username già utilizzato o dati non validi o incompleti";
	        request.getSession().setAttribute("message", message);
	        response.sendRedirect("./AziendaConGrafica/registraDipendenteGrafica.jsp");
	 
	    }
    }
    
    %>