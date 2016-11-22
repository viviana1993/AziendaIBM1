<%@page import="it.alfasoft.viviana.bean.ClienteBean"%>
<%@page import="it.alfasoft.viviana.bean.UtenteBean"%>
<%@page import="ServizioAzienda.ServizioAzienda"%>
<%@ page isELIgnored="false" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="cliente" class="it.alfasoft.viviana.bean.ClienteBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="cliente"/>

	<jsp:useBean id="utente" class="it.alfasoft.viviana.bean.UtenteBean" scope="request"></jsp:useBean>
	
	

 <%
	 	ServizioAzienda sA= new ServizioAzienda();
 		cliente=sA.trovaCliente(cliente.getId_utente());	
// 	 	String id = String.valueOf(cliente.getId_utente());
// 	 	cliente.setId_utente(Long.parseLong(id));

	 	if (cliente.isValid() && sA.trovaCliente(cliente.getId_utente())!=null) {
			sA.eliminaUtenteESuaRubrica(sA.trovaUtenteConId(cliente.getId_utente()));
	 		
	 		String message = "Cliente eliminato";
	 		request.getSession().setAttribute("message", message);
	 		response.sendRedirect("./AziendaConGrafica/ElencoClientiGrafica.jsp");

	 	} else {
	 		String message = "Utente noneliminato";
	 		request.getSession().setAttribute("message", message);
	 		response.sendRedirect("./AziendaConGrafica/ElencoClientiGrafica.jsp");

	 	}
	 %>

            