/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.EstacionVcub;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.logica.interfaces.IServicioEstacionVcubMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ja.silva11
 */
@Path("/Estacion")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstacionService 
{
    /**
     * Referencia al Ejb del tranvia encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioEstacionVcubMockLocal estacionVcubEjb;
    
    @POST
    @Path("agregar/")
    public List<EstacionVcub> agregarEstacionVcub(List<EstacionVcub> est) {
        for (EstacionVcub x : est) {
            estacionVcubEjb.agregarEstacion(x);
        }
        return est;
    }
    
    /**
     *
     * @param est
     * @return
     */
    @POST
    @Path("agregar/id/id2")
    public Vcub agregarVcubEstacion(@PathParam("id") long id, @PathParam("id2") long id2) 
    {
        return estacionVcubEjb.agregarVcub(id,id2);
    }   
    
    /**
     * Servicio que ofrece una lista JSON con todas las estaciones de Vcub.
     * @return la lista JSON con los muebles de MDLA.
  
     */
    @GET
    @Path("estaciones/")
    public List<EstacionVcub> getTodasLosEstaciones() 
    {
        return estacionVcubEjb.darEstaciones();
    }
}
