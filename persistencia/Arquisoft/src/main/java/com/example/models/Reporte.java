/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author df.sabogal10
 */
@Entity
public class Reporte {
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID de la estación
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    /**
     * 
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    /** 
     * 
     */
    @ManyToOne( targetEntity = Vehiculo.class)
    @JoinColumn(name="idVehiculo")
    private Vehiculo vehiculo;
    
    //-----------------------------------------------------------
    // Costructor
    //-----------------------------------------------------------
    
     /**
     * Constructor de la clase (sin argumentos)
     */
    public Reporte()
    {

    }

    /**
     * Constructo de repporte
     * @param id
     * @param fecha
     * @param vehiculo 
     */
    public Reporte(int id, Date fecha, Vehiculo vehiculo) {
        this.id = id;
        this.fecha = fecha;
        this.vehiculo = vehiculo;
    }

    /**
     * getter id
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * getter fecha
     * @return 
     */
    public Date getFecha() {
        return fecha;
    }
    
    /**
     * getter vehiculo
     * @return 
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    /**
     * setter id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * setter vehiculo
     * @param vehiculo 
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
