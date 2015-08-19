/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquisoft.dto;

/**
 *
 * @author dc.bonilla10
 */
public class Mobibus
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del Mobibus
     */
    private int id;
    
    /**
     * Estado del Mobibus
     */
    private String estado;
    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Mobibus()
    {

    }

    /**
     * Constructor de la clase (con argumentos)
     * @param id
     */
    public Mobibus(int id)
    {
        this.id = id;
        this.estado = "disponible";
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el id del Mobibus
     * @return id Id del Mobibus
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * Devuelve el estado del Mobibus
     * @return estado Estado del Mobibus
     */
    public String getEstado()
    {
        return estado;
    }
    
    /**
     * Modifica el id del Mobibus
     * @param id Nuevo id del Mobibus
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Modifica el estado del Mobibus
     */
    public void setEstado() {
        if(this.estado.equalsIgnoreCase("disponible"))
        {
            this.estado = "reservado"; 
        }
        else
        {
            this.estado = "disponible";
        }
    }
}