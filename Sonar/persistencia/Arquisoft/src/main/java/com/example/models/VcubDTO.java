/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

/**
 *
 * @author ja.silva11
 */
public class VcubDTO
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    /**
     * Estado del VcubDTO
     */
    private String estado;
    

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public VcubDTO()
    {

    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    
    /**
     * Devuelve el estado del VcubDTO
     * @return estado Estado del VcubDTO
     */
    public String getEstado()
    {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
        
    /**
     * Modifica el estado del Vcub
     */
    public void cambiarEstado() {
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