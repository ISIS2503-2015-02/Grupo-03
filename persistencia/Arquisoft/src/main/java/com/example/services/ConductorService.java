/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.ConductorDTO;
import com.example.models.Conductor;
import com.example.PersistenceManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

/**
 *
 * @author ja.silva11
 */
@Path("/conductor")
@Produces(MediaType.APPLICATION_JSON)
public class ConductorService 
{
    /**
     * Referencia al Ejb del mobibus encargada de realizar las operaciones del mismo.
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
    public Response createCompetitor(ConductorDTO conductor) {

        JSONObject rta = new JSONObject();
        Conductor condTmp= new Conductor();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(condTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(condTmp);
            rta.put("conductor_id", condTmp.getCc());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            condTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from Conductor u");
        List<Conductor> conductores = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(conductores).build();
    } 
    
    @GET
    @Path("/rank")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRank() {
        Query q = entityManager.createQuery("select u from Conductor u order by u.promedio DSC");
        List<Conductor> conductores = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(conductores).build();
    }   
}