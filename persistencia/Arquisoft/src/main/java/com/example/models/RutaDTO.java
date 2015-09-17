/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.ArrayList;

/**
 *
 * @author dc.bonilla10
 */
public class RutaDTO
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Id de la ruta
     */
    private long id;
    /**
     * Inicio de la ruta
     */
    private String inicio;
    
    /**
     * Fin de la ruta
     */
    private String fin;
    

    //-----------------------------------------------------------
    // Constructores
    
    //-----------------------------------------------------------


    /**
     * Constructor de la clase
     * @param pinicio
     * @param pfinal
     * @param id
     */
    public RutaDTO(long id, String pinicio, String pfinal)
    {
        this.inicio = pinicio;
        this.fin = pfinal;
        this.id = id;

    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFinal() {
        return fin;
    }

    public void setFinal(String fin) {
        this.fin= fin;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
