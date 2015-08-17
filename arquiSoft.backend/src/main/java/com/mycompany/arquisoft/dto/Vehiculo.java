/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.dto;

/**
 *
 * @author df.sabogal10
 */
public class Vehiculo {
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del Vehiculo
     */
    private int id;
    
    /**
     * 
     */
    private int capacidad;
    
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
     */
    public Vehiculo(int id)
    {
        this.id = id;
    }
     /**
     * Devuelve el id del Vehiculo
     * @return id Id del Vehiculo
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * Devuelve la capacidad del Vehiculo
     * @return capacidad Capacidad del vehiculo
     */
    public int getCapacidad()
    {
        return capacidad;
    }
    

    
    /**
     * Modifica la capacidad del Vehiculo
     * @param cap La nueva capacidad del vehiculo
     */
    public void setCapacidad(int cap) {
        capacidad= cap;
    }
    
}
