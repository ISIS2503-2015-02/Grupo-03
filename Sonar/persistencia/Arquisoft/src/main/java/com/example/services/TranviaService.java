/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.TranviaDTO;
import com.example.models.Tranvia;
import com.example.PersistenceManager;
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
@Path("/tranvia")
@Produces(MediaType.APPLICATION_JSON)
public class TranviaService 
{
    /**
     * Referencia al Ejb del tranvia encargada de realizar las operaciones del mismo.
     */
    @PersistenceContext(unitName = "tbcPU")
    EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            System.out.println("Almenos");

            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTranvia(TranviaDTO pTranvia)
    {
        JSONObject rta = new JSONObject();
        Tranvia tranvia= new Tranvia();
        tranvia.setId(pTranvia.getId());
        tranvia.setCoordenada(pTranvia.getCoordenada());
        tranvia.setKilometraje(pTranvia.getKilometraje());
        tranvia.setLinea(pTranvia.getLinea());
        tranvia.setTempatura(pTranvia.getTempatura());
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tranvia);
            entityManager.getTransaction().commit();
            entityManager.refresh(tranvia);
            rta.put("Se ha creado el tranvia", tranvia.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            tranvia = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }
    
    @GET
    @Path("/tranvias")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from Tranvia u");
        List<Tranvia> tranvias = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(tranvias).build();
    } 
     @GET
    @Path("/tranvias/idTranvia/{idTranvia}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("idTranvia") String idTranvia) {
        Query q = entityManager.createQuery("select u from Tranvia u where u.id = '"+ idTranvia +"'");
        List<Tranvia> tranvias = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(tranvias).build();
    } 
    
    @PUT
    @Path("/chocado/idTranvia/{idTranvia}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response accidente(@PathParam("idTranvia") String idTranvia) 
    {

        JSONObject rta = new JSONObject();
        
        Query q = entityManager.createQuery("select u from Tranvia u where u.id = '"+ idTranvia +"'");
        List<Tranvia> tranvias = q.getResultList();
        if (tranvias.isEmpty())
        {
       throw  new NotAuthorizedException("paila");

        
        }
        else
        {
             Tranvia jesus = tranvias.get(0);
             jesus.setchocado();
        
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(jesus);
            entityManager.getTransaction().commit();
            rta.put("Se ha actualizado el tranvia", jesus.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            jesus = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
    } 
   @PUT
    @Path("/actualizar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(TranviaDTO pTranvia) 
    {
        System.out.println("COpas");

        
        JSONObject rta = new JSONObject();
        Tranvia tranvia= new Tranvia();
        tranvia.setId(pTranvia.getId());
        tranvia.setCoordenada(pTranvia.getCoordenada());
        tranvia.setKilometraje(pTranvia.getKilometraje());
        tranvia.setLinea(pTranvia.getLinea());
        tranvia.setTempatura(pTranvia.getTempatura());
       if(pTranvia.getPanico()){ tranvia.setPanico();}
       if(pTranvia.getChoque()){tranvia.setchocado();}

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(tranvia);
            entityManager.getTransaction().commit();
            rta.put("Se ha actualizado el tranvia", tranvia.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            tranvia = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }
    @PUT
    @Path("/panico/idTranvia/{idTranvia}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response emergencia(@PathParam("idTranvia") String idTranvia) 
    {

        JSONObject rta = new JSONObject();
        
        Query q = entityManager.createQuery("select u from Tranvia u where u.id = '"+ idTranvia +"'");
        List<Tranvia> tranvias = q.getResultList();
        if (tranvias.isEmpty())
        {
       throw  new NotAuthorizedException("paila");

        
        }
        else
        {
             Tranvia jesus = tranvias.get(0);
             jesus.setPanico();
        
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(jesus);
            entityManager.getTransaction().commit();
            rta.put("Se ha actualizado el tranvia", jesus.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            jesus = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
    } 
    
    
    
    
}
