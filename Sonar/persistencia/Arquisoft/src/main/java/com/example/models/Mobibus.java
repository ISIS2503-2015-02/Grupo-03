/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 *
 * @author dc.bonilla10
 */
@Entity
public class Mobibus implements Serializable
{
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * Estado del Mobibus
     */

    private String estado;
    
    @OneToOne
    private transient Ubicacion ubic;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Mobibus( )
    {
        
    }
    
    public Mobibus(int id)
    {
        this.id = id;
        estado = "disponible";
        Ubicacion w = new Ubicacion( 4.60, -74.07);
        this.ubic = w;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    
    /**
     * Devuelve el estado del Mobibus
     * @return estado Estado del Mobibus
     */
    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
            
    
    public Ubicacion getUbicacion() {
        return ubic;
    }

    public void setUbicacion(Ubicacion ubic) {
        this.ubic = ubic;
    }
    
     
 
    /**
     * Modifica el estado del Mobibus
     */
    public void cambiarEstado() {
        if(this.estado == null||this.estado.equalsIgnoreCase("disponible"))
        {
            this.estado = "reservado"; 
        }
        else
        {
            this.estado = "disponible";
        }
    }
}