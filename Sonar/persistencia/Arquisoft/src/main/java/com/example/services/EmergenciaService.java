/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;
import com.example.PersistenceManager;
import com.example.excepciones.OperacionInvalidaException;
import com.example.models.Emergencia;
import com.example.models.EmergenciaDTO;
import com.example.models.Vehiculo;
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
@Path("/emergencia")
@Produces(MediaType.APPLICATION_JSON)
public class EmergenciaService {
    
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
    @Path("/add/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmergencia(EmergenciaDTO ub, @PathParam("id") int idVehiculo) throws OperacionInvalidaException {

        JSONObject rta = new JSONObject();
        Emergencia vTmp= new Emergencia();
        vTmp.setConsecuencia(ub.getConsecuencia());
        vTmp.setDescripcion(ub.getDescripcion());
        vTmp.setFecha(ub.getFecha());
        vTmp.setMagnitud(ub.getMagnitud());
        vTmp.setUbicacion(ub.getUbicacion());
        Vehiculo v=entityManager.find(Vehiculo.class, idVehiculo);
        List <Vehiculo> l= ub.getVehiculosInvolucrados();
        l.add(v);
        vTmp.setVehiculosInvolucrados(l);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vTmp);
            entityManager.getTransaction().commit();
            entityManager.refresh(vTmp);
            rta.put("emergencia_id", vTmp.getId());
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
    public void actulizarEmergencia(EmergenciaDTO ub, @PathParam("id") int idEmergencia) throws OperacionInvalidaException 
    {

        Emergencia vTmp= entityManager.find(Emergencia.class, idEmergencia);
        entityManager.getTransaction().begin();
        vTmp.setConsecuencia(ub.getConsecuencia());
        vTmp.setDescripcion(ub.getDescripcion());
        vTmp.setFecha(ub.getFecha());
        vTmp.setMagnitud(ub.getMagnitud());
        vTmp.setUbicacion(ub.getUbicacion());
        entityManager.getTransaction().commit();
        
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from Emergencia u");
        List<Emergencia> estaciones = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(estaciones).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByID( @PathParam("id") int idEmergencia) 
    {
        Emergencia e = entityManager.find(Emergencia.class,idEmergencia );
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(e).build();
    }
   
}
