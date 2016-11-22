<%@page import="it.alfasoft.viviana.bean.DipendenteBean"%>
<%@page import="it.alfasoft.viviana.bean.UtenteBean"%>
<%@page import="ServizioAzienda.ServizioAzienda"%>
<%@ page isELIgnored="false" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="dipendente" class="it.alfasoft.viviana.bean.DipendenteBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="dipendente"/>

	<jsp:useBean id="utente" class="it.alfasoft.viviana.bean.UtenteBean" scope="request"></jsp:useBean>
	
	

 <%
	 	ServizioAzienda sA= new ServizioAzienda();
 		dipendente=sA.trovaDipendente(dipendente.getId_utente());	
// 	 	String id = String.valueOf(cliente.getId_utente());
// 	 	cliente.setId_utente(Long.parseLong(id));

	 	if (dipendente.isValid() && sA.trovaDipendente(dipendente.getId_utente())!=null) {
			sA.eliminaUtenteESuaRubrica(sA.trovaUtenteConId(dipendente.getId_utente()));
	 		
	 		String message = "Dipendente eliminato";
	 		request.getSession().setAttribute("message", message);
	 		response.sendRedirect("./AziendaConGrafica/ElencoDipendentiGrafica.jsp");

	 	} else {
	 		String message = "Utente non eliminato";
	 		request.getSession().setAttribute("message", message);
	 		response.sendRedirect("./AziendaConGrafica/ElencoDipendentiGrafica.jsp");

	 	}
	 %>
