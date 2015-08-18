/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.Estacion;
import com.mycompany.arquisoft.logica.interfaces.IServicioEstacionMockLocal;
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
@Path("/Estacion")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstacionService 
{
        /**
     * Referencia al Ejb de la emergenica encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioEstacionMockLocal estacionEjb;
   
    @POST
    @Path("agregar/")
 
    public List<Estacion> agregarEstaciones(List<Estacion> vs) {
        for (Estacion veh : vs) {
            estacionEjb.agregarEstacion(veh);
        }
 
        return vs;
    }
    
    @PUT
    @Path("{id}")
    public void actulizarEstacion(Estacion estacion) 
    {
        estacionEjb.actualizarEstacion(estacion);
    }
 
    /**
     * Servicio que ofrece una lista JSON con el catálogo de Muebles de los alpes (Los muebles disponibles para la venta).
     * @return la lista JSON con los muebles de MDLA.
  
     */
    @GET
    @Path("estaciones/")
    public List<Estacion> getTodasLasEstaciones() 
    {
        return estacionEjb.darEstaciones();
    }
    
    /**
     * 
     */
    @GET
    @Path("{id}")
    public Estacion getEstacion(@PathParam("id") int id)
    {
       return estacionEjb.darEstacion(id);
    }
    /**
     * 
     */
    @DELETE
    @Path("{id}")
    public void eliminaEstacion(@PathParam("id") int id)
    {
       estacionEjb.eliminarEstacion(id);
    }
    
    

    
}
