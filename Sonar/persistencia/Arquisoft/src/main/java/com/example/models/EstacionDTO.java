/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.List;

/**
 * clase que representa una estación de vcubs
 * @author df.sabogal10
 */
public class EstacionDTO {
    
     //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID de la estación
     */
    private int id;
    
    /**
     * capacidad de guardar vcubs
     */
    private int capacidad;
    
    /**
     * los vcubs guardados en la estación.
     */
    private List<Vcub> vcubs;
    
    /**
     * la ubicacion de la estación de vcubs.
     */
    private Ubicacion ubicacion;
    
    
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

      /**
     * Constructor de la clase (sin argumentos)
     */
    public EstacionDTO()
    {

    }
    /**
     * constructor de Estacion
     * @param id
     * @param capacidad
     * @param vcubs
     * @param ubicacion 
     */
    public EstacionDTO(int id, int capacidad, List<Vcub> vcubs, Ubicacion ubicacion) {
        this.id = id;
        this.capacidad = capacidad;
        this.vcubs = vcubs;
        this.ubicacion = ubicacion;
    }

    /**
     * setter id
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * setter capacidad
     * @return 
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * getter vcubs
     * @return 
     */
    public List<Vcub> getVcubs() {
        return vcubs;
    }

    /**
     * getter ubicacion
     * @return 
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * setter id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * setter capacidad
     * @param capacidad 
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * setter vcubs
     * @param vcubs 
     */
    public void setVcubs(List<Vcub> vcubs) {
        this.vcubs = vcubs;
    }

    /**
     * setter ubicacion
     * @param ubicacion 
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    

}
