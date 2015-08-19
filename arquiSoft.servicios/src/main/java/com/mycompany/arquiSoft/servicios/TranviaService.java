/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.Tranvia;
import com.mycompany.arquisoft.logica.interfaces.IServicioTranviaMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author je.camargo10
 */
@Path("/Tranvia")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TranviaService 
{
    /**
     * Referencia al Ejb del tranvia encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioTranviaMockLocal tranviaEjb;
   
    @PUT
    @Path("actualizar/")
    public void actulizarTranvia(List<Tranvia> usr) 
    {
        for (Tranvia usuario : usr) {
        tranviaEjb.actualizarTranvia(usuario);
    }
        }
    
    @POST
    @Path("agregar/")
 
    public List<Tranvia> agregarTranvia(List<Tranvia> trn) {
        for (Tranvia usuario : trn) {
            tranviaEjb.agregarTranvia(usuario);
        }
        
        return trn;
    }
 
    /**
     * Servicio que ofrece una lista JSON con todos los tranvias del Tbc
     * @return la lista JSON con los tranvias
  
     */
    @GET
    @Path("tranvias/")
    public List<Tranvia> getTodosLosTranvias() 
    {
        return tranviaEjb.darTranvias();
    }
     /**
     * Servicio que ofrece una eliminar un tranvia dado el id
     * @return la lista JSON con los tranvias
  
     */
    @DELETE
    @Path("tranvias/id/{id}")
    
    public void eliminarTranvia(@PathParam("id") String id) 
    {
         tranviaEjb.eliminarTranvia(Long.parseLong(id));
    }

     @PUT
    @Path("emergencia/id/{id}")
    public void emergenciaTranvia(@PathParam("id") String id)
    {
     tranviaEjb.emergenciaTranvia(Long.parseLong(id));
    
    
    }
         
 @PUT
    @Path("choque/id/{id}")
    public void choqueTranvia(@PathParam("id") String id)
    {
     tranviaEjb.choqueTranvia(Long.parseLong(id));
    
    
    }
    
    
    
}
