/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.VcubDTO;
import com.example.models.Vcub;
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
@Path("/vcub")
@Produces(MediaType.APPLICATION_JSON)
public class VcubService 
{
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
            e.printStackTrace();
        }
    }
   
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCompetitor(VcubDTO vcub) {

        JSONObject rta = new JSONObject();
        Vcub vcubTmp= new Vcub();
        vcubTmp.setEstado(vcub.getEstado());
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vcubTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(vcubTmp);
            rta.put("vcub_id", vcubTmp.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            vcubTmp = null;
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
        Query q = entityManager.createQuery("select u from Vcub u");
        List<Vcub> vcubs = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(vcubs).build();
    } 
    
    @GET
    @Path("/disponibles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDisp() {

        Query q = entityManager.createQuery("select u from Vcub u where u.estado = 'disponible'");
        List<Vcub> vcubs = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(vcubs).build();
    }
    
    @GET
    @Path("/alquilados")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAlqui() {

        Query q = entityManager.createQuery("select u from Vcub u where u.estado = 'alquilado'");
        List<Vcub> vcubs = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(vcubs).build();
    }
}