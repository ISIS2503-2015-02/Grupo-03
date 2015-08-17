/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.Vehiculo;
import com.mycompany.arquisoft.logica.interfaces.IServicioVehiculoMockLocal;
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
@Path("/Vehiculo")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehiculoService {
    
    /**
     * Referencia al Ejb del vcub encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioVehiculoMockLocal vehiculoEjb;
   
    @POST
    @Path("agregar/")
 
    public List<Vehiculo> agregarVehiculos(List<Vehiculo> vs) {
        for (Vehiculo veh : vs) {
            vehiculoEjb.agregarVehiculo(veh);
        }
 
        return vs;
    }
    
    @PUT
    @Path("{id}")
    public void actulizarVehiculo(Vehiculo vehiculo) 
    {
        vehiculoEjb.actualizarVehiculo(vehiculo);
    }
 
    /**
     * Servicio que ofrece una lista JSON con el catálogo de Muebles de los alpes (Los muebles disponibles para la venta).
     * @return la lista JSON con los muebles de MDLA.
  
     */
    @GET
    @Path("vehiculos/")
    public List<Vehiculo> getTodosLosVehiculos() 
    {
        return vehiculoEjb.darVehiculos();
    }
    
    /**
     * 
     */
    @GET
    @Path("{id}")
    public Vehiculo getVehiculo(@PathParam("id") int id)
    {
       return vehiculoEjb.darVehiculo(id);
    }
    /**
     * 
     */
    @DELETE
    @Path("{id}")
    public void eliminarVehiculo(@PathParam("id") int id)
    {
       vehiculoEjb.eliminarVehiculo(id);
    }
    
    
}
