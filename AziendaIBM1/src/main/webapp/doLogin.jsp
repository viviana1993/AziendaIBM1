<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.alfasoft.viviana.bean.UtenteBean"%>

<%@page import="ServizioAzienda.ServizioAzienda"%>
<%@page import="utility.MessageBean"%>

<jsp:useBean id="utente" class="it.alfasoft.viviana.bean.UtenteBean" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="utente"/>

<jsp:useBean id="mex" class="utility.MessageBean" scope="request"></jsp:useBean>
	
	<%
	ServizioAzienda sA= new ServizioAzienda();
	
	String username= request.getParameter("username");
	UtenteBean uBean= sA.trovaUser(username);
	
	String password=request.getParameter("password");
    String pass=sA.conversionePass(password);
    
	if(uBean!=null && uBean.getPassword().equals(pass)){
		
		char ruolo=uBean.getRuolo();
		utente.setNome(uBean.getNome());
		utente.setCognome(uBean.getCognome());
		utente.setRuolo(ruolo);
		utente.setPassword(uBean.getPassword());
		utente.setId_utente(uBean.getId_utente());
		utente.setUsername(uBean.getUsername());
		
		switch(ruolo){
		case 'A':
			response.sendRedirect("./AziendaConGrafica/HomePageAdmin.jsp");
			break;
		
		case 'C':
			response.sendRedirect("./AziendaConGrafica/HomePageCliente.jsp");
	
			break;
			
			
		case 'D':
			response.sendRedirect("./AziendaConGrafica/HomePageDipendente.jsp");
			
//  			%><jsp:forward page="HomePageDipendente.jsp"/><% 
			
		
			break;
		
		}
	}else{
		String message = "Username o password errati";
        request.getSession().setAttribute("message", message);
		response.sendRedirect("./AziendaConGrafica/login.jsp");
	
	}
	
	
	%>