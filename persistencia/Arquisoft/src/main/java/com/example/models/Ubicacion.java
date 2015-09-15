/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ja.silva11
 */
@Entity
public class Ubicacion implements Serializable{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    /**
     * Latitud de la ubicacion
     */
    private double latitud;
    
    /**
     * Longitud de la ubicacion
     */
    private double longitud;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Ubicacion()
    {

    }
    
      /**
     * Constructor de la clase (sin argumentos)
     */
    public Ubicacion(double lat, double lon)
    {
        latitud = lat;
        longitud = lon;
    }
    
     //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve la latitud de la ubicacion
     * @return latitud Latitud de la ubicacion
     */
    public double getLatitud()
    {
        return latitud;
    }
    
    /**
     * Devuelve la longitud de la ubicacion
     * @return longitud Longitud de la ubicacion
     */
    public double getLongitud()
    {
        return longitud;
    }
    
    /**
     * Modifica la latitud de la ubicacion
     * @param lat Nueva latitud de la ubicacion
     */
    public void setLatitud(double lat) {
        this.latitud = lat;
    }
    
    /**
     * Modifica la longitud de la ubicacion
     * @param lon Nueva longitud de la ubicacion
     */
    public void setLongitud(double lon) {
        this.longitud = lon;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
