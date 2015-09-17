/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

/**
 *
 * @author dc.bonilla10
 */
public class MobibusDTO
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * ID del MobibusDTO
     */
    private int id;
    
    /**
     * Estado del MobibusDTO
     */
private String estado;    

    /**
     * Ubicacion del mobibus
     */
     private Ubicacion ubic;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public MobibusDTO()
    {

    }

    /**
     * Constructor de la clase (con argumentos)
     * @param id
     */
    public MobibusDTO(int id)
    {
        this.id = id;
        this.estado = "disponible";
     
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el id del MobibusDTO
     * @return id Id del MobibusDTO
     */
    public long getId()
    {
        return id;
    }
    
    /**
     * Devuelve el estado del MobibusDTO
     * @return estado Estado del MobibusDTO
     */
    public String getEstado()
    {
        return estado;
    }
    
    /**
     * Modifica el id del MobibusDTO
     * @param id Nuevo id del MobibusDTO
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Modifica la ubicacion del MobibusDTO
     * @param ubic Nuevo id del MobibusDTO
     */
    public void setUbicacion(Ubicacion ubic) {
        this.ubic = ubic;
    }
    
     /**
     * Retorna la ubicacion del MobibusDTO
     */
    public Ubicacion getUbicacion() {
        return ubic;
    }
    
    
    /**
     * Modifica el estado del MobibusDTO
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