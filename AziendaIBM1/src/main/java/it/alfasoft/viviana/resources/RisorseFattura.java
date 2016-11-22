package it.alfasoft.viviana.resources;


import java.util.ArrayList;
import java.util.List;

import it.alfasoft.viviana.bean.FatturaBean;
import it.alfasoft.viviana.filtri.FiltriFatturaMeseAnno;
import it.alfasoft.viviana.servizi.ServizioFattura;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;


@Path("fatture")
@Produces(MediaType.APPLICATION_JSON)
public class RisorseFattura {
	private ServizioFattura s=new ServizioFattura();
	
	 
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public List<FatturaBean> getAllFatture(){		
		return new ArrayList<FatturaBean>(s.leggiFatture());
	}
	
	
	@Path("/{codiceFattura}")
	@GET	
	public FatturaBean getFatturaCod(@PathParam("codiceFattura") String codiceFattura){
		return s.cercaFatturaCodice(codiceFattura);
	}
	
	
     @Path("/registrazione")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
     
	public Response addFattura(FatturaBean f,
			                   @Context HttpServletRequest request){
		String pathJasper=request.getServletContext().getRealPath("/fatture/jasper/Fattura.jasper");
		
	
		System.out.println(pathJasper);
		
		boolean b=s.aggiungiFattura(f);
		if(b==true){
			s.creaPDF(f,pathJasper);
		}

		return Response.status(Status.CREATED)
						.entity(f)
						.build();
	}
	
	@GET
	@Path("/filtro")
	public List<FatturaBean> getFatturaMeseAnno(@QueryParam("mese") int mese, @QueryParam("anno") int anno){
		
		return new ArrayList<FatturaBean>(s.leggiFattureMeseAnno(mese, anno));
	}
	
	
	
	
}
