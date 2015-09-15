/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author ja.silva11
 */
@Entity
public class Vcub implements Serializable
{
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    public Vcub( )
    {
        
    }
    
    public Vcub(String pEstado)
    {
        estado = pEstado;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    
    /**
     * Devuelve el estado del Vcub
     * @return estado Estado del Vcub
     */
    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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