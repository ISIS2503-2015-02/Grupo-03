/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;
import com.example.models.Ubicacion;
import com.example.models.UbicacionDTO;
import com.example.PersistenceManager;
import com.example.models.Vehiculo;
import com.example.models.VehiculoDTO;
import java.util.List;
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
import javax.ws.rs.PathParam;

/**
 *
 * @author df.sabogal10
 */
@Path("/vehiculo")
@Produces(MediaType.APPLICATION_JSON)
public class VehiculoService {
    
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
    public Response createVehicle(VehiculoDTO ub) {

        JSONObject rta = new JSONObject();
        Vehiculo vTmp= new Vehiculo();
        vTmp.setCapacidad(ub.getCapacidad());
        vTmp.setUbicacion(ub.getUbicacion());
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(vTmp);
            rta.put("vehiculo_id", vTmp.getId());
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
        Query q = entityManager.createQuery("select u from Vehiculo u");
        List<Vehiculo> ubs = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(ubs).build();
    }
    
    @PUT
    @Path("{id}")
    public void actulizarUbicacionVehiculo(UbicacionDTO ub, @PathParam("id") int idVehiculo) 
    {

        Vehiculo v= entityManager.find(Vehiculo.class, idVehiculo);
        Long  idUbicacion=v.getUbicacion().getId();
        Ubicacion u = entityManager.find(Ubicacion.class, idUbicacion);
        entityManager.getTransaction().begin();
        u.setLatitud(ub.getLatitud());
        u.setLongitud(ub.getLongitud());
        entityManager.getTransaction().commit();
        
    }
    
}
