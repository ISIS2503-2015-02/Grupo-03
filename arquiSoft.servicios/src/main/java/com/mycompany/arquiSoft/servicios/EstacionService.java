/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

<<<<<<< HEAD
import com.mycompany.arquisoft.dto.EstacionVcub;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.logica.interfaces.IServicioEstacionVcubMockLocal;
=======
import com.mycompany.arquisoft.dto.Estacion;
import com.mycompany.arquisoft.logica.interfaces.IServicioEstacionMockLocal;
>>>>>>> origin/master
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
<<<<<<< HEAD
import javax.ws.rs.POST;
=======
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
>>>>>>> origin/master
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
<<<<<<< HEAD

/**
 *
 * @author ja.silva11
=======
/**
 *
 * @author df.sabogal10
>>>>>>> origin/master
 */
@Path("/Estacion")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstacionService 
{
<<<<<<< HEAD
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
=======
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
>>>>>>> origin/master
     * @return la lista JSON con los muebles de MDLA.
  
     */
    @GET
    @Path("estaciones/")
<<<<<<< HEAD
    public List<EstacionVcub> getTodasLosEstaciones() 
    {
        return estacionVcubEjb.darEstaciones();
    }
=======
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
    
    

    
>>>>>>> origin/master
}
