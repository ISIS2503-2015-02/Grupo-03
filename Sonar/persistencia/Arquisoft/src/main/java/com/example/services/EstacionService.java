/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;
import com.example.PersistenceManager;
import com.example.models.Estacion;
import com.example.models.EstacionDTO;
import com.example.models.Vcub;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
 * @author df.sabogal10
 */
@Path("/estacion")
@Produces(MediaType.APPLICATION_JSON)
public class EstacionService {
    
    private transient Logger LOGGER;
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
    public Response createEstacion(EstacionDTO ub) {

        JSONObject rta = new JSONObject();
        Estacion vTmp= new Estacion();
        vTmp.setCapacidad(ub.getCapacidad());
        vTmp.setUbicacion(ub.getUbicacion());
        vTmp.setVcubs(new ArrayList<Vcub>());
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(vTmp);
            rta.put("estacion_id", vTmp.getId());
        } catch (Exception t) {
            LOGGER.log(null, "context", t);
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            vTmp = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    }
    
    @PUT
    @Path("{id}")
    public void actulizarEstacion(EstacionDTO ub, @PathParam("id") int idEstacion) 
    {

        Estacion v= entityManager.find(Estacion.class, idEstacion);
        entityManager.getTransaction().begin();
        v.setCapacidad(ub.getCapacidad());
        v.setUbicacion(ub.getUbicacion());
        v.setVcubs(ub.getVcubs());
        entityManager.getTransaction().commit();
        
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from Estacion u");
        List<Estacion> estaciones = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(estaciones).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByID( @PathParam("id") int idEstacion) 
    {
        Estacion e = entityManager.find(Estacion.class,idEstacion );
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(e).build();
    }
      
    @PUT
    @Path("/addVcub/{id}/{idVcub}")
    public void agregarVcub( @PathParam("id") int idEstacion, @PathParam("idVcub") Long idVcub) 
    {

        Estacion e= entityManager.find(Estacion.class, idEstacion);
        Vcub v= entityManager.find(Vcub.class, idVcub);
        entityManager.getTransaction().begin();
        List <Vcub> l=e.getVcubs();
        l.add(v);
        e.setVcubs(l);
        entityManager.getTransaction().commit();   
    }
    
    @PUT
    @Path("/removeVcub/{id}/{idVcub}")
    public void eliminarVcub( @PathParam("id") int idEstacion, @PathParam("idVcub") Long idVcub) 
    {
        Estacion e= entityManager.find(Estacion.class, idEstacion);
        Vcub v= entityManager.find(Vcub.class, idVcub);
        entityManager.getTransaction().begin();
        List <Vcub> l=e.getVcubs();
        l.remove(v);
        e.setVcubs(l);
        entityManager.getTransaction().commit();   
    }

    
    
    
}
