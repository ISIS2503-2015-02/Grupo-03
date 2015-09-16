/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.UsuarioDTO;
import com.example.models.Usuario;
import com.example.PersistenceManager;
import com.example.models.Vcub;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author je.camargo10
 */
@JsonIgnoreProperties(ignoreUnknown=true)  
@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService 
{
    /**
     * Referencia al Ejb del tranvia encargada de realizar las operaciones del mismo.
     */
    @PersistenceContext(unitName = "tbcPU")
    EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {

            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UsuarioDTO pUsuario)
    {
        JSONObject rta = new JSONObject();
        Usuario usuario= new Usuario();
        usuario.setNombre(pUsuario.getNombre());
        usuario.setDocumento(pUsuario.getDocumento());
        usuario.setTipoDocumento(pUsuario.getTipoDocumento());
        usuario.setCorreo(pUsuario.getCorreo());
        usuario.setDireccion(pUsuario.getDireccion());
        usuario.setTelefono(pUsuario.getTelefono());
        usuario.setTarjeta(pUsuario.getTarjeta());


        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            entityManager.refresh(usuario);
            rta.put("Se ha creado el usuario", usuario.getNombre());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            usuario = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }
    
    @GET
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from Usuario u");
        List<Usuario> tranvias = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(tranvias).build();
    } 
    
     
   @PUT
    @Path("/actualizar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(UsuarioDTO pUsuario) 
    {

        
         JSONObject rta = new JSONObject();
        Usuario usuario= new Usuario();
        usuario.setNombre(pUsuario.getNombre());
        usuario.setDocumento(pUsuario.getDocumento());
        usuario.setTipoDocumento(pUsuario.getTipoDocumento());
        usuario.setCorreo(pUsuario.getCorreo());
        usuario.setDireccion(pUsuario.getDireccion());
        usuario.setTelefono(pUsuario.getTelefono());
        usuario.setTarjeta(pUsuario.getTarjeta());


        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            entityManager.refresh(usuario);
            rta.put("Se ha creado el usuario", usuario.getNombre());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            usuario = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }
    
   
    
    @PUT
    @Path("/alquilar/idUsr/{idUsr}/idVcub/{idVcub}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response alquilar(@PathParam("idUsr") String idUsr,@PathParam("idVcub") String idVcub) 
    {

        JSONObject rta = new JSONObject();
        
        Query q = entityManager.createQuery("select u from Usuario u where u.documento = '"+ idUsr +"'");
        List<Usuario> usuarios = q.getResultList();
        
        Query cristo = entityManager.createQuery("select u from Vcub u where u.id = '"+ idVcub +"'");
        List<Vcub> vcubs = cristo.getResultList();
        
        if (usuarios.isEmpty()|| vcubs.isEmpty())
        {
       throw  new NotAuthorizedException("paila");

        
        }
        else
        {
             Usuario jesus = usuarios.get(0);
             Vcub mia = vcubs.get(0);
             
             jesus.prestarVicicleta(mia);
             mia.cambiarEstado();
        
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(jesus);
            entityManager.merge(mia);

            entityManager.getTransaction().commit();
            rta.put("Usted ha alquilado un vcub", jesus.getNombre());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            jesus = null;
            mia = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }
        }
   
    
    @PUT
    @Path("/devolver/idUsr/{idUsr}/idVcub/{idVcub}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response devolver(@PathParam("idUsr") String idUsr,@PathParam("idVcub") String idVcub) 
    {

        JSONObject rta = new JSONObject();
        
        Query q = entityManager.createQuery("select u from Usuario u where u.documento = '"+ idUsr +"'");
        List<Usuario> usuarios = q.getResultList();
        
        
        
        if (usuarios.isEmpty())
        {
       throw  new NotAuthorizedException("paila");

        
        }
        else
        {
             Usuario jesus = usuarios.get(0);
             
            Vcub mia =jesus.getBicicleta();

        
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(jesus);
            entityManager.merge(mia);

            entityManager.getTransaction().commit();
            rta.put("Usted ha devuelto el vcub", jesus.getNombre());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            jesus = null;
            mia = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }
        }
    
    
    
    
}
