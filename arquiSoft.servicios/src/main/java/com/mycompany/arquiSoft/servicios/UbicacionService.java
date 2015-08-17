/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.Ubicacion;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.logica.interfaces.IServicioUbicacionMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioVcubMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ja.silva11
 */
@Path("/Ubicacion")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UbicacionService 
{
     /**
     * Referencia al Ejb del vcub encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioUbicacionMockLocal ubicacionEjb;
   
    @POST
    @Path("agregar/")
 
    public List<Ubicacion> agregarUbicaciones(List<Ubicacion> ub) {
        for (Ubicacion ubicacion : ub) {
            ubicacionEjb.agregarUbicacion(ubicacion);
        }
 
        return ub;
    }
    
    @PUT
    @Path("{id}")
    public void actulizarVcub(@PathParam("id") int id,Ubicacion ubicacion) 
    {
        ubicacionEjb.actualizarUbicacion(ubicacion);
    }
 
    /**
     * Servicio que ofrece una lista JSON con el catálogo de Muebles de los alpes (Los muebles disponibles para la venta).
     * @return la lista JSON con los muebles de MDLA.
  
     */
    @GET
    @Path("ubicaciones/")
    public List<Ubicacion> getTodosLasUbicaciones() 
    {
        return ubicacionEjb.darUbicaciones();
    }    
}
