/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.MobibusDTO;
import com.example.models.Mobibus;
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
 * @author dc.bonilla10
 */
@Path("/mobibus")
@Produces(MediaType.APPLICATION_JSON)
public class MobibusService 
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
    public Response createCompetitor(MobibusDTO mobibus) {

        JSONObject rta = new JSONObject();
        Mobibus mobiTmp= new Mobibus();
        mobiTmp.setEstado(mobibus.getEstado());
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(mobiTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(mobiTmp);
            rta.put("mobibus_id", mobiTmp.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            mobiTmp = null;
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
        Query q = entityManager.createQuery("select u from Mobibus u");
        List<Mobibus> mobibuses = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(mobibuses).build();
    } 
    
    @GET
    @Path("/disponibles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDisp() {

        Query q = entityManager.createQuery("select u from Mobibus u where u.estado = 'disponible'");
        List<Mobibus> mobibuses = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(mobibuses).build();
    }
    
    @GET
    @Path("/reservados")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAlqui() {

        Query q = entityManager.createQuery("select u from Mobibus u where u.estado = 'reservado'");
        List<Mobibus> mobibuses = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(mobibuses).build();
    }
}