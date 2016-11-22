<%@page import="it.alfasoft.viviana.bean.DipendenteBean"%> 
<%@page import="it.alfasoft.viviana.bean.UtenteBean"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ page isELIgnored="false" %>
<%@page import="ServizioAzienda.ServizioAzienda"%>
    <jsp:useBean id="dipendente" class="it.alfasoft.viviana.bean.DipendenteBean"
	scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="dipendente"/>
	
	
	<jsp:useBean id="utente" class="it.alfasoft.viviana.bean.UtenteBean"
	scope="session"></jsp:useBean>
	
	
	<jsp:useBean id="mex" class="utility.MessageBean" scope="request"></jsp:useBean>

<!--        header di pagina  -->
<%

ServizioAzienda sA=new ServizioAzienda();
dipendente=sA.trovaDipendente(dipendente.getId_utente());
%>
    
    
<jsp:include page="headerHTML.jsp"></jsp:include>
    
    <!-- nav bar starts -->
    <jsp:include page="navBarAdmin.jsp"></jsp:include>
     
    <div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
        <jsp:include page="menùLateraleAdmin.jsp"></jsp:include>
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            
            <div class="alert alert-info">
                <h3>Aggiornamento Dipendente<br>

                </h3>
               
            </div>
            
            
                 
                
                <% 
            if(request.getSession().getAttribute("message")!=null){
            	%>
            	
            	
            	
            	<div class="box-content alerts">
                
                <div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <p>${message}
                <c:remove var="message" scope="session" /></p>
                </div>
               
            </div>
            	
            	
            	<%
            }
            %>
            
    
 
   

   
   <form action="../doEditDipendente.jsp" method="post">
   <input type="hidden" name="id_utente" value="<%=dipendente.getId_utente()%>"/> 
Nome : <input class="form-control" type="text" name="nome"  value="<%=dipendente.getNome()%>"/> <br>
Cognome : <input class="form-control" type="text" name="cognome"  value="<%=dipendente.getCognome()%>"/> <br>
Username : <input class="form-control" type="text" name="username" value="<%=dipendente.getUsername()%>"/> <br>
Password : <input class="form-control" type="password" name="password" value="<%=dipendente.getPassword()%>"/> <br>
Posizione : <input class="form-control" type="text" name="posizione" value="<%=dipendente.getPosizione()%>"/> <br>
Stipendio : <input class="form-control" type="text" name="stipendio" value="<%=dipendente.getStipendio()%>"/> <br>

	
<p class="center col-md-5">
 <button type="submit" class="btn btn-primary">Edit</button>
 </p>



</form>

<div class=" row">
    
<!--       devo scrivere per ogni pagina   -->
   
   

  

    
</div><!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

  
    

    <hr>

    <jsp:include page="footer.jsp"></jsp:include>
    

</div><!--/.fluid-container-->

<!--      includo tutti script di sotto -->
<jsp:include page="IncludeScriptEnd.jsp"></jsp:include>