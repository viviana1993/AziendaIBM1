<%@page import="it.alfasoft.viviana.bean.DipendenteBean"%>

<%@page import="ServizioAzienda.ServizioAzienda"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="dipendente" class="it.alfasoft.viviana.bean.DipendenteBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="dipendente" />

<jsp:useBean id="utente" class="it.alfasoft.viviana.bean.UtenteBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="utente" />


<%
	ServizioAzienda sA = new ServizioAzienda();

	String id = String.valueOf(dipendente.getId_utente());
	dipendente.setId_utente(Long.parseLong(id));
	
	
	String username = request.getParameter("username");

	String password=request.getParameter("password");
	String posizione = request.getParameter("posizione");
	String stipendio = request.getParameter("stipendio");
	double stipendio2 = 0;
	boolean error = false;

	try {
		stipendio2 = Double.parseDouble(stipendio);
		dipendente.setNome(request.getParameter("nome"));
		dipendente.setCognome(request.getParameter("cognome"));
		dipendente.setRuolo('D');
		password = sA.conversionePass(password);
		dipendente.setPassword(password);
		dipendente.setPosizione(request.getParameter("posizione"));
		dipendente.setStipendio(stipendio2);

	} catch (NumberFormatException e) {

		String message = "Lo stipendio inserito non è nel formato corretto";
		request.getSession().setAttribute("message", message);
		response.sendRedirect("./AziendaConGrafica/EditDipendente.jsp");
		error = true;
	}

	if (error == false) {

		if (dipendente.isValid() && ((sA.trovaUser(username)==null)|| ((sA.trovaUser(username)!=null && username == dipendente
				.getUsername())))) {
			
			dipendente.setUsername(username);
			sA.aggiornaDip(dipendente);
			String message = "Aggiornamento effettuato con successo";
			request.getSession().setAttribute("message", message);
			response.sendRedirect("./AziendaConGrafica/HomePageAdmin.jsp");

		} else {

			String message = "Username già utilizzato o dati non validi o incompleti";
			request.getSession().setAttribute("message", message);
			response.sendRedirect("./AziendaConGrafica/EditDipendente.jsp");

		}
	}

%>

