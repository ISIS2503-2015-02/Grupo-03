/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.PersistenceManager;
import com.example.models.Estacion;
import com.example.models.Reporte;
import com.example.models.ReporteDTO;
import com.example.models.Vehiculo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Path("/reporte")
@Produces(MediaType.APPLICATION_JSON)
public class ReporteService {
    
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
    @Path("/add/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReporte(ReporteDTO ub, @PathParam("id") int idVehiculo) {

        JSONObject rta = new JSONObject();
        Reporte vTmp= new Reporte();
        vTmp.setFecha(ub.getFecha());
        try {
            entityManager.getTransaction().begin();
            Vehiculo v=entityManager.find(Vehiculo.class, idVehiculo);
            vTmp.setVehiculo(v);
            entityManager.persist(vTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(vTmp);
            rta.put("reporte_id", vTmp.getId());
        } catch (Throwable t) {
            t.printStackTrace();
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
     @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from Reporte u");
        List<Estacion> reportes = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(reportes).build();
    }

    
}
