
<%@page import="it.alfasoft.viviana.bean.ClienteBean"%>

<%@page import="ServizioAzienda.ServizioAzienda"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="cliente" class="it.alfasoft.viviana.bean.ClienteBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="cliente"/>

	<jsp:useBean id="utente" class="it.alfasoft.viviana.bean.UtenteBean" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="utente"/>
	

 <%
	 	ServizioAzienda sA= new ServizioAzienda();
	  		
 
 		
	  	cliente.setNome(request.getParameter("nome"));
	 	cliente.setCognome(request.getParameter("cognome"));
	 	String user=request.getParameter("username");
	 	cliente.setPassword(request.getParameter("password"));
	 	cliente.setRuolo('C');
	 	cliente.setRagioneSociale(request.getParameter("ragioneSociale"));
	 	cliente.setP_iva(request.getParameter("p_iva"));

	 	String id = String.valueOf(cliente.getId_utente());
	 	cliente.setId_utente(Long.parseLong(id));

	 	if (cliente.isValid() && (sA.trovaUser(user)==null|| (sA.trovaUser(user)!=null && user==cliente.getUsername()))) {
			cliente.setUsername(user);
	 		sA.aggiornaCliente(cliente);
	 		String message = "Aggiornamento effettuato con successo";
	 		request.getSession().setAttribute("message", message);
	 		response.sendRedirect("./AziendaConGrafica/HomePageAdmin.jsp");

	 	} else {
	 		String message = "Username già utilizzato o dati non validi";
	 		request.getSession().setAttribute("message", message);
	 		response.sendRedirect("./AziendaConGrafica/EditCliente.jsp");

	 	}
	 %>

            