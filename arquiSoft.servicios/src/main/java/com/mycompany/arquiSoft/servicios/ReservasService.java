/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.Reservas;
import com.mycompany.arquisoft.dto.Usuario;
import com.mycompany.arquisoft.logica.interfaces.IServicioReservasMockLocal;
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
@Path("/Reservas")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservasService 
{
    /**
     * Referencia al Ejb del tranvia encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioReservasMockLocal reservaEjb;
   
    @PUT
    @Path("actualizar/")
    public void actulizarTranvia(List<Reservas> res) 
    {
        for (Reservas reser : res) {
        reservaEjb.actualizarReservas(reser);
    }
        }
    
    @POST
    @Path("agregar/")
 
    public List<Reservas> agregarReservas(List<Reservas> trn) {
        for (Reservas usuario : trn) {
            reservaEjb.agregarReservasMoviBus(usuario);
        }
        
        return trn;
    }

    
     @GET
    @Path("reservas/")
    public List<Reservas> getTodosLosTranvias() 
    {
        return reservaEjb.darReservas();
    }
    
      @GET
    @Path("usuario/")
    public List<Usuario> getUsuarioReserva() 
    {
        return reservaEjb.darUsuario();
    }
    
}
