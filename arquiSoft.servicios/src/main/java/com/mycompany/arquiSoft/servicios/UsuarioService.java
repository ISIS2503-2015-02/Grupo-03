/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquiSoft.servicios;

import com.mycompany.arquisoft.dto.Usuario;
import com.mycompany.arquisoft.dto.Vcub;
import com.mycompany.arquisoft.logica.interfaces.IServicioUsuarioMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author je.camargo10
 */
@Path("/Usuario")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService 
{
    /**
     * Referencia al Ejb del tranvia encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioUsuarioMockLocal usuarioEjb;
   
    @PUT
    @Path("actualizar/")
    public void actulizarUsuario(List<Usuario> usr) 
    {
        for (Usuario usuario : usr) {
        usuarioEjb.actualizarUsuario(usuario);
    }
        }
    
     @POST
    @Path("agregar/")
 
    public List<Usuario> agregarUsuario(List<Usuario> usr) {
        for (Usuario usuario : usr) {
            usuarioEjb.agregarUsuario(usuario);
        }
        
        return usr;
    }
 
    /**
     * Servicio que ofrece una lista JSON con todos los Usuarios del Tbc
     * @return la lista JSON con los usuarios
  
     */
    @GET
    @Path("usuario/")
    public List<Usuario> getTodosLosUsuarios() 
    {
        return usuarioEjb.darUsuarios();
    }
    

    @POST
    @Path("prestar/idUsr/{idUsr}/idVcub/{idVcub}")
    public List<Vcub> prestarVcub(@PathParam("idUsr") String idUsr, @PathParam("idVcub") String idVcub) throws Exception
    
    {
      
        return usuarioEjb.prestarVcub(Long.parseLong(idUsr), Long.parseLong(idVcub));
        
    }
    

    
    
}
