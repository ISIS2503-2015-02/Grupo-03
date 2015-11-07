/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

/**
 *
 * @author df.sabogal10
 */
public class VehiculoDTO {
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del VehiculoDTO
     */
    private int id;
    
    /**
     * capacidad del vehiculo
     */
    private int capacidad;
    
    /**
     * ubicacion del vehiculo
     */
    private Ubicacion ubicacion;
    
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public VehiculoDTO()
    {

    }
    
    /**
     * Constructor de la clase (con argumentos)
     * @param id
     * @param ubic
     */
    public VehiculoDTO(int id, Ubicacion ubic)
    {
        this.id = id;
        ubicacion = ubic;
        
    }
     /**
     * Devuelve el id del VehiculoDTO
     * @return id Id del VehiculoDTO
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * Devuelve la capacidad del VehiculoDTO
     * @return capacidad Capacidad del vehiculo
     */
    public int getCapacidad()
    {
        return capacidad;
    }

    /**
     * getter ubicacion
     * @return ubicacion
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    

    
    /**
     * Modifica la capacidad del VehiculoDTO
     * @param cap La nueva capacidad del vehiculo
     */
    public void setCapacidad(int cap) {
        capacidad= cap;
    }

    /**
     * setter ubicacion
     * @param ubicacion 
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
   
    
}
