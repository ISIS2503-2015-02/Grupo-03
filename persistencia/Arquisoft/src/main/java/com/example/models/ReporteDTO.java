/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.Date;

/**
 *
 * @author df.sabogal10
 */
public class ReporteDTO {
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID de la estación
     */
    private int id;
    
    /**
     * 
     */
    private Date fecha;
    
    /** 
     * 
     */
    private VehiculoDTO vehiculo;
    
    //-----------------------------------------------------------
    // Costructor
    //-----------------------------------------------------------
    
     /**
     * Constructor de la clase (sin argumentos)
     */
    public ReporteDTO()
    {

    }

    /**
     * Constructo de repporte
     * @param id
     * @param fecha
     * @param vehiculo 
     */
    public ReporteDTO(int id, Date fecha, VehiculoDTO vehiculo) {
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
    public VehiculoDTO getVehiculo() {
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
    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
    
    
    

    
    
    
}
