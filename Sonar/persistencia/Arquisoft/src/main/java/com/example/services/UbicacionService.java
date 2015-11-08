/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.UbicacionDTO;
import com.example.models.Ubicacion;
import com.example.PersistenceManager;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("/ubicacion")
@Produces(MediaType.APPLICATION_JSON)
public class UbicacionService 
{
    
    private transient Logger LOGGER;
    /**
     * Referencia al Ejb del vcub encargada de realizar las operaciones del mismo.
     */
    @PersistenceContext(unitName = "tbcPU")
    EntityManager entityManager;

    @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            LOGGER.log(null, "context", e);
        }
    }
   
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompetitor(UbicacionDTO ub) {

        JSONObject rta = new JSONObject();
        Ubicacion ubTmp= new Ubicacion();
        ubTmp.setLatitud(ub.getLatitud());
        ubTmp.setLongitud(ub.getLongitud());
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(ubTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(ubTmp);
            rta.put("ubicacion_id", ubTmp.getId());
        } catch (Exception t) {
            LOGGER.log(null, "context", t);
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ubTmp = null;
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
        Query q = entityManager.createQuery("select u from Ubicacion u");
        List<Ubicacion> ubs = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(ubs).build();
    } 
}