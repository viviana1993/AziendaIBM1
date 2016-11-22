<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <jsp:useBean id="admin" class="it.alfasoft.viviana.bean.AdminBean" scope="session"></jsp:useBean>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!--        header di pagina  -->
<jsp:include page="./headerHTML.jsp"></jsp:include>
    
    <!-- nav bar starts -->
    <jsp:include page="./navBarAdmin.jsp"></jsp:include>
    
   
    <div class="row">
        
        <!-- left menu starts -->
        <jsp:include page="./menùLateraleAdmin.jsp"></jsp:include>
        <!-- left menu ends -->


        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            
            <div>
  <ul class="breadcrumb">
        <li>
            <a href="#">Home</a>
        </li>
        <li>
            <a href="#">Admin</a>
        </li>
    </ul>
   
</div>


<div class=" row">
    
<!--       devo scrivere per ogni pagina   -->
   
      <div class="alert alert-info">
                <h1 >Welcome ${admin.nome}</h1>
               	 
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
	
  

    
</div><!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

  
    

    <hr>

    <jsp:include page="./footer.jsp"></jsp:include>
    








<!--      includo tutti script di sotto -->
<jsp:include page="./IncludeScriptEnd.jsp"></jsp:include>