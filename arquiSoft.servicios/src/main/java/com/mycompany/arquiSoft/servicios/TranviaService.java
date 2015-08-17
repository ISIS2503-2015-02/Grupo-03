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
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.Path;
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
     * Referencia al Ejb del vcub encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioTranviaMockLocal tranviaEjb;
   
    @PUT
    @Path("actualizar/")
    public void actulizarTranvia(Tranvia tranvia) 
    {
        tranviaEjb.actualizarTranvia(tranvia);
    }
 
    /**
     * Servicio que ofrece una lista JSON con el catálogo de Muebles de los alpes (Los muebles disponibles para la venta).
     * @return la lista JSON con los muebles de MDLA.
  
     */
    @GET
    @Path("tranvias/")
    public List<Tranvia> getTodosLosVcubs() 
    {
        return tranviaEjb.darTranvias();
    }
}
