/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 *
 * @author dc.bonilla10
 */
@Entity
public class Mobibus implements Serializable
{
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Estado del Mobibus
     */

    private String estado;
    
    @OneToMany
    private List<Reserva> reservas;
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Mobibus( )
    {
        
    }
    
    public Mobibus(String pEstado)
    {
        estado = pEstado;
        reservas = new ArrayList<Reserva>();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
    
    /**
     * Devuelve el estado del Mobibus
     * @return estado Estado del Mobibus
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
     * Modifica el estado del Mobibus
     */
    public void cambiarEstado() {
        if(this.estado == null||this.estado.equalsIgnoreCase("disponible"))
        {
            this.estado = "reservado"; 
        }
        else
        {
            this.estado = "disponible";
        }
    }
}