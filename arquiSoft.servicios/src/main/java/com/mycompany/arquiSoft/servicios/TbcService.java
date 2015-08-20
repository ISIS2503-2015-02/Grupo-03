/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.logica.interfaces.IServicioTbcMockLocal;
import com.mycompany.arquisoft.logica.interfaces.IServicioVcubMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ja.silva11
 */
@Path("/Tbc")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TbcService 
{
    /**
     * Referencia al Ejb del vcub encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioTbcMockLocal tbcEjb;
   
    /**
     * Servicio que ofrece una lista JSON con el conductor mas productivo.
     * @return la lista JSON con los muebles de MDLA.
  
     */
    @GET
    @Path("conductor/")
    public Long getConductor() 
    {
        return tbcEjb.darConductorProductivo();
    }
}
