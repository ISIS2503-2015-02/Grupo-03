/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.Mobibus;
import com.mycompany.arquisoft.logica.interfaces.IServicioMobibusMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dc.bonilla10
 */
@Path("/Mobibus")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MobibusService 
{
    /**
     * Referencia al Ejb del Mobibus encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioMobibusMockLocal mobibusEjb;
   
    @POST
    @Path("agregar/")
 
    public List<Mobibus> agregarMobibus(List<Mobibus> mb) {
        for (Mobibus mobibus : mb) {
            mobibusEjb.agregarMobibus(mobibus);
        }
 
        return mb;
    }
    
    @PUT
    @Path("{id}")
    public void actulizarMobibus(@PathParam("id") int id,Mobibus mobibus) 
    {
        mobibusEjb.actualizarMobibus(mobibus);
    }
 
    /**
     * Servicio que ofrece una lista JSON con los Mobibus.
     * @return la lista JSON con los mobibus.
  
     */
    @GET
    @Path("mobibus/")
    public List<Mobibus> getTodosLosMobibus() 
    {
        return mobibusEjb.darMobibus();
    }
}

