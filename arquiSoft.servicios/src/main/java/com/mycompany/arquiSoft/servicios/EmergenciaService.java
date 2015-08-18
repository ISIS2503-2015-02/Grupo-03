/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.Emergencia;
import com.mycompany.arquisoft.logica.interfaces.IServicioEmergenciaMockLocal;
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
@Path("/Emergencia")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmergenciaService {
    
    /**
     * Referencia al Ejb de la emergenica encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioEmergenciaMockLocal emergenciaEjb;
   
    @POST
    @Path("agregar/")
 
    public List<Emergencia> agregarEstaciones(List<Emergencia> vs) {
        for (Emergencia veh : vs) {
            emergenciaEjb.agregarEmergencia(veh);
        }
 
        return vs;
    }
    
    @PUT
    @Path("{id}")
    public void actulizarEmergencia(Emergencia emergencia) 
    {
        emergenciaEjb.actualizarEmergencia(emergencia);
    }
 
    /**
     * Servicio que ofrece una lista JSON con el catálogo de Muebles de los alpes (Los muebles disponibles para la venta).
     * @return la lista JSON con los muebles de MDLA.
  
     */
    @GET
    @Path("emergencias/")
    public List<Emergencia> getTodasLasEmergencias() 
    {
        return emergenciaEjb.darEmergencias();
    }
    
    /**
     * 
     */
    @GET
    @Path("{id}")
    public Emergencia getEmergencia(@PathParam("id") int id)
    {
       return emergenciaEjb.darEmergencia(id);
    }
    /**
     * 
     */
    @DELETE
    @Path("{id}")
    public void eliminaEmergencia(@PathParam("id") int id)
    {
       emergenciaEjb.eliminarEmergencia(id);
    }
    
    
}
