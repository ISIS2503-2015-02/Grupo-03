/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Login;
import com.example.PersistenceManager;
import com.example.models.LoginDTO;
import com.example.models.RoleDTO;
import java.io.File;
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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jettison.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;

/**
 *
 * @author je.camargo10
 */
@JsonIgnoreProperties(ignoreUnknown=true)  
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginService 
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
    
    
    
    @GET
    @Path("/login/idUsr/{idUsr}/pass/{pass}")
    @Produces(MediaType.APPLICATION_JSON)
        public Response logUser(@PathParam("idUsr") String idUsr,@PathParam("pass") String pass)
    {
        JSONObject rta = new JSONObject();
        Login usuario= new Login();
        usuario.setPassword(pass);
        usuario.setUsername(idUsr);

        //1. Load the INI configuration
        try
        {
        File jesus = new File("src/main/webapp/WEB-INF:shiro.ini");
        
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("src\\main\\webapp\\WEB-INF\\shiro.ini");

//2. Create the SecurityManager
SecurityManager securityManager = factory.getInstance();

//3. Make it accessible
SecurityUtils.setSecurityManager(securityManager);
        
        
//1. Acquire submitted principals and credentials:
AuthenticationToken token = new UsernamePasswordToken(usuario.getUsername(), usuario.getPassword());
//2. Get the current Subject:
Subject currentUser = SecurityUtils.getSubject();

//3. Login:
currentUser.login(token);


                RoleDTO satan = new RoleDTO( "administrador");
            
            
            List<RoleDTO> list = new ArrayList<RoleDTO>();
            list.add(satan);

if ( currentUser.hasRole("examplerole"))
{
rta.put("userRole", "administrador");
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(list).build();
 
    
//show the ‘Create User’ button
} 
    else if (currentUser.hasRole("invitado"))
{
       rta.put("userRole", "invitado"); 
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
 
    
    
}
else
{
        return Response.status(403).header("Access-Control-Allow-Origin", "*").entity("error").build();


}
        }
        catch(Exception e)
        {
                return Response.status(403).header("Access-Control-Allow-Origin", "*").entity("error").build();

        }

    
    
}

   
}