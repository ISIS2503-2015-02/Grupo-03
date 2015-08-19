/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.Reporte;
import com.mycompany.arquisoft.logica.interfaces.IServicioReporteMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author df.sabogal10
 */
@Path("/Reporte")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReporteService {
    
    /**
     * Referencia al Ejb de el reporte encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioReporteMockLocal reporteEjb;
   
    @POST
    @Path("agregar/")
 
    public List<Reporte> agregarReportes(List<Reporte> vs) {
        for (Reporte veh : vs) {
            reporteEjb.agregarReporte(veh);
        }
 
        return vs;
    }
    
    @PUT
    @Path("{id}")
    public void actulizarReporte(Reporte reporte) 
    {
        reporteEjb.actualizarReporte(reporte);
    }
 
    /**
     * Servicio que ofrece una lista JSON con los Reportes.
     * @return la lista JSON con los reportes de Tci.
  
     */
    @GET
    @Path("reportes/")
    public List<Reporte> getTodosLosReportes() 
    {
        return reporteEjb.darReportes();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public Reporte getReporte(@PathParam("id") int id)
    {
       return reporteEjb.darReporte(id);
    }
    /**
     * 
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void eliminaReporte(@PathParam("id") int id)
    {
       reporteEjb.eliminarReporte(id);
    }
    
    
}
