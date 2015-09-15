/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author df.sabogal10
 */
@Entity
public class Vehiculo implements Serializable {
    
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del VehiculoDTO
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idVehiculo")
    private int id;
    
    /**
     * capacidad del vehiculo
     */
    private int capacidad;
    
    /**
     * ubicacion del vehiculo
     */
    @OneToOne( cascade= CascadeType.PERSIST, targetEntity = Ubicacion.class)
    @JoinColumn(name="idUbicacion")  
    private Ubicacion ubicacion;
    
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Vehiculo()
    {

    }
    
    /**
     * Constructor de la clase (con argumentos)
     * @param id
     * @param ubic
     */
    public Vehiculo(int id, Ubicacion ubic)
    {
        this.id = id;
        ubicacion = ubic;    
    }
    
    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

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
