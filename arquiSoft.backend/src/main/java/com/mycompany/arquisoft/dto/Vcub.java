/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.dto;

/**
 *
 * @author ja.silva11
 */
public class Vcub
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del Vcub
     */
    private long id;
    
    /**
     * Estado del Vcub
     */
    private String estado;
    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Vcub()
    {

    }

    /**
     * Constructor de la clase (con argumentos)
     * @param id
     */
    public Vcub(long id)
    {
        this.id = id;
        this.estado = "disponible";
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el id del Vcub
     * @return id Id del Vcub
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * Devuelve el estado del Vcub
     * @return estado Estado del Vcub
     */
    public String getEstado()
    {
        return estado;
    }
    
    /**
     * Modifica el id del Vcub
     * @param id Nuevo id del Vcub
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Modifica el estado del Vcub
     */
    public void setEstado() {
        if(this.estado.equalsIgnoreCase("disponible"))
        {
            this.estado = "alquilado"; 
        }
        else
        {
            this.estado = "disponible";
        }
    }
}